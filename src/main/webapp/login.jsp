<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>登陆页面</title>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<form name = logon action="<%=request.getContextPath()%>/login" method = "post">
    <table>
        <tr>
            <td colspan = 2>登陆界面</td>
        </tr>
        <tr>
            <td>账号：</td>
            <td><input type = "text" id="usercode" name = "usercode" size = 16/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type = "password" id="userpwd" name = "userpwd" size = 16/></td>
        </tr>
        <tr>
            <td><input type="checkbox" id="inlineCheckbox2" value="1"><span style="color: #00B83F">记住用户名</span></td>
        </tr>
        <tr>
            <td><input type = submit value = submit></td>
        </tr>
    </table>
    ${msg}
</form>
<%--jquery--%>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/jquery/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
    $(function () {
        //读取cookie
        if(document.cookie != null && document.cookie.length > 0)
        {
            var c = document.cookie;
            var carr = c.split("=");
            $("#usercode").val(carr[1]);
            $("#inlineCheckbox2").attr("checked","checked");
        }
        //当用户点击记住用户名的时候，设置cookie
        $("#inlineCheckbox2").click(function () {
            var isCheck = $("#inlineCheckbox2").val();
            var usercode = $("#usercode").val();
            if(usercode != null && usercode != "" && isCheck == "1")
            {
                document.cookie = "user=" + usercode;
            }
        })
    });
    function kickout()
    {
        var href=location.href;
        if(href.indexOf("kickout")>0)
        {
            alert("您的账号在另一台设备上登录，您被挤下线，若不是您本人操作，请立即修改密码！");
        }
    }
    window.onload=kickout();  //页面加载完成之后调用判断是否被踢出的方法
</script>
</body>
</html>