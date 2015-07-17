<%-- 
    Document   : index
    Created on : 22/06/2015, 01:31:31 PM
    Author     : vcisneros
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
        <script type="text/javascript" src="js/log.js"></script>
        <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="css/css.css">
        <c:if test="${errorEmpresa eq true or errorEmpresa eq 'true'}">
            <script>
                $(document).on('ready', function(){
                    $('#log-empresa').modal('show');
                });
            </script>
        </c:if>
    </head>

    <body>
        <div class="cover">
            <div class="navbar navbar-default">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="logo.png"><span>Quadrum</span><br></a>
                    </div>
                    <div class="collapse navbar-collapse" id="navbar-ex-collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="#">Contacto<br></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="cover-image" style="background-image : url('http://pingendo.github.io/pingendo-bootstrap/assets/blurry/800x600/7.jpg')"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-12 text-center">
                        <div class="col-md-12">
                            <img src="images/Isotipo Comercial-01.png" class="center-block img-responsive img-rounded">
                        </div>
                        <h1 class="text-inverse">¡BIENVENIDO!
                            <br>
                        </h1>
                        <p class="text-inverse" contenteditable="true">Selecciona un modo de acceso
                            <br>
                            <br>
                        </p>
                        <div class="btn-group">
                            <a id="empresaButton" class="btn btn-danger btn-lg">Empresas</a>
                            <a id="empleadoButton" class="btn btn-danger btn-lg">Empleados<br></a>
                        </div>
                        <br>
                        <br>
                    </div>
                </div>
            </div>
        </div>
        <div class="fade modal text-center" id="log-empresa" data-backdrop="static">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header danger">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title">Login Empresa</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-12">
                                <form id="loginEmpresaForm" role="form" method="post" action="empresa/loginEmpresa">
                                    <div class="form-group has-feedback">
                                        <input class="form-control input-lg" id="rfcEmpresa" placeholder="RFC" type="text" name="j_username">
                                        <span class="fa form-control-feedback fa-user"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input class="form-control input-lg" id="passwordRfc" placeholder="CONTRASEÑA" type="password" name="j_password">
                                        <span class="fa form-control-feedback fa-lock"></span>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox">Recordarme
                                                    <br>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <input type="submit" class="btn btn-block btn-lg btn-success" value="ENtrar"/>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer danger">
                        <a>Olvide mi contraseña</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="fade modal text-center" id="log-empleado" data-backdrop="static">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title">Login Empleado
                            <br>
                        </h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-12">
                                <form id="loginEmpleadoForm" role="form" method="post" action="loginEmpleado">
                                    <div class="form-group has-feedback">
                                        <input class="form-control input-lg" placeholder="CORREO" type="text" name="j_username">
                                        <span class="fa form-control-feedback fa-user"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input class="form-control input-lg" placeholder="CONTRASEÑA" type="password" name="j_password">
                                        <span class="fa form-control-feedback fa-lock"></span>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox">Recordarme</label>
                                            </div>
                                        </div>
                                    </div>
                                    <input type="submit" class="btn btn-block btn-lg btn-success" value="Entrar"/>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer text-center">
                        <a>Olvide mi contraseña</a>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>