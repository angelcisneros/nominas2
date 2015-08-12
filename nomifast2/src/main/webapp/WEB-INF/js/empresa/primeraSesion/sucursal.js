/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).on('ready', function() {
    $('#sucursalForm').on('submit', function(e) {
        if (!validarSucursal()) {
            e.preventDefault();
        }
    });
});

function validarSucursal() {
    var requisitos = 0;
    if (validarNombre($('#nombre'))) {
        requisitos++;
    }
    if (validaRFC($('#rfc'))) {
        requisitos++;
    }
    if (validarNoVacio($('#password'))) {
        requisitos++;
    }
    if (validarExtencion($('#cer'), '.cer')) {
        requisitos++;
    }
    if (validarExtencion($('#ky'), '.key')) {
        requisitos++;
    }
    return requisitos === 5;
}

