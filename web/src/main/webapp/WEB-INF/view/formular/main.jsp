<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container text-center">
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="messages" var="i18n"/>

    <b><fmt:message bundle="${i18n}" key="formular.yourBooks"/></b>

<TABLE>
    <tr>
        <th width=35>№</th>
        <th width=200><fmt:message bundle="${i18n}" key="books.name"/></th>
        <th><fmt:message bundle="${i18n}" key="books.author"/></th>
    </tr>

    <c:forEach var="formular" items="${formularDto}" varStatus="status">
        <tr>
            <td>${status.index +1}</td>
            <td>${formular.name}</td>
            <td>${formular.author}</td>
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
