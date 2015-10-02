<%@include file="/WEB-INF/pages/empresaTemplates/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
    <div class="col-xs-12 col-sm-12 col-lg-7 col-md-7">
        <h1 class="text-danger">    
            <i class="fa fa-fw -circle -text s fa-bell"></i>Timbrar</h1>
        <hr>
    </div>
    <div class="col-xs-12 col-sm-12 col-lg-5 col-md-5">
        <h2>
            <div class="btn-group pull-right" role="group" aria-label="">
                <button class="btn btn-danger"><i class="fa fa-fw -circle -text s -photo-o -circle -circle fa-file-pdf-o"></i>Descargar Instructivo</button>
                <button class="btn btn-primary"><i class="fa fa-fw -circle -text s -photo-o -circle -circle fa-file-pdf-o"></i>Ver Instructivo</button>
            </div>
        </h2>
    </div>
    <hr>

</div>
<%--
<div class="row" role="alert">
    <div class="col-xs-12 col-sm-12 col-lg-7 col-md-7">
        <h2>
            <div class="checkbox">
                <label>
                    <input type="checkbox">Seleccionar yo mismo las fechas de período
                </label>
            </div>
        </h2>
        <p class="help-block"><smal>Si no marca esta opción la matriz debe contener las fechas</smal></p>
    </div>
    <div class="col-xs-12 col-sm-12 col-lg-5 col-md-5">
        <h2>
            <div class="btn-group pull-right" role="group" aria-label="">
                <button class="btn btn-danger"><i class="fa fa-fw -circle -text s -photo-o -circle -circle fa-file-pdf-o"></i>Descargar Instructivo</button>
                <button class="btn btn-primary"><i class="fa fa-fw -circle -text s -photo-o -circle -circle fa-file-pdf-o"></i>Ver Instructivo</button>
            </div>
        </h2>
    </div>
    <hr>
</div>

<div class="row">
    <div class="col-xs-12 col-sm-12 col-lg-6 col-md-6">
        <h2><label class="col-lg-12 col-md-12 text-center">Deducciones</label></h2>

        <div class="row form-group">
            <hr>
            <label class="control-label col-lg-4 col-md-4">Total Deducciones Gravadas:</label>
            <div class="input-group col-lg-8 col-md-8">
                <span class="input-group-addon" id="basic-addon1">$</span>
                <input type="number" class="form-control" placeholder="Total Deducciones Gravadas" aria-describedby="basic-addon1">
            </div>
        </div>
        <div class="row form-group">
            <label class="control-label col-lg-4 col-md-4">Total Deducciones Exentas:</label>
            <div class="input-group col-lg-8 col-md-8">
                <span class="input-group-addon" id="basic-addon1">$</span>
                <input type="number" class="form-control" placeholder="Total Deducciones Exentas" aria-describedby="basic-addon1">
            </div>
        </div>
        <div class="row form-group">
            <label class="control-label col-lg-4 col-md-4">Total Deducciones:</label>
            <div class="input-group col-lg-8 col-md-8">
                <span class="input-group-addon" id="basic-addon1">$</span>
                <input type="number" class="form-control" placeholder="Total Deducciones" aria-describedby="basic-addon1">
            </div>
        </div>
    </div>
    <div class="col-xs-12 col-sm-12 col-lg-6 col-md-6">
        <h2><label class="col-lg-12 col-md-12 text-center">Percepciones</label></h2>
        <div class="row form-group">
            <hr>
            <label class="control-label col-lg-4 col-md-4">Total Percepciones Gravadas:</label>
            <div class="input-group col-lg-8 col-md-8">
                <span class="input-group-addon" id="basic-addon1">$</span>
                <input type="number" class="form-control col-lg-8 col-md-8" placeholder="Total Percepciones Gravadas">
            </div>
        </div>
        <div class="row form-group">
            <label class="control-label col-lg-4 col-md-4">Total Percepciones Exentas:</label>
            <div class="input-group col-lg-8 col-md-8">
                <span class="input-group-addon" id="basic-addon1">$</span>
                <input type="number" class="form-control col-lg-8 col-md-8" placeholder="Total Percepciones Exentas">
            </div>
        </div>
        <div class="row form-group">
            <label class="control-label col-lg-4 col-md-4">Total Percepciones</label>
            <div class="input-group col-lg-8 col-md-8">
                <span class="input-group-addon" id="basic-addon1">$</span>
                <input type="number" class="form-control col-lg-8 col-md-8" placeholder="Total Percepciones">
            </div>
        </div>
    </div>
    <div class="col-xs-12 col-sm-12 col-lg-12 col-md-12 pull-right">
        <div class="row form-group">
            <label class="control-label col-lg-4 col-md-4">Total Percepciones</label>
            <div class="input-group col-lg-8 col-md-8">
                <span class="input-group-addon" id="basic-addon1">$</span>
                <input type="number" class="form-control col-lg-8 col-md-8" placeholder="Total Percepciones">
            </div>
        </div>
    </div>
    
</div>
--%>
<div class="row well col-xs-12 col-sm-12 col-lg-12 col-md-12">
    <button id="editarSucursal" type="button" class="botonEsquinado btn btn-default">
        <i class="fa fa-fw fa-edit"></i> Editar Sucursal
    </button>
    <div class="col-xs-12 col-sm-12 col-lg-6 col-md-6">
        <h3><strong><i class="fa fa-fw fa-building-o"></i> Sucursales</strong></h3>
        <div class="row form-group">
            <div class="col-lg-4 col-md-4">
                <label class="control-label">Selecciones una sucursal</label>
            </div>
            <div class="col-lg-8 col-md-8">
                <select id="sucursal" class="form-control">
                    <option label="Seleccione..." value="0">Seleccione...</option>
                    <c:forEach  items="${sucursales}" var="s" varStatus="status">
                        <option label="${s.nombre}" value="${s.id}">${s.nombre}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
</div>
<div id="bloqueArchivo" class="row well collapse col-xs-12 col-sm-12 col-lg-12 col-md-12">
    <button id="editarArchivo" type="button" class="botonEsquinado btn btn-default">
        <i class="fa fa-fw fa-edit"></i> Editar Archivo
    </button>
    <div class="col-xs-12 col-sm-12 col-lg-6 col-md-6">
        <h3><strong><i class="fa fa-fw fa-file-excel-o"></i> Nómina</strong></h3>
        <div class="form-group">
            <div class="col-lg-4 col-md-4">
                <label class="control-label">Selecciones una nómina (.csv):</label>
            </div>
            <div class="col-lg-8 col-md-8">
                <input class="form-control" type="file" id="matriz">
            </div>
        </div>
    </div>
    <div id="archivo" class="col-xs-12 col-sm-12 col-lg-6 col-md-6 collapse">
        <h3 class="text-center"><strong>Validando Nómina...</strong></h3>
        <div class="progress">
            <div id="barraValidacion" class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
                0% Completado
            </div>
        </div>
    </div>
</div>
<div id="conclusion" class="row well collapse col-xs-12 col-sm-12 col-lg-12 col-md-12">
    <ol id="erroresMatriz"></ol>
</div>

<script type="text/javascript" src="../js/main.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/validaciones.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/empresa/timbrar/datos.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/empresa/timbrar/timbrar.js" charset="utf-8"></script>
<%@include file="/WEB-INF/pages/empresaTemplates/footer.jsp" %>