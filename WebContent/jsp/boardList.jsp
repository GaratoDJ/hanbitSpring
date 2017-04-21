<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<style type="text/css">
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border-bottom: 1px solid #ddd;
	padding: 15px;
	text-align: center;
}

</style>

</head>
<body>

전체 게시물 수 : ${totalPage}<br>
맨 처음 페이지 : 1 <br>
네비게이터의 첫번째 번호 : ${start} <br>
네비게이터의 마지막 번호 : ${end} <br>
마지막 페이지 : ${last} <br>

${keyword}
${type}

<form action="boardList.do" method="post">
<table>
	<tr>
		<td colspan="5" style="text-align: right;">
			<input type="button" value="글쓰기" onclick="location.href='writeForm.do'">
		</td>
	</tr>
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>이름</th>
		<th>조회수</th>
		<th>작성일</th>
	</tr>

	<c:forEach items="${boardList}" var="b">
		<tr>
			<td>${b.num}</td>
			<td><a href="view.do?num=${b.num}">${b.title}</a></td>
			<td>${b.name}</td>
			<td>${b.readCount}</td>
			<td><fmt:formatDate value="${b.writeDate}" pattern="yyyy-MM-dd"/></td>
		</tr>
	</c:forEach>
	
	<tr>
		<td colspan="5">
		<c:if test="${start != 1}">
			<a href="boardList.do?page=1&type=${type}&keyword=${keyword}">[처음]</a>
			<a href="boardList.do?page=${start-1}&type=${type}&keyword=${keyword}">[이전]</a>
		</c:if>
		<c:forEach begin="${start}" end="${end <last? end: last}" var="i">
			
			<c:choose>
				<c:when test="${i == current }">
					[${i}]
				</c:when>
				<c:otherwise>
					<a href="boardList.do?page=${i}&type=${type}&keyword=${keyword}">[${i}]</a>				
				</c:otherwise>
			</c:choose>
				
		</c:forEach>
		
		<c:if test="${end < last}">
			<a href="boardList.do?page=${end+1}&type=${type}&keyword=${keyword}">[다음]</a>
			<a href="boardList.do?page=${last}&type=${type}&keyword=${keyword}">[마지막]</a>
		
		</c:if>
		
		</td>
	</tr>
	
	
	
	
	
	<!-- 
	<tr>
		<td colspan="5">
			<c:if test="${start != 1}">
				<a href="boardList.do?page=1">[처음]</a>
				<a href="boardList.do?page=${start-1}">[이전]</a>
			</c:if>
			
			<c:forEach begin="${start}" end="${end<last? end: last}" var="i">
			
				<c:choose>
					<c:when test="${i == current }">
						[${i}]
					</c:when>
					<c:otherwise>
						<a href="boardList.do?page=${i}">[${i}]</a>
					</c:otherwise>
				</c:choose>		
			</c:forEach>
			
			<c:if test="${end < last}">
				<a href ="boardList.do?page=${end+1}">[다음]</a>
				<a href ="boardList.do?page=${last}">[마지막]</a>
			</c:if>
		
		</td>
	</tr>
	
	 -->
	
	<tr>
		<td colspan="5" style="text-align:right;">
			<select id="type" name="type" size="1">
				<option value="1">제목</option>
				<option value="2">내용</option>
				<option value="3">제목 + 내용</option>
				<option value="4">작성자</option>
			</select>
			검색어 <input type="text" name="keyword">
			<input type="submit" value="검색">
	</tr>

</table>

</form>

</body>
</html>