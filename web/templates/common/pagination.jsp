<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="pagination">
    <li class="${paginate.currentPage<=1?"disabled":""}"><a href="#" aria-label="Previous"><span
            aria-hidden="true">«</span></a></li>
    <c:forEach begin="1" end="8" var="p">
        <c:set var="p" value="${paginate.currentPage-4+p}"/>
        <c:if test="${p > 1 && p < paginate.maxPage}">
            <li class="${paginate.currentPage==p?"active":""}"><a href="?page=${p}">${p}</a></li>
        </c:if>
    </c:forEach>
    <li class="${paginate.currentPage>=paginate.maxPage?"disabled":""}">
        <a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
</ul>