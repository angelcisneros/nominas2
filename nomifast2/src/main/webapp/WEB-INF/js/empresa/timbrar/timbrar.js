var datosRequeridos = {
    RFC: 'RFC',
    NSS: 'NSS',
    CUR: 'CURP',
    NEM: 'No Empleado',
    RCO: 'Regimen de Contatacion',
    PPA: 'Periodicidad de pago',
    NOM: 'Nombre del empleado',
    FPA: 'Fecha Pago',
    FIP: 'Fecha Inicial Pago',
    FFP: 'Fecha final pago',
    NDP: 'No Dias pagados',
    RPA: 'Registro Patronal',
    TPA: 'Total Pagar'
};
var datosOpcionales = {
    FRL: 'Fecha de inicio de relación laboral',
    ANT: 'Antigüedad',
    PUE: 'Puesto',
    TCO: 'Tipo de contrato',
    TJO: 'Tipo de jornada',
    SBC: 'Salario base por acotar',
    SDI: 'Salario diario integrado',
    RPU: 'Riesgo de puesto',
    BAN: 'Banco',
    CLA: 'Clabe',
    DEP: 'Departamento',
    TPG: 'Total Percepcion Gravada',
    TPE: 'Total Percepcion Exenta',
    TDG: 'Total Deduccion Gravada',
    TDE: 'Total Deduccion Exenta'
};
var letras = {1: 'A', 2: 'B', 3: 'C', 4: 'D', 5: 'E', 6: 'F', 7: 'G', 8: 'H', 9: 'I', 10: 'J', 11: 'K', 12: 'L', 13: 'M', 14: 'N', 15: 'O', 16: 'P', 17: 'Q', 18: 'R', 19: 'S', 20: 'T', 21: 'U', 22: 'V', 23: 'W', 24: 'X', 25: 'Y', 26: 'Z'};
var recibos = [];
var uuids = [];
var sucursal = 0;
var currentFile = -1;
var timbrados = 0;
window.onload = function() {
    var matriz = document.getElementById('matriz');
    matriz.addEventListener('change', function(evt) {
        compruebaSucursal();//Validamos la sucursal
        if (sucursal > 0) {
            if (validarExtencion($('#matriz'), '.csv')) {
                var reader = new FileReader();
                reader.onload = function(e) {
                    document.getElementById('matriz').value = ''; //HACE POSIBLE EL EVENTO
                    var renglones = (reader.result).split('\n');
                    var cabecera = renglones[0].split(',');
                    $('#archivo').collapse('show');//muestra la barra de navegacion
                    if (isCabeceraValid(cabecera)) {
                        var correctos = 0;
                        for (var i = 2; i < renglones.length; i++) {
                            var columnas = renglones[i].split(',');
                            var recibo = new Recibo(columnas, cabecera, i + 1);
                            if (recibo.validarDatos()) {
                                recibos.push(recibo.construirRecibo(columnas, cabecera, i + 1));
                                correctos++;
                            }
                            comienzaBarra($('#barraValidacion'), (i - 1) / (renglones.length - 2));
                        }
                        if (correctos === renglones.length - 2) {
                            mostrarBoton();
                        } else {
                            mostrarErrores();
                        }
                    }
                };
                reader.readAsText(matriz.files[0]);
            }
        } else {
            document.getElementById('matriz').value = ''; //HACE POSIBLE EL EVENTO
        }
    });
};
function isCabeceraValid(cabecera) {
    var obligatorios = 0;
    if (isSizeValid(cabecera.length)) {
        var noValido = false;
        for (var i = 0; i < cabecera.length; i++) {
            if (datosRequeridos.hasOwnProperty(cabecera[i].replace(/\f|\n|\s/g, ''))) {
                obligatorios++;
            } else {
                if (!isStringValid(cabecera[i].replace(/\f|\n|\s/g, ''), i + 1)) {
                    noValido = true;
                }
            }
        }
        if (noValido) {
            return !noValido;
        }
    }
    return cumpleObligatorios(obligatorios);
}
function isSizeValid(size) {
    var valid = size < 147;
    if (!valid) {
        muestraPopUpTituloAndMensaje($('#matriz'), 'Matriz invalida', 'No puede tener mas de 146 columnas');
    } else {
        cierraPopUpChiquito($('#matriz'));
    }
    return valid;
}
function isStringValid(str, i) {
    var valid = /^(TPG|TPE|TDG|TDE|FRL|ANT|PUE|TCO|TJO|SBC|SDI|RPU|BAN|CLA|DEP|((P|D)(G|E)[0-9]{3}-.{3,15}-.{1,100}))$/.test(str);
    if (!valid) {
        addError('No se reconoce el titulo: <strong>' + str + '</strong> de la celda: <strong>' + regresaCelda(i) + '</strong>');
    }
    return valid;
}
function regresaCelda(i) {
    if (i < 27)
        return letras[i];
    var a = parseInt(i / 26);
    var b = i % 26;
    return letras[a] + letras[b];
}
function cumpleObligatorios(obligatorios) {
    var valid = obligatorios === Object.keys(datosRequeridos).length;
    if (!valid) {
        addError('Se requiere cumpli con los campos obligatorios del manual');
    } else {
        $('#erroresMatriz').html('');
    }
    return valid;
}
function addError(mensaje) {
    $('#erroresMatriz').append('<li>' + mensaje + '</li>');
}
function Recibo(col, cab, ren) {
    var _this = this;
    var opcionales = {};
    var obligatorios = {};
    var deducciones = {totalGravado: 0.0, totalExento: 0.0};
    var percepciones = {totalGravado: 0.0, totalExento: 0.0};
    this.cabecera = cab;
    this.columnas = col;
    this.renglon = ren;

    var _auxPercepcion = {};
    var _auxDeduccion = {};

    Recibo.prototype.validarDatos = function() {
        if (_this.columnas.length !== _this.cabecera.length) {
            addError('El renglón <strong>' + _this.renglon + '</strong> no coincide con el tamaño de la cabecera');
        }
        var correctos = 0;
        for (var j = 0; j < _this.cabecera.length; j++) {
            if (isDatoValid(_this.cabecera[j].replace(/\s$/g, ''), _this.columnas[j].replace(/\s$/g, ''), _this.renglon, j)) {
                correctos++;
            }
        }
        return correctos === _this.cabecera.length;
    };
    function isDatoValid(cabecera, valor, renglon, j) {
        var columna = regresaCelda(j + 1);

        if (datosRequeridos.hasOwnProperty(cabecera)) {
            return isObligatorioValid(cabecera, valor, renglon, columna);
        } else {
            if (datosOpcionales.hasOwnProperty(cabecera)) {
                return isOpcionalValid(cabecera, valor, renglon, columna);
            } else {
                if (cabecera.split('-').length - 1 === 2) {
                    if (/^((P|D)(G|E)[0-9]{3}-.{3,15})$/.test(cabecera)) {
                        if (cabecera.substring(0, 1) === 'D') {
                            return isDeduccionValid(cabecera.substring(1, cabecera.length), valor, renglon, columna);
                        }
                        return isPercepcionValid(cabecera.substring(1, cabecera.length), valor, renglon, columna);
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
    }
    function isObligatorioValid(cabecera, valor, renglon, columna) {
        var celda = renglon + columna;
        var fecha = /^((([0-9]{4})(-|\/)?(1[0-2]|0[1-9])(-|\/)?(3[01]|0[1-9]|[12][0-9]))|((3[01]|0[1-9]|[12][0-9])(-|\/)?(1[0-2]|0[1-9])(-|\/)?([0-9]{4})))$/;
        switch (cabecera) {
            case 'RFC':
                return validar(/^[A-Z,Ã‘,&]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z,0-9]{3}$/, valor.replace(/-/g, '').replace(/\s/g, ''), 'RFC invalido', celda, obligatorios, 'rfc');
            case 'NSS':
                return validar(/^(.{1,15})$/, valor, 'NSS invalido', celda, obligatorios, 'nss');
            case 'CUR':
                return validar(/[A-Z]{1}[AEIOU]{1}[A-Z]{2}[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])[HM]{1}(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)[B-DF-HJ-NP-TV-Z]{3}[0-9A-Z]{1}[0-9]{1}$/, valor.replace(/-/g, '').replace(/\s/g, ''), 'CURP invalido', celda, obligatorios, 'curp');
            case 'NEM':
                return validar(/^(.{1,15})$/, valor, 'Número de empleado invalido', celda, obligatorios, 'numEmpleado');
            case 'RCO':
                return validar(/^([2-9]|10)$/, valor, 'Regimen de Contratación invalido', celda, obligatorios, 'regimenContratacion');
            case 'PPA':
                return validar(/^(.{1,100})$/, valor, 'Periodicidad de pago invalido', celda, obligatorios, 'periocidadPago');
            case 'NOM':
                return validar(/^([^\d\s][a-zA-ZáéíóúñÁÉÍÓÚÑ\s]{0,145})$/, valor, 'Nombre invalido', celda, obligatorios, 'nombre');
            case 'FPA':
                return validar(fecha, valor.replace(/\//g, '-'), 'Fecha invalida', celda, obligatorios, 'fechaPago');
            case 'FIP':
                return validar(fecha, valor.replace(/\//g, '-'), 'Fecha invalida', celda, obligatorios, 'fechaInicialPago');
            case 'FFP':
                return validar(fecha, valor.replace(/\//g, '-'), 'Fecha invalida', celda, obligatorios, 'fechaFinalPago');
            case 'NDP':
                return validar(/^([0-9]{1,3})$/, valor, 'Dias pagados invalido', celda, obligatorios, 'numeroDiasPagados');
            case 'RPA':
                return validar(/^(.{1,20})$/, valor, 'Registro Patronal', celda, obligatorios, 'registroPatronal');
            case 'TPA':
                return validar(/^(([0-9]{1,6}\.[0-9]{1,6}|[0-9]{1,6}))$/, valor, 'Total Pagar invalida', celda, obligatorios, 'totalPagar');
        }
    }
    function isOpcionalValid(cabecera, valor, renglon, columna) {
        var celda = renglon + columna;
        var monto = /^(([0-9]{1,6}\.[0-9]{1,6}|[0-9]{1,6}))$/;
        switch (cabecera) {
            case 'FRL':
                return validar(/^((([0-9]{4})(-|\/)?(1[0-2]|0[1-9])(-|\/)?(3[01]|0[1-9]|[12][0-9]))|((3[01]|0[1-9]|[12][0-9])(-|\/)?(1[0-2]|0[1-9])(-|\/)?([0-9]{4})))$/, valor.replace(/\//g, '-'), 'Fecha invalido', celda, opcionales, 'fechaInicoLaboral');
            case 'ANT':
                return validar(/^([0-9]{1,5})$/, valor, 'Antiguedad invalido', celda, opcionales, 'antiguedad');
            case 'PUE':
                return validar(/^(.{1,45})$/, valor, 'Puesto invalido', celda, opcionales, 'puesto');
            case 'TCO':
                return validar(/^(.{1,45})$/, valor, 'Tipo de Contrato invalido', celda, opcionales, 'tipoContrato');
            case 'TJO':
                return validar(/^(.{1,45})$/, valor, 'Tipo de jornada invalido', celda, opcionales, 'tipoJornada');
            case 'SBC':
                return validar(monto, valor, 'Salario Base invalido', celda, opcionales, 'salarioBase');
            case 'SDI':
                return validar(monto, valor, 'Salario Diario invalido', celda, opcionales, 'salarioDiario');
            case 'RPU':
                return validar(/^([1-5]{1})$/, valor, 'Riesgo de Puesto invalida', celda, opcionales, 'riesgoPuesto');
            case 'CLA':
                return validar(/^([0-9]{18})$/, valor, 'CLABE invalida', celda, opcionales, 'clabe');
            case 'DEP':
                return validar(/^(.{1,45})$/, valor, 'Departamento invalida', celda, opcionales, 'departamento');
            case 'BAN':
                return validar(/^([0-9]{3})$/, valor, 'Banco invalida', celda, opcionales, 'banco');
            case 'TPE':
                return validar(monto, valor, 'Total Percepcion Exenta', celda, opcionales, 'totalPercepcionesExentas');
            case 'TPG':
                return validar(monto, valor, 'Total Percepcion Gravada invalida', celda, opcionales, 'totalPercepcionesGravadas');
            case 'TDG':
                return validar(monto, valor, 'Total Deduccion Gravada invalida', celda, opcionales, 'totalDeduccionesGravadas');
            case 'TDE':
                return validar(monto, valor, 'Total Deduccion Exenta invalida', celda, opcionales, 'totalDeduccionesExentas');

        }
    }
    function isPercepcionValid(cabecera, valor, renglon, columna) {
        return isIncidenciaValid(cabecera, valor, renglon + columna, 'Percepción', _auxPercepcion, percepciones);
    }
    function isDeduccionValid(cabecera, valor, renglon, columna) {
        return isIncidenciaValid(cabecera, valor, renglon + columna, 'Deducción', _auxDeduccion, deducciones);
    }
    function isIncidenciaValid(cabecera, valor, celda, mensaje, auxiliar, lista) {
        if (/^(([0-9]{1,6}\.[0-9]{1,6}|[0-9]{1,6}))$/.test(valor)) {
            valor = parseFloat(valor);
            if (valor > 0) {
                var cadena = cabecera.split('-');
                var claveSat = cadena[0].substring(1, 4);
                if (auxiliar[claveSat] === undefined) {
                    var incidencia = new Incidencia();
                    incidencia.claveSat = claveSat;
                    incidencia.claveEmpresa = cadena[1];
                    incidencia.concepto = cadena[2];
                    if (cabecera.substring(0, 1) === 'E') {
                        lista.totalExento += valor;
                        incidencia.exento = valor;
                    } else {
                        lista.totalGravado += valor;
                        incidencia.gravado = valor;
                    }
                    auxiliar[claveSat] = incidencia;
                } else {
                    if (cabecera.substring(0, 1) === 'E') {
                        lista.totalExento += valor;
                        auxiliar[claveSat].exento = valor;
                    } else {
                        lista.totalGravado += valor;
                        auxiliar[claveSat].gravado = valor;
                    }
                }
            }
            return true;

        } else {
            addError('Error celda: <strong>' + celda + '</strong>.' + mensaje + ' invalida' + '(<strong>' + valor + '</strong>)');
            return false;
        }
    }
    function validar(exp, valor, mensaje, celda, objeto, atributo) {
        if (exp.test(valor)) {
            objeto[atributo] = valor;
            return true;
        } else {
            addError('Error celda: <strong>' + celda + '</strong>.' + mensaje + '(<strong>' + valor + '</strong>)');
            return false;
        }
    }
    Recibo.prototype.construirRecibo = function() {
        var nomina = {obligatorios: obligatorios};
        if (Object.keys(opcionales).length > 0) {
            nomina['opcionales'] = opcionales;
        }
        regresaListaInsidencias(_auxPercepcion, percepciones, nomina, 'percepciones');
        regresaListaInsidencias(_auxDeduccion, deducciones, nomina, 'deducciones');

        return nomina;
    };
    function regresaListaInsidencias(auxiliar, lista, nomina, nombre) {
        var insidencias = [];
        for (var percepcion in auxiliar) {
            insidencias.push(auxiliar[percepcion]);
        }
        if (insidencias.length > 0) {
            lista[nombre] = insidencias;
            nomina[nombre] = lista;
        }
    }
}
function Incidencia() {
    this.claveSat;
    this.claveEmpresa;
    this.concepto;
    this.gravado = 0;
    this.exento = 0;
}

function timbrar(nomina) {
    $.ajax({
        type: 'POST',
        url: "timbrarRecibo",
        contentType: 'application/json',
        data: nomina,
        success: function(respuesta) {
            timbrados++;
            tratarRespuesta(respuesta);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            timbrados++;
            alert('Estamos teniendo problemas, pero ya estamos trabando en ellos');
        }
    });
}
function mostrarBoton() {
    limpiarConclusion();
    $('#conclusion').prepend('<div id="conclusionFinal" class="col-xs-12 col-sm-12 col-lg-6 col-md-6 form-group">'
            + '<h3><strong><i class="fa fa-fw -o fa-check-circle"></i> Nómina Valida</strong></h3>'
            + '<div class="col-lg-12 col-md-12">'
            + '<div id="timbre" class="col-lg-12 col-md-12"><p><label>Pulse el botón para comenzar a timbrar</label><p></div>'
            + '</div>'
            + '</div>'
            + '<div id="timbrando" class="col-xs-12 col-sm-12 col-lg-6 col-md-6 collapse">'
            + '<div class="">'
            + '<h3 class="text-center"><strong>Timbrando Nómina...</strong></h3>'
            //<div class="col-xs-12 col-sm-12 col-lg-6 col-md-6"></div>
            + '<div class="progress">'
            + '<div id="barraTimbrando" class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="2" aria-valuemin="0" aria-valuemax="100" style="width: 0%">'
            + '2% Completado'
            + '</div>'
            + '</div>'
            + '</div><br>'
            + '<div id="enviandoCorreos" class="">'
            + '<h3 class="text-center"><strong><i class="fa -o-notch fa-fw fa-spin fa-spinner"></i>  Enviando Correos...</strong></h3>'
            + '</div>'
            + '</div>');
    var boton = '<button id="timbrar" type="button" class="btn btn-block btn-lg btn-danger"><i class="fa fa-fw -circle -text s fa-bell"></i>Timbrar</button>';
    $('#timbre').append(boton);
    $('#matriz').prop('disabled', true);
    document.getElementById('matriz').value = '';
    $('#conclusion').collapse('show');
}
function mostrarErrores() {
    limpiarConclusion();
    $('#conclusion').prepend('<div id="conclusionFinal" class="col-xs-12 col-sm-12 col-lg-6 col-md-6"><h3><strong><i class="fa fa-fw -o -circle fa-times-circle"></i> Nómina con Errores</strong></h3><p>Se muestra una lista de errores encontrados.<p></div>');
    $('#conclusion').append('<div id="erroresMatrizDiv" class="well col-xs-12 col-sm-12 col-lg-6 col-md-6 alert-danger"><h4>Lista de Errores</h4></div>');
    $('#erroresMatrizDiv').append($('#erroresMatriz'));
    comienzaBarra($('#barraValidacion'), 0);
    $('#archivo').collapse();
    $('#conclusion').collapse('show');
}
function getCourrentFile() {
    $.ajax({
        type: 'POST',
        //url: "https://localhost:8080/nomifast2/timbrarRecibo",
        url: "getCourrentFile",
        async: false,
        success: function(respuesta) {
            currentFile = respuesta;
        },
        error: function(jqXHR, textStatus, errorThrown) {
            currentFile = -1;
            alert('Estamos teniendo problemas, pero ya estamos trabando en ellos');
        }
    });
    return currentFile;
}
function setCurrentFile() {
    $.ajax({
        type: 'POST',
        url: "setCourrentFile",
        async: false,
        contentType: 'application/json',
        data: JSON.stringify({id: currentFile}),
        success: function(respuesta) {
            currentFile = respuesta;
        },
        error: function(jqXHR, textStatus, errorThrown) {
            currentFile = -1;
            alert('Estamos teniendo problemas, pero ya estamos trabando en ellos');
        }
    });
    return currentFile;
}
function enviarCorreos() {
    $.ajax({
        type: 'POST',
        url: 'enviarPorCorreo',
        async: false,
        contentType: 'application/json',
        data: JSON.stringify({id: currentFile}),
        success: function(respuesta) {
            currentFile = respuesta;
        },
        error: function(jqXHR, textStatus, errorThrown) {
            currentFile = -1;
            alert('Estamos teniendo problemas, pero ya estamos trabando en ellos');
        }
    });
    return currentFile;
}
$('#conclusion').on('click', '#timbrar', function() {
    $(this).attr('disabled', 'disabled');
    $('#timbrando').collapse('show');
    if (getCourrentFile() > 0 && sucursal > 0) {
        $('#editarArchivo').attr('disabled', 'disabled');
        $('#editarSucursal').attr('disabled', 'disabled');
        for (var i = 0; i < recibos.length; i++) {
            (recibos[i])['sucursal'] = {id: sucursal};
            (recibos[i])['archivo'] = {id: currentFile};
            timbrar(JSON.stringify(recibos[i]));
        }

    }

});
$('#sucursal').on('change', function() {
    compruebaSucursal();
});
function compruebaSucursal() {
    //$('#timbre').collapse();//muestra la barra de navegacion
    sucursal = $('#sucursal').val();
    if (sucursal === '0') {
        muestraError($('#sucursal'), 'Error...', 'Debe seleccionar una sucursal');
    } else {
        $.ajax({
            type: 'POST',
            url: "compruebaSucursal",
            async: false,
            data: ({id: sucursal}),
            success: function(respuesta) {
                if (!respuesta) {
                    addError('No se encontro la sucursal');
                    sucursal = -1;
                    $('#sucursal').prop('disabled', false);
                    $('#bloqueArchivo').collapse('hide');
                } else {
                    cierraPopUpChiquito($('#sucursal'));
                    $('#sucursal').prop('disabled', true);
                    $('#bloqueArchivo').collapse('show');
                }

            },
            error: function(jqXHR, textStatus, errorThrown) {
                sucursal = -1;
                alert('Estamos teniendo problemas, pero ya estamos trabando en ellos');
            }
        });

    }
    return sucursal;
}
function comienzaBarra(barra, progreso) {
    progreso = progreso * 100;
    $(barra).removeAttr('style');
    $(barra).attr('style', 'width: ' + progreso + '%');
    $(barra).removeAttr('aria-valuenow');
    $(barra).attr('aria-valuenow', progreso);
    $(barra).text(parseInt(progreso) + '% completado');
}
function tratarRespuesta(respuesta) {
    if (respuesta.ok === true) {

    } else {

    }
    console.log(timbrados + '   ' + recibos.length);
    comienzaBarra($('#barraTimbrando'), (timbrados / recibos.length));
    if (timbrados === recibos.length) {
        setCurrentFile();
        enviarCorreos();
    }
}

$('#content').on('click', '#editarSucursal', function() {
    limpiarSucursal();
    limpiarArchivo();
    limpiarConclusion();
});
$('#content').on('click', '#editarArchivo', function() {
    limpiarArchivo();
    limpiarConclusion();
});

function limpiarSucursal() {
    $('#sucursal').prop('disabled', false);
    $('#bloqueArchivo').collapse('hide');
    $('#sucursal').val('0');
    sucursal = 0;
    cierraPopUpChiquito($('#sucursal'));
}
function limpiarArchivo() {
    $('#conclusion').collapse('hide');
    $('#archivo').collapse('hide');
    comienzaBarra($('#barraValidacion'), 0);
    $('#matriz').prop('disabled', false);
    recibos = [];
    uuids = [];
    currentFile = -1;
    timbrados = 0;
}
function limpiarConclusion() {
    $('#conclusion').collapse('hide');
    console.log($('#conclusionFinal').html());
    $('#conclusionFinal').remove();
    $('#timbrando').remove();
    $('#conclusion').append($('#erroresMatriz'));
    $('#erroresMatrizDiv').remove();
}