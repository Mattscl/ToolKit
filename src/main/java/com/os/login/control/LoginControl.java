package com.os.login.control;

import com.os.bean.UserInfo;
import com.os.login.dao.LoginDao;
import com.os.utils.CheckCodeImg;
import com.os.utils.JsonToMap;
import com.os.utils.SysString;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Matt on 2018/5/8.
 */
@Controller
public class LoginControl {

    @Resource
    private LoginDao loginDao;

    Logger log= Logger.getLogger(LoginControl.class);
    /**
     * 用户登录
     * @param request
     * @param m 传出参数
     * @return
     * 这里的前台用户输入的密码会被shiro自动通过md5加密，因此无需手动对密码进行再次加密
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Object login(HttpServletRequest request, Model m, @RequestBody String data)
    {
        HashMap<String,Object> dataMap = (HashMap<String, Object>) JsonToMap.jsonToMap(data);
        String sUrl="";
        String msg="";
        String userCode = dataMap.get("userID").toString();
        String userPwd = dataMap.get("password").toString();
        HashMap<String,Object> obj = new HashMap<String, Object>();
        try
        {
            userCode=userCode.toUpperCase();
            UsernamePasswordToken token = new UsernamePasswordToken(userCode,userPwd);
            //记录该令牌
            token.setRememberMe(false);
            //subject权限对象
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            if (subject.isAuthenticated())
            {

                UserInfo u=loginDao.getUser(userCode);
                if(u == null)
                {
                    msg = "用户代码不存在!";
                }
                //admin用户不需要验证，其他都需要验证
                else if(u.getUserPosts()==null && !u.getUserCode().equalsIgnoreCase("ADMIN"))
                {
                    msg = "用户["+u.getUserCode()+"]未设置岗位!";
                }
                else if(u.getIsStop()){
                    msg = "用户["+u.getUserCode()+"]已经停用!";
                }
                else
                {
                    sUrl="index";
                    //用户信息存储在session中
                    WebUtils.setSessionAttribute(request,"user",u);
                    log.info("登录验证成功！");
                }
            }
            else
            {
                sUrl="../login";
                obj.put("result","error");
            }
        }
        catch (IncorrectCredentialsException e)
        {
            msg = "登录密码错误!";
        }
        catch (ExcessiveAttemptsException e)
        {
            msg = "登录失败次数过多!";
        }
        catch (LockedAccountException e)
        {
            msg = "帐号已被锁定!";
        }
        catch (DisabledAccountException e)
        {
            msg = "帐号已被禁用!";
        }
        catch (ExpiredCredentialsException e)
        {
            msg = "帐号已过期!";
        }
        catch (UnknownAccountException e) {
            msg = "帐号不存在！"+e.getLocalizedMessage();
        }
        catch (UnauthorizedException e)
        {
            msg = "您没有得到相应的授权！";
        }
        catch (Exception e)
        {
            msg=e.getLocalizedMessage();
        }
        if(!SysString.isEmpty(msg))  //如果报错，重定向到登陆页面
        {
            sUrl = "../login";
            m.addAttribute("msg", msg);  //将错误信息传递到前台
        }
        return obj;
    }

    @RequestMapping(value = "/loginOut",method = RequestMethod.GET)
    public String loginOut(){
        /*Subject subject = SecurityUtils.getSubject();
        if(subject!=null && subject.isAuthenticated()) {
            subject.logout();
        }*/
        log.info("用户注销成功！");
        return "../login";
        //return "redirect:/login.jsp";
    }

    //根据前台请求，生成验证码图片
    @RequestMapping(value = "/login/checkCode",method = {RequestMethod.GET,RequestMethod.POST})
    public void grtImg(HttpServletResponse response){
        response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        // 将内存中的图片通过流动形式输出到客户端
        try
        {
            ImageIO.write(CheckCodeImg.createImg(CheckCodeImg.getSecurityCode(5,0,false))
                    , "JPEG", response.getOutputStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
