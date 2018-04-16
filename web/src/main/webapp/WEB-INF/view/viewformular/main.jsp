<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container text-center">
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="messages" var="i18n"/>

    <b><fmt:message bundle="${i18n}" key="users.title"/></b>
    <br>
    <br>

<TABLE>
    <tr>
        <th width=35>ID</th>
        <th width=120><fmt:message bundle="${i18n}" key="users.name"/></th>
        <th width=120><fmt:message bundle="${i18n}" key="users.login"/></th>
        <th width=120><fmt:message bundle="${i18n}" key="users.age"/></th>
        <th width=120><fmt:message bundle="${i18n}" key="users.sex"/></th>
        <th width=120><fmt:message bundle="${i18n}" key="users.role"/></th>
        <th width=120></th>
        <th width=120></th>
        <%--<th width=120><fmt:message bundle="${i18n}" key="users.booksGot"/></th>--%>
    </tr>

    <c:forEach var="users" items="${usersDto}" varStatus="status">
        <tr>
            <%--<td>${status.index +1}</td>--%>
            <td>${users.userId}</td>
            <td>${users.name}</td>
            <td>${users.login}</td>
            <td>${users.age}</td>
            <td>${users.sex}</td>
            <td>${users.role}</td>
                <td>${users.booksGot}</td>
                <td>
                <form action="frontController?command=users" method="post">
                <p><input type="hidden" name="userId" value=${users.userId}>
                <p><input type="hidden" name="role" value=${users.role}>
                <p><input type="hidden" name="flag" value="change">
                <input type="submit" value="change role">
                </form>
                </td>
                <td>
                <form action="frontController?command=viewFormular" method="post">
                <p><input type="hidden" name="userId" value=${users.userId}>
                <input type="submit" value="view">
                </form>
                </td>
        </tr>
    </c:forEach>
</TABLE>
</div>
