<%--
  Created by IntelliJ IDEA.
  User: guixain
  Date: 2017/11/30
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index</title>
  </head>
  <body>
    <h2>Test</h2>
    <form action="/userRegisteredServelt" method="post">
        name:<input type="text" name="name">
       email:<input type="text" name="email">
      password:<input type="password" name="password">
      <input type="submit" value="注册">
    </form>
  </body>
</html>
