<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/templates/common/init.jsp" %>

<t:override name="title">系统后台</t:override>

<t:override name="head">
    <link href="${ctx}/static/admin/dashboard.css" rel="stylesheet">
</t:override>

<t:override name="body">
    <div class="container-fluid">
        <div class="row">
            <%@include file="/templates/admin/base/left.jsp" %>
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <t:block name="content"/>
            </div>
        </div>
    </div>
</t:override>

<%@include file="/templates/common/base.jsp" %>
