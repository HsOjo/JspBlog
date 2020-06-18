function load_posts() {
    let blog_posts = $('.blog-post');
    blog_posts.hide();
    blog_posts.each(function (i, v) {
        setTimeout(function () {
            $(v).fadeIn(300);
        }, i * 100);
    });
}

function show_blog_message() {
    let name = '_blog_msg'
    let blog_msg = $.cookie(name);
    if (blog_msg !== undefined) {
        alert(blog_msg)
        $.removeCookie(name)
    }
}