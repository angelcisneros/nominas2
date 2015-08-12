<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="header.jsp" %>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1>1. Sucursal Principal </h1>
                <hr>
            </div>
        </div>
        <form id="sucursalForm" commandName="sucursal" class="form-horizontal" role="form" action="agregarMatriz" method="post" enctype="multipart/form-data">
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
                    <div class="form-group">
                        <div class="col-sm-10 col-sm-offset-2 text-right">
                            <button id="siguiente" type="submit" class="btn btn-link">Siguiente
                                <i class="fa fa-fw fa-arrow-right"></i>
                            </button>
                        </div>
                    </div>

                </div>
            </div>
        </form>
    </div>
</div>

<script type="text/javascript" src="../js/main.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/validaciones.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/empresa/primeraSesion/sucursal.js" charset="utf-8"></script>

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