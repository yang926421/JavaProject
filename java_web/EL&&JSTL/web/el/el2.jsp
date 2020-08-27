<%@ page import="cn.gsxt.domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>获取user对象中的数据</h1>
<%
    User user = new User();
    user.setName("张三");
    user.setAge(24);
    user.setBirthday(new Date());

    User user1 = new User();
    user1.setName("张三1");
    user1.setAge(24);
    user1.setBirthday(new Date());
    request.setAttribute("u1", user1);
    request.setAttribute("u", user);

    List<User> users = new ArrayList<>();
    users.add(user);
    users.add(user1);
    request.setAttribute("users", users);


%>

<h3>使用EL来获取</h3>
${requestScope.u.name}
${requestScope.u.age}

<h2>获取列表中的user对象的属性</h2>
${requestScope.users[0].name}
</body>
</html>
