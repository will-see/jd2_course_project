<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container text-center">
    <div class="error">${errorMsg}</div>
    <form action="${pageContext.request.contextPath}/books/doAdd" method="post" accept-charset="UTF-8">
        <b>
            <spring:message code="books.title"/>
            <br>
            <br>
            <b><spring:message code="books.name"/></b><br><input type="text" name="title" required maxlength="30"/>
            <br>
            <b><spring:message code="books.ganr"/></b><br><input type="text" name="ganr" maxlength="30"/>
            <br>
            <b><spring:message code="books.pages"/></b><br><input type="text" name="pages" pattern="^[0-9]+$"
                                                                  maxlength="4"/>
            <br>
            <b><spring:message code="books.quantity"/></b><br><input type="text" name="quantity" required
                                                                     pattern="^[0-9]+$"
                                                                     maxlength="3"/>
            <br>
            <br>
                <spring:message code="books.author"/>
            <br>
            <br>
                <b><spring:message code="author.name"/></b><br><input type="text" name="name" maxlength="30"/>
                <br>
                <b><spring:message code="author.country"/></b><br><input type="text" name="country"
                                                                      maxlength="30"/>
                <br>
                <b><spring:message code="author.year"/></b><br><input type="text" name="year" required
                                                                         pattern="^[0-9]+$"
                                                                         maxlength="4"/>
                <br>
            <input type="submit" value="<spring:message code="books.AddBtn"/>">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>

