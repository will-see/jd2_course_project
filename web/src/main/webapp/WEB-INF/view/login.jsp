<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container text-center">
    <div class="error">${errorMsg}</div>
    <%--<div class="error"><fmt:message key=" ${errorMsg}"/></div>--%>

    <form action="frontController?command=login" method="post">
        <fmt:setLocale value="${sessionScope.locale}"/>
        <fmt:setBundle basename="messages" var="i18n"/>

        <b><fmt:message bundle="${i18n}" key="login.login"/></b> <br>
        <input type="text" name="login" required maxlength="30"/> <br>
        <b><fmt:message bundle="${i18n}" key="login.password"/></b> <br>
        <input type="password" name="password" required zmaxlength="20"/><br/> <br>
        <input type="submit" value="<fmt:message bundle="${i18n}" key="login.submit"/>">


    </form>

    <form action="frontController?command=register" method="post">
        <input type="submit" value="<fmt:message bundle="${i18n}" key="login.register"/>">
    </form>
</div>
