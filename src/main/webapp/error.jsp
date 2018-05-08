<%@ page import="java.util.Enumeration" %>
<%@ page import="com.os.bean.UserInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <title>错误页面</title>


    <style type="text/css">
        table{
            text-align: left;
            margin: 150px auto;
        }
    </style>
</head>
<body>
<table width="800px">
    <tr>
        <td style="border-bottom:dotted 1px Gray;" colspan="2" >
           <span style="color: red;font-size: 40px;">错误提示</span>
        </td><td></td>
    </tr>
    <tr>
        <td style="width: 130px" >
            <img src="static/img/sorry.gif" id="error_img" />
        </td>
        <td>尊敬的用户：<br />系统出现了异常，请重试。
            <br />如果问题重复出现，请向系统管理员反馈。<br /><br />
            <a id="showErrorMessageButton" href="javascript:return false;">详细错误信息</a>
        </td>
    </tr>
    <tr>
        <td >
                <%
                    try {
                        //全部内容先写到内存，然后分别从两个输出流再输出到页面和文件
                        UserInfo u= (UserInfo) request.getSession().getAttribute("user");
                        if(u!=null) {
                            System.out.println("当前登录账号：" + u.getUserName());
                            System.out.println("");
                        }
                        System.out.println("访问的路径: " + request.getAttribute("javax.servlet.forward.request_uri"));

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                %>
        </td>
        <td>
            <%
                System.out.println("--------------------异常信息-------------------");
                if(exception!=null) {
                    System.out.println(exception.getClass() + " : " + exception.getMessage());
                }
            %>
        </td>
    </tr>
</table>


</body>
</html>