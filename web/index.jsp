<%--
  Created by IntelliJ IDEA.
  User: hsojo
  Date: 2020/6/10
  Time: 8:46 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tpl" uri="/WEB-INF/tlds/block_override.tld" %>

<tpl:Override name="title">Test</tpl:Override>

<tpl:Override name="body">
    <button class="btn btn-success">Test</button>
</tpl:Override>

<%@include file="/templates/base.jsp" %>
