<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/templates/common/init.jsp" %>
<%--@elvariable id="paginate" type="dao.base.Paginate<entity.Comment>"--%>

<t:override name="title">文章留言列表</t:override>

<t:override name="content">
    <ul id="myTab" class="nav nav-tabs">
        <li class="active"><a href="${ctx}/admin/comment/index">文章留言列表</a></li>
    </ul>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>id</th>
                <th>所属文章</th>
                <th>用户</th>
                <th>内容</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${paginate.items}" var="comment">
                <tr>
                    <td>${comment.id}</td>
                    <td>${article_service.getArticleById(comment.articleId).title}</td>
                    <td>${user_service.getUserById(comment.userId).username}</td>
                    <td>${comment.content}</td>
                    <td>
                        <a href="${ctx}/admin/comment/delete?id=${comment.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <%@include file="/templates/common/pagination.jsp" %>
</t:override>

<%@include file="/templates/admin/base/base.jsp" %>
