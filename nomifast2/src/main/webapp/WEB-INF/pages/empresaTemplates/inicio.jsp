<%-- 
    Document   : inicio
    Created on : 22/06/2015, 01:43:15 PM
    Author     : vcisneros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="author" content="www.frebsite.nl">
        <meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes">
        <title>Nomifast</title>
        <link type="text/css" rel="stylesheet" href="css/demo.css">
        <link type="text/css" rel="stylesheet" href="dist/css/jquery.mmenu.all.css">
        <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
        <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="dist/js/jquery.mmenu.min.all.js"></script>
        <!-- <script type="text/javascript" src="js/menu.js"></script> /!-->
        <script type="text/javascript">
            $(function() {
                $('nav#menu').mmenu();
            });
        </script>
    </head>

    <body>
        <div id="page">
            <div class="header">
                <a href="#menu"></a>QUADRUM</div>
            <div class="content">
                <div class="col-xs-1 col-sm-1 col-lg-1 col-md-1"></div>
                <div class="col-xs-10 col-sm-10 col-lg-10 col-md-10">
                    <div id="content" class="container-fluid">
                        <div class="row">
                            <div class="jumbotron">
                                <div class="page-header">
                                    <h1>
                                        <i class="fa fa-fw fa-child"></i>¡Bienvenido!
                                        <small>El futuro empieza hoy</small>
                                    </h1>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <nav id="menu">
                <ul>
                    <li>
                        <a id="perfil" href="perfil"><i class="fa fa-fw -circle -text fa-user"></i>Perfil</a>
                    </li>
                    <li>
                        <a id="empleados" href="empleados"><i class="fa fa-fw -circle -text fa-users"></i>Empleados</a>
                    </li>
                    <li>
                        <a id="recibos" href="recibos"><i class="fa fa-fw -circle fa-file-text"></i>Recibos</a>
                    </li>
                    <li>
                        <a id="timbrar" href="timbrar"><i class="fa fa-fw -circle -text s fa-bell"></i>Timbrar</a>
                    </li>
                    <li>
                        <a id="cancelar" href="cancelar"><i class="fa fa-fw -circle -text s fa-trash"></i>Cancelar</a>
                    </li>
                    <li>
                        <a id="logo" href="logo"><i class="fa fa-fw -circle -text s fa-file-photo-o"></i>Logo</a>
                    </li>
                    <li>
                        <a id="sucursales" href="sucursales"><i class="fa fa-fw -circle -text s -photo-o fa-building"></i>Sucursales</a>
                    </li>
                    <li>
                        <a id="percepciones" href="percepciones"><i class="fa fa-fw -circle -text s -photo-o fa-plus-circle"></i>Percepciones</a>
                    </li>
                    <li>
                        <a id="deducciones" href="deducciones"><i class="fa fa-fw -circle -text s -photo-o -circle fa-minus-circle"></i>Deducciones</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-fw -circle -text s fa-sign-out"></i>Cerrar Sesión</a>
                    </li>
                </ul>
            </nav>
        </div>
    </body>

</html>
