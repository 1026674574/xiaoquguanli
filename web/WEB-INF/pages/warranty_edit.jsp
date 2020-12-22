<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>编辑:物业管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">
    <!-- The styles -->
    <link href="${pageContext.request.contextPath}/css/bootstrap-cerulean.min.css" rel="stylesheet" media="screen">
    <link href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
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
    <link href='${pageContext.request.contextPath}/css/elfinder.theme.css' rel='stylesheet'>
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
        <a class="navbar-brand" href="index.jsp"> <img alt="Charisma Logo" src="${pageContext.request.contextPath}/img/logo20.png" class="hidden-xs"/>
            <span>物业管理系统</span></a>
        <!-- user dropdown starts -->
        <div class="btn-group pull-right">
            <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"> ${admin.name}</span>
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li><a href="user?action=logout">注销登录</a></li>
            </ul>
        </div>
    </div>
</div>
<!-- topbar ends -->
<div class="ch-container">
    <div class="row">
        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked"></div>
                    <ul class="nav nav-pills nav-stacked main-menu">
                        <li class="nav-header">功能</li>
                            <li><a class="ajax-link" href="index.jsp"><i class="glyphicon glyphicon-home"></i><span> &ensp;首&ensp;页</span></a>
                            <li><a class="ajax-link" href="admin?action=adminList"><i class="glyphicon glyphicon-cog"></i><span> &ensp;管&ensp;理&ensp;员&ensp;信&ensp;息</span></a>
                            <li class="active"><a class="ajax-link" href="main?action=maintainList"><i class="glyphicon glyphicon-wrench"></i><span> &ensp;报&ensp;修&ensp;管&ensp;理</span></a>
                            <li><a class="ajax-link" href="custom?action=customAccountList"><i class="glyphicon glyphicon-user"></i><span> &ensp;业&ensp;主&ensp;信&ensp;息</span></a>
                            <li><a class="ajax-link" href="house?action=houseList"><i class="glyphicon glyphicon-list-alt"></i><span> &ensp;房&ensp;产&ensp;信&ensp;息</span></a>
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
                    <li><a href="index.jsp">首页</a></li>
                    <li><a href="main?action=maintainList">报修管理</a></li>
                    <li><a href="#">编辑</a></li>
                </ul>
            </div>

        <div class="row">
                <div class="box col-md-12">
                    <div class="box-inner">
                        <div class="box-header well" data-original-title="">
                            <h2><i class="glyphicon glyphicon-edit"></i> 编辑</h2>
                            <div class="box-icon">
                                <a href="#" class="btn btn-minimize btn-round btn-default"><i
                                        class="glyphicon glyphicon-chevron-up"></i></a>
                                <a href="#" class="btn btn-close btn-round btn-default"><i
                                        class="glyphicon glyphicon-remove"></i></a>
                            </div>
                        </div>
                        <div class="box-content">
                            <form role="form" data-toggle="validator" action="warrantyServlet?method=updateWarranty" method="post">
                                <fieldset>
<%--                                    <div class="form-group">--%>
<%--                                        <div class="input-group col-md-3">--%>
<%--                                            <label class="control-label">报修物品*</label>--%>
<%--                                            <input type="text" class="form-control" name="thing" value="${requestScope.warrranty.wa_text}" required>--%>
<%--                                            <span class="help-block with-errors"></span>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
                                    <div class="form-group">
                                        <div class="input-group col-md-3">
                                            <label class="control-label">报修单状态*</label><br>
                                            <select data-rel="chosen" name="status" value="${requestScope.warrranty.wa_state}">
                                                <option value="${requestScope.warrranty.wa_state }">${requestScope.warrranty.wa_state }</option>
                                                <option value="0">等待处理</option>
                                                <option value="1">正在处理</option>
                                                <option value="2">已完成</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label">报修时间*</label>
                                        <div class="input-group date form_date col-md-3" data-date="" data-date-format="yyyy-mm-dd" data-link-format="yyyy-mm-dd">
                                            <input class="form-control" name="sdate" type="text" value="${requestScope.warrranty.wa_datetime}" readonly required>
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                        </div>
                                        <input type="hidden" id="dtp_input2" value="" /><br/>
                                    </div>
<%--                                    <div class="form-group">--%>
<%--                                        <div class="input-group col-md-3">--%>
<%--                                            <label class="control-label">报修人</label>--%>
<%--                                            <input type="text" class="form-control" name="maintainer" value="${requestScope.warrranty.userInfo.us_truename}" required>--%>
<%--                                            <span class="help-block with-errors"></span>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
                                    <div class="input-group col-md-3">
                                        <label class="control-label">报修详情</label>
                                        <input type="text" class="form-control" name=back >
                                        <span class="help-block with-errors">

                                        </span>
                                    </div>
                        <input type="hidden"  name="id"  value="${requestScope.warrranty.wa_id}"/>
                        <button type="submit" class="btn btn-info">提&ensp;交&ensp;</button>
                        </fieldset>
                        </form>

                </div>
            </div>
        </div>
    </div>
    </div>
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
                <h3>确认提交</h3>
            </div>
            <div class="modal-body">
                <p>信息将被提交。</p>
            </div>
            <div class="modal-footer">
                <a href="#" class="btn btn-default" data-dismiss="modal">取消</a>
                <a href="#" class="btn btn-primary" data-dismiss="modal">确定</a>
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
<script src="${pageContext.request.contextPath}/js/validator.min.js"></script>
<script src="${pageContext.request.contextPath}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- library for cookie management -->
<script src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='${pageContext.request.contextPath}/bower_components/moment/min/moment.min.js'></script>
<script src='${pageContext.request.contextPath}/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='${pageContext.request.contextPath}/js/jquery.dataTables.min.js'></script>
<!-- select or dropdown enhancer -->
<script src="${pageContext.request.contextPath}/bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="${pageContext.request.contextPath}/bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="${pageContext.request.contextPath}/js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="${pageContext.request.contextPath}/bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="${pageContext.request.contextPath}/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="${pageContext.request.contextPath}/js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="${pageContext.request.contextPath}/js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="${pageContext.request.contextPath}/js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="${pageContext.request.contextPath}/js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="${pageContext.request.contextPath}/js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="${pageContext.request.contextPath}/js/charisma.js"></script>
<!-- datetime-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript">
    $('.form_date').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
</script>
</body>
</html>
</html>