<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
<form:form commandName="loginCommand">
	<form:errors element="div"/>
	<label for="email">이메일</label>:
	<input type="text" name="email" id="email" value="${loginCommand.email }">
	<form:errors path="email"/><br>
	
	<label for="password">암호</label>:
	<input type="password" name="password" id="password">
	<form:errors path="password"/><br>
	<br/>
	
	<input type="submit" value="로그인">
	
</form:form>
	<ul>
		<li>이메일/암호로 yuna@yuna.com/yuna 입력 또는 sanghwa@sanghwa.com/sanghwa로 테스트</li>
	</ul>
</body>
</html>