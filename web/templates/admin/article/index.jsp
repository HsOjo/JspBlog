<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/templates/common/init.jsp" %>
<%--@elvariable id="paginate" type="dao.base.Paginate<entity.Article>"--%>

<t:override name="title">文章列表</t:override>

<t:override name="content">
    <ul id="myTab" class="nav nav-tabs">
        <li class="active"><a href="${ctx}/admin/article/index">文章列表</a></li>
        <li><a href="${ctx}/admin/article/add">添加文章</a></li>
    </ul>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>id</th>
                <th>标题</th>
                <th>文章分类</th>
                <th>创建时间</th>
                <th>修改时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${paginate.items}" var="article">
                <tr>
                    <td>${article.id}</td>
                    <td>${article.title}</td>
                    <td>${article.categoryId}</td>
                    <td>${article.createTime}</td>
                    <td>${article.updateTime}</td>
                    <td>
                        <a href="${ctx}/admin/article/edit?id=${article.id}">编辑</a>
                        <a href="${ctx}/admin/article/delete?id=${article.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="pagination">{$pages}</div>
</t:override>

<%@include file="/templates/admin/base/base.jsp" %>
