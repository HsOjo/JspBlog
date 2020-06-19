<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/templates/common/init.jsp" %>
<%--@elvariable id="user" type="entity.User"--%>

<t:override name="title">编辑用户</t:override>

<t:override name="content">
    <ul id="myTab" class="nav nav-tabs">
        <li><a href="${ctx}/admin/user/index">用户列表</a></li>
        <li><a href="${ctx}/admin/user/add">添加用户</a></li>
        <li class="active"><a href="${ctx}/admin/user/edit">编辑用户</a></li>
    </ul>
    <div class="placeholder"></div>
    <form method="post" action="${ctx}/admin/user/edit?id=${user.id}" class="form-horizontal" role="form">
        <%@include file="form.jsp"%>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">编辑</button>
            </div>
        </div>
    </form>
</t:override>

<%@include file="/templates/admin/base/base.jsp" %>
