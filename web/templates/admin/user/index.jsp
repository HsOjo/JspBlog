<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/templates/common/init.jsp" %>
<%--@elvariable id="paginate" type="dao.base.Paginate<entity.User>"--%>

<t:override name="title">用户列表</t:override>

<t:override name="content">
    <ul id="myTab" class="nav nav-tabs">
        <li class="active"><a href="${ctx}/admin/user/index">用户列表</a></li>
        <li><a href="${ctx}/admin/user/add">添加用户</a></li>
    </ul>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>id</th>
                <th>用户名</th>
                <th>是否为管理员</th>
                <th>邮箱</th>
                <th>手机</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${paginate.items}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.isAdmin ? "是" : "否"}</td>
                    <td>${user.email}</td>
                    <td>${user.phone}</td>
                    <td>
                        <a href="${ctx}/admin/user/edit?id=${user.id}">编辑</a>
                        <a href="${ctx}/admin/user/delete?id=${user.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="pagination">{$pages}</div>
</t:override>

<%@include file="/templates/admin/base/base.jsp" %>
