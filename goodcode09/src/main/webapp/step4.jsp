<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ja" xml:lang="ja">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="Content-Style-Type" content="text/css" />
  <meta http-equiv="Content-Script-Type" content="text/JavaScript" />
  <link href="${contextPath}/css/default.css" rel="stylesheet" type="text/css" media="screen,projection" charset="utf-8" />
</head>
<body>
<h1>Image File List</h1>
<c:forEach var="files" items="${filesList}">
<c:set var="labelKey" value="label.${files.path}"/>
<h2>${messages[labelKey]}(<fmt:formatNumber pattern="0" value="${files.sizeOfFiles / 1024}"/>KB)</h2>
<ul>
<c:forEach var="file" items="${files.files}">
<li>${file.name}</li>
</c:forEach>
</ul>
</c:forEach>
</body>
</html>
