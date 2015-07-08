<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:choose>
    <c:when test="${fn:length(empleados) > 0}">
        <c:forEach items="${empleados}" var="e" varStatus="status">
            <tr valign="top">
                <td><label class="curp">${e.curp}</label></td>
                <td><label class="nombre">${e.nombre}</label></td>
                <td>
                    <div class="btn-group" role="group">
                        <button class="btn btn-warning">Editar</button>
                        <button class="btn btn-danger">Eliminar</button>
                        <button class="btn btn-info">Ver Recibos</button>
                    </div>
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