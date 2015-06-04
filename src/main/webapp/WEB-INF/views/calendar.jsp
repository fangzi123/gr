<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String contextPath = pageContext.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>GR评审系统</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="author" content="Web Layout:Silence">
<link href="<%=contextPath%>/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=contextPath%>/resources/css/fullcalendar.css" rel="stylesheet">
<link href="<%=contextPath%>/resources/css/css.css" rel="stylesheet">
<script type="text/javascript" src="<%=contextPath%>/resources/js/comm/jquery.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/js/comm/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/js/comm/moment.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/js/comm/fullcalendar.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/js/comm/zh-cn.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/js/calendar.js"></script>
</head>

<body>

<%@ include file="inc/nav.jsp"%> 
<!--nav-->
<div id="content">
	<jsp:include page="inc/left_box.jsp" flush="true"/>
	<!--left_box-->
	<div id="right_box">
    	<div class="row">
        	<div class="col-xs-10">
                <ol class="breadcrumb">
                    <li><a href="<%=contextPath%>/gr/index">首页</a></li>
                    <li class="active">日历</li>
                </ol>
            </div>
        	<div class="col-xs-2 text-right">
            </div>
        </div>
		<!--路径导航-->
        <div id="calendar"></div>
		<!--calendar-->
	</div>
	<!--right_box-->
</div>
<!--content-->
<input type="hidden" value='${list}' id="data">
</body>
</html>