<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
    <title><tiles:getAsString name="title" ignore="true" /></title>
</head>

<body>
<table width="100%" border="0">
    <tr>
        <td colspan="2" width="100%">
            <tiles:insertAttribute name="header" />
        </td>
    </tr>
    <tr>
        <%--<td width="20%" nowrap="nowrap">--%>
            <%--<tiles:insertAttribute name="menu" />--%>
        <%--</td>--%>
        <td width="80%">
            <tiles:insertAttribute name="body" />
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <tiles:insertAttribute name="footer" />
        </td>
    </tr>
</table>
</body>
</html>