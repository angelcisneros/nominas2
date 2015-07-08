/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).on('ready', function() {

    $('#perfil').on('click', function() {
        $('#content').load('perfil', function(a, b, c) {

        });
    });

    $('#empleados').on('click', function() {
        $('#content').load('empleados', function(a, b, c) {
            window.history.pushState(null, "empleados", "empleados");
        });
    });
    $('#sucursales').on('click', function() {
        $('#content').load('sucursales', function(a, b, c) {
            window.history.pushState(null, "sucursales", "empleados");
        });
    });
    $('#recibos').on('click', function() {
        $('#content').load('recibos', function(a, b, c) {

        });
    });
    $('#timbrar').on('click', function() {
        $('#content').load('timbrar', function(a, b, c) {

        });
    });
    $('#cancelar').on('click', function() {
        $('#content').load('cancelar', function(a, b, c) {

        });
    });
    $('#logo').on('click', function() {
        $('#content').load('logo', function(a, b, c) {

        });
    });
    $('#percepciones').on('click', function() {
        $('#content').load('percepciones', function(a, b, c) {

        });
    });
    $('#deducciones').on('click', function() {
        $('#content').load('deducciones', function(a, b, c) {

        });
    });

});