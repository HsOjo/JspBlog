<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/templates/common/init.jsp" %>

<t:override name="title">首页</t:override>

<t:override name="body">
    <div class="container">
        <div class="col-sm-8 blog-main">
            <%@include file="/templates/common/header.jsp" %>
            <c:forEach items="${paginate.entities}" var="entity">
                <div class="blog-post">
                    <h2 class="blog-post-title">
                        <a href="${ctx}/article/view?id=${entity.id}">
                            <c:out value="${entity.title}" default="文章标题"/>
                        </a>
                    </h2>
                    <p class="blog-post-meta">
                        于 <c:out value="${entity.createTime}" default="创建时间"/> 由
                        <a href="${ctx}/user/view?id=${entity.id}">
                            <c:out value="${entity.userId}" default="作者"/>
                        </a> 发布，最后更新于 <c:out value="${entity.updateTime}" default="更新时间"/>。
                    </p>
                    <p><c:out
                            value="${entity.content.length() >= 128 ? entity.content.substring(0, 128) : entity.content}"
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
