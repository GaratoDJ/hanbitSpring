<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>작성해볼까요</title>
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
    text-align: left;
}

</style>
</head>
<body>
<h1>게시글 작성</h1>

<form action="write.do" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<th>작성자</th>
			<td>
				<input type="text" name="name">
			</td>
		</tr>
		
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="pass" >* 필수
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="email" ></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" size="70" >* 필수</td>
		</tr>
		
		<tr>
			<th>첨부파일</th>
			<td><input type="file" name="ufile">
		</tr>
		
		<tr>
			<th>내용</th>
			<td><textarea rows="15" cols="70" name="content" ></textarea> </td>					
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="글쓰기">
			</td>
		</tr>		
	</table>


</form>


</body>
</html>