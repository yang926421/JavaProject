<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>el表达式只能从域对象中获取值</h1>
<h1> ${域名称.键名} 从指定域中获取指定键的值</h1>

<%
    //在域中存储数据
    request.setAttribute("name", "张三");
    session.setAttribute("name", "张三");
%>
<h3>el获取值</h3>
${requestScope.name}
${sessionScope.name}

<%
    List<user> users = new ArrayList<>();
%>

</body>
</html>
