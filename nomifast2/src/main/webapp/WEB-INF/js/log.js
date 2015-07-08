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


    $('#logEmpresa').on('click', function() {
        $.ajax({
            type: 'POST',
            url: "loginEmpresa/",
            dataType: 'text',
            data: $('#loginEmpresaForm').serialize(),
            success: function(respuesta) {
                
            },
            error: function(jqXHR, textStatus, errorThrown) {

            }
        });
    });

});


