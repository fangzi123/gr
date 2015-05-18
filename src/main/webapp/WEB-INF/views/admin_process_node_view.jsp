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
<link href="<%=contextPath%>/resources/css/css.css" rel="stylesheet">
<script type="text/javascript" src="<%=contextPath%>/resources/js/comm/jquery.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/js/comm/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/js/procNode_manage_view.js"></script>
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
                    <li><a href="<%=contextPath%>/process/index">流程</a></li>
                    <li><a href="<%=contextPath%>/process/procNode/index?procId=${procNode.processId}">${procNode.process.name }</a></li>
                    <li class="active">${procNode.name}</li>
                </ol>
            </div>
        	<div class="col-xs-2 text-right">
                <button type="button" class="btn btn-danger  btn-block" data-toggle="modal" data-target="#exampleModal">模块管理</button>
            </div>
        </div>
		<!--路径导航-->
		<div class="panel panel-default">
        <div class="panel-heading">${procNode.name}</div>
        <form action="editSave" method="post" id="form-save">
        <input type="hidden" value="${procNode.id}" name="id">
        <input type="hidden" value="${procNode.processId}" name="processId" id="processId">
        <input type="hidden" value="${procNode.hasFee}" name="hasFee">
        <input type="hidden" value="${procNode.hasManPower}" name="hasManPower">
        <input type="hidden" value="${procNode.hasTaskBook }" name="hasTaskBook">
        <input type="hidden" value="${procNode.hasCheckBill }" name="hasCheckBill">
        <input type="hidden" value="${procNode.hasDocument }" name="hasDocument">
		<div class="panel-body">
                <div class="form-inline">
                  <div class="form-group">
                    <select name="processType" class="form-control" data="${procNode.processType}"> 
                          <option value="GR">GR</option>
                          <option value="CR">CR</option>
                          <option value="MR">MR</option>
                          <option value="TR">TR</option>
                          <option value="CB&OB">CB&amp;OB</option>
                        </select>
                  </div>
                  <div class="form-group">
                    <select name="endType" class="form-control" data="${procNode.endType }">
                          <option value="手动完结">手动完结</option>
                          <option value="邮件完结">邮件完结</option>
                        </select>
                  </div>
                  <div class="form-group">
                    <select name="timeType" class="form-control" data="${procNode.timeType }">
                          <option value="时间段">时间段</option>
                          <option value="时间点">时间点</option>
                        </select>
                  </div>
                <hr>
                </div>
                <div id="hasFee_box" style="<c:if test="${!procNode.hasFee}">display:none</c:if>">
                <h3>费用</h3>
                <table class="table table-condensed table-striped table-hover">
                    <thead>
                        <tr>
                        <th>费用名称</th>
                        <th width="200">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${feets}" var="feet">
                    <input type="hidden" name="feetId" value="${feet.id}">
                        <tr>
                        <td><input type="text" class="form-control" name="feeName" value="${feet.name }" placeholder=""></td>
                        <td>
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-arrow-up"></span></button>
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-arrow-down"></span></button>
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-plus"></span></button>
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-minus"></span></button>
                        </td>
                        </tr>
                     </c:forEach>
                    </tbody>
                </table>
                </div>
                <div id="hasManPower_box" style="<c:if test="${!procNode.hasManPower}">display:none</c:if>">
                <h3>人力</h3>
                <table class="table table-condensed table-striped table-hover">
                    <thead>
                        <tr>
                        <th>项目团队</th>
                        <th>人力标准模型</th>
                        <th width="200">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${manpowerts}" var="manpower">
                        <tr>
                        <td><input type="text" class="form-control" name="projectTeam" value="${manpower.projectTeam }" placeholder=""></td>
                        <td><input type="text" class="form-control" name="standardModel" value="${manpower.standardModel }" placeholder=""></td>
                        <td>
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-arrow-up"></span></button>
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-arrow-down"></span></button>
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-plus"></span></button>
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-minus"></span></button>
                        </td>
                        </tr>
                     </c:forEach>
                    </tbody>
                </table>
                </div>
                <div id="hasTaskBook_box" style="<c:if test="${!procNode.hasTaskBook}">display:none</c:if>">
                <h3>任务书</h3>
                <table class="table table-condensed table-striped table-hover">
                    <thead>
                        <tr>
                        <th>指标名称</th>
                        <th>标注</th>
                        <th width="200">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${taskbookts}" var="taskBookt">
                        <tr>
                        <td><select name="quotaName" class="form-control">
                        <c:forEach items="${quotaList}" var="quota">
                          <option value="${quota.name}" <c:if test="${quota.name eq  taskBookt.quotaName }">selected="selected"</c:if>>${quota.name}</option>
                        </c:forEach>
                        </select></td>
                        <td><select name="quotaType" class="form-control">
                          <option vauel="辅助参考" <c:if test="${'辅助参考' eq  taskBookt.quotaType }">selected="selected"</c:if>>辅助参考</option>
                          <option value="关键指标" <c:if test="${'关键指标' eq  taskBookt.quotaType }">selected="selected"</c:if>>关键指标</option>
                        </select></td>
                      </c:forEach>
                        <td>
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-arrow-up"></span></button>
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-arrow-down"></span></button>
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-plus"></span></button>
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-minus"></span></button>
                        </td>
                        </tr>
                    </tbody>
                </table>
                </div>
                <div id="hasCheckBill_box" style="<c:if test="${!procNode.hasCheckBill}">display:none</c:if>">
                <h3>检查单</h3>
                <table class="table table-condensed table-striped table-hover">
                    <thead>
                        <tr>
                        <th>检查项</th>
                        <th>检查项属性</th>
                        <th>备注</th>
                        <th width="200">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${checkbillTs}" var="checkBill">
                        <tr>
                        <td><input type="text" class="form-control" name="checkItem" value="${ checkBill.checkItem}" placeholder=""></td>
                        <td><select name="checkItemProperty" class="form-control">
                          <option value="必须" <c:if test="${checkBill.checkItemProperty eq '必须'}">selected="selected"</c:if>>必须</option>
                          <option value="建议" <c:if test="${checkBill.checkItemProperty eq '建议'}">selected="selected"</c:if>>建议</option>
                          <option value="特殊增项" <c:if test="${checkBill.checkItemProperty eq '特殊增项'}">selected="selected"</c:if>>特殊增项</option>
                        </select></td>
                        <td><input type="text" class="form-control" name="remark" value="${checkBill.remark}" placeholder="检查项说明，非必填"></td>
                        <td>
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-arrow-up"></span></button>
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-arrow-down"></span></button>
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-plus"></span></button>
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-minus"></span></button>
                        </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </div>
                <div id="hasDocument_box" style="<c:if test="${!procNode.hasDocument}">display:none</c:if>">
                <h3>文档管理</h3>
                <table class="table table-condensed table-striped table-hover">
                    <thead>
                        <tr>
                            <th>文档名称</th>
                            <th width="40%">选择文件</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><input type="text" class="form-control" id="" placeholder="文档名称" disabled></td>
                            <td><input type="file" id="" disabled></td>
                        </tr>
                    </tbody>
                </table>
                </div>
                <h3>当前进展概述</h3>
                <div class="form-inline">
                  <div class="form-group">
                    <select name="" class="form-control" disabled>
                          <option>正常</option>
                          <option>异常</option>
                    </select>
                  </div>
                </div>
                <div class="form-group"><textarea class="form-control" rows="3" disabled></textarea></div>
                <h3>节点简述</h3>
                <div class="form-group"><textarea class="form-control" rows="3" disabled></textarea></div>
				<!--readme-->
		</div>
		</form>
		</div>
		<!--check list-->
        <div class="text-center">
              <a href="javascript:void(0)" id="a-save" class="btn btn-success btn-lg"><span class="glyphicon glyphicon-floppy-saved">&nbsp;</span>保存</a>
              <a href="javascript:void(0)" id="a-back" class="btn btn-default btn-lg"><span class="glyphicon glyphicon glyphicon-share">&nbsp;</span>返回</a>
        </div>
	</div>
	<!--right_box-->
</div>
<!--content-->
<!--弹窗开始-->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">模块管理</h4>
      </div>
      <div class="modal-body">
        <form id="module">
        <div class="checkbox"><label><input type="checkbox" value="hasFee">费用模块</label></div>
        <div class="checkbox"><label><input type="checkbox" value="hasManPower">人力模块</label></div>
        <div class="checkbox"><label><input type="checkbox" value="hasTaskBook">任务书模块</label></div>
        <div class="checkbox"><label><input type="checkbox" value="hasCheckBill">检查单模块</label></div>
        <div class="checkbox"><label><input type="checkbox" value="hasDocument">文档管理模块</label></div>
        </form>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
<!--         <button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-floppy-saved">&nbsp;</span>Save</button> -->
      </div>
    </div>
  </div>
</div>
<!--弹窗结束-->
<script>
//up&dwon
$('.glyphicon-arrow-up').parent().click(function(){
	$(this).parent().parent().prev('tr').before($(this).parent().parent());
});
$('.glyphicon-arrow-down').parent().click(function(){
	$(this).parent().parent().next('tr').after($(this).parent().parent());
});
//+-
$('.glyphicon-plus').parent().click(function(){
	$(this).parent().parent().clone(true).insertAfter($(this).parent().parent());
});
$('.glyphicon-minus').parent().click(function(){
	var tr_length = $(this).parent().parent().parent().children('tr').length;
	if (tr_length>1){$(this).parent().parent().remove();}
	else{alert('最后一行无法删除！');};
});
</script>
</body>
</html>