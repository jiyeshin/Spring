<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
	<form method="post" encType="multipart/form-data">
		이름 <input type="text" name="name"/><br>
		첨부파일 <input type="file" name="report"><br>
		<input type="submit" value="업로드"/>	
	</form>
</body>
</html>