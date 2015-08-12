<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="header.jsp" %>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1>2. Domicilio Fiscal</h1>
                <hr>
            </div>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <form id="domicilioForm" class="form-horizontal" role="form" method="post" action="agregarDomicilio">
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
                </div>
                <div class="row">
                    <div class="col-sm-1 col-sm-offset-11 text-right">
                        <button type="submit" class="btn btn-link">Siguiente<i class="fa fa-fw fa-arrow-right"></i></button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript" src="../js/main.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/validaciones.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/empresa/primeraSesion/domicilioFiscal.js" charset="utf-8"></script>

<c:if test="${hasErrors eq true or hasErrors eq 'true'}">
    <script type="text/javascript" charset="utf-8">
        $(document).on('ready', function() {
            <c:forEach items="${errores}" var="e" varStatus="status">
                muestraError($('#${fn:split(e.codes[1], '.')[1]}'), 'Campo inválido', '${e.defaultMessage}');
            </c:forEach>
        });
    </script>    
</c:if>
<%@include file="footer.jsp" %>