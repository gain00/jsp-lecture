<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String pUserId = request.getParameter("userId");
String pUserPw = request.getParameter("userPw");
String pUserName = request.getParameter("userName");
String pAddress = request.getParameter("Address");
String pZipcode = request.getParameter("Zipcode");
String pGender = request.getParameter("Gender");




String driver = "oracle.jdbc.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String id = "wjdwo1104";
String pw = "1234";

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String sql = " insert into member  values (?,?,?,?,?,?)";

Class.forName(driver);
conn = DriverManager.getConnection(url,id,pw);
pstmt = conn.prepareStatement(sql);

pstmt.setString(1, pUserId);
pstmt.setString(2, pUserName);
pstmt.setString(3, pUserPw);
pstmt.setString(4, pAddress);
pstmt.setString(5, pZipcode);
pstmt.setString(6, pGender);
int result = pstmt.executeUpdate();
response.setContentType("text/html;charset-utf-8");


if(result>0){
	response.sendRedirect("login-form.jsp");
}else{
	out.println("<script>alert('서버오류입니다. 잠시뒤 다시 시돟해주세요'); location.href='';</script>");
}



%>