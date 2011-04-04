<%--

    Copyright 2004-2010 the Seasar Foundation and the Others.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
    either express or implied. See the License for the specific language
    governing permissions and limitations under the License.

--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ja" xml:lang="ja">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="Content-Style-Type" content="text/css" />
  <meta http-equiv="Content-Script-Type" content="text/JavaScript" />
  <link href="css/default.css" rel="stylesheet" type="text/css" media="screen,projection" charset="utf-8" />
  <title>Cubby archetype sample app : /hello/</title>
</head>
<body>
<h1>Cubby archetype sample app : /hello/</h1>
<c:import url="/common/errors.jsp"/>
<c:import url="/common/notice.jsp"/>
<t:form action="message" value="${action}" method="post">
	Your Name:
	<t:input type="text" name="name"/>
	<input type="submit" value="POST"/>
</t:form>
</body>
</html>
