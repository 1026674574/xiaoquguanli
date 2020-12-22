<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
        <meta charset="utf-8" />
        <title>物业管理</title>
        <link id="bs-css" href="${pageContext.request.contextPath}/css/bootstrap-cerulean.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/charisma-app.css" rel="stylesheet">
        <link href='${pageContext.request.contextPath}/bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
        <link href='${pageContext.request.contextPath}/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
        <link href='${pageContext.request.contextPath}/bower_components/chosen/chosen.min.css' rel='stylesheet'>
        <link href='${pageContext.request.contextPath}/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
        <link href='${pageContext.request.contextPath}/bower_components/responsive-tables/responsive-tables.css'  type="text/css" rel='stylesheet'>
        <link href='${pageContext.request.contextPath}/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' type="text/css"  rel='stylesheet'>
        <link href='${pageContext.request.contextPath}/css/jquery.noty.css' type="text/css" rel='stylesheet'>
        <link href='${pageContext.request.contextPath}/css/noty_theme_default.css' type="text/css" rel='stylesheet'>
        <link href='${pageContext.request.contextPath}/css/elfinder.min.css' type="text/css" rel='stylesheet'>
        <link href='${pageContext.request.contextPath}/css/elfinder.theme.css' type="text/css" rel='stylesheet'>
        <link href='${pageContext.request.contextPath}/css/jquery.iphone.toggle.css' type="text/css" rel='stylesheet'>
        <link href='${pageContext.request.contextPath}/css/uploadify.css' type="text/css" rel='stylesheet'>
        <link href='${pageContext.request.contextPath}/css/animate.min.css' type="text/css" rel='stylesheet'>
</head>
<body>
<div class="navbar navbar-default" role="navigation">
    <div class="navbar-inner">
        <button type="button" class="navbar-toggle pull-left animated flip">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index.jsp"> <img alt="Charisma Logo" src="${pageContext.request.contextPath}/img/logo20.png" class="hidden-xs"/>
            <span>物业管理系统</span></a>
        <div class="btn-group pull-right">
            <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                <i class="glyphicon glyphicon-user"></i>
                <span class="hidden-sm hidden-xs"> ${sessionScope.admin.ad_truename}
                </span>
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li><a href="user?action=logout">注销登录</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="ch-container">
    <div class="row">
        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked">
                    </div>
                    <ul class="nav nav-pills nav-stacked main-menu">
                        <li class="nav-header">功能</li>
                        <li><a class="ajax-link" href="index.html"><i class="glyphicon glyphicon-home"></i><span> &ensp;首&ensp;页</span></a>
                        <li><a class="ajax-link" href="admin_list.html"><i class="glyphicon glyphicon-cog"></i><span> &ensp;管&ensp;理&ensp;员&ensp;信&ensp;息</span></a>
                        <li><a class="ajax-link" href="maintain_list.html"><i class="glyphicon glyphicon-wrench"></i><span> &ensp;报&ensp;修&ensp;管&ensp;理</span></a>
                        <li><a class="ajax-link" href="coustom_list.html"><i class="glyphicon glyphicon-user"></i><span> &ensp;业&ensp;主&ensp;信&ensp;息</span></a>
                        <li><a class="ajax-link" href="house_list.html"><i class="glyphicon glyphicon-list-alt"></i><span> &ensp;房&ensp;产&ensp;信&ensp;息</span></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <noscript>
            <div class="alert alert-block col-md-12">
                <h4 class="alert-heading">Warning!</h4>
                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>
        <div id="content" class="col-lg-10 col-sm-10">
            <div>
                <ul class="breadcrumb">
                    <li>
                        <a href="index.jsp">首页</a>
                    </li>
                    <li>
                        <a href="admin?action=adminList">管理员信息</a>
                    </li>
                </ul>
            </div>
            <div class="row">
                <div class="box col-md-12">
                    <div class="box-inner">
                        <div class="box-header well" data-original-title="">
                            <h2><i class="glyphicon glyphicon-cog"></i> 管理员信息</h2>
                            <div class="box-icon">
                                <a href="#" class="btn btn-minimize btn-round btn-default"><i
                                        class="glyphicon glyphicon-chevron-up"></i></a>
                                <a href="#" class="btn btn-close btn-round btn-default"><i class="glyphicon glyphicon-remove"></i></a>
                            </div>
                        </div>
                        <div class="box-content">
                            <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
                                <thead>
                                <a class="btn btn-success" href="admin/admin-add.jsp">
                                    <i class="glyphicon glyphicon-plus icon-white"></i>
                                    &ensp;添&ensp;加&ensp;记&ensp;录
                                </a>
                                <br/>
                                <br/>
                                <tr>
                                    <th>用户名</th>
                                    <th>密码</th>
                                    <th>身份证</th>
                                    <th>真名</th>
                                    <th>电话</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="admin" items="${requestScope.adminList}" >
                                    <tr>
                                        <td>${admin.ad_username}</td>
                                        <td>******</td>
                                        <td>${admin.ad_idcar}</td>
                                        <td>${admin.ad_truename}</td>
                                        <td>${admin.ad_phone}</td>
                                        <td class="center">
                                            <a class="btn btn-info" href="admin?action=findById&id=${admin.ad_id}">
                                                <i class="glyphicon glyphicon-edit icon-white"></i>
                                                编&ensp;辑
                                            </a>
                                            <a class="btn btn-danger" href="#" data-href="admin?action=adminDelete&id=${admin.ad_id}" data-toggle="modal" data-target="#myModal">
                                                <i class="glyphicon glyphicon-trash icon-white"></i>
                                                删&ensp;除
                                            </a>
                                        </td>
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

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h3>确认？</h3>
                </div>
                <div class="modal-body">
                    <p>此条记录将被永久删除</p>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-default" data-dismiss="modal">取消</a>
                    <a class="btn btn-danger btn-ok">确认删除</a>
                </div>
            </div>
        </div>
    </div>

    <footer class="row">
        <p class="col-md-9 col-sm-9 col-xs-12 copyright">&copy; <a href="http://usman.it" target="_blank">Muhammad
            Usman</a> 2012 - 2015</p>

        <p class="col-md-3 col-sm-3 col-xs-12 powered-by">Powered by: <a
                href="http://usman.it/free-responsive-admin-template">Charisma</a></p>
    </footer>

</div><!--/.fluid-container-->

<!-- external javascript -->

<script src="${pageContext.request.contextPath}bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="${pageContext.request.contextPath}js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='${pageContext.request.contextPath}bower_components/moment/min/moment.min.js'></script>
<script src='${pageContext.request.contextPath}bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src="${pageContext.request.contextPath}js/jquery.dataTables.min.js"></script>
<!-- select or dropdown enhancer -->
<script src="${pageContext.request.contextPath}bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="${pageContext.request.contextPath}bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="${pageContext.request.contextPath}js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="${pageContext.request.contextPath}bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="${pageContext.request.contextPath}bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="${pageContext.request.contextPath}js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="${pageContext.request.contextPath}js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="${pageContext.request.contextPath}js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="${pageContext.request.contextPath}js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="${pageContext.request.contextPath}js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="${pageContext.request.contextPath}js/charisma.js"></script>
<script>
    $('#myModal').on('show.bs.modal', function(e) {
        $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
    });
</script>
</body>
</html>
