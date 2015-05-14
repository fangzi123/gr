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
<script type="text/javascript" src="<%=contextPath%>/resources/js/rights_manage.js"></script>
</head>

<body>
<%@ include file="inc/nav.html"%> 
<!--nav-->
<div id="content">
	<jsp:include page="inc/left_box.jsp" flush="true"/>
	<!--left_box-->
	<div id="right_box">
    	<div class="row">
        	<div class="col-xs-10">
                <ol class="breadcrumb">
                    <li><a href="index.shtml">首页</a></li>
                    <li class="active">权限</li>
                </ol>
            </div>
        	<div class="col-xs-2 text-right">
                <button type="button" class="btn btn-danger  btn-block" data-toggle="modal" data-target="#exampleModal" id="btn-add">添加账号</button>
            </div>
        </div>
		<!--路径导航-->
		<div class="panel panel-default">
        <div class="panel-heading">权限管理</div>
		<div class="panel-body tab-content">
        <table class="table table-condensed table-striped table-hover">
                    <thead>
                        <tr>
                        <th>用户名</th>
                        <th>是否管理员</th>
                        <th>可查看项目</th>
                        <th>可编辑项目</th>
                        <th>账号管理</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach items="${userList}" var="user">
                        <tr>
                        <td>${user.name}</td>
                        <td>${user.type}</td>
                        <td><c:forEach items="${user.proList}" var="pro"><c:if test="${pro.isView}">${pro.name}、</c:if></c:forEach></td>
                        <td><c:forEach items="${user.proList}" var="pro"><c:if test="${pro.isEdit}">${pro.name}、</c:if></c:forEach></td>
                        <td>
                        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#exampleModal" data-userid="${user.id}"><span class="glyphicon glyphicon glyphicon-edit"></span></button>
                        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#delete_gr" data-userid="${user.id}"><span class="glyphicon glyphicon-trash"></span></button>
                        </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
		</div>
		</div>
		<!--Process-->
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
        <h4 class="modal-title" id="exampleModalLabel">管理账号</h4>
      </div>
      <form action="useradd" id="form-save" method="post">
      <input type="hidden" value="" id="edit_userid" name="id">
      <div class="modal-body">
          <div class="form-group">
            <input type="text" class="form-control" id="recipient-name" name="name" placeholder="账号邮箱名称">
          </div>
          <div class="form-group">
            <select class="form-control" id="admin" name="type">
              <option value="普通用户">普通用户</option>
              <option value="管理员">管理员</option>
            </select>
          </div>
          <div class="form-group" id="porject">
            <table class="table table-bordered table-condensed table-striped table-hover">
              <tr>
                <th>查看</th>
                <th>编辑</th>
              </tr>
              <tr>
                <td>
            <select multiple  class="form-control" id="porject_view" name="porIdsView">
            <c:forEach items="${proList}" var="pro">
              <option value="${pro.id}" text="${pro.name}">${pro.name}</option>
            </c:forEach>
            </select></td>
                <td>
            <select multiple  class="form-control" id="porject_edit" name="porIdsEdit">
              <c:forEach items="${proList}" var="pro">
              	<option value="${pro.id}" text="${pro.name}">${pro.name}</option>
              </c:forEach>
            </select></td>
              </tr>
            </table>
          </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-danger" id="btn-save"><span class="glyphicon glyphicon-floppy-saved">&nbsp;</span>Save</button>
      </div>
      </form>
    </div>
  </div>
</div>
<!--弹窗结束-->
<!--弹窗开始-->
<div class="modal fade" id="delete_gr" tabindex="-1" role="dialog" aria-labelledby="delete_gr" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">删除确认</h4>
      </div>
      <div class="modal-body">
      <p>确定删除此账号吗？</p>
      <p>PS：删除后该账号则不能再次登陆此系统，请三思！</p>
      <input type="hidden" value="" id="del_userid">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-danger" id="btn-delete"><span class="glyphicon glyphicon-remove">&nbsp;</span>Delete</button>
      </div>
    </div>
  </div>
</div>
<!--弹窗结束-->
<script>
//role
$('#admin').change(function(){
	if ($(this).val() == '管理员'){
		$('#porject_view').find('option').attr('selected',true);
		$('#porject_edit').find('option').attr('selected',true);
// 		$('#porject_view').attr('disabled',true);
// 		$('#porject_edit').attr('disabled',true);
	}
	else{
		$('#porject_view').find('option').attr('selected',false);
		$('#porject_edit').find('option').attr('selected',false);
		$('#porject_view').attr('disabled',false);
		$('#porject_edit').attr('disabled',false);
	};		
})
//up&dwon
$('.glyphicon-arrow-up').parent().click(function(){
	$(this).parent().parent().prev('tr').before($(this).parent().parent());
});
$('.glyphicon-arrow-down').parent().click(function(){
	$(this).parent().parent().next('tr').after($(this).parent().parent());
});
</script>
</body>
</html>