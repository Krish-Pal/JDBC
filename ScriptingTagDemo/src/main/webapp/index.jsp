<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.time.LocalDate"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Demo</title>
</head>
<body>

<%!
int a = 10;
String name = "Krish";

int square(int x) {
    return x * x;
}
%>

<%
int b = 20;

out.println("a: " + a + "<br>");
out.println("Name: " + name + "<br>");
out.println("Square of a: " + square(a) + "<br>");

if(b < 100) {
    out.println("b is smaller than 100<br>");
} else {
    out.println("b is greater than 100<br>");
}

for(int i = 1; i <= 10; i++) {
    out.println(i + "<br>");
}
%>

<br>
<%= a %><br>
<%= name %><br>
<%= square(a) %><br>
<%= LocalDate.now() %><br>
<%= Math.random() %>

</body>
</html>