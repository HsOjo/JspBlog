<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/templates/common/init.jsp" %>
<%--@elvariable id="paginate" type="dao.base.Paginate<entity.Article>"--%>
<%--@elvariable id="count" type="java.lang.Long"--%>

<t:override name="title">搜索：${keyword}，结果数：${count}</t:override>

<t:override name="body">
    <div class="container">
        <div class="col-sm-8 blog-main">
            <div class="blog-header">
                <h1 class="blog-title"><c:out value="搜索：${keyword}" default="搜索结果"/></h1>
            </div>
            <c:forEach items="${paginate.items}" var="article">
                <div class="blog-post">
                    <h2 class="blog-post-title">
                        <a href="${ctx}/article/view?id=${article.id}">
                            <c:out value="${article.title}" default="文章标题"/>
                        </a>
                    </h2>
                    <p class="blog-post-meta">
                        于 <c:out value="${convert_utils.convertDateTime(article.createTime)}" default="创建时间"/> 由
                        <a href="${ctx}/user/view?id=${article.id}">
                            <c:out value="${user_service.getUserById(article.userId).username}" default="作者"/>
                        </a> 发布，最后更新于 <c:out value="${convert_utils.convertDateTime(article.updateTime)}" default="更新时间"/>。
                    </p>
                    <p><c:out
                            value="${article.content.length() >= 128 ? article.content.substring(0, 128) : article.content}"
                            default="文章内容"/>......</p>
                </div>
            </c:forEach>
            <%@include file="/templates/common/pagination.jsp" %>
        </div>
        <%@include file="/templates/common/right.jsp" %>
    </div>
    <%@include file="/templates/common/footer.jsp" %>
</t:override>

<%@include file="/templates/common/base.jsp" %>
