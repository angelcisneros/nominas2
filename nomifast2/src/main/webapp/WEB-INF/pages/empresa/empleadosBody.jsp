<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:choose>
    <c:when test="${fn:length(empleados) > 0}">
        <c:forEach items="${empleados}" var="e" varStatus="status">
            <tr valign="top">
                <td><label class="curp">${e.curp}</label></td>
                <td><label class="curp">${e.rfc}</label></td>
                <td><label class="nombre">${e.nombre}</label></td>
                <td>
                    <div class="dropdown">
                        <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                            <i class="fa fa-fw fa-cogs"></i>
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                            <li><a href="#">Descargar</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li><a href="#">Separated link</a></li>
                        </ul>
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