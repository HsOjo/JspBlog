<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/templates/common/init.jsp" %>
<%--@elvariable id="item" type="entity.User"--%>

<t:override name="title">查看用户</t:override>

<t:override name="body">
    <div class="container">
        <div class="blog-header">
            <h1 class="blog-title">
                <c:out value="${item.username}" default="用户名"/>
            </h1>
            <p class="lead blog-description">
                <br/>
                以下为联系方式：<br/>
                邮箱：<c:out value="${item.email}" default="（邮箱）"/><br/>
                电话：<c:out value="${item.phone}" default="（电话）"/><br/>
                <br/>
                自我介绍：<br/>
                <c:out value="${item.introduce}" default="（自我介绍）"/>
            </p>
        </div>
    </div>
</t:override>

<%@include file="/templates/common/base.jsp" %>
