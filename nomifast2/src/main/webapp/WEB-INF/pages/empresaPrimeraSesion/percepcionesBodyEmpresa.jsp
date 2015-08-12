<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:choose>
    <c:when test="${fn:length(percepciones) > 0}">
        <c:forEach items="${percepciones}" var="p" varStatus="status">
            <tr valing="top">
                <td><label>${p.percepcionEmpresa.id}</label></td>
                <td><label>${p.percepcionEmpresa.nombre}</label></td>
                <td>
                    <label>${p.clave}</label>
                </td>
            </tr>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <tr valign="top">
            <td colspan="3">
                <label>No hay datos para mostrar</label>
            </td>
        </tr>
    </c:otherwise>
</c:choose>