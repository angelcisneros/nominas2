<%-- 
    Document   : primeraSesion
    Created on : 1/07/2015, 03:04:20 PM
    Author     : vcisneros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
        <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
              rel="stylesheet" type="text/css">
        <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
              rel="stylesheet" type="text/css">
    </head>

    <body>
        <div class="section section-danger">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="page-header text-inverse">
                            <h1>Configuración Inicial</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h1>1. Cambio de Password
                            <br>
                        </h1>
                        <div class="col-md-12">
                            <hr>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <form role="form" id="cambioPassAdmin">
                            <div class="form-group">
                                <label class="control-label" for="exampleInputEmail1">*Nueva Contraseña:</label>
                                <input class="form-control" id="antigua" placeholder="NUEVA CONTRASEÑA" type="password">
                            </div>
                            <div class="form-group">
                                <label class="control-label">*Repita Su Contraseña:</label>
                                <input class="form-control" id="nueva" placeholder="REPITA SU CONTRASEÑA" type="password">
                            </div>
                            <button type="submit" class="btn btn-lg btn-link pull-right">Siguiente
                                <i class="fa fa-fw fa-arrow-right"></i>
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>
