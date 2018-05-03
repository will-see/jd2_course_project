<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container text-center">
    <b><spring:message code="users.title"/></b>

    <br>
    <br>

<TABLE>
    <tr>
        <th width=35>ID</th>
        <th width=120><spring:message code="users.name"/></th>
        <th width=120><spring:message code="users.login"/></th>
        <th width=120><spring:message code="users.age"/></th>
        <th width=120><spring:message code="users.sex"/></th>
        <th width=120><spring:message code="users.role"/></th>
        <th width=120><spring:message code="users.booksGot"/></th>
        <th width=120></th>
        <th width=120></th>
    </tr>

    <c:forEach var="users" items="${users}" varStatus="status">
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
                <form action="frontController?command=formular" method="post">
                <p><input type="hidden" name="userId" value=${users.userId}>
                <input type="submit" value="view">
                </form>
                </td>
                <td>
                <form action="frontController?command=users" method="post">
                <p><input type="hidden" name="userId" value=${users.userId}>
                <p><input type="hidden" name="role" value=${users.role}>
                <p><input type="hidden" name="flag" value="change">
                <input type="submit" value="change role">
                </form>
                </td>
        </tr>
    </c:forEach>
    <%--<c:forEach var="book" items="${books}" varStatus="status">--%>
        <%--<tr class="info">--%>
            <%--<td class="col-md-1">${book.name}</td>--%>
            <%--<div class="col-md-2">--%>
                <%--<td class="col-md-1">${book.ganr}</td>--%>
                <%--<td class="col-md-1">${book.bookCount}</td>--%>
                    <%--&lt;%&ndash;<td class="col-md-1"><input id="${product.id}" class="btn-primary addProductBtn" type="button" title="Добавить в корзину" value="+"/></td>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<td class="col-md-1"><input id="${product.id}" class="btn-primary reduceProductBtn" type="button" title="Удалить 1 из корзину" value="-"/></td>&ndash;%&gt;--%>
            <%--</div>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
</TABLE>
</div>
