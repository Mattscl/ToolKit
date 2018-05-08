<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <link rel="stylesheet" href="./static/font-awesome-4.7.0/css/font-awesome.min.css" />
    <link rel="stylesheet" href="./static/bootstrap-3.3.7/css/bootstrap.css" />
    <link rel="stylesheet" href="./static/login/css/login.css" />
</head>
<body>

<div class="htmleaf-container ">
    <div class="form-bg" style="padding: 20px 0;">
        <div class="container">
            <div class="row">
                <div class="col-md-offset-3 col-md-6">
                    <form id="login_form" class="form-horizontal">
                        <span class="heading">ToolKit</span>
                        <div class="form-group">
                            <div class="col-lg-12" style="padding-left: 0px">
                                <input type="text" class="form-control" id="userID" name="userID" placeholder="用户名" value="1001">
                            </div>
                            <i class="fa fa-user"></i>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-12" style="padding-left: 0px">
                                <input type="password" class="form-control" id="password" name="password" placeholder="密　码">
                            </div>
                            <i class="fa fa-lock"></i>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-9" style="padding-left: 0px">
                                <input type="text" class="form-control" id="checkCode" name="checkCode" placeholder="输入验证码">
                            </div>
                            <i class="fa fa-user"></i>
                            <div class="col-lg-3" style="padding-right: 0px">
                                <img id="checkCodeImg" alt="checkCodeImg" src="<%= request.getContextPath()%>/login/checkCode" title="点我刷新">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-10" style="padding-left: 0px">
                                <div class="main-checkbox">
                                    <input type="checkbox" value="None" id="checkbox1" name="check"/>
                                    <label for="checkbox1"></label>
                                </div>
                                <span class="text">记住我</span>
                            </div>
                            <div class="col-lg-2" style="padding-right: 0px">
                                <button type="submit" class="btn btn-default">登录</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="./static/jquery/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="./static/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./static/bootstrapValidator/js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="./static/jquery/jquery.md5.js"></script>
<script type="text/javascript" src="./static/login/js/login.js"></script>
</body>
</html>