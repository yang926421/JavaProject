<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2020/8/16
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/quick23" method="post" enctype="multipart/form-data">
    名称<input type="text" name="username"><br>
    <%--    如果是多个文件上传,服务器需要使用数组来接收--%>
    文件<input type="file" name="uploadFile"><br>
    文件2<input type="file" name="uploadFile"><br>
    文件3<input type="file" name="uploadFile"><br>
    <input type="submit" value="提交">
</form>

</body>
</html>
