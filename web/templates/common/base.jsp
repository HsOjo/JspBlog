<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><t:block name="title">Title</t:block></title>
    <link href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css"
          rel="stylesheet">
    <link href="${ctx}/static/blog.css" rel="stylesheet">
    <t:block name="head"/>
</head>
<body>
<%@ include file="nav.jsp" %>
<div class="container" style="margin-bottom: 16px; padding-top: 72px;">
    <t:block name="body">Body</t:block>
</div>
<footer class="blog-footer">
    <p><a href="#">回到顶端</a></p>
</footer>
<t:block name="scripts"/>
<script src="${ctx}/static/bootstrap-3.3.7-dist/jquery.min.js"></script>
<script src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="${ctx}/static/blog.js"></script>
</body>
</html>