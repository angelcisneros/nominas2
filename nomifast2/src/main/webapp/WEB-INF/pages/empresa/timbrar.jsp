<%@include file="/WEB-INF/pages/empresaTemplates/header.jsp" %>
<div class="row">
    <h1 class="text-danger">    
        <i class="fa fa-fw -circle -text s fa-bell"></i>Timbrar</h1>
    <hr>
</div>
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
<%@include file="/WEB-INF/pages/empresaTemplates/footer.jsp" %>