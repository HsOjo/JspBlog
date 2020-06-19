<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="article" type="entity.Article"--%>

<input type="hidden" name="user_id" id="user_id">
<div class="form-group">
    <label for="title" class="col-sm-2 control-label">标题：</label>
    <div class="col-sm-10">
        <input type="text" name="title" id="title" class="form-control" value="${article.title}"/>
    </div>
</div>
<div class="form-group">
    <label for="category_id" class="col-sm-2 control-label">文章分类：</label>
    <div class="col-sm-10">
        <select name="category_id" id="category_id" class="form-control">
            <c:forEach items="${categories}" var="category">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>
    </div>
</div>
<div class="form-group">
    <label for="content" class="col-sm-2 control-label">内容：</label>
    <div class="col-sm-10">
        <textarea name="content" id="content" class="form-control">${article.content}</textarea>
    </div>
</div>
