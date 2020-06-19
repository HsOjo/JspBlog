<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="friend_link" type="entity.FriendLink"--%>

<div class="form-group">
    <label for="name" class="col-sm-2 control-label">名称：</label>
    <div class="col-sm-10">
        <input type="text" name="name" id="name" class="form-control" value="${friend_link.name}"/>
    </div>
</div>

<div class="form-group">
    <label for="url" class="col-sm-2 control-label">链接：</label>
    <div class="col-sm-10">
        <input type="text" name="url" id="url" class="form-control" value="${friend_link.url}"/>
    </div>
</div>