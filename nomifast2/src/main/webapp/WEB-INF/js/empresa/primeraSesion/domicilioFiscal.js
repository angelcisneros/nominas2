/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).on('ready', function (){
    $('#domicilioForm').on('submit', function(e) {
        if (!validarDomicilio()) {
            e.preventDefault();
        }
    });
});

function validarDomicilio() {
    var requisitos = 0;
    if (validarNoVacio($('#calle'))) {
        requisitos++;
    }
    if (validarNoVacio($('#estado'))) {
        requisitos++;
    }
    if (validarNoVacio($('#municipio'))) {
        requisitos++;
    }
    if (validarNoVacio($('#pais'))) {
        requisitos++;
    }
    if (validarCP($('#codigoPostal'))) {
        requisitos++;
    }
    //opcionales
//    if (validarNoVacio($('#numInterior'))) {
//        requisitos++;
//    }
//    if (validarNombre($('#numExterior'))) {
//        requisitos++;
//    }
//    if (validaRFC($('#localidad'))) {
//        requisitos++;
//    }
//    if (validarNoVacio($('#colonia'))) {
//        requisitos++;
//    }
//    if (validarNoVacio($('#referencia'))) {
//        requisitos++;
//    }
    return requisitos === 5;
}
