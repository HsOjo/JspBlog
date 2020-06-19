<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/templates/common/init.jsp" %>

<t:override name="title">博客设置</t:override>

<t:override name="content">
    <ul id="myTab" class="nav nav-tabs">
        <li class="active"><a href="${ctx}/admin/setting/site_setting">网站设置</a></li>
        <li><a href="${ctx}/admin/setting/info_setting">信息设置</a></li>
    </ul>
    <div class="placeholder"></div>
    <form method="post" action="${ctx}/admin/setting/site_setting" class="form-horizontal" role="form">
        <div class="form-group">
            <label for="site_name" class="col-sm-2 control-label">网站名称：</label>
            <div class="col-sm-10">
                <input type="text" name="site_name" id="site_name" class="form-control"
                       value="${site_setting.siteName}"/>
            </div>
        </div>
        <div class="form-group">
            <label for="site_footer" class="col-sm-2 control-label">网站页尾：</label>
            <div class="col-sm-10">
                <textarea name="site_footer" id="site_footer" class="form-control">${site_setting.siteFooter}</textarea>
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
