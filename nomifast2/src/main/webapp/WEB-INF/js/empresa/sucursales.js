/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).on('ready', function(){
    $('#agregar').on('click', function(){
        $('#popUpSucursal').modal('show');
    });
    
    $('#agregarSucursal').on('click', function(){
        var cer = document.getElementById('cer');
        var csd = new FormData();
        csd.append('cer', cer.files[0]);
        var data = {'sucursal':$('#datosForm').serialize(), 'archivos':csd}; 
        
        //data.append('sucursal', $('#datosForm').serialize());
         $.ajax({
            url: 'agregarSucursal',
            data: data,
            async: true,
            dataType: 'text',
            processData: false,
            contentType: false,
            type: 'POST',
            success: function(data) {
                if(data === '1'){
                    var div = $(valor).siblings('div');
                    var estilo = $(div).attr('style') + ' opacity: 0.4; filter: alpha(opacity=40);';
                    $(div).attr('style', estilo);
                }
            }
        });
    });
});

