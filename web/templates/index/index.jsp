<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/templates/common/init.jsp" %>

<t:override name="title">首页</t:override>

<t:override name="body">
    <button class="btn btn-success">${requestScope.get("test")}</button>
</t:override>

<%@include file="/templates/common/base.jsp" %>
