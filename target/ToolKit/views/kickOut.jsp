<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/2
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>校验是否被踢出</h2>
<script type="text/javascript">
    function kickout(){
        var href=location.href;
        if(href.indexOf("kickout")>0){
            alert("您的账号在另一台设备上登录，您被挤下线，若不是您本人操作，请立即修改密码！");
        }
        else
        {
            alert("未被踢出");
        }
    }
    window.onload=kickout();
</script>
</body>
</html>
