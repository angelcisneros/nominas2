<%@include file="/WEB-INF/pages/empresaTemplates/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:choose>
    <c:when test="${fn:length(sucursales) > 0}">
        <c:forEach items="${sucursales}" var="s" varStatus="status">
            <tr valign="top">
                <td><label class="nombre">${s.nombre}</label></td>
                <td><label class="rfc">${s.rfc}</label></td>
                <td><label class="domicilio">${s.domicilio}</label></td>
                <td><label class="folios">${s.foliosConsumidos}</label></td>
                <td><label class="correo">${s.correo}</label></td>
                <td>
                    <div class="btn-group" role="group">
                        <button class="btn btn-warning">Editar</button>
                        <button class="btn btn-danger">Eliminar</button>
                        <button class="btn btn-info">CSD</button>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <tr valign="top">
            <td colspan="6">
                <label>No hay datos para mostrar</label>
            </td>
        </tr>
    </c:otherwise>
</c:choose>