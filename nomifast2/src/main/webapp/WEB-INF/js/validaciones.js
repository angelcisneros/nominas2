/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validarCorreo(correo) {
    var valido = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test($(correo).val());
    if (valido) {
        limpiar(correo);
    } else {
        muestraError(correo, 'Correo Invalido', 'Ingrese Un correo valido');
    }
    return valido;
}

function validarCP(cp){
    var valido = /[0-9]{5}/.test($(cp).val());
    if (valido) {
        limpiar(cp);
    } else {
        muestraError(cp, 'Código Postal Invalido', 'Ingrese Un Código Postal valido');
    }
    return valido;
}

function validarPassword(password) {
    //var valido = /(?=^.{8,15}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/.test($(password).val());
    var valido = /^[a-z\d_]{1,15}$/i.test($(password).val());
    if (valido) {
        limpiar(password);
    } else {
        muestraError(password, 'Password Invalido', 'Debe incluir una mayúscula, un carácter especial (@,?,#, etc) y un número');
    }
    return valido;
}

function validarPasswordIguales(pass, pass1) {
    var valido = false;
    if (validarPassword(pass)) {
        limpiar(pass);
        valido = $(pass).val() === $(pass1).val();
        if (!valido) {
            muestraError(pass1, 'Passwords incorrectos', "Los password no coinciden");
        } else {
            limpiar(pass1);
        }
    }
    return valido;
}

function validarNombre(nombre) {
    var valido = /^[a-zA-Z]{1,15}$/i.test($(nombre).val());
    if (valido) {
        limpiar(nombre);
    } else {
        muestraError(nombre, 'Nombre Invalido', 'Los nombres deben ser solo letras');
    }
    return valido;
}
function validarNoVacio(campo){
    var valido = $(campo).val() !== '';
    if(valido){
        limpiar(campo);
    }else{
        muestraError(campo, 'Campo Inválido', 'Este campo no puede ser vacio');
    }
    return valido;
}
function validarOption(opcion) {
    var valido = $(opcion).val() !== '0';
    if (valido) {
        limpiar(opcion);
    } else {
        muestraPopUpCampoNoVacio(opcion);
        $(opcion).css("border", "1px solid red");
    }
    return valido;
}
function validaRFC(rfc) {
    var valido = /^[A-Z,Ã‘,&]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z,0-9]{3}$/.test($(rfc).val());
    if(valido){
        limpiar(rfc);
    }else{
        muestraError(rfc, 'RFC Inválido', 'La estructura del rfc debe ser valida');
    }
    return valido;
}
function validarExtencion(campo, ext1) {
    var name = $(campo).val();
    var len = name.length;
    var ext = name.substring(len - ext1.length, len);
    ext1 = ext1.toLowerCase();
    var valido = ext === ext1;
    ext = ext.toLowerCase();
    if (valido) {
        limpiar(campo);
    }else{
        muestraError(campo, 'Campo Inválido', 'La estención debe ser un ' + ext1);
    }
    return valido;
}
function limpiar(input) {
    $(input).removeAttr('style');
    cierraPopUpChiquito(input);
}

function muestraError(selector, titulo, mensaje) {
    muestraPopUpTituloAndMensaje(selector, titulo, mensaje);
    $(selector).css("border", "1px solid red");
}