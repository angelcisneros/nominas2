/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).on('ready', function() {
    $('#editarPerfil').on('click', function() {
        if (validarPerfil()) {
            $.ajax({
                type: 'POST',
                url: "editarPerfil",
                dataType: 'text',
                data: $('#datosForm').serialize(),
                success: function(respuesta) {
                    var respuesta = respuesta.split('#');
                    $('#tituloPopUp').text(respuesta[0]);
                    $('#contenidoPopUp').text(respuesta[1]);
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
function validarPerfil() {
    var requisitos = 0;
    if (validarNombre($('#razonSocial'))) {
        requisitos++;
    }
    if (validarOption('#regimenFiscal')) {
        requisitos++;
    }
    return requisitos === 2;
}