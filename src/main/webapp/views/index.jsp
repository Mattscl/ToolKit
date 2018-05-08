<%--
  Created by IntelliJ IDEA.
  User: Mattscl
  Date: 2018-02-27
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登陆成功！</title>
</head>
<body>
    login success!
    <shiro:hasPermission name="E11:1">
        <button id="btnEdit" class="btn btn-default" onclick="show()"><i></i> 修改
        </button>
    </shiro:hasPermission><br/>
    Hello, <shiro:principal/>, how are you today?

<%--jquery--%>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/jquery/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
    $(function () {
        $.ajax({
            type: 'POST',
            dataType: 'json',
            url: "<%=request.getContextPath()%>/index/getMenus",
            success: function(data)
            {
                alert("success: " + data.name);
            },
            error: function(xhr) {
                alert('error:');
            }
        }).done(function(data) {
                // 请求成功后要做的工作
                console.log('success');
        }).fail(function() {
                // 请求失败后要做的工作
                console.log('error');
        }).always(function() {
                // 不管成功或失败都要做的工作
                console.log('complete');
        });
    });
    function show()
    {
        window.location = "./views/kickOut.jsp";
    }
</script>
</body>
</html>
