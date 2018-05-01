<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container text-center">
    <div class="error">${errorMsg}</div>
    <form action="${pageContext.request.contextPath}/register" method="post" accept-charset="UTF-8">
        <%--<fmt:setLocale value="${sessionScope.locale}"/>--%>
        <%--<fmt:setBundle basename="messages" var="i18n"/>--%>
        <br>
        <b><spring:message code="users.name"/></b><br><input type="name" name="name" maxlength="30"/>
        <br>
        <b><spring:message code="users.login"/></b><br><input type="login" name="login" maxlength="30"/>
        <br>
        <b><spring:message code="users.pass"/></b><br><input type="password" name="password" maxlength="30"/>
        <br>
        <b><spring:message code="users.age"/></b><br><input type="age" name="age" required pattern="^[0-9]+$"
                                                            maxlength="3"/>
        <br>
        <b><spring:message code="users.sex"/></b><br>


        <%--<input type="sex" name="sex" maxlength="20"/><br/>--%>
        <%--<input type="sex" name="sex" /><br/>--%>
        <%--<br>--%>

        <input type="radio" name="sex" value="male" checked> <spring:message code="sex.male"/>
        <input type="radio" name="sex" value="female"> <spring:message code="sex.female"/>

        <%--<div class="data-list-input" style="width:160px;">--%>
        <%--<select class="data-list-input" style="width:160px;">--%>
        <%--<option value="male" selected>Male</option>--%>
        <%--<option value="female" >Female</option>--%>
        <%--</select>--%>
        <%--</div>--%>
        <br>
        <br>

        <input type="submit" value="<spring:message code="login.register"/>">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>
