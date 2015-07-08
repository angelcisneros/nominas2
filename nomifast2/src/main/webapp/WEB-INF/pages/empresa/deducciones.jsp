<%@include file="/WEB-INF/pages/empresaTemplates/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="row">
    <h1 class="text-danger">
        <i class="fa fa-fw -circle -text s -photo-o -circle fa-minus-circle"></i>Deducciones</h1>
    <hr>
</div>
<div class="row">
    <div class="col-md-6 col-lg-6">
        <h2 class="text-center">Catálogo SAT</h2>
        <table class="table table-bordered table-condensed table-hover table-striped">
            <thead>
                <tr>
                    <th class="danger">Clave SAT</th>
                    <th class="danger">Nombre</th>
                    <th class="danger">Clave</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${fn:length(deduccionesSat) > 0}">
                        <c:forEach items="${deduccionesSat}" var="ds" varStatus="status">
                            <tr valign="top">
                                <td><label class="uuid">${ds.id}</label></td>
                                <td><label class="empleado">${ds.nombre}</label></td>
                                <td>
                                    <div class="input-group">
                                        <input type="text" class="form-control" placeholder="Search for...">
                                        <span class="input-group-btn">
                                            <button class="btn btn-success" type="button"><i class="fa fa-fw fa-arrow-circle-right"></i></button>
                                        </span>
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
            </tbody>
        </table>
    </div>
    <div class="col-md-6 col-lg-6">
        <h2 class="text-center" contenteditable="true">Claves Empresa</h2>
        <table class="table table-bordered table-condensed table-hover table-striped">
            <thead>
                <tr>
                    <th class="danger">Clave SAT</th>
                    <th class="danger">Clave Empresa</th>
                    <th class="danger">Nombre</th>
                    <th class="danger">Opicones</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${fn:length(deduccionesEmpresa) > 0}">
                        <c:forEach items="${deduccionesEmpresa}" var="de" varStatus="status">
                            <tr valign="top">
                                <td><label class="uuid">${de.id}</label></td>
                                <td><label class="empleado">${de.nombre}</label></td>
                                <td>
                                    <div class="input-group">
                                        <input type="text" class="form-control" placeholder="Search for...">
                                        <span class="input-group-btn">
                                            <button class="btn btn-success" type="button"><i class="fa fa-fw fa-arrow-circle-right"></i></button>
                                        </span>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr valign="top">
                            <td colspan="4">
                                <label>No hay datos para mostrar</label>
                            </td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>
    </div>
</div>
<%@include file="/WEB-INF/pages/empresaTemplates/footer.jsp" %>
