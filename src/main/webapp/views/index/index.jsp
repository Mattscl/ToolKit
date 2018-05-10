<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="<%=request.getContextPath() %>/static/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link href="<%=request.getContextPath() %>/views/index/index.css" rel="stylesheet">
</head>

<body>
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
        <div class="col-md-2">
            <ul id="main-nav" class="main-nav nav nav-tabs nav-stacked" style="">
                <li>
                    <a href="#">
                        <i class="glyphicon glyphicon-th-large"></i>
                        首页
                    </a>
                </li>
                <li>
                    <a href="#systemSetting" class="nav-header collapsed" data-toggle="collapse">
                        <i class="glyphicon glyphicon-cog"></i>
                        系统管理
                        <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
                    </a>
                    <ul id="systemSetting" class="nav nav-list secondmenu collapse" style="height: 0px;">
                        <li><a href="#"><i class="glyphicon glyphicon-user"></i>&nbsp;用户管理</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-th-list"></i>&nbsp;菜单管理</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-asterisk"></i>&nbsp;角色管理</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-edit"></i>&nbsp;修改密码</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-eye-open"></i>&nbsp;日志查看</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#configSetting" class="nav-header collapsed" data-toggle="collapse">
                        <i class="glyphicon glyphicon-credit-card"></i>
                        配置管理
                        <span class="pull-right glyphicon  glyphicon-chevron-toggle"></span>
                    </a>
                    <ul id="configSetting" class="nav nav-list secondmenu collapse in">
                        <li class="active"><a href="#"><i class="glyphicon glyphicon-globe"></i>&nbsp;全局缺省配置</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-star-empty"></i>&nbsp;未开通用户配置</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-star"></i>&nbsp;退订用户配置</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-text-width"></i>&nbsp;试用用户配置</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-ok-circle"></i>&nbsp;开通用户配置</a></li>
                    </ul>
                </li>

                <li>
                    <a href="#disSetting" class="nav-header collapsed" data-toggle="collapse">
                        <i class="glyphicon glyphicon-globe"></i>
                        分发配置
                        <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
                    </a>
                    <ul id="disSetting" class="nav nav-list secondmenu collapse">
                        <li><a href="#"><i class="glyphicon glyphicon-th-list"></i>&nbsp;分发包配置</a></li>
                    </ul>
                </li>

                <li>
                    <a href="#dicSetting" class="nav-header collapsed" data-toggle="collapse">
                        <i class="glyphicon glyphicon-bold"></i>
                        字典配置
                        <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
                    </a>
                    <ul id="dicSetting" class="nav nav-list secondmenu collapse">
                        <li><a href="#"><i class="glyphicon glyphicon-text-width"></i>&nbsp;关键字配置</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <i class="glyphicon glyphicon-fire"></i>
                        关于系统
                        <span class="badge pull-right">1</span>
                    </a>
                </li>

            </ul>
        </div>
        <div class="col-md-10">
            这里是内容
        </div>
    </div>
</div>

<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
