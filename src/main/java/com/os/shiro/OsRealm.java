package com.os.shiro;

import com.os.bean.PostInfo;
import com.os.bean.UserInfo;
import com.os.login.dao.LoginDao;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.rmi.activation.UnknownObjectException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matt on 2018-02-28.
 * 自定义安全处理
 */
public class OsRealm extends AuthorizingRealm {

    @Resource
    private LoginDao loginDao;

    /**
     * 获取登陆用户的权限
     * @param principals
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
    {
        String username = (String)getAvailablePrincipal(principals);
        try
        {
            UserInfo u = loginDao.getUser(username);
            if(u != null)
            {
                SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
                List<String> pers = null;
                //如果是admin用户则给予最大权限
                if(u.getUserCode().equalsIgnoreCase("admin"))
                {
                    pers = loginDao.getPostModels(null);
                }
                else
                {
                    //获取用户岗位
                    List<PostInfo> posts = u.getUserPosts();
                    //获取用户岗位
                    List<String> userPosts = new ArrayList<String>();
                    if(posts != null && !posts.isEmpty())
                    {
                        for(PostInfo p:posts)
                        {
                            userPosts.add(p.getCode());
                        }
                        pers = loginDao.getPostModels(userPosts);  //根据用户岗位获取模块权限(模块代码：操作权限)
                    }
                }
                info.addStringPermissions(pers);
                return info;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException
    {
        UsernamePasswordToken upToken = (UsernamePasswordToken)token;
        String username = upToken.getUsername();
        //从数据库中拿到密码，存储在传递过来的用户对象身上
        String password = "";
        UserInfo u = null;
        try
        {
            u = loginDao.getUser(username);
            if(u == null)
            {
                throw new UnknownObjectException("账号或密码不正确");
            }
            //数据密码保护冒号，需要剔除
            password = u.getPassword().replace(":","").toLowerCase();
        }
        catch (Exception e)
        {
            throw new UnknownAccountException(e.getLocalizedMessage());
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,password,getName());
        return info;
    }
}
