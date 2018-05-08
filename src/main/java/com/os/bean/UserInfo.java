//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.os.bean;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UserInfo {
    private String userCode;
    private String loginCode;
    private String userName;
    private String deptCode;
    private String deptName;
    private String orgCode;
    private String orgName;
    private String password;
    private String dataRange;
    private boolean isStop;
    private List<PostInfo> userPosts;

    public UserInfo() {
    }

    public String getDataRang() {
        return this.dataRange;
    }

    public boolean getIsStop() {
        return this.isStop;
    }

    public void setIsStop(boolean stop) {
        this.isStop = stop;
    }

    public String getDataRange() {
        return this.dataRange;
    }

    public void setDataRange(String dataRange) {
        this.dataRange = dataRange;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getLoginCode() {
        return this.loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeptCode() {
        return this.deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return this.deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getOrgCode() {
        return this.orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return this.orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public List<PostInfo> getUserPosts() {
        return this.userPosts;
    }

    public void setUserPosts(List<PostInfo> userPosts) {
        this.userPosts = userPosts;
    }

    public Set<String> getRoles() {
        HashSet userRole = new HashSet();
        List posts = this.getUserPosts();
        Iterator i$ = posts.iterator();

        while(i$.hasNext()) {
            PostInfo p = (PostInfo)i$.next();
            userRole.add(p.getCode());
        }

        return userRole;
    }
}
