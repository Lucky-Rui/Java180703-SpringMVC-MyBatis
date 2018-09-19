<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"
	href="${ctx}/lib/bootstrap-3.3.7-dist/css/bootstrap.css" />
</head>
<body>
	<script type="text/javascript"
		src="${ctx}/lib/jquery/jquery-1.11.1.js"></script>
	<script type="text/javascript"
		src="${ctx}/lib/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	<script src="${ctx}/lib/layer/layer.js"
		type="text/javascript" charset="utf-8"></script>
	<script src="${ctx}/js/mylayer.js"
		type="text/javascript" charset="utf-8"></script>
		
	<form id="add_form" action="${ctx}/banji/addBanji.action" method="post">
		班级名称：<input type="text" id="name"  name="name" onblur="checkName()"/>
		<br/>
		<input type="button" onclick="submitForm()" value="添加"/>
	</form>		


	<script type="text/javascript">
		function checkName(){
			var name = document.getElementById("name").value;
			//ajax请求验证这个用户名
			$.post(
				"${ctx}/banji/checkName.action",
				{"name":name},
				function(data) {
					if (data){
						mylayer.errorAlert("该班级已经存在，请使用其它班级名称");
					} else {
						mylayer.success("该班级名可以使用");
					}
				},
				"json"
			);
		}
		
		function submitForm() {
	        $.ajax({
	          url : "${ctx}/banji/addBanji.action",
	          type : "post",
	          dataType : "json",
	          data : $("#add_form").serialize(),
	          success : function(data) {
	             if(data) {
	               mylayer.success("添加成功");
	               //先得到当前iframe层的索引
	               var index = parent.layer.getFrameIndex(window.name);
	               setTimeout(function() {
	                  parent.layer.close(index);
	                  //刷新父页面
	                  window.parent.location.reload();
	               }, 1000);
	             } else {
	               mylayer.errorMsg("添加失败");
	             }
	          }
	        });
	     }
	</script>
</body>
</html>
