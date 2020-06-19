<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/templates/common/init.jsp" %>
<%--@elvariable id="paginate" type="dao.base.Paginate<entity.Article>"--%>
<%--@elvariable id="category" type="entity.Category"--%>

<t:override name="title">分类：${category.name}</t:override>

<t:override name="body">
    <div class="container">
        <div class="col-sm-8 blog-main">
            <%@include file="/templates/common/header.jsp" %>
            <c:forEach items="${paginate.items}" var="article">
                <div class="blog-post">
                    <h2 class="blog-post-title">
                        <a href="${ctx}/article/view?id=${article.id}">
                            <c:out value="${article.title}" default="文章标题"/>
                        </a>
                    </h2>
                    <p class="blog-post-meta">
                        于 <c:out value="${article.createTime}" default="创建时间"/> 由
                        <a href="${ctx}/user/view?id=${article.id}">
                            <c:out value="${article.userId}" default="作者"/>
                        </a> 发布，最后更新于 <c:out value="${article.updateTime}" default="更新时间"/>。
                    </p>
                    <p><c:out
                            value="${article.content.length() >= 128 ? article.content.substring(0, 128) : article.content}"
                            default="文章内容"/>......</p>
                </div>
            </c:forEach>
            <div class="pagination"></div>
        </div>
        <%@include file="/templates/common/right.jsp" %>
    </div>
    <%@include file="/templates/common/footer.jsp" %>
</t:override>

<%@include file="/templates/common/base.jsp" %>
