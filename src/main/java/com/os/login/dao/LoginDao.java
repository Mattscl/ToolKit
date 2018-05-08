package com.os.login.dao;

import com.os.bean.UserInfo;

import java.util.List;

/**
 * 登录
 * Created by xhc on 2017/3/28.
 */
public interface LoginDao {
    /**
     * 获得用户信息
     * @param sUserCode 用户代码
     * @return
     */
    public UserInfo getUser(String sUserCode) throws Exception;
    /**
     * 获得岗位模块权限
     * @param posts
     * @return
     * @throws Exception
     */
    public List<String> getPostModels(List<String> posts) throws Exception;
}
