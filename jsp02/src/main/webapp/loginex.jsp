<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	String userId  = request.getParameter("userId");
 String userPw  = request.getParameter("userPw");
 String isLogin = "";
 if(userId.equals("wjdwo1104")&& userPw.equals("1234")){
	 isLogin = "success";
 }else{
	 isLogin = "fail";
 }
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.println("hello jsp");
%>
</body>
</html>