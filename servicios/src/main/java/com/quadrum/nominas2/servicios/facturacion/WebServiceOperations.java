/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios.facturacion;

import com.quadrum.nominas2.servicios.util.ManejadorArchivos;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;
import mx.com.cfdiquadrum.ws.timbrar.ApplicationStub;
import mx.com.cfdiquadrum.ws.timbrar.TimbrarSOAPLocator;
import org.apache.axis.AxisFault;
import views.core.soap.services.apps.AcuseRecepcionCFDI;
import views.core.soap.services.apps.Incidencia;

/**
 *
 * @author vcisneros
 */
public class WebServiceOperations {

    private static final String USER = "fjvelasco@quadrum.com.mx";
    private static final String PASSWORD = "Francisco123.";
//    public static final String WS = "https://ws.cfdiquadrum.com.mx/timbrar.wsdl";
    private static final String WS = "http://dev.ws.cfdiquadrum.com.mx/timbrar.wsdl";

    @Getter private String xml;
    @Getter private String uuid;
    @Getter private String estado;
    @Getter private boolean completa = false;
    @Getter private List<ErroresTimbrado> errores;
    @Getter private String fecha;

    public void timbarWSProduccion(String xml) {
        try {
            ManejadorArchivos.escribirArchivo(new File("C:/Users/vcisneros/Desktop/xml.xml"), xml.getBytes("UTF-8"));
            AcuseRecepcionCFDI r = new ApplicationStub(new URL(WS), new TimbrarSOAPLocator()).timbrar(xml.getBytes("UTF-8"), USER, PASSWORD);
            completa = r.getUUID() != null;
            if (completa) {
                uuid = r.getUUID();
                this.xml = r.getXml();
                estado = r.getCodEstatus();
                fecha = r.getFecha();
                r.getSelloSAT();
                r.getNoCertificadoSAT();
            } else {
                configuraIncidencias(r.getIncidencias());
            }
        } catch (AxisFault e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(WebServiceOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void configuraIncidencias(Incidencia[] incidencias) {
        errores = new ArrayList<ErroresTimbrado>();
        for (Incidencia i : incidencias) {
            errores.add(new ErroresTimbrado(i.getCodigoError(), i.getMensajeIncidencia()));
        }
    }

}
