<%@include file="/WEB-INF/pages/empresaTemplates/header.jsp" %>
<div class="row">
    <h1 class="text-danger">
        <i class="fa fa-fw -circle fa-globe"></i>Sucursales</h1>
    <hr>
</div>
<div class="row">
    <div class="form-inline col-xs-12 col-sm-12 col-lg-9 col-md-9">
        <div class="input-group">
            <span class="input-group-addon" id="basic-addon1">Búsquedas:</span>
            <select id="busquedas" class="form-control" aria-describedby="basic-addon1">
                <option label="--TODOS--" value="0">--TODOS--</option>
                <option label="Por Nombre" value="1" >Por Fecha de Pago</option>
                <option label="Por RFC" value="2" >Por Período</option>
            </select>
        </div>
    </div>
    <div class="form-inline col-xs-12 col-sm-12 col-lg-3 col-md-3">
        <div class="btn-group pull-right" role="group" aria-label="">
            <button class="btn btn-success"><i class="fa form-control-feedback fa-plus"></i>Agregar Nueva</button>
            <button class="btn btn-danger"><i class="fa fa-fw -circle -text s -photo-o -circle -circle fa-file-pdf-o"></i>Reporte PDF</button>
        </div>
    </div>
</div>
<hr>
<div class="row">
    <div id="busquedasDivPrincipal">

    </div>
</div>
<div class="row">
    <table class="table table-bordered table-condensed table-hover table-striped">
        <thead>
            <tr class="danger">
                <th>Nombre</th>
                <th>RFC</th>
                <th>Domicilio</th>
                <th>Folios Consumidos</th>
                <th>Correo</th>
                <th>Opciones</th>
            </tr>
        </thead>
        <tbody>
            <%@ include file="/WEB-INF/pages/empresa/cancelarBody.jsp"%>
        </tbody>
    </table>
</div>
<%@include file="/WEB-INF/pages/empresaTemplates/footer.jsp" %>