<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%
 
 String name = "Krish";
 out.println(name); 
 
 %>
 
 
 <%
 session.setAttribute("session_name", "Kaka");
 
 
 
 %>  
 
 
 <form action = "output.jsp" method = "get">
 
 <input type = "text" name = "name1" placeholder = "Enter name" />
 
 <input type = "submit" value = "click me"/>
 </form>
 
</body>
</html>