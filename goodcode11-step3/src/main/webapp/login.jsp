<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ja" xml:lang="ja">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="Content-Style-Type" content="text/css" />
  <meta http-equiv="Content-Script-Type" content="text/JavaScript" />
</head>
<body>
<div>
	<h1>ログイン画面</h1>
	<c:if test="${errorMessage != null}">
		<div style="color:red"><c:out value="${errorMessage}"/></div>
	</c:if>
	<form action="loginProcess.action" method="post">
		ログインID:<input type="text" name="loginId" value="<c:out value="${loginId}"/>"/><br/>
		パスワード:<input type="password" name="password" value="<c:out value="${password}"/>"/><br/>
		<input type="submit" value="Login"/>
	</form>
	※user1/passwordでログインできます。
</div>
</body>
</html>
