<%@page trimDirectiveWhitespaces="true"%>
<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Post</title>
<link href="/css/global.css" rel="stylesheet" type="text/css">
</head>
<body>
<h2 id="header">Post</h2>
<form action="/post" method="POST">
	<div>Content:</div>
	<div><textarea name="content" rows="10" cols="30"></textarea></div>
	<div><button type="submit">submit</button></div>
</form>
<p><a href="/">back to Top</a></p>
</body>
</html>
