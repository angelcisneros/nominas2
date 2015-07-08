<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:choose>
    <c:when test="${fn:length(recibos) > 0}">
        <c:forEach items="${recibos}" var="r" varStatus="status">
            <tr valign="top">
                <td><label class="uuid">${r.uuid}</label></td>
                <td><label class="sucursal">${r.sucursal.nombre}</label></td>
                <td><label class="fechaTimbrado">${r.fechaTimbrado}</label></td>
                <td><label class="fechaPago">${r.fechaPago}</label></td>
                <td><label class="fechaInicialPago">${r.fechaInicialPago}</label> al <label class="fechaFinalPago">${r.fechaFinalPago}</label></td>
                <td><label class="numeroDiasPagados">${r.numeroDiasPagados}</label></td>
                <td><label class="periodicidadPago">${r.periodicidadPago}</label></td>
                <td>
                    <div class="btn-group" role="group">
                        <button class="btn btn-warning">Editar</button>
                        <button class="btn btn-danger">Eliminar</button>
                        <button class="btn btn-info">Ver</button>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <tr valign="top">
            <td colspan="9">
                <label>No hay datos para mostrar</label>
            </td>
        </tr>
    </c:otherwise>
</c:choose>