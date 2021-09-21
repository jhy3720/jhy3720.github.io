<!-- first.jsp -->
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
     <%
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
       %>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
       <title>Insert title here</title>
</head>
<body>
        <h1>현재시간은<%=hour %> 시 <%=minute %> 분 <%=second %>초 입니다.</h1>
</body>
</html>
