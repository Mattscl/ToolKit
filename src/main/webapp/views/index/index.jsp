<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="<%=request.getContextPath() %>/views/index/os-frame.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="<%=request.getContextPath() %>/static/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/views/index/index.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/views/index/sidebar-menu.css" rel="stylesheet">

    <style type="text/css">
        .main-sidebar{
            position: absolute;
            top: 50px;
            left: 0;
            height: 100%;
            min-height: 100%;
            width: 230px;
            z-index: 810;
            background-color: #222d32;
        }
        .navbar{

            width: 100%;
            height: 50px;
            background-color: #3c8dbc;
            border-radius: 0;
        }
        .navbarLeft{
            float: left;
            background-color: #367fa9;
            width: 230px;
            height: 100%;
        }
        .navbarLeft .logo-lg{
            display: block;
            color: #fff;
            font-size: 20px;
            line-height: 50px;
            text-align: center;
            font-weight: 300;
            font-family: Helvetica, 'Hiragino Sans GB', 'Microsoft Yahei', '微软雅黑', Arial, sans-serif;
        }
        .navbarLeft .logo-lg b{

            font-weight: 800;
        }
        .navbar .navbar-custom-menu{
            position: relative;
            float: right;
        }
        .navbarRight{
            margin-left:230px;width:100%;
        }
        .navbar .navbar-custom-menu .navbar-nav .right{
            color: #fff;
            padding-top: 15px;
            padding-bottom: 15px;
            line-height: 20px;
            display: block;
            list-style-type: disc;
            -webkit-margin-before: 1em;
            -webkit-margin-after: 1em;
            -webkit-margin-start: 0px;
            -webkit-margin-end: 0px;
            -webkit-padding-start: 40px;

        }
    </style>

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
            <%--<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
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
            </div>--%>
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

<script src="<%=request.getContextPath() %>/static/jquery/jquery-1.11.0.min.js"></script>
<script src="<%=request.getContextPath() %>/static/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/views/index/sidebar-menu.js"></script>
<script src="<%=request.getContextPath() %>/views/index/index.js"></script>
</body>
</html>
