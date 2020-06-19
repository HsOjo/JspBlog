<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/templates/common/init.jsp" %>
<%--@elvariable id="paginate" type="dao.base.Paginate<entity.Category>"--%>

<t:override name="title">文章分类列表</t:override>

<t:override name="content">
    <ul id="myTab" class="nav nav-tabs">
        <li class="active"><a href="${ctx}/admin/category/index">文章分类列表</a></li>
        <li><a href="${ctx}/admin/category/add">添加文章分类</a></li>
    </ul>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>id</th>
                <th>文章分类名</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${paginate.items}" var="category">
                <tr>
                    <td>${category.id}</td>
                    <td>${category.name}</td>
                    <td>
                        <a href="${ctx}/admin/category/edit?id=${category.id}">编辑</a>
                        <a href="${ctx}/admin/category/delete?id=${category.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <%@include file="/templates/common/pagination.jsp" %>
</t:override>

<%@include file="/templates/admin/base/base.jsp" %>
