<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<script type="text/javascript" src="<%=contextPath%>/resources/js/comm/jquery-html5Validate.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/js/comm/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/js/doc_comm.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/js/doc.js"></script>
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
                    <li class="active">文档管理</li>
                </ol>
            </div>
        	<div class="col-xs-2 text-right">
            </div>
        </div>
		<!--路径导航-->
		<div class="choose">
		<form class="form-inline" role="form">
		  <div class="form-group">
            <input type="text" class="form-control" id="recipient-name" placeholder="文档名称">
		  </div>
		  <div class="form-group">
				<select class="form-control">
				  <option>流程</option>
				  <option>端游GR流程</option>
				  <option>手游GR流程</option>
				</select>
		  </div>
		  <div class="form-group">
				<select class="form-control">
				  <option>节点</option>
				  <option>GR0</option>
				  <option>GR1</option>
				  <option>GR2</option>
				  <option>GR3</option>
				</select>
		  </div>
		  <div class="form-group">
				<select class="form-control">
				  <option>项目</option>
				  <option>游戏A</option>
				  <option>幻想神域</option>
				</select>
		  </div>
		  <button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-search">&nbsp;</span>搜索</button>
          <button type="button" class="btn btn-default" data-toggle="modal" data-target="#upfiles"><span class="glyphicon glyphicon-paperclip">&nbsp;</span>添加文档</button>
		</form>
		</div>
        <!--choose-->
		<div class="panel panel-default">
		<div class="panel-body tab-content">
        <table class="table table-condensed table-striped table-hover">
                    <thead>
                        <tr>
                        <th>文档名称</th>
                        <th>发行线</th>
                        <th>项目</th>
                        <th>节点</th>
                        <th>上传者</th>
                        <th>上传时间</th>
                        <th>管理</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach items="${docList }" var="doc">
                    	<form action="<%=contextPath%>/doc/download" method="post" name="form${doc.id}"> 
	                        <tr>
	                        <input name="path" value="${doc.url}" type="hidden">
	                        <td><a href="javascript:document.form${doc.id}.submit()">${doc.filename }</a></td>
	                        <td>${doc.proNode.project.releaseLine}</td>
	                        <td>${doc.proNode.project.name }</td>
	                        <td>${doc.proNode.processNode.name }</td>
	                        <td>${doc.author}</td>
	                        <td><fmt:formatDate value="${doc.uploadTime}" pattern="yyyy-MM-dd"/> </td>
	                        <td>
	                        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#exampleModal" data-docid="${doc.id}"><span class="glyphicon glyphicon-trash"></span></button>
	                        </td>
	                        </tr>
	                    </form>
                        </c:forEach>
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
<div class="modal fade" id="upfiles" tabindex="-1" role="dialog" aria-labelledby="upfiles" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">添加文档</h4>
      </div>
      <div class="modal-body">
        <form id="form_upload" method="post" action="<%=contextPath%>/doc/upload" enctype="multipart/form-data">
          <div class="form-group">
            <select class="form-control" id="projectId" name="projectId" required>
              <option value="">选择项目</option>
              <c:forEach items="${projList}" var="proj">
             	 <option value="${proj.id}">${proj.name}</option>
              </c:forEach>
            </select>
          </div>
          <div class="form-group">
            <select class="form-control" name="id" id="id" required>
              <option value="">选择节点</option>
            </select>
          </div>
          <div class="form-group">
            <input type="file" class="form-control" name="doc" id="fileToUpload">
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-floppy-saved">&nbsp;</span>Save</button>
      </div>
    </div>
  </div>
</div>
<!--弹窗结束-->
<!--弹窗开始-->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModal" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">删除确认</h4>
      </div>
      <div class="modal-body">
      <p>确定删除此文档内容吗？</p>
      <p>PS：删除后不可恢复哦，请三思！</p>
      <input type="hidden" id="docId" value="">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-remove">&nbsp;</span>Delete</button>
      </div>
    </div>
  </div>
</div>
<!--弹窗结束-->
<script type="text/javascript">
var ctx='<%=contextPath%>';
</script>
</body>
</html>