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
<script type="text/javascript" src="<%=contextPath%>/resources/js/procNode_manage.js"></script>
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
		<div class="panel-body">
                <div class="form-inline">
                  <div class="form-group">
                    <select name="" class="form-control">
                          <option>选择流程类型</option>
                          <option>GR</option>
                          <option>CR</option>
                          <option>MR</option>
                          <option>TR</option>
                          <option>CB&amp;OB</option>
                        </select>
                  </div>
                  <div class="form-group">
                    <select name="" class="form-control">
                          <option>选择完结类型</option>
                          <option>手动完结</option>
                          <option>邮件完结</option>
                        </select>
                  </div>
                  <div class="form-group">
                    <select name="" class="form-control">
                          <option>选择时间类型</option>
                          <option>时间段</option>
                          <option>时间点</option>
                        </select>
                  </div>
                <hr>
                </div>
                <div id="fee_box" style="display:none">
                <h3>费用</h3>
                <table class="table table-condensed table-striped table-hover">
                    <thead>
                        <tr>
                        <th>费用名称</th>
                        <th width="200">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                        <td><input type="text" class="form-control" id="" placeholder=""></td>
                        <td>
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-arrow-up"></span></button>
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-arrow-down"></span></button>
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-plus"></span></button>
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-minus"></span></button>
                        </td>
                        </tr>
                        <tr>
                        <td><input type="text" class="form-control" id="" placeholder=""></td>
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
                <div id="manpower_box" style="display:none">
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
                        <tr>
                        <td><input type="text" class="form-control" id="" placeholder=""></td>
                        <td><input type="text" class="form-control" id="" placeholder=""></td>
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
                <div id="mission_box" style="display:none">
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
                        <tr>
                        <td><select name="" class="form-control">
                          <option>新增有效率</option>
                          <option>次日留存率</option>
                          <option>7日留存率</option>
                        </select></td>
                        <td><select name="" class="form-control">
                          <option>辅助参考</option>
                          <option>关键指标</option>
                        </select></td>
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
                <div id="checklist_box" style="display:none">
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
                        <tr>
                        <td><input type="text" class="form-control" id="" placeholder=""></td>
                        <td><select name="" class="form-control">
                          <option>必须</option>
                          <option>建议</option>
                          <option>特殊增项</option>
                        </select></td>
                        <td><input type="text" class="form-control" id="" placeholder="检查项说明，非必填"></td>
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
                <div id="document_box" style="display:none">
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
		</div>
		<!--check list-->
        <div class="text-center">
              <a href="02.shtml" class="btn btn-success btn-lg"><span class="glyphicon glyphicon-floppy-saved">&nbsp;</span>保存</a>
              <a href="02.shtml" class="btn btn-default btn-lg"><span class="glyphicon glyphicon glyphicon-share">&nbsp;</span>返回</a>
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
        <div class="checkbox"><label><input type="checkbox" value="fee">费用模块</label></div>
        <div class="checkbox"><label><input type="checkbox" value="manpower">人力模块</label></div>
        <div class="checkbox"><label><input type="checkbox" value="mission">任务书模块</label></div>
        <div class="checkbox"><label><input type="checkbox" value="checklist">检查单模块</label></div>
        <div class="checkbox"><label><input type="checkbox" value="document">文档管理模块</label></div>
        </form>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-floppy-saved">&nbsp;</span>Save</button>
      </div>
    </div>
  </div>
</div>
<!--弹窗结束-->
<script>
//module
$('#module input').change(function(){
	if ($(this).prop('checked')){
		$('#'+$(this).val()+'_box').css('display','block');
	}
	else{
		$('#'+$(this).val()+'_box').css('display','none');
	};
});
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