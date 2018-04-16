<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="container text-center">
    <div class="error">${errorMsg}</div>
    <form action="frontController?command=register" method="post">
        <fmt:setLocale value="${sessionScope.locale}"/>
        <fmt:setBundle basename="messages" var="i18n"/>
        <br>
        <b><fmt:message bundle="${i18n}" key="users.name"/></b><br>
        <input type="name" name="name" required maxlength="20"/>
        <br>
        <b><fmt:message bundle="${i18n}" key="users.login"/></b><br>
        <input type="login" name="login" required maxlength="30"/>
        <br>
        <b><fmt:message bundle="${i18n}" key="users.pass"/></b><br>
        <input type="password" name="password" required maxlength="20"/>
        <br>
        <b><fmt:message bundle="${i18n}" key="users.age"/></b><br>
        <input type="age" name="age" required pattern="^[0-9]+$" maxlength="20"/>
        <br>
        <b><fmt:message bundle="${i18n}" key="users.sex"/></b><br>
        <%--<input type="sex" name="sex" maxlength="20"/><br/>--%>
        <%--<input type="sex" name="sex" /><br/>--%>
            <%--<br>--%>

            <input type="radio" name="sex" value="male" checked> <fmt:message bundle="${i18n}" key="sex.male"/>
            <input type="radio" name="sex" value="female"> <fmt:message bundle="${i18n}" key="sex.female"/>

    <%--<div class="data-list-input" style="width:160px;">--%>
            <%--<select class="data-list-input" style="width:160px;">--%>
                <%--<option value="male" selected>Male</option>--%>
                <%--<option value="female" >Female</option>--%>
            <%--</select>--%>
        <%--</div>--%>
            <br>
            <br>

        <input type="submit" value="<fmt:message bundle="${i18n}" key="login.register"/>">
    </form>
</div>
