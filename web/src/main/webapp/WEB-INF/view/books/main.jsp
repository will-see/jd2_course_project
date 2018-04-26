<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div style="font-size: large">
    <c:if test="${not empty message}">INFO : ${message}</c:if> <br/>
</div>
<div>

    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="messages" var="i18n"/>
    <div class="container-fluid">
        <div class="col-md-11"><b><fmt:message bundle="${i18n}" key="books.title"/></b></div>
        <table class="table">
            <tr>
                <th class="col-md-2"> <fmt:message bundle="${i18n}" key="books.name"/></th>
                    <th class="col-md-2"><fmt:message bundle="${i18n}" key="books.ganr"/></th>
                    <th class="col-md-2"><fmt:message bundle="${i18n}" key="books.pages"/></th>
                    <%--<th class="col-md-2"><fmt:message bundle="${i18n}" key="books.author"/></th>--%>
                    <th class="col-md-2"><fmt:message bundle="${i18n}" key="books.quantity"/></th>
                    <th class="col-md-1"></th>
            </tr>
            <script>
                function callAlert(bookId) {
                    alert(bookId);
                }
            </script>
            <c:forEach var="book" items="${books}" varStatus="status">
                <tr class="info">
                    <td class="col-md-1">${book.title}</td>
                    <div class="col-md-2">
                        <td class="col-md-1">${book.ganr}</td>
                        <td class="col-md-1">${book.pages}</td>
                        <%--<td class="col-md-1">${book.author}</td>--%>
                        <td id="count${book.bookId}" class="col-md-1">${book.bookCount}</td>
                        <%--<c:if test="${not empty user}">--%>
                        <%--<td class="col-md-1"><input id="${book.bookId}" class="btn-primary getBookBtn" type="button" title="get book" value="+"/></td>--%>
                        <%--</c:if>--%>
                    </div>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>


