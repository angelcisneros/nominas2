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
        <script type="text/javascript" src="js/main.js" charset="utf-8"></script>
        <script type="text/javascript" src="js/validaciones.js" charset="utf-8"></script>
        <script type="text/javascript" src="js/log.js" charset="utf-8"></script>
        <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="css/css.css">
        <c:if test="${errorEmpresa eq true or errorEmpresa eq 'true'}">
            <script>
                $(document).on('ready', function() {
                    $('#log-empresa').modal('show');
                    $('#mensaje-empresa').text('Usuario o Password incorrectos.');
                });
            </script>
        </c:if>
        <c:if test="${popup eq 'empresa'}">
            <script>
                $(document).on('ready', function() {
                    $('#log-empresa').modal('show');
                    $('#mensaje-empresa').text('Se activado su cuenta. Inicie sesión nuevamente');
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
                                    <label id="mensaje-empresa" class=""></label>
                                    <input type="submit" class="btn btn-block btn-lg btn-success" value="Entrar"/>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer danger">
                        <a id="registrarEmpresa">Registrarme</a>
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
                                    <label id="mensaje-empleado" class=""></label>
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

        <div class="fade modal text-center" id="newEmpresa" data-backdrop="static">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title">Registro
                            <br>
                        </h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-12">
                                <form id="empresaForm" class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label">Email:</label>
                                        </div>
                                        <div class="col-sm-10">
                                            <input type="email" class="form-control" id="mailEmpresa" placeholder="Email" name="usuario.userName">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label">Password:</label>
                                        </div>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" id="passwordEmpresa" placeholder="Password">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label">Confirme Password:</label>
                                        </div>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" id="passwordEmpresaConfirmación" placeholder="Password" name="usuario.password">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label">Razón Social:</label>
                                        </div>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="nombreEmpresa" placeholder="Razón Social" name="usuario.nombre">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label">Regimén Fiscal:</label>
                                        </div>
                                        <div class="col-sm-10">
                                            <select id="regimenFiscal" class="form-control" name="regimenFiscal.id">
                                                <option label="Seleccione..." value="0">Seleccione...</option>
                                                <c:forEach items="${regimenesFiscales}" var="r" varStatus="status">
                                                    <option label="${r.nombre}" value="${r.id}">${r.nombre}</option>    
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                </form>
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <button id="registrarEmpresaButton" type="submit" class="btn btn-default">Sign in</button>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>

                    <div class="modal-footer text-center">
                        <a>Olvide mi contraseña</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- POPUP RESPUESTA CRUD -->
        <div class="modal fade" id="popUpRespuesta" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header amarillo">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                        </button>
                        <h1 class="modal-title"><strong id="tituloPopUp"></strong></h1>
                    </div>
                    <div class="modal-body">
                        <h2 class="modal-title"><strong id="tituloContenidoPopUp"></strong></h2>
                        <h3 id="contenidoPopUp"></h3>
                    </div>
                    <div class="modal-footer amarillo">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Aceptar</button>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div>
    </body>

</html>