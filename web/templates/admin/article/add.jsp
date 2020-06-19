<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/templates/common/init.jsp" %>
<%--@elvariable id="article" type="entity.Article"--%>

<t:override name="title">添加文章</t:override>

<t:override name="content">
    <ul id="myTab" class="nav nav-tabs">
        <li><a href="${ctx}/admin/article/index">文章列表</a></li>
        <li class="active"><a href="${ctx}/admin/article/add">添加文章</a></li>
    </ul>
    <div class="placeholder"></div>
    <form method="post" action="${ctx}/admin/article/add" class="form-horizontal" role="form">
        <%@include file="form.jsp"%>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">添加</button>
            </div>
        </div>
    </form>
</t:override>

<%@include file="/templates/admin/base/base.jsp" %>
