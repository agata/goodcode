<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ja" xml:lang="ja">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="Content-Style-Type" content="text/css" />
  <meta http-equiv="Content-Script-Type" content="text/JavaScript" />
  <link href="${contextPath}/css/default.css" rel="stylesheet" type="text/css" media="screen,projection" charset="utf-8" />
</head>
<body>
<h1>ToDo List</h1>
<h2>Login</h2>
<t:form action="${contextPath}/login" method="post" value="${action}">
<table border="1">
  <tr>
    <th>Account ID</th>
    <td><t:input type="text" name="accountId" maxlength="20" /></td>
  </tr>
  <tr>
    <th></th>
    <td><input type="submit" value="Login"/></td>
  </tr>
</table>
</t:form>
Account ID : 10000 or 10001 or 10002
</body>
</html>
