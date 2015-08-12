<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="header.jsp" %>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1 contenteditable="true">4. Claves de Percepciones</h1>
                <hr>
            </div>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h2 class="text-center">Catálogo SAT</h2>
                <table class="table table-bordered table-condensed table-hover table-striped">
                    <thead>
                        <tr>
                            <th class="danger">Clave SAT</th>
                            <th class="danger">Nombre</th>
                            <th class="danger">Agregar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%@ include file="/WEB-INF/pages/empresaPrimeraSesion//percepcionesBodyEmpresa.jsp"%>
                    </tbody>
                </table>
            </div>
            <div class="col-md-6">
                <h2 class="text-center" contenteditable="true">Claves Empresa</h2>
                <table class="table table-bordered table-condensed table-hover table-striped">
                    <thead>
                        <tr>
                            <th class="danger">Clave SAT</th>
                            <th class="danger">Concepto</th>
                            <th class="danger">Clv Empresa</th>
                        </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1 col-sm-offset-11 text-right">
                <button type="submit" class="btn btn-link">Siguiente
                    <i class="fa fa-fw fa-arrow-right"></i>
                </button>
            </div>
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