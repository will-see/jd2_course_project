<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container text-center">
    <%--<b><spring:message code="formular.yourBooks"/></b>--%>
    <div class="col-md-10"><b><spring:message code="books.taken"/></b></div>
    <table class="table">
        <tr>
            <th class="col-md-1 text-center">№</th>
            <th class="col-md-3 text-center"><spring:message code="books.name"/></th>
            <th class="col-md-3 text-center"><spring:message code="books.author"/></th>
            <th class="col-md-3 text-center"></th>
        </tr>
        <c:forEach var="formular" items="${formularDto}" varStatus="status">
            <tr class="info">
                    <td class="col-md-1">${status.index +1}</td>
                    <td class="col-md-1">${formular.name}</td>
                    <td class="col-md-1">${formular.author}</td>
                    <sec:authorize access="isAuthenticated()">
                        <td class="col-md-1"><input id="${book.bookId}" class="getBack" type="button" title="get back" value=<spring:message code="books.getBack"/> onclick="getBack()"/></td>
                        <%--<td class="col-md-1"><input id="${book.bookId}" class="btn-primary getBookBtn" type="button" title="get book" value="+"/></td>--%>
                    </sec:authorize>
            </tr>
        </c:forEach>
    </table>
<%--<TABLE>--%>
    <%--<tr>--%>
        <%--<th width=35>№</th>--%>
        <%--<th width=200><spring:message code="books.name"/>></th>--%>
        <%--<th><spring:message code="books.author"/></th>--%>
    <%--</tr>--%>

    <%--<c:forEach var="formular" items="${formularDto}" varStatus="status">--%>
        <%--<tr>--%>
            <%--<td>${status.index +1}</td>--%>
            <%--<td>${formular.name}</td>--%>
            <%--<td>${formular.author}</td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</TABLE>--%>
</div>
