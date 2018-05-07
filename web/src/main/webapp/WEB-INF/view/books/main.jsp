<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<head>
    <%--<![CDATA[--%>
    <script src="${pageContext.request.contextPath}/assests/js/jquery-1.11.1.min.js" type="text/javascript">
        <jsp:text/>
    </script>
    <script src="${pageContext.request.contextPath}/assests/js/utils.js" type="text/javascript">
        <jsp:text/>
    </script>
    <%--]]>--%>
    <title>Books Page</title>
</head>

<div style="font-size: large">
    <c:if test="${not empty message}">INFO : ${message}</c:if> <br/>
</div>
<div>
    <div class="container-fluid">
        <div class="col-md-11"><b><spring:message code="books.title"/></b></div>
        <table class="table">
            <tr>
                <th class="col-md-2 text-center"><spring:message code="books.name"/></th>
                <th class="col-md-2 text-center"><spring:message code="books.ganr"/></th>
                <th class="col-md-2 text-center"><spring:message code="books.pages"/></th>
                <th class="col-md-2 text-center"><spring:message code="books.author"/></th>
                <th class="col-md-2 text-center"><spring:message code="books.quantity"/></th>
                <th class="col-md-1 text-center"></th>
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
                        <td class="col-md-1">${book.author}</td>
                        <td id="count${book.bookId}" class="col-md-1">${book.bookCount}</td>
                        <sec:authorize access="isAuthenticated()">

                            <td class="col-md-1"><form action="${pageContext.request.contextPath}/books/getBook" method="post">
                                <input type="hidden" name="bookId" value="${book.bookId}"/>
                                <input type="submit" value=<spring:message code="books.getBook"/>>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><jsp:text/>
                            </form></td>
                            <%--<td class="col-md-1"><input id="${book.bookId}" class="getBookBtn" type="button"--%>
                                                        <%--title="get book" value="+" onclick="getBook()"/></td>--%>
                            <%--<td class="col-md-1"><input id="${book.bookId}" class="btn-primary getBookBtn" type="button" title="get book" value="+"/></td>--%>
                        </sec:authorize>
                    </div>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>


