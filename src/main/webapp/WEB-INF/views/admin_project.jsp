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
<script type="text/javascript" src="<%=contextPath%>/resources/js/project_manage.js"></script>
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
                    <li class="active">项目</li>
                </ol>
            </div>
        	<div class="col-xs-2 text-right">
                <button type="button" class="btn btn-danger  btn-block" data-toggle="modal" data-target="#exampleModal" id="btn-add">添加项目</button>
            </div>
        </div>
		<!--路径导航-->
		<div class="panel panel-default">
        <div class="panel-heading">项目管理</div>
		<div class="panel-body tab-content">
        <table class="table table-condensed table-striped table-hover">
                    <thead>
                        <tr>
                        <th width="30%">项目名称</th>
                        <th width="30%">流程</th>
                        <th>发行线</th>
                        <th>排序&amp;删除</th>
                        </tr>
                    </thead>
                    <tbody>
                     <c:forEach items="${proList}" var="pro" varStatus="status">
                        <tr <c:if test="${!pro.flag}">class="warning"</c:if>>
                        <input type="hidden" value="${pro.id}" name="id">
                        <input type="hidden" value="${pro.sort}" name="sort">
                        <td>${pro.name}</td>
                        <td>${pro.process.name}</td>
                        <td>${pro.releaseLine}</td>
                        <td>
                        <c:if test="${!status.first}"><button type="button" class="btn btn-default"><span class="glyphicon glyphicon-arrow-up"></span></button></c:if> 
                        <c:if test="${!status.last}"><button type="button" class="btn btn-default"><span class="glyphicon glyphicon-arrow-down"></span></button></c:if> 
                        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#exampleModal" data-projectid="${pro.id }"><span class="glyphicon glyphicon glyphicon-edit"></span></button>
                        <c:if test="${pro.flag}"><button type="button" class="btn btn-default" data-toggle="modal" data-target="#delete_gr" data-projectid="${pro.id }"><span class="glyphicon glyphicon-trash"></span></button></c:if>
                        <c:if test="${!pro.flag}"><button type="button" class="btn btn-default" data-projectid="${pro.id}"><span class="glyphicon glyphicon-wrench"></span></button></c:if>
                        </td>
                        </tr></c:forEach>
                    </tbody>
                    </tbody>
                </table>
		</div>
		</div>
		<!--check list-->
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
        <h4 class="modal-title" id="exampleModalLabel">项目管理</h4>
      </div>
      <div class="modal-body">
        <form action="add" method="post" id="form-save">
        <input type="hidden" value="" id="edit_projectId" name="id">
          <div class="form-group">
            <input type="text" class="form-control" id="recipient-name" name="name" placeholder="项目名称">
          </div>
          <div class="form-group">
            <select class="form-control" name="processId" id="ps_id">
              <option value="">选择流程</option>
              <c:forEach items="${processList}"  var="ps"> 
              <option value="${ps.id }" text="${ps.name }">${ps.name }</option>
              </c:forEach>
            </select>
          </div>
          <div class="form-group">
            <select class="form-control" name="releaseLine" id="releaseLine">
              <option value="大中华">大中华</option>
              <option value="欧美">欧美</option>
              <option value="韩国">韩国</option>
              <option value="自研">自研</option>
              <option value="合作">合作</option>
            </select>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-danger" id="btn-save"><span class="glyphicon glyphicon-floppy-saved">&nbsp;</span>Save</button>
      </div>
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
      <p>您确定要删除这个项目吗？</p>
      <p>PS：删除后仅在前台不显示，资料还在哦！</p>
      <input type="hidden" value="" id="del_projectId">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-danger" id="btn-delete"><span class="glyphicon glyphicon-remove">&nbsp;</span>Delete</button>
      </div>
    </div>
  </div>
</div>
<!--弹窗结束-->
</body>
</html>