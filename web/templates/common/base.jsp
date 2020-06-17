<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><t:block name="title">Title</t:block></title>
    <%@include file="head.jsp"%>
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
<%@include file="scripts.jsp"%>
<t:block name="scripts"/>
</body>
</html>