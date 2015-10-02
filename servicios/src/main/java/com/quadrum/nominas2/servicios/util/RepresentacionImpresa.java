/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios.util;

import com.quadrum.nominas2.entidades.Recibo;
import com.quadrum.nominas2.servicios.vistas.Nomina;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author vcisneros
 */
public class RepresentacionImpresa {

    Map<String, Object> parametros;
//    List<PercepcionNomina> percepcionesDS;
//    List<DeduccionNonima> deduccionesDS;

    String uuid;
    File pdf;
    
    public RepresentacionImpresa() {
    }

    
//    public boolean generarRepresentacion(Nomina nomina) {
//        
//        LeerXml leerXml = new LeerXml();
//        leerXml.leerXml(cfdi);
//        parametros = leerXml.getParametros();
//        percepcionesDS = leerXml.getPercepcionesDS();
//        deduccionesDS = leerXml.getDeduccionesDS();
//        if(faltas != null){
//            parametros.put("nomina_faltas", faltas.toString());
//        }
//        this.uuid = uuid;
//        
//        return ejecutaJasper();
//    }
//
//    private boolean ejecutaJasper() {
//        List<RepresentacionImpresa> dataSource = new ArrayList<RepresentacionImpresa>();
//        dataSource.add(this);
//        try {
//            File jasper = new File(JASPER);
//            JasperReport reporte = (JasperReport) JRLoader.loadObject(jasper);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(dataSource));
//            
//            JRPdfExporter exporter = new JRPdfExporter();
//            
//            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//            pdf = new File(ARCHIVOS_TEMPORALES + uuid + ".pdf");
//            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, pdf);
//
//            exporter.exportReport();
//            pdf = new File(ARCHIVOS_TEMPORALES + uuid + ".pdf");
//            return true;
//        } catch (JRException ex) {
//            Logger.getLogger(RepresentacionImpresa.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return false;
//    }
//
//  
    
}
