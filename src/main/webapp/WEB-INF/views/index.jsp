<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String contextPath = pageContext.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- <meta charset="utf-8"> -->
<title>GR评审系统</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="author" content="Web Layout:Silence">
<link href="<%=contextPath%>/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=contextPath%>/resources/css/css.css" rel="stylesheet">
<script type="text/javascript" src="<%=contextPath%>/resources/js/comm/jquery.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/js/comm/bootstrap.min.js"></script>
</head>

<body>
<%@ include file="inc/nav.jsp"%> 
<!--nav-->
<div id="content">
<jsp:include page="inc/left_box.jsp" flush="true"/> 
	<!--left_box-->
	<div id="right_box">
		<ol class="breadcrumb">
			<li><a href="<%=contextPath%>">首页</a></li>
			<li class="active">评审进度查询</li>
			</ol>
		<!--路径导航-->
		<div class="choose">
        	<div class="btn-group" role="group" aria-label="" id="process_btn">
        	<c:forEach items="${procList}" var="process">
              <button type="button" class="btn btn-default">${process.name }</button>
            </c:forEach>
            </div>
        	<div class="btn-group" role="group" aria-label="" id="line_btn">
              <button type="button" class="btn btn-default active">全部</button>
              <button type="button" class="btn btn-default">大中华</button>
              <button type="button" class="btn btn-default">欧美</button>
              <button type="button" class="btn btn-default">韩国</button>
              <button type="button" class="btn btn-default">自研</button>
              <button type="button" class="btn btn-default">合作</button>
            </div>
		</div>
        <!--choose-->
        <c:forEach items="${procList}" var="process">
		<div class="panel panel-default">
		<div class="panel-body">
			<table class="table tb1">
				<tbody>
				<c:forEach items="${process.projList}" var="proj">
                	<tr>
                    	<th width="100"></th>
                    	<c:forEach items="${proj.projNodeList}" var="projNode">
                        	<th>${projNode.processNode.name}</th>
                        </c:forEach>
                    </tr>
					<tr>
						<td align="center"><a href="porject.shtml">${proj.name }</a>&nbsp;<a href="#" class="msg">
							<c:forEach items="${proj.projNodeList}" var="projNode">
								<c:if test="${'进行中' eq projNode.status}">
								<span class="glyphicon <c:if test="${'正常' eq projNode.isNormal}">glyphicon-ok-circle</c:if><c:if test="${'异常' eq projNode.isNormal}">glyphicon-exclamation-sign</c:if>"></span>
								</c:if>
							</c:forEach>
						</a></td>
						<c:forEach items="${proj.projNodeList}" var="projNode" varStatus="status">
							<c:set var="pcType0" value="${fn:toLowerCase(projNode.processNode.processType)}"/>
							<c:set var="pcType" value="${fn:substring(pcType0, fn:length(pcType0)-2, fn:length(pcType0))}"/>
							<c:choose>
								<c:when test="${'已完成' eq projNode.status}">
									<td class="over"><c:if test="${!status.last}"><q></q></c:if>
										<i class="${pcType}" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i>
									</td>
								</c:when>
								<c:when test="${'进行中' eq projNode.status}">
									<td class="now"><em class="${pcType}"></em><c:if test="${!status.last}"><q></q></c:if>
										<i class="${pcType} pop_show" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="费用工：1234$<br>费用B：3131$"></i>
									</td>
								</c:when>
								<c:otherwise>
									<td><c:if test="${!status.last}"><q></q></c:if>
										<i class="${pcType}" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="费用工：1234$<br>费用B：3131$"></i>
									</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<c:forEach items="${proj.projNodeList}" var="projNode">
						<c:if test="${'进行中' eq projNode.status}">
							<c:if test="${'正常' eq projNode.isNormal}">
								<tr class="msg_nothing">
			                    	<td class="bg-success"></td>
			                    	<td colspan="18" class="bg-success">
			                        	<p><strong>当前进展概述</strong>：${projNode.currentProgressDesc}。</p></td>
			                    </tr>
		                   	</c:if>
		                    <c:if test="${'异常' eq projNode.isNormal}">
								<tr class="msg_something">
			                    	<td class="bg-warning"></td>
			                    	<td colspan="18" class="bg-warning">
			                    	<p><strong>当前进展概述</strong>：${projNode.currentProgressDesc}。</p></td>
			                    </tr>
		                    </c:if>
	                    </c:if>
                    </c:forEach>
                    </c:forEach>
				</tbody>
			</table>
		</div>
		</div>
        <!--GR-->
        </c:forEach>
	</div>
	<!--right_box-->
</div>
<!--content-->
<script>
$('th').wrapInner("<b></b>");
//process_btn
$('#process_btn button').click(function(){
	if($(this).hasClass('active')){
		$('#process_btn button').removeClass('active');
		$('.panel').css('display','block');
	}
	else{
		$('#process_btn button').removeClass('active');
		$(this).addClass('active');
		$('.panel').css('display','none');
		$('body').find('.panel').eq($(this).index()).css('display','block');
	};
});
//line_btn
$('#line_btn button').click(function(){
	$('#line_btn button').removeClass('active');
	$(this).addClass('active');
});
$(function (){$("[data-toggle='popover']").popover({html : true});});
$(function (){$('.pop_show').popover('show');});
$('.msg').click(function (){
	if($(this).parent().parent().next('tr').hasClass('msg_nothing')){
		$(this).parent().parent().next('tr').removeClass('msg_nothing');
		$(this).parent().parent().next('tr').addClass('msg_something');
		}
	else{
		$(this).parent().parent().next('tr').removeClass('msg_something');
		$(this).parent().parent().next('tr').addClass('msg_nothing');
		};
});
</script>
</body>
</html>