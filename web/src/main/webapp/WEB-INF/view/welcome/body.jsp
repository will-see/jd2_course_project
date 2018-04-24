<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<table width="100%" border="0">
    <tr>
        <td align="center" valign="center">
            <c:set var="title">
                <spring:message code="welcome.title"/>
            </c:set>
            <c:if test="${not empty title}">
                <title>${title}</title>
            </c:if>
            <h2><spring:message code="welcome.body.text0"/></h2>
            <spring:message code="welcome.body.text1"/>

        </td>
    </tr>
</table>
