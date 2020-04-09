<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 주문 목록</title>
</head>
<body>
${member.name }님의 주문 목록:
<ul>
	<c:forEach var="order" items="${orders }">
	<li><a href="<%=request.getContextPath() %>/members/${order.memberId }/orders/${order.id}">${order.id }</a></li>
	</c:forEach>
</ul>
</body>
</html>