<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>foreach标签</h1>

<%
    List list1 = new ArrayList();
    list1.add(1);
    list1.add(2);
    list1.add(3);
%>
<%--<c:forEach begin="1" end="10" var="i" step="1" varStatus="s">--%>
<%--${i}<br>--%>
<%--    ${s.index}<br>--%>
<%--    ${s.count}<br>--%>
<%--</c:forEach>--%>

<c:forEach items="${list1}" var="i" varStatus="s">
    ${s.index} ${s.count} ${i}<br>
</c:forEach>
</body>
</html>
