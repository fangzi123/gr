$(function(){
    $("#project").on("change",function(){
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
	
})