$(function(){
   //添加文档 项目-节点联动
	$("#projectId").on("change",function(){
        var obj=$(this);
        var projectId=obj.find("option:selected").val();
        obj.parent().next().find("select").empty().append("<option value=''>选择节点</option>");
        if(projectId){
            var dom=obj.parent().next().find("select");
            $.ajax({
                url :  "projNodeList.json",
                type : 'POST',
                data : {
                	projectId:projectId
                },
                async:false,
                dataType : 'json',
                success : function(data) {
                    $.each(data.proNodeList, function (index, node) {
                        var optionHTML="<option value='"+node.id+"'>"+node.processNode.name+"</option>";
                        dom.append($(optionHTML));
                    })
                }
            });
        }
    })
    
	 /**
	 * 搜索下拉框 联动
	 */
	  $("#processId").on('change',function(){
		    projectAndNode($(this));
	    })
     //搜索回填 下拉框
     if($("#processId").find("option:selected").val()){
    	  projectAndNode($("#processId"));
     }
	//删除赋值
    $(".glyphicon-trash").parent().on('click',function(){
    	$("#docId").val($(this).data('docid'));
    })
    //删除
    $(".glyphicon-remove").parent().on('click',function(){
    	var obj={};
    	obj.id=$("#docId").val();
    	del(obj);
    	if(status=true){
    		window.location.href='index';
    	}
    })
    //上传
    $('.glyphicon-floppy-saved').parent().on('click',function(){
    	form=$('#form_upload');
    	data={
	        	id : $("#id").val(),
	        	projectId : $("#projectId").val()
     	}
    	if($.html5Validate.isAllpass(form)){
    		if($("#fileToUpload").val()){
    			ajaxFileUpload(form,data,uploadEnd);
    		}else{
    			alert("请选择文件");
    		}
		}
    })
})

function uploadEnd(data){
	window.location.href='index';
}
/**
 * 级联函数  流程 项目/节点 
 * @param obj
 */
function projectAndNode(obj){
	   var processId=obj.find("option:selected").val();
       obj.parent().next().find("select").empty().append("<option value=''>项目</option>");
       obj.parent().next().next().find("select").empty().append("<option value=''>节点</option>");
       if(processId){
       	var projectDom=obj.parent().next().find("select");
       	var nodeDom=obj.parent().next().next().find("select");
           $.ajax({
               url :  "projectAndNode.json",
               type : 'POST',
               data : {
               	processId:processId
               },
               async:false,
               dataType : 'json',
               success : function(data) {
                   $.each(data.pjList, function (index, json) {
                       var optionHTML="<option value='"+json.id+"'>"+json.name+"</option>";
                       projectDom.append($(optionHTML));
                   })
                   $.each(data.pcnList, function (index, json) {
                   	var optionHTML="<option value='"+json.id+"'>"+json.name+"</option>";
                   	nodeDom.append($(optionHTML));
                   })
                   	  //搜索回填
	                  var projectId=$("input[name='s_projectId']").val();
	                  var procNodeId=$("input[name='s_procNodeId']").val();
	                  if(projectId){
	                  	projectDom.find('option[value="'+projectId+'"]').attr('selected',true);
	                  }
	                  if(procNodeId){
	                  	nodeDom.find('option[value="'+procNodeId+'"]').attr('selected',true);
	                  }
               }
           });
       }
}
