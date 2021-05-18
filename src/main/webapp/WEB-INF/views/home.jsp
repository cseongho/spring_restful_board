<%@page import="net.developia.board.dto.UserDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" contentType="text/html; charset=UTF-8"%>
<%
	UserDTO userInfo = new UserDTO();
	userInfo.setUsr_id("next");
	userInfo.setUsr_name("신해철");
	userInfo.setUsr_no(1);
	userInfo.setUsr_level(1);
	userInfo.setUsr_status(0);
	
	session.setAttribute("userInfo", userInfo);
	response.sendRedirect("board/");
	
%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
