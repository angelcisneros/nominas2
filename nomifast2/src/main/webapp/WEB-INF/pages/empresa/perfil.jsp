<%@include file="/WEB-INF/pages/empresaTemplates/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
    <div class="col-md-12">
        <h1 class="text-danger"><i class="fa fa-fw fa-info-circle"></i>Información General</h1>
        <hr><br>
        <label><i class="fa fa-fw -circle fa-warning"></i>La información con * es obligatoria</label>
        <div class="row">
            <div class="col-md-6">
                <form class="form-horizontal" role="form" id="datosForm">
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">*Razón Social:</label>
                        </div>
                        <div class="col-sm-10">
                            <input id="razonSocial" name="usuario.nombre" type="text" class="form-control" id="razonSocial" placeholder="Razón Social" value="${empresa.usuario.nombre}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">*Rgimén Fical:</label>
                        </div>
                        <div class="col-sm-10">
                            <select name="regimenFiscal.id" class="form-control" id="regimenFiscal">
                                <option value="0" label="Seleccione">Seleccione</option>
                                <c:forEach items="${regimenes}" var="r" varStatus="status">
                                    <option value="${r.id}" label="${r.nombre}">${r.nombre}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </form>
                <a id="editarPerfil" class="btn btn-danger pull-right">Editar Información</a>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/pages/util/respuesta.jsp" %>
<script type="text/javascript" src="../js/main.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/validaciones.js" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">
    $(document).on('ready', function() {
        setOption($('option'), '${empresa.regimenFiscal.nombre}');
    });
</script>
<script type="text/javascript" src="../js/empresa/perfil.js" charset="utf-8"></script>
<%@include file="/WEB-INF/pages/empresaTemplates/footer.jsp" %>