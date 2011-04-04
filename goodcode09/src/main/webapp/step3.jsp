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
<h2>Food Photos(<fmt:formatNumber pattern="0" value="${foodFiles.sizeOfFiles / 1024}"/>KB)</h2>
<ul>
<c:forEach var="file" items="${foodFiles.files}">
<li>${file.name}</li>
</c:forEach>
</ul>
<h2>Animal Photos(<fmt:formatNumber pattern="0" value="${animalFiles.sizeOfFiles / 1024}"/>KB)</h2>
<ul>
<c:forEach var="file" items="${animalFiles.files}">
<li>${file.name}</li>
</c:forEach>
</ul>
<h2>Landscape Photos(<fmt:formatNumber pattern="0" value="${landscapeFiles.sizeOfFiles / 1024}"/>KB)</h2>
<ul>
<c:forEach var="file" items="${landscapeFiles.files}">
<li>${file.name}</li>
</c:forEach>
</ul>
</body>
</html>
