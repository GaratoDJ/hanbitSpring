<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물 수정하기</title>
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

<h1>게시글 수정</h1>

<form action="modify.do" method="post">
	<input type="hidden" name="num" value="${board.num}"><!-- 게시물 번호를 hidden으로 파라미터에 담기. -->
														<!-- 수정을 할 게시물 정보는 컨트롤러로 따로 담아주지 않았었음. -->
	<table>
		<tr>
			<th>작성자</th>
			<td>
				<input type="text" name="name" value="${board.name}" readonly="readonly">
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="email" value="${board.email}"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" size="70" value="${board.title}" readonly="readonly">* 필수</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="15" cols="70" name="content" >${board.content}</textarea> </td>					
		</tr>
		<tr>
			<td colspan="2">
				비밀번호 : <input type="password" name="pass">
				<input type="submit" value="수정">
			</td>
		</tr>	

	
	</table>
	
</form>

</body>
</html>