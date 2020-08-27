<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
$END$
<%
    System.out.println("hello jsp");
    int i = 5;

    String contextPath = request.getContextPath();
    out.print(contextPath);
%>

<%!
    int i = 3;
%>
<%= "hello" %>


System.out.println("hello jsp");
<h1>hi~ jsp!</h1>

<% response.getWriter().write("response....."); %>
</body>
</html>
