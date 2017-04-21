<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<style type="text/css">

table {
    border-collapse: collapse;
    width: 100%;
}

th{
width : 20%
}

th, td {
    border : 1px solid #ddd;
    padding: 15px;
    text-align: center;
}

</style>

<title>게시물 상세보기</title>
</head>
<body>

<h1>게시글 상세보기</h1>
	<table>
	<tr>
		<th>작성자</th>
		<td>${board.name}</td>
		<th>이메일</th>
		<td>${board.email}</td>	
	</tr>
		<tr>
		<th>작성일</th>
		<td><fmt:formatDate value="${board.writeDate}"/></td>
		<th>조회수</th>
		<td>${board.readCount}</td>	
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="3">${board.title}</td>
	<tr>
	
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3">${board.content}</td>	
	</tr>
	
	<tr>
		<th>첨부파일</th>
		<td colspan="3">
			<img src="download.do?num=${board.num}">
		</td>
	</tr>
	
	<tr>
		<td colspan="4">
			<input type="button" value="목록으로" onclick="location.href='boardList.do'">
			<input type="button" value="수정하기" onclick="location.href='modifyForm.do?num=${board.num}'">
		</td>
	</tr>
</table>
</body>
</html>