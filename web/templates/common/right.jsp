<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-sm-3 col-sm-offset-1 blog-sidebar">
    <div class="sidebar-module sidebar-module-inset">
        <h4>关于</h4>
        <p>{{ info_setting.about }}</p>
    </div>
    <div class="sidebar-module sidebar-module-inset">
        <h4>文章分类</h4>
        <ol class="list-unstyled">
            {% for item in CategoryModel.query.all() %}
            <li><a href="{{ url_for('article.category', name=item.name) }}">{{ item.name }}</a></li>
            {% endfor %}
        </ol>
    </div>
    <div class="sidebar-module sidebar-module-inset">
        <h4>友情链接</h4>
        <ol class="list-unstyled">
            {% for item in FriendLinkModel.query.all() %}
            <!-- target="_blank" 可以使点击链接在新页面打开 -->
            <li><a href="{{ item.url }}" target="_blank">{{ item.name }}</a></li>
            {% endfor %}
        </ol>
    </div>
</div>