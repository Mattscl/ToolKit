<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!--header 作为公共模版分离出去-->
    <jsp:include page="/static/commonviews/header.jsp"/>
    <link href="<%=request.getContextPath() %>/views/index/index.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/views/index/sidebar-menu.css" rel="stylesheet">
</head>

<body>
login success!
<shiro:hasPermission name="E11:1">
    <button id="btnEdit" class="btn btn-default" onclick="show()"><i></i> 修改
    </button>
</shiro:hasPermission><br/>
Hello, <shiro:principal/>, how are you today?

<!--顶栏-->
<div class="navbar navbar-duomi navbar-static-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#" id="logo">ToolKit
            </a>
        </div>
    </div>
</div>
<!--100%宽度，包含左侧菜单栏和右侧导航容器-->
<div class="container-fluid">
    <div class="row">
        <!--左侧菜单栏-->
        <div class="col-md-2">
            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingOne">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                用户菜单
                            </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                        <ul class="list-group">
                            <a href="javascript:void(0);" data-addtab="userMenu1" url="/admin/message" class="list-group-item">用户菜单 1</a>
                            <a href="javascript:void(0);" data-addtab="userMenu2" url="/admin/message" class="list-group-item">用户菜单 2</a>
                            <a href="javascript:void(0);" data-addtab="userMenu3" url="/admin/message" class="list-group-item">用户菜单 3</a>
                            <a href="javascript:void(0);" data-addtab="userMenu4" url="/admin/message" class="list-group-item">用户菜单 4</a>
                            <a href="javascript:void(0);" data-addtab="userMenu5" url="/admin/message" class="list-group-item">用户菜单 5</a>
                            <a href="javascript:void(0);" data-addtab="userMenu6" url="/admin/message" class="list-group-item">用户菜单 6</a>
                            <a href="javascript:void(0);" data-addtab="userMenu7" url="/admin/message" class="list-group-item">用户菜单 7</a>
                            <a href="javascript:void(0);" data-addtab="userMenu8" url="/admin/message" class="list-group-item">用户菜单 8</a>
                            <a href="javascript:void(0);" data-addtab="userMenu9" url="/admin/message" class="list-group-item">用户菜单 9</a>
                            <a href="javascript:void(0);" data-addtab="userMenu10" url="/admin/message" class="list-group-item">用户菜单 10</a>
                        </ul>
                    </div>
                </div>
            </div>
            <!--动态多层菜单容器-->
            <section id="div_menu" class="sidebar">
            </section>
        </div>
        <!--右侧内容区域-->
        <div class="col-md-10">
            <div class="main">
                <div id="tabs">
                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active">
                            <a href="#home" aria-controls="home" role="tab" data-toggle="tab">Home</a></li>
                    </ul>
                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="home">
                            <button type="button" class="btn btn-default" addtabs="save" id="save" url="/admin/save">
                                <i class="glyphicon glyphicon-floppy-disk"></i>
                                SAVE
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--footer 作为公共模版分离出去-->
<jsp:include page="/static/commonviews/footer.jsp"/>
<script src="<%=request.getContextPath() %>/static/utils/os-frame.js"></script>
<script src="<%=request.getContextPath() %>/views/index/sidebar-menu.js"></script>
<script src="<%=request.getContextPath() %>/views/index/index.js"></script>
</body>
</html>
