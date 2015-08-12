<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:choose>
    <c:when test="${fn:length(sucursales) > 0}">
        <c:forEach items="${sucursales}" var="s" varStatus="status">
            <c:set var="class" value=""></c:set>
            <c:if test="${s.matriz eq true}">
                <c:set var="class" value="class=\"primary\""></c:set>
            </c:if>
            <tr valign="top" ${class}>
                <td>
                    <label class="nombre">${s.nombre}</label>
                    <label class="ocultar number">${s.id}</label>
                </td>
                <td><label class="rfc">${s.rfc}</label></td>
                <td>
                    <label class="domicilio">${s.domicilio.calle}</label>&nbsp;
                    <label class="domicilio">${s.domicilio.numInterior}</label>&nbsp;
                    <label class="domicilio">${s.domicilio.localidad}</label>&nbsp;
                    <label class="domicilio">${s.domicilio.numExterior}</label>&nbsp;
                    <label class="domicilio">${s.domicilio.colonia}</label>&nbsp;
                    <label class="domicilio">${s.domicilio.municipio}</label>&nbsp;
                    <label class="domicilio">${s.domicilio.estado}</label>&nbsp;
                    <label class="domicilio">${s.domicilio.pais}</label>&nbsp;
                    <label class="domicilio">${s.domicilio.codigoPostal}</label>&nbsp;
                </td>
                <td><label class="folios">${s.foliosConsumidos}</label></td>
                <td>
                    <div class="dropdown">
                        <button class="btn btn-danger dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                            <i class="fa fa-fw fa-cogs"></i>
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                            <li><a >Editar Datos</a></li>
                            <li><a >Editar Domicilio</a></li>
                            <li><a >Eliminar</a></li>
                            <li rol="divider" class="divider"></li>
                            <li><a >Hacer Matriz</a></li>
                        </ul>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <tr valign="top">
            <td colspan="6">
                <label>No hay datos para mostrar </label>
            </td>
        </tr>
    </c:otherwise>
</c:choose>