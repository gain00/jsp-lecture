<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");

String pUserName = request.getParameter("userName");
String pTitle = request.getParameter("Title");

String pContents = request.getParameter("contents");




String driver = "oracle.jdbc.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String id = "wjdwo1104";
String pw = "1234";

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String sql = "insert into board values (seq_board.nextval,?,?,?,sysdate,0)";

Class.forName(driver);
conn = DriverManager.getConnection(url, id, pw);
pstmt = conn.prepareStatement(sql);
pstmt.setString(1, pUserName);
pstmt.setString(2, pTitle);
pstmt.setString(3, pContents);

int result = pstmt.executeUpdate(); //select를 제외하ㅏ ㄴ나머지 update,delete,insert executeUpdate를 사용

if(result>0){
	response.sendRedirect("list.jsp");
}else{
	out.println("<script>alert('서버오류입니다. 잠시뒤 다시 시돟해주세요'); location.href='';</script>");
}



%>