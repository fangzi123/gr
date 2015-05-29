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
<script type="text/javascript" src="<%=contextPath%>/resources/js/comm/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/js/comm/jquery-html5Validate.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/js/mail.js"></script>
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
                    <li><a href="<%=contextPath%>/gr/projview?id=${projNode.projectId}">${projNode.project.name}</a></li>
                    <li><a href="<%=contextPath%>/gr/projnview?id=${projNode.id}">${projNode.processNode.name}</a></li>
                    <li class="active">邮件</li>
                </ol>
            </div>
        	<div class="col-xs-2 text-right">
            </div>
        </div>
		<!--路径导航-->
		<form class="form-horizontal" role="form" id="form_mail" action="<%=contextPath%>/gr/sendmail" method="post">
		<div class="panel panel-default">
		<div class="panel-body tab-content mail_txt">
            <div class="form-group">
                <label for="inputEmail3" class="col-xs-1 control-label">收件人</label>
                <div class="col-xs-4"><input type="email" class="form-control" name="to" required placeholder="XXX@XXX"></div>
            </div>
            <div class="form-group">
                <label for="inputEmail3" class="col-xs-1 control-label">邮件标题</label>
                <div class="col-xs-4"><input type="text" class="form-control" name="title" required placeholder=""></div>
            </div>
<!--             <div class="form-group"> -->
<!--                 <label for="inputEmail3" class="col-xs-1 control-label">模块选择</label> -->
<!--                 <div class="col-xs-11"> -->
<!--                     <div class="btn-group" role="group" aria-label="" id="module_btn"> -->
<!--                       <button type="button" class="btn btn-default">任务书</button> -->
<!--                       <button type="button" class="btn btn-default">文档管理</button> -->
<!--                       <button type="button" class="btn btn-default">检查单</button> -->
<!--                     </div> -->
<!--                 </div> -->
<!--             </div> -->
            <div class="form-group">
              <div class="col-xs-offset-1 col-sm-11">
                <div class="checkbox">
                  <label>
                    <input type="checkbox" checked disabled>自动完结此节点
                  </label>
                </div>
              </div>
            </div>
            
            <hr>
             
            <div class="col-xs-offset-1 col-sm-11">
            	<textarea class="form-control" rows="5" name="contents" required>
             	   各位领导、同事：
                
                </textarea>
                <p>&nbsp;</p>
                <c:if test="${projNode.processNode.hasFee}">
                <h5>费用</h5>
                <table class="table table-condensed table-bordered table-striped table-hover">
                    <thead>
                        <tr>
	                        <th width="150">默认显示</th>
	                        <th>费用名称</th>
	                        <th>金额</th>
	                    </tr>
                    </thead>
                    <tbody> <c:forEach items="${projNode.feeList}" var="fee">
                        <tr>
                        <td>${fee.display}</td>
                        <td>${fee.feeTemplate.name}</td>
                        <td> ${fee.money}</td>
                        </tr></c:forEach>
                </table>
                </c:if>
                <c:if test="${projNode.processNode.hasManpower}">
                <h5>人力</h5>
                <table class="table table-condensed table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                        <th>项目团队</th>
                        <th>核心大师人力投入</th>
                        <th>人力标准模型</th>
                        </tr>
                    </thead>
                    <tbody><c:forEach items="${projNode.manpowerList}" var="man">
                        <tr>
                        <td>${man.manpowerTemplate.projectTeam }</td>
                        <td>${man.coreMan }</td>
                        <td>${man.manpowerTemplate.standardModel }</td>
                        </tr></c:forEach>
                </table>
                </c:if>
                <c:if test="${projNode.processNode.hasTaskbook}">
                <h5>任务书</h5>
                <table class="table table-condensed table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                        <th>产品</th>
                        <th>标注</th>
                        <th>指标</th>
                        <th>实际值</th>
                        </tr>
                    </thead>
                    <tbody> <c:forEach items="${projNode.taskbookList}" var="taskbook">
                        <tr>
                        <td>${taskbook.taskBookTemplate.quotaName }</td>
                        <td>${taskbook.taskBookTemplate.quotaType }</td>
                        <td><fmt:formatNumber value="${taskbook.quotaNum}" pattern="#,#00.00#%"/></td>
                        <td><span class="label ${taskbook.quotaNumReal gt taskbook.quotaNum?'label-success':'label-danger'}"><fmt:formatNumber value="${taskbook.quotaNumReal}" pattern="#,#00.00#%"/></span></td>
                        </tr></c:forEach>
                </table>
                </c:if>
                <c:if test="${projNode.processNode.hasCheckbill}">
                <h5>检查单</h5>
				<table class="table table-condensed table-bordered table-striped table-hover">
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
									<td>${cb.checkItem}</td>
									<td>特殊增项</td>
									<td><span class="label ${cb.isqualified?'label-success':'label-danger'}">${cb.isqualified?'√':'X'}</span></td>
									<td>${cb.remark}</td>
								  </tr>
				  			  </c:when>
							  <c:otherwise>
								  <tr>
									<td>${cb.checkbillTemplate.checkItem}</td>
									<td>${cb.checkbillTemplate.checkItemProperty }</td>
									<td><span class="label ${cb.isqualified?'label-success':'label-danger'}">${cb.isqualified?'√':'X'}</span></td>
									<td>${cb.checkbillTemplate.remark}</td>
								  </tr>
				  	  		 </c:otherwise>
						</c:choose>
			      </c:forEach>
		 		</table></c:if>
		 		<c:if test="${projNode.processNode.hasDocument}">
                <h5>文档管理</h5>
                <table class="table table-condensed table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>文档名称</th>
                            <th>上传者</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${projNode.documentList}" var="doc" varStatus="status">
                        <tr>
                            <td>【${projNode.project.name}】${doc.filename}</td>
                            <td>${doc.author }&nbsp;<span class="badge"><fmt:formatDate  value="${doc.uploadTime}" type="both" pattern="yyyy-MM-dd"/></span></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <p>&nbsp;</p></c:if>
              </div>
		</div>
		</div>
		<!--mailtext-->
        <div class="text-center">
              <a href="javascript:void(0)" class="btn btn-success btn-lg"><span class="glyphicon glyphicon-send">&nbsp;</span>发送</a>
              <a href="<%=contextPath%>/gr/projnview?id=${projNode.id}" class="btn btn-default btn-lg"><span class="glyphicon glyphicon glyphicon-share">&nbsp;</span>返回</a>
        </div>
        <input type="hidden" value="${projNode.id}" name="id">
        <input type="hidden" value="${projNode.projectId}" name="projectId">
        </form>
        <!--mail-->
	</div>
	<!--right_box-->
</div>
<!--content-->
<script>
//module_btn
$('#module_btn button').click(function(){
	if($(this).hasClass('active')){
		$(this).removeClass('active');
	}
	else{
		$(this).addClass('active');
	};
});
</script>
</body>
</html>