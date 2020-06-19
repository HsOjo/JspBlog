<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="category" type="entity.Category"--%>

<div class="form-group">
    <label for="name" class="col-sm-2 control-label">文章分类名称：</label>
    <div class="col-sm-10">
        <input type="text" name="name" id="name" class="form-control" value="${category.name}"/>
    </div>
</div>