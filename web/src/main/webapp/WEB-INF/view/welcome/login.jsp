<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="error">${message}</div>

<table width="100%" border="0">
    <tr>
        <td align="center" valign="center">

            <sec:authorize access="isAnonymous()">
                <c:url var="loginUrl" value="/login"/>
                <form action="${loginUrl}" method="post">

                    <div>
                        <c:if test="${param.error != null}">
                            <div><p>Invalid username or password.</p></div>
                        </c:if>
                        <div>
                            <label for="login"><spring:message code="login.login"/></label><br>
                            <input type="text" id="login" name="login"
                                   placeholder="<spring:message code="login.enterlogin"/>" required maxlength="18"><jsp:text/>
                            </input>
                        </div>
                        <div>
                            <label for="password"><spring:message code="login.password"/></label><br>
                            <input type="password" id="password" name="password"
                                   placeholder="<spring:message code="login.enterpassword"/>" required="required"
                                   maxlength="18"><jsp:text/>
                            </input>
                            <br><br/>
                            <div>
                                <button type="submit"><spring:message code="login.submit" /></button>
                            </div>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><jsp:text/>
                        </input>
                    </div>
                </form>
            </sec:authorize>

            <form action="${pageContext.request.contextPath}/register" method="get" accept-charset="UTF-8">
                <input type="submit" value="<spring:message code="login.register"/>">
            </form>
        </td>
    </tr>
</table>