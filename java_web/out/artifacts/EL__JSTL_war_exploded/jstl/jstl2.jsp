<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>choose标签做一个类似于switch标签 数字案例对应星期几</h1>
<%
request.setAttribute("number", 3);
%>
<c:choose>
    <c:when test="${number == 1}"> 星期一</c:when>
    <c:when test="${number == 2}"> 星期二</c:when>
    <c:when test="${number == 3}"> 星期三</c:when>
    <c:when test="${number == 4}"> 星期四</c:when>
    <c:when test="${number == 5}"> 星期五</c:when>
    <c:when test="${number == 6}"> 星期六</c:when>
    <c:when test="${number == 7}"> 星期天</c:when>


</c:choose>

</body>
</html>
