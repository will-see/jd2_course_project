<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div style="font-size: large">
    <c:if test="${not empty message}">INFO : ${message}</c:if> <br/>
</div>
<div>

    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="messages" var="i18n"/>
    <div>
        <spring:message code="books.name"/>
        <%--<c:if test="${empty books}"><spring:message code="persons.table.empty"/></c:if><br/>--%>
        <c:forEach var="book1" items="${books}" varStatus="status">
            <br/>${status.count}.       ${book1.title}
        </c:forEach>
    </div>

</div>


