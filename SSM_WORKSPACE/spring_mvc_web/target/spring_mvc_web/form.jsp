<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2020/8/15
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/quick15" method="post">
    <%--    表明是第几个对象的username age--%>
    <input type="text" name="userList[0].username">
    <input type="text" name="userList[0].age">
    <input type="text" name="userList[1].username">
    <input type="text" name="userList[1].age">
    <input type="submit" value="提交">
</form>

</body>
</html>
