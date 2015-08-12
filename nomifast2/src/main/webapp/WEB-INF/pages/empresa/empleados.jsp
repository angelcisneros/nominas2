<%@include file="/WEB-INF/pages/empresaTemplates/header.jsp" %>
<div class="row">
    <h1 class="text-danger">
        <i class="fa fa-fw -circle -text fa-users"></i>Empleados</h1>
    <hr>
</div>
<div class="row">
    <div class="form-inline col-xs-12 col-sm-12 col-lg-9 col-md-9">
        <div class="input-group">
            <span class="input-group-addon" id="basic-addon1"><i class="fa fa-fw s fa-search"></i>Búsquedas:</span>
            <select id="busquedas" class="form-control" aria-describedby="basic-addon1">
                <option label="--TODOS--" value="0">--TODOS--</option>
                <option label="Por RFC" value="1" >Por RFC</option>
                <option label="Por CURP" value="2" >Por CURP</option>
                <option label="Por Nombre" value="3" >Por Nombre</option>
            </select>
        </div>
    </div>
    <div class="form-inline col-xs-12 col-sm-12 col-lg-3 col-md-3">
        <div class="btn-group pull-right" role="group" aria-label="">
            <button id="reporteAlumnosPDF" class="btn btn-danger"><i class="fa fa-fw -circle -text s -photo-o -circle -circle fa-file-pdf-o"></i>Reporte PDF</button>
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
                <th>CURP</th>
                <th>RFC</th>
                <th>Nombre</th>
                <th>Opciones</th>
            </tr>
        </thead>
        <tbody>
            <%@ include file="/WEB-INF/pages/empresa/empleadosBody.jsp"%>
        </tbody>
    </table>
</div>
<%@include file="/WEB-INF/pages/empresaTemplates/footer.jsp" %>