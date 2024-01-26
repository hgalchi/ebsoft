<%@ page import="com.study.connection.ConnectionTest" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello </title>
</head>
<body>
<h1><%= "Hello !!3434" %>
</h1>
<br/>



<%

    ConnectionTest t = new ConnectionTest();
    System.out.println(t.getConnection());

%>

</body>
</html>
