/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).on('ready', function() {

    $('#empresaButton').on('click', function() {
        $('#log-empresa').modal('show');
    });
    $('#empleadoButton').on('click', function() {
        $('#log-empleado').modal('show');
    });

    $('#registrarEmpresa').on('click', function() {
        cerrarPopUps();
        $('#newEmpresa').modal('show');
    });

    $('#registrarEmpresaButton').on('click', function() {
        if (validar()) {
            $.ajax({
                type: 'POST',
                url: "registrarEmpresa",
                dataType: 'text',
                data: $('#empresaForm').serialize(),
                success: function(respuesta) {
                    var respuesta = respuesta.split('#');
                    $('#tituloPopUp').text(respuesta[0]);
                    $('#tituloContenidoPopUp').text(respuesta[1]);
                    $('#contenidoPopUp').text(respuesta[2]);
                    $('#popUpRespuesta').modal('show');
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    $('#tituloPopUp').text('Ups!...');
                    $('#contenidoPopUp').text('Estmos experiemntando problemas pero ya estamos trabajhanod en ellos.');
                    $('#popUpRespuesta').modal('show');
                }
            });
        }
    });
});
function cerrarPopUps() {
    $('.fade modal').modal('hide');
}
function validar() {
    var requisitos = 0;
    if (validarCorreo($('#mailEmpresa'))) {
        requisitos++;
    }
    if (validarPasswordIguales($('#passwordEmpresa'), $('#passwordEmpresaConfirmación'))) {
        requisitos++;
    }
    if (validarNombre($('#nombreEmpresa'))) {
        requisitos++;
    }
    if (validarOption($('#regimenFiscal'))) {
        requisitos++;
    }
    return requisitos === 4;
}
