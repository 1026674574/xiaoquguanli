<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>报修管理:物业管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">

    <!-- The styles -->
    <link id="bs-css" href="${pageContext.request.contextPath}/css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/css/charisma-app.css" rel="stylesheet">
    <link href='${pageContext.request.contextPath}/bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='${pageContext.request.contextPath}/bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/css/jquery.noty.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/css/noty_theme_default.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/css/elfinder.min.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/css/elfinder.theme.css' rel='stylesheet'>、
    <link href='${pageContext.request.contextPath}/css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/css/uploadify.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/css/animate.min.css' rel='stylesheet'>

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/bower_components/jquery/jquery.min.js"></script>

    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- The fav icon -->
    <link rel="shortcut icon" href="img/favicon.ico">

</head>

<body>
<!-- topbar starts -->
<div class="navbar navbar-default" role="navigation">
    <div class="navbar-inner">
        <button type="button" class="navbar-toggle pull-left animated flip">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index.html"> <img alt="Charisma Logo" src="${pageContext.request.contextPath}/img/logo20.png" class="hidden-xs"/>
            <span>物业管理系统</span></a>

        <!-- user dropdown starts -->
        <div class="btn-group pull-right">
            <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs">admin</span>
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li><a href="user?action=logout">注销登录</a></li>
            </ul>
        </div>
        <!-- user dropdown ends -->
    </div>
</div>
<!-- topbar ends -->
<div class="ch-container">
    <div class="row">

        <!-- left menu starts -->
        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked">

                    </div>
                    <ul class="nav nav-pills nav-stacked main-menu">
                        <li class="nav-header">功能</li>
                        <li><a class="ajax-link" href="adminServlet?method=getPage&page=user_index"><span> &ensp;首&ensp;页</span></a>
                        <li><a class="ajax-link" href="propertyServlet?method=getList2"><span>&ensp;缴&ensp;费</span></a></li>
                        <li class="active"><a class="ajax-link" href="warrantyServlet?method=getList2"><span> &ensp;报&ensp;修</span></a>                    </ul>
                </div>
            </div>
        </div>
        <!--/span-->
        <!-- left menu ends -->

        <noscript>
            <div class="alert alert-block col-md-12">
                <h4 class="alert-heading">Warning!</h4>

                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>

        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
            <div>
                <ul class="breadcrumb">
                    <li>
                        <a href="usear_index.html">首页</a>
                    </li>
                    <li>
                        <a href="usear_maintain_list.html">报修</a>
                    </li>
                </ul>
            </div>

            <div class="row">
                <div class="box col-md-12">
                    <div class="box-inner">
                        <div class="box-header well" data-original-title="">
                            <h2> 报修</h2>

                            <div class="box-icon">
                                <a href="#" class="btn btn-minimize btn-round btn-default"><i
                                        class="glyphicon glyphicon-chevron-up"></i></a>
                                <a href="#" class="btn btn-close btn-round btn-default"><i class="glyphicon glyphicon-remove"></i></a>
                            </div>
                        </div>
                        <div class="box-content">

                            <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
                                <thead>
                                <a class="btn btn-success" href="warrantyServlet?method=getPage&page=user_maintain_add">
                                    &ensp;添&ensp;加&ensp;记&ensp;录
                                </a>
                                <br/>
                                <br/>
                                <tr>

                                    <th>报修内容</th>
                                    <th>是否处理</th>
                                    <th>处理结果</th>
                                    <th>处理人</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="warranty2" items="${requestScope.warrantys2}" >
                                    <tr>
                                        <td>${warranty2.wa_text}</td>
                                        <td>${warranty2.flag}</td>
                                        <td>${warranty2.wa_back}</td>
                                        <td>${warranty2.admin.ad_truename}</td>
                                    </tr>
                                </c:forEach>

                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!--/span-->

            </div><!--/row-->


            <!-- content ends -->
        </div><!--/#content.col-md-0-->
    </div><!--/fluid-row-->


    <hr>


    <footer class="row">
        <p class="col-md-9 col-sm-9 col-xs-12 copyright">&copy; <a href="http://usman.it" target="_blank">Muhammad
            Usman</a> 2012 - 2015</p>

        <p class="col-md-3 col-sm-3 col-xs-12 powered-by">Powered by: <a
                href="http://usman.it/free-responsive-admin-template">WZL</a></p>
    </footer>

</div><!--/.fluid-container-->

<!-- external javascript -->

<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='bower_components/moment/min/moment.min.js'></script>
<script src='bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src="js/jquery.dataTables.min.js"></script>
<!-- select or dropdown enhancer -->
<script src="bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="js/charisma.js"></script>
<script>
    $('#myModal').on('show.bs.modal', function(e) {
        $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
    });
</script>

</body>
</html>


