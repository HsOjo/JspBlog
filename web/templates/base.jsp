<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tpl" uri="/WEB-INF/tlds/block_override.tld" %>
<html>
<head>
    <title><tpl:Block name="title">Title</tpl:Block></title>
    <link href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/blog.css" rel="stylesheet">
    <tpl:Block name="head"/>
</head>
<body>
<%@ include file="nav.jsp" %>
<div class="container" style="margin-bottom: 16px; padding-top: 72px;">
    <tpl:Block name="body">Body</tpl:Block>
</div>
<footer class="blog-footer">
    <p><a href="#">回到顶端</a></p>
</footer>
<tpl:Block name="scripts"/>
<script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/blog.js"></script>
</body>
</html>