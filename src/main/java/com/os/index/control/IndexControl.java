package com.os.index.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Created by Matt on 2018/3/2.
 * 接口说明： 主页面的请求操作
 */
@Controller
public class IndexControl
{
    @RequestMapping(value = "/index/getMenus",method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String,Object> getMenus()
    {
        HashMap<String,Object> result = new HashMap<String, Object>();
        result.put("name","matt");
        result.put("age",30);
        return result;
    }
}
