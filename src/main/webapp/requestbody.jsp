<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>json交互测试</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript">
	//请求是key/value，输出是json  
	function requestJson() {
		$.ajax({
			type : 'post',
			url : '${pageContext.request.contextPath }/post/save',
			//请求的是key/value，这里不需要指定contentType，因为默认就是key/value类型  
			contentType : 'application/json;charset=utf-8',
			//数据格式是json串,商品信息  
			data : '{"id":1,"postName":"999","postCode":"1234"}',
			success : function(data) {//返回json结果  
				alert(data);
			}
		});
	}
</script>


</head>

<body>
	<input type="button" onclick="requestJson()"
		value="请求的是key/value，输出的是json" />
</body>
</html>
