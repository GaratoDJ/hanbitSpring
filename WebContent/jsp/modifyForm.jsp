<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>�Խù� �����ϱ�</title>
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

<h1>�Խñ� ����</h1>

<form action="modify.do" method="post">
	<input type="hidden" name="num" value="${board.num}"><!-- �Խù� ��ȣ�� hidden���� �Ķ���Ϳ� ���. -->
														<!-- ������ �� �Խù� ������ ��Ʈ�ѷ��� ���� ������� �ʾҾ���. -->
	<table>
		<tr>
			<th>�ۼ���</th>
			<td>
				<input type="text" name="name" value="${board.name}" readonly="readonly">
			</td>
		</tr>
		<tr>
			<th>�̸���</th>
			<td><input type="text" name="email" value="${board.email}"></td>
		</tr>
		<tr>
			<th>����</th>
			<td><input type="text" name="title" size="70" value="${board.title}" readonly="readonly">* �ʼ�</td>
		</tr>
		<tr>
			<th>����</th>
			<td><textarea rows="15" cols="70" name="content" >${board.content}</textarea> </td>					
		</tr>
		<tr>
			<td colspan="2">
				��й�ȣ : <input type="password" name="pass">
				<input type="submit" value="����">
			</td>
		</tr>	

	
	</table>
	
</form>

</body>
</html>