<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-sm-3 col-sm-offset-1 blog-sidebar">
    <div class="sidebar-module sidebar-module-inset">
        <h4>关于</h4>
        <p><c:out value="${info_setting.about}" default="关于内容"/></p>
    </div>
    <div class="sidebar-module sidebar-module-inset">
        <h4>文章分类</h4>
        <ol class="list-unstyled">
            <c:forEach items="${categories}" var="category">
                <li><a href="${ctx}/article/category?id=${category.id}">${category.name}</a></li>
            </c:forEach>
        </ol>
    </div>
    <div class="sidebar-module sidebar-module-inset">
        <h4>友情链接</h4>
        <ol class="list-unstyled">
            <c:forEach items="${friend_links}" var="friend_link">
                <li><a href="${friend_link.url}" target="_blank">${friend_link.name}</a></li>
            </c:forEach>
        </ol>
    </div>
</div>