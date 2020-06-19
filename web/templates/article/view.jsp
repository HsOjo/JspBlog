<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/templates/common/init.jsp" %>
<%--@elvariable id="article" type="entity.Article"--%>
<%--@elvariable id="paginate" type="dao.base.Paginate<entity.Comment>"--%>

<t:override name="title">${article.title}</t:override>

<t:override name="body">
    <div class="container">
        <div class="row">
            <div class="col-sm-8 blog-main">
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
                        </a> 发布，最后更新于 <c:out value="${convert_utils.convertDateTime(article.updateTime)}"
                                             default="更新时间"/>。
                    </p>
                    <p><c:out value="${article.content}" default="文章内容"/></p>
                </div>

                <div class="row">
                    <form method="post" action="${ctx}/article/comment?id=${article.id}" class="form-horizontal"
                          role="form">
                        <div class="form-group">
                            <label for="content" class="col-sm-3 control-label">留言内容：</label>
                            <div class="col-sm-9">
                                <textarea name="content" id="content" class="form-control"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div style="float: right;">
                                <button type="submit" class="btn btn-primary">提交</button>
                            </div>
                        </div>
                    </form>
                    <c:forEach items="${paginate.items}" var="comment">
                        <div class="row">
                            <div class="col-xs-9">
                                <h4>
                                    <a href="${ctx}/user/view?id=${comment.userId}">
                                            ${user_service.getUserById(comment.userId).username}</a>：
                                </h4>
                            </div>
                            <div class="col-xs-3">
                                <h5>${convert_utils.convertDateTime(comment.createTime)}</h5>
                            </div>
                            <div class="col-xs-12">
                                <p class="form-control">${comment.content}</p>
                            </div>
                        </div>
                    </c:forEach>

                    <c:choose>
                        <c:when test="${paginate.items.size() == 0}">
                            <p style="text-align: center">暂时没有留言</p>
                        </c:when>
                        <c:otherwise>
                            <%@include file="/templates/common/pagination.jsp" %>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <%@include file="/templates/common/right.jsp" %>
        </div>
    </div>
    <%@include file="/templates/common/footer.jsp" %>
</t:override>

<%@include file="/templates/common/base.jsp" %>
