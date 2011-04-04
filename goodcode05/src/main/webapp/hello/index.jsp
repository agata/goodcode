<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ja" xml:lang="ja">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="Content-Style-Type" content="text/css" />
  <meta http-equiv="Content-Script-Type" content="text/JavaScript" />
  <link href="css/default.css" rel="stylesheet" type="text/css" media="screen,projection" charset="utf-8" />
  <title>Cuuby archetype sample app : /hello/</title>
</head>
<body>
<h1>Cuuby archetype sample app : /hello/</h1>
<c:import url="/common/errors.jsp"/>
<c:import url="/common/notice.jsp"/>
<t:form action="message" value="${action}" method="post">
	Your Name:
	<t:input type="text" name="name"/>
	<input type="submit" value="POST"/>
</t:form>
</body>
</html>
