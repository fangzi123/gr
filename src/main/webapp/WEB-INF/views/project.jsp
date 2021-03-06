<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<link href="<%=contextPath%>/resources/css/css.css" rel="stylesheet">
<link href="<%=contextPath%>/resources/css/project.css" rel="stylesheet">
<script type="text/javascript" src="<%=contextPath%>/resources/js/comm/jquery.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/js/comm/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/js/project.js"></script>
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
                    <li><a href="<%=contextPath%>">首页</a></li>
                    <li><a href="<%=contextPath%>">评审进度查询</a></li>
                    <li class="active">${project.name}</li>
                </ol>
            </div>
            <shiro:hasPermission name="edit:${project.id}">
        	<div class="col-xs-2 text-right">
        		<c:set var="pjnId" value=""/>
        		<c:forEach items="${project.projNodeList}" var="pjn" varStatus="status">
        			<c:if test="${status.first}"><c:set var="pjnId" value="${pjn.id}"/></c:if>
        			<c:if test="${'进行中' eq pjn.status}">
        				<c:set var="pjnId" value="${pjn.id}"/>
        			</c:if>
                </c:forEach>
        		<button type="button" class="btn btn-danger btn-block" id="btn-edit" data-pjnid="${empty pjnid?pjnId:pjnid}">编辑内容</button>
            </div>
            </shiro:hasPermission>
        </div>
		<!--路径导航-->
		<div class="panel panel-default">
		<div class="panel-body">
			<table class="table tb1">
            	<tbody>
					<tr>
                    	<th width="100"></th>
                    	<c:forEach items="${project.projNodeList}" var="pjn">
                        	<th>${pjn.processNode.name}</th>
                        </c:forEach>
               		</tr>
               		<c:forEach items="${pcTypeSet}" var="type">
	   					<c:set var="type0" value="${fn:toLowerCase(type)}"/>
						<c:set var="type1" value="${fn:substring(type0, fn:length(type0)-2, fn:length(type0))}"/>
						<tr id="${type1}">
							<td align="center">${type}</td>
		               		<c:forEach items="${project.projNodeList}" var="pjn" varStatus="status">
		               				<c:set var="pcType0" value="${fn:toLowerCase(pjn.processNode.processType)}"/>
									<c:set var="pcType" value="${fn:substring(pcType0, fn:length(pcType0)-2, fn:length(pcType0))}"/>
									<c:set var="feeVar" value=""/>
									<c:forEach items="${pjn.feeList}" var="fee">
										<c:set var="fee_i" value="${fee.feeTemplate.name}:${fee.money}"/>
										<c:set var="feeVar" value="${feeVar}${fee_i} "/>
									</c:forEach>
		                   			<c:choose>
										<c:when test="${'已完成' eq pjn.status}">
											<td class="over"><c:if test="${!status.last}"><q></q></c:if>
												<a href="#${pjn.processNode.name}" data-toggle="tab" data-nav="${pjn.processNode.name}" data-pjnid="${pjn.id}">
													<i class="${pcType}" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="${feeVar}"></i>
												</a>
											</td>
										</c:when>
										<c:when test="${'进行中' eq pjn.status}">
											<td class="now"><em class="${pcType}"></em><c:if test="${!status.last}"><q></q></c:if>
												<a href="#${pjn.processNode.name}" data-toggle="tab" data-nav="${pjn.processNode.name}" data-pjnid="${pjn.id}">
													<i class="${pcType}" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="${feeVar}"></i>
												</a>
											</td>
										</c:when>
										<c:otherwise>
											<td><c:if test="${!status.last}"><q></q></c:if>
												<a href="#${pjn.processNode.name}" data-toggle="tab" data-nav="${pjn.processNode.name}" data-pjnid="${pjn.id}">
													<i class="${pcType}" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="${feeVar}"></i>
												</a>
											</td>
										</c:otherwise>
									</c:choose>
		                    </c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</div>
		<!--进度-->
		<ul class="nav nav-tabs" id="nav_gr">
			<c:forEach items="${project.projNodeList}" var="pjn" varStatus="status">
				<li class="${pjn.processNode.name}" status="${pjn.status}"><a href="#${pjn.processNode.name}" data-toggle="tab" data-pjnid="${pjn.id}">${pjn.processNode.name}</a></li>
			</c:forEach>
		</ul>
		<div class="panel panel-default panel_tabs">
		<div class="panel-body tab-content">
		<c:forEach items="${project.projNodeList}" var="pjn" varStatus="status">
        	<div id="${pjn.processNode.name}" class="tab-pane fade in">
        		<c:if test="${'时间段' eq pjn.processNode.timeType}"><h3>开始时间：<fmt:formatDate  value="${pjn.startTime}" type="both" pattern="yyyy-MM-dd"/>&nbsp;-&nbsp;结束时间：<fmt:formatDate  value="${pjn.endTime}" type="both" pattern="yyyy-MM-dd"/></h3></c:if>
        		<c:if test="${'时间点' eq pjn.processNode.timeType}"><h3>评审时间：<fmt:formatDate  value="${pjn.reviewTime}" type="both" pattern="yyyy-MM-dd"/></h3></c:if>
               	<hr>
               	<c:if test="${pjn.processNode.hasFee}">
                <h3>费用</h3>
                <table class="table table-condensed table-striped table-hover pass">
                    <thead>
                        <tr>
                        <th>费用名称</th>
                        <th>金额</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pjn.feeList}" var="fee">
                        <tr>
                        <td>${fee.feeTemplate.name}</td>
                        <td>${fee.money}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                </c:if>
                <c:if test="${pjn.processNode.hasManpower}">
                <h3>人力 </h3>
                <table class="table table-condensed table-striped table-hover pass">
                    <thead>
                        <tr>
                        <th>项目团队</th>
                        <th>核心大师人力投入</th>
                        <th>人力标准模型</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pjn.manpowerList}" var="man">
                        <tr>
                        <td>${man.manpowerTemplate.projectTeam }</td>
                        <td>${man.coreMan }</td>
                        <td>${man.manpowerTemplate.standardModel }</td>
                        </tr></c:forEach>
                    </tbody>
                </table>
                </c:if>
                <c:if test="${pjn.processNode.hasTaskbook}">
                <h3>任务书</h3>
                <table class="table table-condensed table-striped table-hover">
                    <thead>
                        <tr>
                        <th>产品</th>
                        <th>标注</th>
                        <th>指标</th>
                        <th>实际值</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pjn.taskbookList}" var="taskbook">
                        <tr>
                        <td>${taskbook.taskBookTemplate.quotaName }</td>
                        <td>
                        	<c:if test="${'关键指标' eq taskbook.taskBookTemplate.quotaType }"><strong>${taskbook.taskBookTemplate.quotaType }</strong></c:if>
                        	<c:if test="${'关键指标' ne taskbook.taskBookTemplate.quotaType }">${taskbook.taskBookTemplate.quotaType }</c:if>
                        </td>
                        <td><fmt:formatNumber value="${taskbook.quotaNum}" pattern="#,#00.00#%"/></td>
                        <td><span class="label label-success"><fmt:formatNumber value="${taskbook.quotaNumReal}" pattern="#,#00.00#%"/></span></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table></c:if>
                <c:if test="${pjn.processNode.hasCheckbill}">
	                <h3>检查单</h3>
	                <table class="table table-condensed table-striped table-hover">
					  <thead><tr>
						<th>检查项</th>
						<th>检查项属性</th>
						<th>是否合格</th>
						<th>备注</th>
					  </tr></thead>
					  <c:forEach items="${pjn.checkbillList}" var="cb">
						  <c:choose>
							  <c:when test="${'特殊增项' eq cb.checkbillTemplate.checkItemProperty }">
							  		<tr>
							  		<td>${cb.checkItem}</td>
									<td>特殊增项</td>
									<td>
										<c:if test="${cb.isqualified}"><span class="label label-success">√</span></c:if>
										<c:if test="${!cb.isqualified}"><span class="label label-danger">X</span></c:if>
									</td>
									<td>${cb.remark}</td>
									</tr>
							  </c:when>
							  <c:otherwise>
									<tr>
									<td>${cb.checkbillTemplate.checkItem}</td>
									<td>${cb.checkbillTemplate.checkItemProperty }</td>
									<td>
										<c:if test="${cb.isqualified}"><span class="label label-success">√</span></c:if>
										<c:if test="${!cb.isqualified}"><span class="label label-danger">X</span></c:if>
									</td>
									<td>${cb.checkbillTemplate.remark}</td>
									</tr>
							  </c:otherwise>
						  </c:choose>
					  </c:forEach>
			 		</table>
		 		</c:if>
		 		<c:if test="${pjn.processNode.hasDocument}">
                <h3>文档管理</h3>
                <table class="table table-condensed table-striped table-hover">
                    <thead>
                        <tr>
                            <th>文档名称</th>
                            <th>上传者</th>
                            <th>下载</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pjn.documentList}" var="doc" varStatus="status">
	                    <form action="<%=contextPath%>/doc/download" method="post" name="form${doc.id}">  
                        	<tr>
	                        <input name="path" value="${doc.url}" type="hidden">
                            <td><a href="javascript:document.form${doc.id}.submit()">【${project.name}】${doc.filename}</a></td>
                            <td>${doc.author }&nbsp;<span class="badge"><fmt:formatDate  value="${doc.uploadTime}" type="both" pattern="yyyy-MM-dd"/></span></td>
                            <td><button type="button" class="btn btn-default" onclick="javascript:document.form${doc.id}.submit()"><span class="glyphicon glyphicon-floppy-save"></span></button></td>
                        	</tr>
                        </form> 
                    </c:forEach>
                    </tbody>
                </table>
		 		</c:if>
                <h3>当前进展概述</h3>
                <p <c:if test="${'异常' eq pjn.isNormal}">class="text-danger"</c:if>>【${pjn.isNormal}】：${pjn.currentProgressDesc}</p>
                <div class="alert alert-warning alert-dismissible" role="alert">
			        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <strong>说明：</strong>${pjn.processNode.nodesOverview}
		        </div>
             </div>
             </c:forEach>
		</div>
		</div>
	</div>
	<!--right_box-->
</div>
<input type="hidden" name="pjnid" value="${pjnid}">
<!--content-->
<script>
//popover
$(function (){$("[data-toggle='popover']").popover();});
$(function (){$('.pop_show').popover('show');});
</script>
</body>
</html>