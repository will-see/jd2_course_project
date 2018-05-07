<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container text-center">
    <b><spring:message code="users.title"/></b>

    <br>
    <br>

    <div class="col-md-9"><b><spring:message code="books.taken"/></b></div>
    <table class="table">
        <tr>
            <th class="col-md-1 text-center">ID</th>
            <th class="col-md-1 text-center"><spring:message code="users.name"/></th>
            <th class="col-md-1 text-center"><spring:message code="users.login"/></th>
            <th class="col-md-1 text-center"><spring:message code="users.age"/></th>
            <th class="col-md-1 text-center"><spring:message code="users.sex"/></th>
            <th class="col-md-1 text-center"><spring:message code="users.role"/></th>
            <th class="col-md-1 text-center"><spring:message code="users.booksGot"/></th>
            <th class="col-md-1 text-center"></th>
            <th class="col-md-1 text-center"></th>
        </tr>

        <c:forEach var="users" items="${users}" varStatus="status">

            <tr class="info">
                    <%--<td>${status.index +1}</td>--%>
                <td class="col-md-1">${users.userId}</td>
                <td class="col-md-1">${users.name}</td>
                <td class="col-md-1">${users.login}</td>
                <td class="col-md-1">${users.age}</td>
                <td class="col-md-1">${users.sex}</td>
                <td class="col-md-1">${users.role}</td>
                <td class="col-md-1">${users.booksGot}</td>
                <td class="col-md-1">
                    <form action="${pageContext.request.contextPath}/formular/page" method="post">
                        <p><input type="hidden" name="userId" value=${users.userId}>
                            <input type="submit" value="view">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </td>
                <td class="col-md-1">
                    <form action="${pageContext.request.contextPath}/users/changeRole" method="post">
                        <input type="hidden" name="userId" value=${users.userId}>
                        <input type="hidden" name="role" value=${users.role}>
                            <%--<p><input type="hidden" name="flag" value="change">--%>
                        <input type="submit" value="change role">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        <%--<jsp:text/>--%>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
