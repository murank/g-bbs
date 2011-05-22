<%@page trimDirectiveWhitespaces="true"%>
<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Sample BBS</title>
<link href="/css/global.css" rel="stylesheet" type="text/css">
</head>
<body>
<h2>Sample BBS</h2>
<c:if test="${isPosted}"><p>Posting has been completed.</p></c:if>
<p><a href="/post">post</a></p>

<c:forEach var="e" items="${postingList}">
<p>
<div>
${f:h(e.content)}
</div>
<span class="small">${f:h(e.postingDate)}</span>
</p>
<hr />
</c:forEach>

</body>
</html>
