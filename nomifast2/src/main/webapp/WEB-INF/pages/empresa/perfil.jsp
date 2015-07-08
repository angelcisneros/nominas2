<%@include file="/WEB-INF/pages/empresaTemplates/header.jsp" %>
<div class="row">
    <div class="col-md-12">
        <h1 class="text-danger"><i class="fa fa-fw fa-info-circle"></i>Informaci�n General</h1>
        <hr><br>
        <label><i class="fa fa-fw -circle fa-warning"></i>La informaci�n con * es obligatoria</label>
        <div class="row">
            <div class="col-md-6">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">*Raz�n Social:</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="razonSocial" placeholder="Raz�n Social" value="${empresa.razonSocial}">
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
                            <label class="control-label">*Rgim�n Fical:</label>
                        </div>
                        <div class="col-sm-10">
                            <select class="form-control" id="regimenFiscal">
                                <option value="0" label="Seleccione">Seleccione</option>
                            </select>
                        </div>
                    </div>
                </form>
                <a class="btn btn-danger pull-right">Editar Informaci�n</a>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/pages/empresaTemplates/footer.jsp" %>