<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="app" value="${pageContext.request.contextPath}" />
<c:set var="dto" value="${articleDTO}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function confirm_delete() {
	if(confirm('정말로 삭제하시겠습니꺄?')) {
		location.href='delete';
	}	
}
</script>
</head>
<body>
<table>
	<caption>게시물 상세보기</caption>
<tr>
	<th>글번호</th>
	<td>${dto.art_no}</td>
</tr>
<tr>
	<th>제목</th>
	<td>${dto.art_title}</td>
</tr>
<tr>
	<th>작성자</th>
	<td>${dto.userDTO.usr_name}(${dto.userDTO.usr_id})</td>
</tr>
<tr>
	<th>작성일</th>
	<td><fmt:formatDate value="${dto.art_regdate}" 
		pattern="yyyy-MM-dd HH:mm:ss"/></td>
</tr>
<tr>
	<th>조회수</th>
	<td>${dto.art_readcnt}</td>
</tr>
<tr>
	<th>내용</th>
	<td>${dto.art_content}</td>
</tr>
<tr>
	<th>추천</th>
	<td><span id="good_count">${dto.art_like}</span>
		<img src="${app}/resources/img/like.png" id="good" /></td>
</tr>
<tr>
	<th>비추천</th>
	<td><span id="bad_count">${dto.art_dislike}</span>
		<img src="${app}/resources/img/dislike.png" id="bad" /></td>
</tr>
<tr>
	<th>작성자ip</th>
	<td>${dto.art_ip}</td>
</tr>
<tr>
	<td colspan="2">
		<a href="../">[리스트]</a>
		<c:if test="${dto.userDTO.usr_id == sessionScope.userInfo.usr_id}">
			<a href="update">[수정]</a>
			<a href="javascript:;" onclick="confirm_delete()">[삭제]</a>
		</c:if>
	</td>
</tr>
</body>
</html>