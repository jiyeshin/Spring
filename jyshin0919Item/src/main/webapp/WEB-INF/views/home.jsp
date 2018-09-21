<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
 <table align="center" cellpadding="5px">
 	<tr style="background:#c98fed">
 		<th width="80"> 아이템 번호</th>
 		<th width="200"> 아이템 이름 </th>
 		<th width="120"> 가격 </th>
 	</tr>
 	<c:forEach var="item" items="${list}">
 		<tr style="background:#ededed">
 			<td align="right">${item.itemid}</td>	
 			<td><a href="detail?itemname=${item.itemname}">${item.itemname}</a></td>	
 			<td align="right">${item.price}</td>	
 		</tr>
 	</c:forEach> 	
 </table>
</body>
</html>