<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

String driver = "oracle.jdbc.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String id = "wjdwo1104";
String pw = "1234";
String pUserId = request.getParameter("userId");
String pUserPw = request.getParameter("userPw");

out.println(pUserId);
out.println(pUserPw);

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String sql = "select * from member where id = ? and password = ?";



Class.forName(driver);
conn = DriverManager.getConnection(url,id,pw);//sql과 연결
pstmt = conn.prepareStatement(sql);
pstmt.setString(1,pUserId);
pstmt.setString(2,pUserPw);
pstmt.executeQuery();

rs = pstmt.executeQuery();
response.setContentType("text/html;charset-utf-8");

//page(그페이지한번만쓰고말꺼)<request(다음페이지로넘길때)<session(세션을없애기전까지)<application(무조껀 저장)


if(rs.next()){
	String userId = rs.getString("id");
	String userPw = rs.getString("password");
	String userName = rs.getString("name");
	request.setAttribute("userId", userId);
	request.getRequestDispatcher("login-ok.jsp");
	pageContext.setAttribute("pageUserId", userId);//못넘어옴 페이지
session.setAttribute("userId",userId);
	//response.sendRedirect("login-ok.jsp?userId="+userId);
	//request.getRequestDispatcher("");
	//out.println("로그인 성공");
}else{
	out.println("로그인 실패");
	
}
%>