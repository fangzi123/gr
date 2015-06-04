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
<script type="text/javascript" src="<%=contextPath%>/resources/js/comm/jquery.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/js/comm/ajaxfileupload.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/js/comm/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/js/comm/jquery-html5Validate.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/js/projnode_edit.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/js/doc_comm.js"></script>
<c:set var="sysDate" value="<%=new java.util.Date()%>"></c:set>
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
                    <li><a href="<%=contextPath%>/gr/index">评审进度查询</a></li>
                    <li><a href="<%=contextPath%>/gr/projview?id=${projNode.projectId}">${projNode.project.name}</a></li>
                    <li class="active">${projNode.processNode.name}</li>
                </ol>
            </div>
        	<div class="col-xs-2 text-right">
        		<button type="button" class="btn btn-danger btn-block" onclick="javascript:window.location.href='<%=contextPath%>/gr/mail?id=${projNode.id}'">发送邮件</button>
            </div>
        </div>
		<!--路径导航-->
		<!--进度-->
		<div class="panel panel-default">
		<div class="panel-heading">${projNode.processNode.name}</div>
		<form id="form_edit" name="form_edit" method="post" action="<%=contextPath%>/gr/pjnedit" enctype="multipart/form-data">
		<input name="projectId" type="hidden" value="${projNode.projectId}">
		<input name="id" type="hidden" value="${projNode.id}">
		<div class="panel-body">
                <div class="form-inline">
                  <div class="form-group">
                    <label for="">当前状态：</label>
                    <select name="status" class="form-control" id="status">
                          <option value="未开启" <c:if test="${'未开启 ' eq projNode.status}">selected</c:if>>未开启</option>
                          <option value="进行中" <c:if test="${'进行中' eq projNode.status }">selected</c:if>>进行中</option>
                          <option value="未通过" <c:if test="${'未通过 ' eq projNode.status}">selected</c:if>>未通过</option>
                          <c:if test="${'手动完结' eq projNode.processNode.endType}">
                          <option value="已完成" <c:if test="${'已完成 ' eq projNode.status}">selected</c:if>>已完成</option></c:if>
                          <option value="跳过 " <c:if test="${'跳过' eq projNode.status}">selected</c:if>>跳过</option>
                    </select>
                  </div>
                <hr>
                </div>
                <c:choose>
	                <c:when test="${'时间点' eq projNode.processNode.timeType}">
		                <div class="form-inline pass">
		                  <div class="form-group">
		                    <label for="exampleInputName2">开始时间：</label>
		                    <input type="date" class="form-control" name="startTime" placeholder="" value="<fmt:formatDate  value="${empty projNode.endTime?sysDate:projNode.startTime}" type="both" pattern="yyyy-MM-dd"/>">
		                  </div>
		                  <div class="form-group">
		                    <label for="exampleInputEmail2">结束时间：</label>
		                    <input type="date" class="form-control" name="endTime" placeholder="" value="<fmt:formatDate  value="${empty projNode.endTime?sysDate:projNode.endTime}" type="both" pattern="yyyy-MM-dd"/>">
		                  </div>
		               	<hr>
		                </div>
	                </c:when>
	                <c:otherwise>
		                <div class="form-inline pass">
		                  <div class="form-group">
		                    <label for="exampleInputName2">评审时间：</label>
		                    <input type="date" class="form-control" name="reviewTime" placeholder="" value="<fmt:formatDate  value="${empty projNode.reviewTime?sysDate:projNode.reviewTime}" type="both" pattern="yyyy-MM-dd"/>">
		                  </div>
		                <hr>
						</div>
					</c:otherwise> 
				</c:choose>
				<c:if test="${projNode.processNode.hasFee}">
	                <h3 class="pass">费用</h3>
	                <table class="table table-condensed table-striped table-hover pass">
	                    <thead>
	                        <tr>
	                        <th width="150">是否在默认显示</th>
	                        <th>费用名称</th>
	                        <th>金额</th>
	                        </tr>
	                    </thead>
	                    <tbody>
	                    	<c:forEach items="${projNode.feeList}" var="fee">
		                        <tr>
		                        <input type="hidden" name="feeId" value="${fee.id}">
		                        <td>
		                        <input type="checkbox"   onClick="isDisplay(this);" <c:if test="${fee.display}">checked</c:if>>
		                        <input type="hidden" name="display" value="${fee.display}">
		                        </td>
		                        <td>${fee.feeTemplate.name}</td>
		                        <td><input type="text" class="form-control"  placeholder="" name="money" value="${fee.money}" required></td>
		                        </tr>
	                        </c:forEach>
	                    </tbody>
	                </table>
                </c:if>
                <c:if test="${projNode.processNode.hasManpower}">
                <h3 class="pass">人力</h3>
                <table class="table table-condensed table-striped table-hover pass">
                    <thead>
                        <tr>
                        <th>项目团队</th>
                        <th>核心大师人力投入</th>
                        <th>人力标准模型</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach items="${projNode.manpowerList}" var="man">
	                        <tr>
	                        <input type="hidden" name="manpowerId" value="${man.id}" required>
	                        <td>${man.manpowerTemplate.projectTeam }</td>
	                        <td><input type="text" class="form-control" name="coreMan" placeholder="" value="${man.coreMan }" required></td>
	                        <td>${man.manpowerTemplate.standardModel }</td>
	                        </tr>
                        </c:forEach>
                    </tbody>
                </table></c:if>
                <c:if test="${projNode.processNode.hasTaskbook}">
                <h3 class="pass">任务书</h3>
                <table class="table table-condensed table-striped table-hover pass">
                    <thead>
                        <tr>
                        <th width="30%">产品</th>
                        <th width="30%">标注</th>
                        <th>指标</th>
                        <th>实际值</th>
                        </tr>
                    </thead>
                    <tbody> <c:forEach items="${projNode.taskbookList}" var="taskbook">
                        <tr>
                        <input type="hidden" name="taskbookId" value="${taskbook.id}">
                        <td>${taskbook.taskBookTemplate.quotaName }</td>
                        <td><c:if test="${'关键指标' eq taskbook.taskBookTemplate.quotaType }"><strong>${taskbook.taskBookTemplate.quotaType }</strong></c:if>
                        	<c:if test="${'关键指标' ne taskbook.taskBookTemplate.quotaType }">${taskbook.taskBookTemplate.quotaType }</c:if></td>
                        <td><input type="number" class="form-control" name="quotaNum" max="1" min="0" step="0.0001" required placeholder="" value="${taskbook.quotaNum}"></td>
                        <td><input type="number" class="form-control" name="quotaNumReal" max="1" min="0" step="0.0001" required placeholder="" value="${taskbook.quotaNumReal}"></td>
                        </tr></c:forEach>
                    </tbody>
                </table></c:if>
                <c:if test="${projNode.processNode.hasCheckbill}">
                <h3 class="pass">检查单</h3>
                <table class="table table-condensed table-striped table-hover pass">
				  <thead><tr>
					<th>检查项</th>
					<th>检查项属性</th>
					<th>是否合格</th>
					<th>备注</th>
				  </tr></thead>
				  <c:forEach items="${projNode.checkbillList}" var="cb">
						  <c:choose>
							  <c:when test="${'特殊增项' eq cb.checkbillTemplate.checkItemProperty }">
								  <tr>
								  	<input type="hidden" name="checkbillId" value="${cb.id}">
									<td><input type="text" class="form-control" name="checkItem" placeholder="特殊增项" value="${cb.checkItem}"></td>
									<td>特殊增项</td>
									<td>
				                    	<div class="btn-group switch" role="group">
				                          <button type="button" class="btn btn-success ${cb.isqualified?'active':''}">YES</button>
				                          <button type="button" class="btn btn-danger  ${cb.isqualified?'':'active'}">NO</button>
				                          <input type="hidden" name="isqualified" value="${cb.isqualified}">
				                        </div>
				                    </td>
									<td><input type="text" class="form-control" name="remark" placeholder="特殊需要增加评审项说明。" value="${cb.remark}"></td>
								  </tr>
				 			  </c:when>
							  <c:otherwise>
								  <tr>
								  	<input type="hidden" name="checkbillId" value="${cb.id}">
								  	<input type="hidden" name="checkItem" value="">
								  	<input type="hidden" name="remark" value="">
									<td>${cb.checkbillTemplate.checkItem}</td>
									<td>${cb.checkbillTemplate.checkItemProperty }</td>
									<td>
				                    	<div class="btn-group switch" role="group">
				                          <button type="button" class="btn btn-success ${cb.isqualified?'active':''}">YES</button>
				                          <button type="button" class="btn btn-danger  ${cb.isqualified?'':'active'}">NO</button>
				                          <input type="hidden" name="isqualified" value="${cb.isqualified}">
				                        </div>
				                    </td>
									<td>${cb.checkbillTemplate.remark}</td>
								  </tr>
				   			  </c:otherwise>
						</c:choose>
			      </c:forEach>
		 		</table></c:if>
		 		<c:if test="${projNode.processNode.hasDocument}">
                <h3 class="pass">文档管理</h3>
                <table class="table table-condensed table-striped table-hover pass">
                    <thead>
                        <tr>
                            <th>文档名称</th>
                            <th width="30%">选择文件</th>
                            <th width="20%">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach items="${projNode.documentList}" var="doc" varStatus="status">
                        <tr>
                            <td>【${projNode.project.name}】${doc.filename}</td>
                            <td>${doc.author }&nbsp;<span class="badge"><fmt:formatDate  value="${doc.uploadTime}" type="both" pattern="yyyy-MM-dd"/></span></td>
                            <td><button type="button" class="btn btn-default" data-docid="${doc.id}" name="btn_del"><span class="glyphicon glyphicon-trash"></span></button></td>
                        </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="2">
                           		<input type="file"  name="doc" id="fileToUpload">
                            </td>
<!--                             <td> -->
<!-- 	                            <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-plus"></span></button>&nbsp; -->
<!-- 	                            <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-minus"></span></button> -->
<!--                             </td> -->
                        </tr>
                    </tbody>
                </table>
                </c:if>
            <h3>当前进展概述</h3>
            <div class="form-inline">
              <div class="form-group">
                <select name="isNormal" class="form-control">
                      <option value="正常" <c:if test="${'正常' eq projNode.isNormal}">selected</c:if>>正常</option>
                      <option value="异常 " <c:if test="${'异常' eq projNode.isNormal}">selected</c:if>>异常</option>
                </select>
              </div>
            </div>
            <div class="form-group"><textarea class="form-control" rows="3" name="currentProgressDesc">${projNode.currentProgressDesc}</textarea></div>
		</div>
		</form>
		</div>
		<!--GR-->
        <div class="text-center">
              <button class="btn btn-success btn-lg"><span class="glyphicon glyphicon-floppy-saved">&nbsp;</span>保存</button>
              <a href="<%=contextPath%>/gr/projview?id=${projNode.projectId}" class="btn btn-default btn-lg"><span class="glyphicon glyphicon glyphicon-share">&nbsp;</span>返回</a>
        </div>
        <!--save-->
	</div>
	<!--right_box-->
</div>
<!--content-->
<input id="projectName" type="hidden" value="${projNode.project.name}">
<script>
//status
$('#status').change(function(){
	if ($(this).val() == 'pass'){
		$('.pass').css('display','none');
	}
	else{
		$('.pass').css('display','block');
	};		
}) 

//+-
$('.glyphicon-plus').parent().click(function(){
	$(this).parent().parent().clone(true).insertAfter($(this).parent().parent());
});
$('.glyphicon-minus').parent().click(function(){
	var tr_length = $(this).parent().parent().parent().children('tr').length;
	if (tr_length>2){$(this).parent().parent().remove();}
	else {alert('最后一行无法删除！')};
});
var ctx='<%=contextPath%>';
</script>
</body>
</html>