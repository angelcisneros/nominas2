<%@include file="/WEB-INF/pages/empresaTemplates/header.jsp" %>
<div class="row">
    <h1 class="text-danger"><i class="fa fa-fw -circle fa-globe"></i>Sucursales</h1>
    <hr>
</div>
<div class="row">
    <div class="form-inline col-xs-12 col-sm-12 col-lg-9 col-md-9">
        <div class="input-group">
            <span class="input-group-addon" id="basic-addon1"><i class="fa fa-fw s fa-search"></i>Búsquedas:</span>
            <select id="busquedas" class="form-control" aria-describedby="basic-addon1">
                <option label="--TODOS--" value="0">--TODOS--</option>
                <option label="Por Nombre" value="1">Por Nombre</option>
                <option label="Por RFC" value="2" >Por RFC</option>
            </select>
        </div>
    </div>
    <div class="form-inline col-xs-12 col-sm-12 col-lg-3 col-md-3">
        <div class="btn-group pull-right" role="group" aria-label="">
            <!--<button class="btn btn-success"><i class="fa form-control-feedback fa-plus"></i>Agregar Nueva</button>-->
            <button class="btn btn-danger" id="agregar"> <i class="fa fa-fw -circle -text s -photo-o -circle -circle fa-file-pdf-o"></i>Reporte PDF</button>
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
                <th>Opciones</th>
            </tr>
        </thead>
        <tbody>
            <%@ include file="/WEB-INF/pages/empresa/sucursalesBody.jsp"%>
        </tbody>
    </table>
</div>
<div class="modal fade" id="popUpDomicilio" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header amarillo">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                </button>
                <h1 class="modal-title"><strong id="tituloPopUp"></strong></h1>
            </div>
            <div class="modal-body">
                <form>
                    <div class="col-md-6">
                        <h3>Datos Obligatorios</h3>
                        <div class="form-group">
                            <div class="col-sm-2">
                                <label class="control-label">*Calle:</label>
                            </div>
                            <div class="col-sm-10">
                                <input id="calle" name="calle" type="text" class="form-control" placeholder="Calle">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-2">
                                <label class="control-label">*Estado:</label>
                            </div>
                            <div class="col-sm-10">
                                <input id="estado" name="estado" type="text" class="form-control" placeholder="Estado">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-2">
                                <label class="control-label">*Municipio:</label>
                            </div>
                            <div class="col-sm-10">
                                <input id="municipio" name="municipio" type="text" class="form-control" placeholder="Municipio">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-2">
                                <label class="control-label">*País:</label>
                            </div>
                            <div class="col-sm-10">
                                <input id="pais" name="pais" type="text" class="form-control" placeholder="País">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-2">
                                <label class="control-label">*CP:</label>
                            </div>
                            <div class="col-sm-10">
                                <input id="codigoPostal" name="codigoPostal" type="text" class="form-control" placeholder="Código Postal">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <h3>Datos Opcionales</h3>
                        <div class="form-group">
                            <div class="col-sm-2">
                                <label class="control-label">Núm. Int:</label>
                            </div>
                            <div class="col-sm-10">
                                <input id="numInterior" name="numInterior" type="text" class="form-control" placeholder="Número Interior">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-2">
                                <label class="control-label">Núm. Ext:</label>
                            </div>
                            <div class="col-sm-10">
                                <input id="numExterior" name="numExterior" type="text" class="form-control" placeholder="Número Exterior">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-2">
                                <label class="control-label">Localidad</label>
                            </div>
                            <div class="col-sm-10">
                                <input id="localidad" name="localidad" type="text" class="form-control" placeholder="Localidad">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-2">
                                <label class="control-label">Colonia:</label>
                            </div>
                            <div class="col-sm-10">
                                <input id="colonia" name="colonia" type="text" class="form-control" placeholder="Colonia">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-2">
                                <label class="control-label">Referencia:</label>
                            </div>
                            <div class="col-sm-10">
                                <input id="referencia" name="referencia" type="text" class="form-control" placeholder="Referencia">
                            </div>
                        </div>
                    </div>s
                </form>
            </div>
            <div class="modal-footer amarillo">
                <button type="button" class="btn btn-primary" data-dismiss="modal" id="agregarDomicilio">Agregar</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="popUpSucursal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header amarillo">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                </button>
                <h1 class="modal-title"><strong id="tituloPopUp"></strong></h1>
            </div>
            <div class="modal-body">
                <form id="datosForm" >
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label class="control-label">*Nombre:</label>
                                </div>
                                <div class="col-sm-10">
                                    <input id="nombre" name="nombre" class="form-control" placeholder="Nombre" value="${nombre}"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label class="control-label">*RFC:</label>
                                </div>
                                <div class="col-sm-10">
                                    <input id="rfc" name="rfc" class="form-control" placeholder="RFC" value="${rfc}"/>
                                </div>
                                <div class="col-sm-offset-2 col-sm-10">
                                    <p class="help-block">RFC correspondiente a los archivos .cer y .key</p>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label class="control-label">*Contraseña:</label>
                                </div>
                                <div class="col-sm-10">
                                    <input id="password" name="password" type="password" class="form-control" placeholder="Contraseña" />
                                </div>
                                <div class="col-sm-offset-2 col-sm-10">
                                    <p class="help-block">(Contraseña de los archivos .cer y .key)</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="alert alert-danger alert-dismissable">
                                <strong>¡Importante!</strong>Los archivos que debe subir deben ser un Certificado
                                de Sello Digital (CSD) y no una Firma Electronica (FIEL)</div>
                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label class="control-label">*CER:</label>
                                </div>
                                <div class="col-sm-10">
                                    <input id="cer" name="certificados" type="file" class="form-control" >
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label class="control-label">*KEY:</label>
                                </div>
                                <div class="col-sm-10">
                                    <input id="ky" name="llaves" type="file" class="form-control" placeholder="Password">
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer amarillo">
                <button id="agregarSucursal" type="submit" class="btn btn-primary">Siguiente
                    <i class="fa fa-fw fa-arrow-right"></i>
                </button>
            </div>
        </div>
    </div>
</div>

<script charset="utf-8" src="../js/empresa/sucursales.js"></script>
<%@include file="/WEB-INF/pages/util/respuesta.jsp" %>
<%@include file="/WEB-INF/pages/empresaTemplates/footer.jsp" %>