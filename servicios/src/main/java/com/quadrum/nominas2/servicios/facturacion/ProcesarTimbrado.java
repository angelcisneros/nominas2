/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios.facturacion;

/**
 *
 * @author vcisneros
 */
import com.quadrum.nominas2.entidades.Recibo;
import static com.quadrum.nominas2.servicios.util.Utileria.convierteFechaSatToDate;
import com.quadrum.nominas2.servicios.vistas.Nomina;
import com.quadrum.nominas2.servicios.vistas.Respuesta;

public class ProcesarTimbrado {
    
    public Respuesta timbrar(Nomina nomina) {
        Respuesta respuesta = new Respuesta();
        EstructuraXml estructuraXml = new EstructuraXml(nomina);
        respuesta.setCurp(nomina.getObligatorios().getCurp());
        if (estructuraXml.construirXml()) {
            WebServiceOperations operation = new WebServiceOperations();
            operation.timbarWSProduccion(estructuraXml.getXml());
            if (operation.isCompleta()) {
                respuesta.setOk(true);
                respuesta.setMensaje(operation.getEstado());
                respuesta.setUuid(operation.getUuid());
                respuesta.setFechaTimbrado(operation.getFecha());
                Recibo recibo = nomina.getRecibo();
                recibo.setUuid(operation.getUuid());
                recibo.setReciboXML(operation.getXml());
                recibo.setFechaTimbrado(convierteFechaSatToDate(respuesta.getFechaTimbrado()));
            } else {
                respuesta.setOk(false);
                respuesta.setMensaje("Ocurrieron errores al timbrar");
                respuesta.setErrores(operation.getErrores());
            }
        } else {
            respuesta.setOk(false);
            respuesta.setMensaje("No se pudo construir el XML");
        }
        return respuesta;
    }
}
