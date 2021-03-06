<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation" style="position: relative">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${ctx}">
                <c:out value="${site_setting.siteName}" default="博客标题"/>
            </a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="true">
                        <c:out value="${current_user.username}" default="游客"/>
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <c:if test="${current_user.isAdmin}">
                            <li><a href="${ctx}/admin">管理后台</a></li>
                            <li class="divider"></li>
                        </c:if>
                        <c:choose>
                            <c:when test="${current_user == null}">
                                <li><a href="${ctx}/user/login">登录</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="${ctx}/user/logout">注销</a></li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-right" action="${ctx}/article/search">
                <label>
                    <input name="keyword" type="text" class="form-control" placeholder="Search..."
                           value="${keyword}">
                </label>
            </form>
        </div>
    </div>
</nav>