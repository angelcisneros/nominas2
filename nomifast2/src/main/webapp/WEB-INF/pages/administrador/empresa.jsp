<%-- 
    Document   : empresa
    Created on : 25/06/2015, 12:11:50 PM
    Author     : vcisneros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">
    <h1 class="text-danger"><i class="fa fa-fw -circle -text s fa-trash"></i>Empresas</h1>
    <hr>
</div>
<div class="row">
    <div class="form-inline col-xs-12 col-sm-12 col-lg-9 col-md-9">
        <div class="input-group">
            <span class="input-group-addon" id="basic-addon1">Búsquedas:</span>
            <select id="busquedas" class="form-control" aria-describedby="basic-addon1">
                <option label="--TODOS--" value="0">--TODOS--</option>
                <option label="Por Fecha de Pago" value="1" >Por Fecha de Pago</option>
                <option label="Por Período" value="2" >Por Período</option>
                <option label="Por Empleado" value="3" >Por Empleado</option>
                <option label="Por Periodicidad" value="4" >Por Periodicidad</option>
                <option label="Por Sucursal" value="5" >Por Sucursal</option>
                <option label="Por Fecha de Timbrado" value="6" >Por Fecha de Timbrado</option>
                <option label="Por Núm de Dias Pagados" value="7" >Por Núm de Dias Pagados</option>
                <option label="Por UUID" value="8" >Por UUID</option>
            </select>
        </div>
    </div>
    <div class="form-inline col-xs-12 col-sm-12 col-lg-3 col-md-3">
        <div class="btn-group pull-right" role="group" aria-label="">
            <button class="btn btn-danger"><i class="fa fa-fw -circle -text s -photo-o -circle -circle fa-file-pdf-o"></i>Agregar</button>
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
                <th>UUID</th>
                <th>Empleado</th>
                <th>Sucursal</th>
                <th>Fech de Timbrado</th>
                <th>Fech de Pago</th>
                <th>Período Pag</th>
                <th>Núm Días Pag</th>
                <th>Periodicidad</th>
                <th>Opciones</th>
            </tr>
        </thead>
        <tbody>
            <%@ include file="/WEB-INF/pages/empresa/cancelarBody.jsp"%>
        </tbody>
    </table>
</div>
