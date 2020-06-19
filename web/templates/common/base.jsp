<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><t:block name="title">网页标题</t:block></title>
    <%@include file="head.jsp" %>
    <t:block name="head"/>
</head>
<body>
<%@ include file="nav.jsp" %>
<t:block name="body">Body</t:block>
<%@include file="scripts.jsp" %>
<t:block name="scripts"/>
</body>
</html>