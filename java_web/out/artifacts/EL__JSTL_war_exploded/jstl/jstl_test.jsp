<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.gsxt.domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List list = new ArrayList<>();
    list.add(new User("z行三", 23, new Date()));
    list.add(new User("李四", 25, new Date()));
    list.add(new User("王五", 26, new Date()));
    request.setAttribute("list", list);


%>

<table>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>出生日期</th>
    </tr>
    <h1>数据行</h1>
    <c:forEach items="${list}" var="user" varStatus="s">
        <tr>
            <td>${s.count}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.birthday}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
