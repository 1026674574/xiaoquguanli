<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: asus1
  Date: 2020/12/22
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录:物业管理系统</title>
    <link id="bs-css" href="${pageContext.request.contextPath}/css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/css/charisma-app.css" rel="stylesheet">
    <link href='${pageContext.request.contextPath}/bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='${pageContext.request.contextPath}/bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/css/jquery.noty.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/css/noty_theme_default.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/css/elfinder.min.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/css/elfinder.theme.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/css/uploadify.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/css/animate.min.css' rel='stylesheet'>

</head>
<body background= '${pageContext.request.contextPath}/img/bg.jpg' style="background-repeat: no-repeat; background-size:cover; margin: auto;">
<div class="ch-container">
    <div class="row">

        <div class="row">
            <div class="col-md-12 center login-header">
                <h1>物业管理系统</h1>
            </div>
            <!--/span-->
        </div><!--/row-->

        <div class="row">
            <div class="well col-md-4 center login-box">
                <div class="alert alert-info">
                    请输入用户名和密码.
                </div>
                <c:if test="${requestScope.flag.equals('false')}">
                    <div style="color: red">
                        用户名或密码错误.
                    </div>
                </c:if>
                <form data-toggle="validator" class="form-horizontal" action="adminServlet?method=login"  method="post">
                    <fieldset>
                        <div class="form-group col-md-12">
                            <div class="input-group input-group-lg">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
                                <input type="text" class="form-control" name="username" placeholder="用户名" required>
                            </div>
                            <!-- <span class="help-block with-errors"></span> -->
                        </div>
                        <div class="form-group col-md-12">
                            <div class="input-group input-group-lg">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
                                <input type="password" class="form-control" name="password" placeholder="密码" required>
                            </div>
                            <!--<span class="help-block with-errors"></span>-->
                        </div>
                        <div class="clearfix"></div>

                        <div class="radio">
                            <label>
                                <input type="radio" name="usertype" value="user" checked>
                                <i class="glyphicon glyphicon-home"></i>
                                业主登录　　
                            </label>
                            <label>
                                <input type="radio" name="usertype" value="admin">
                                <i class="glyphicon glyphicon-cog"></i>
                                管理员登录
                            </label>
                        </div>

                        <p class="center col-md-7">
                            <button type="submit" class="btn btn-primary">登录系统</button>
                        </p>
                    </fieldset>
                </form>
            </div>
            <!--/span-->
        </div><!--/row-->
    </div><!--/fluid-row-->
</div>


</body>
</html>
