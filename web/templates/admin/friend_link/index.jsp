<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/templates/common/init.jsp" %>
<%--@elvariable id="paginate" type="dao.base.Paginate<entity.FriendLink>"--%>

<t:override name="title">友情链接列表</t:override>

<t:override name="content">
    <ul id="myTab" class="nav nav-tabs">
        <li class="active"><a href="${ctx}/admin/friend_link/index">友情链接列表</a></li>
        <li><a href="${ctx}/admin/friend_link/add">添加友情链接</a></li>
    </ul>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>id</th>
                <th>名称</th>
                <th>链接</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${paginate.items}" var="friend_link">
                <tr>
                    <td>${friend_link.id}</td>
                    <td>${friend_link.name}</td>
                    <td>${friend_link.url}</td>
                    <td>
                        <a href="${ctx}/admin/friend_link/edit?id=${friend_link.id}">编辑</a>
                        <a href="${ctx}/admin/friend_link/delete?id=${friend_link.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <%@include file="/templates/common/pagination.jsp" %>
</t:override>

<%@include file="/templates/admin/base/base.jsp" %>
