<%@include file="/WEB-INF/pages/empresaTemplates/header.jsp" %>
<div class="row">
    <div class="col-md-12">
        <h1 class="text-danger"><i class="fa fa-fw fa-info-circle"></i>Información General</h1>
        <hr><br>
        <label><i class="fa fa-fw -circle fa-warning"></i>La información con * es obligatoria</label>
        <div class="row">
            <div class="col-md-6">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">*Razón Social:</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="razonSocial" placeholder="Razón Social" value="${empresa.razonSocial}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">*Correo:</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="correo" placeholder="Correo" value="${empresa.razonSocial}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">*Rgimén Fical:</label>
                        </div>
                        <div class="col-sm-10">
                            <select class="form-control" id="regimenFiscal">
                                <option value="0" label="Seleccione">Seleccione</option>
                            </select>
                        </div>
                    </div>
                </form>
                <a class="btn btn-danger pull-right">Editar Información</a>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/pages/empresaTemplates/footer.jsp" %>