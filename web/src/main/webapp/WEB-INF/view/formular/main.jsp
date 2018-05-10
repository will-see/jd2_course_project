<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="text">${message}</div>

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
                <sec:authorize access="hasRole('ROLE_admin')">
                    <td class="col-md-1">
                        <form action="${pageContext.request.contextPath}/books/getBack" method="post">
                            <input type="hidden" name="bookId" value="${formular.bookId}"/>
                            <input type="hidden" name="userId" value=${formular.userId}>
                            <input type="submit" value=<spring:message code="books.getBack"/>>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            <jsp:text/>
                        </form>
                    </td>
                </sec:authorize>
            </tr>
        </c:forEach>
    </table>
</div>
