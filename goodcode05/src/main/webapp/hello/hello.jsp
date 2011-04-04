<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ja" xml:lang="ja">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="Content-Style-Type" content="text/css" />
  <meta http-equiv="Content-Script-Type" content="text/JavaScript" />
  <link href="css/default.css" rel="stylesheet" type="text/css" media="screen,projection" charset="utf-8" />
  <title>Cuuby archetype sample app : /hello/message</title>
</head>
<body>
<h1>Cuuby archetype sample app : /hello/message</h1>
${messages['msg.dummy']}<br/>
<c:import url="/common/errors.jsp"/>
<c:import url="/common/notice.jsp"/>
post message : [${message}]
<br/>
<a href="back">Back(redirect and flash message)</a>
</body>
</html>
