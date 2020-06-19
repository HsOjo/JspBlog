<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/templates/common/init.jsp" %>

<t:override name="title">信息设置</t:override>

<t:override name="content">
    <ul id="myTab" class="nav nav-tabs">
        <li><a href="${ctx}/admin/setting/site_setting">网站设置</a></li>
        <li class="active"><a href="${ctx}/admin/setting/info_setting">信息设置</a></li>
    </ul>
    <div class="placeholder"></div>
    <form method="post" action="${ctx}/admin/setting/info_setting" class="form-horizontal" role="form">
        <div class="form-group">
            <label for="blog_title" class="col-sm-2 control-label">博客标题：</label>
            <div class="col-sm-10">
                <input type="text" name="blog_title" id="blog_title" class="form-control"
                       value="${info_setting.blogTitle}"/>
            </div>
        </div>
        <div class="form-group">
            <label for="blog_description" class="col-sm-2 control-label">博客描述：</label>
            <div class="col-sm-10">
                <textarea name="blog_description" id="blog_description"
                          class="form-control">${info_setting.blogDescription}</textarea>
            </div>
        </div>
        <div class="form-group">
            <label for="about" class="col-sm-2 control-label">“关于”信息：</label>
            <div class="col-sm-10">
                <textarea name="about" id="about" class="form-control">${info_setting.about}</textarea>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">保存</button>
            </div>
        </div>
    </form>
</t:override>

<%@include file="/templates/admin/base/base.jsp" %>
