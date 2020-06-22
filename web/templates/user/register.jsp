<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/templates/common/init.jsp" %>

<t:override name="title">用户注册</t:override>

<t:override name="body">
    <div class="container">
        <div class="col-md-4">
            <form method="post" action="${ctx}/user/register" id="form-register">
                <div class="form-group">
                    <label class="control-label" for="input-username">用户名</label>
                    <input class="form-control" type="text" id="input-username" name="username">
                </div>
                <div class="form-group">
                    <label class="control-label" for="input-password">密码</label>
                    <input class="form-control" type="password" id="input-password" name="password">
                </div>
                <div class="form-group">
                    <label class="control-label" for="input-email">邮箱</label>
                    <input class="form-control" type="email" id="input-email" name="email">
                </div>
                <div class="form-group">
                    <label class="control-label" for="input-phone">手机号</label>
                    <input class="form-control" type="number" id="input-phone" name="phone">
                </div>
                <div class="form-group">
                    <label class="control-label" for="input-introduce">个人简介</label>
                    <textarea class="form-control" id="input-introduce" name="introduce"></textarea>
                </div>
                <div class="form-group">
                    <label class="control-label" for="input-auth-code">验证码</label>
                    <input class="form-control" type="text" id="input-auth-code" name="captcha">
                    <img class="help-block" src="${ctx}/index/captcha" alt="验证码"/>
                </div>
                <button class="btn btn-primary" type="button" onclick="return callbackSubmit();">注册</button>
                    <%--                <button class="btn btn-primary" type="submit">注册</button>--%>
                <a class="btn btn-default" href="${ctx}/templates/user/login.jsp">登录</a>
            </form>
        </div>
    </div>
</t:override>

<t:override name="script">
    <script>
        function callbackSubmit() {
            let form = $('#form-register');
            $.ajax({
                type: 'post',
                url: form.attr('action'),
                cache: false,
                data: form.serialize(),
                dataType: "json",
                success: function (resp_data) {
                    let code = resp_data['code'];
                    let msg = resp_data['msg'];
                    let data = resp_data['data'];
                    alert(msg);
                    if (code === 1)
                        location.href = data['url'];
                }
            });

            return false;
        }
    </script>
</t:override>

<%@include file="/templates/common/base.jsp" %>
