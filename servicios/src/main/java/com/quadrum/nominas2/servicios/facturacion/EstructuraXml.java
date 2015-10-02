/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios.facturacion;

import com.quadrum.nominas2.entidades.Sucursal;
import static com.quadrum.nominas2.servicios.util.ManejadorArchivos.convertStreamToString;
import static com.quadrum.nominas2.servicios.util.Rutas.CADENA_ORIGINAL;
import com.quadrum.nominas2.servicios.util.Utileria;
import static com.quadrum.nominas2.servicios.util.Utileria.convierteImporte;
import static com.quadrum.nominas2.servicios.util.Utileria.formatoFechaSat;
import com.quadrum.nominas2.servicios.vistas.Deduccion;
import com.quadrum.nominas2.servicios.vistas.Nomina;
import com.quadrum.nominas2.servicios.vistas.Obligatorios;
import com.quadrum.nominas2.servicios.vistas.Opcionales;
import com.quadrum.nominas2.servicios.vistas.Percepcion;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lombok.Getter;
import org.apache.commons.io.IOUtils;
import org.apache.xerces.jaxp.DocumentBuilderFactoryImpl;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class EstructuraXml {

    private Nomina nomina;
    @Getter private String xml;

    private Document documentoXML = null;
    private Element factura = null;
    private Element itemHijo;
    private Element elemento;
    private Element item;
    private DocumentBuilderFactory dbFactory;
    private DocumentBuilder docBuilder;
    private ByteArrayOutputStream xmlBytes;
    private StringWriter strWriter;
    private XMLSerializer seliarizadorXML;
    private OutputFormat formatoSalida;
    private AtributosCertificado cer;
    

    public EstructuraXml(Nomina nomina) {
        this.nomina = nomina;
    }

    public boolean construirXml() {
        try {
            this.dbFactory = DocumentBuilderFactoryImpl.newInstance();
            this.docBuilder = this.dbFactory.newDocumentBuilder();
            this.docBuilder.newDocument();
            this.documentoXML = this.docBuilder.newDocument();
            this.factura = this.documentoXML.createElement("cfdi:Comprobante");
            construirEmisor();
            construirReceptor();
            construirConcepto();
            construirImpuestos();
            construirComplementoNomina();
            otros();
            return true;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(EstructuraXml.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private void construirEmisor() throws ParserConfigurationException {
        this.elemento = this.documentoXML.createElement("cfdi:Emisor");
        this.elemento.setAttribute("rfc", this.nomina.getSucursal().getRfc());
        if (!Utileria.isNullOrEmpty(this.nomina.getEmpresa().getUsuario().getNombre())) {
            this.elemento.setAttribute("nombre", this.nomina.getEmpresa().getUsuario().getNombre());
        }
        this.item = this.documentoXML.createElement("cfdi:DomicilioFiscal");
        this.item.setAttribute("calle", this.nomina.getDomicilio().getCalle());
        this.item.setAttribute("estado", this.nomina.getDomicilio().getEstado());
        this.item.setAttribute("municipio", this.nomina.getDomicilio().getMunicipio());
        this.item.setAttribute("pais", this.nomina.getDomicilio().getPais());
        this.item.setAttribute("codigoPostal", this.nomina.getDomicilio().getCodigoPostal());
        if (!Utileria.isNullOrEmpty(this.nomina.getDomicilio().getNumExterior())) {
            this.item.setAttribute("noExterior", this.nomina.getDomicilio().getNumExterior());
        }
        if (!Utileria.isNullOrEmpty(this.nomina.getDomicilio().getNumInterior())) {
            this.item.setAttribute("noInterior", this.nomina.getDomicilio().getNumInterior());
        }
        if (!Utileria.isNullOrEmpty(this.nomina.getDomicilio().getColonia())) {
            this.item.setAttribute("colonia", this.nomina.getDomicilio().getColonia());
        }
        if (!Utileria.isNullOrEmpty(this.nomina.getDomicilio().getLocalidad())) {
            this.item.setAttribute("localidad", this.nomina.getDomicilio().getLocalidad());
        }
        if (!Utileria.isNullOrEmpty(this.nomina.getDomicilio().getReferencia())) {
            this.item.setAttribute("referencia", this.nomina.getDomicilio().getReferencia());
        }
        this.elemento.appendChild(this.item);

        this.item = this.documentoXML.createElement("cfdi:RegimenFiscal");
        this.item.setAttribute("Regimen", this.nomina.getEmpresa().getRegimenFiscal().getNombre());
        this.elemento.appendChild(this.item);
        this.factura.appendChild(this.elemento);
    }

    private void construirReceptor() {
        this.elemento = this.documentoXML.createElement("cfdi:Receptor");
        this.elemento.setAttribute("rfc", this.nomina.getObligatorios().getRfc());
        this.elemento.setAttribute("nombre", this.nomina.getObligatorios().getNombre());

        this.factura.appendChild(this.elemento);
    }

    private void construirConcepto() {
        this.elemento = this.documentoXML.createElement("cfdi:Conceptos");
        this.item = this.documentoXML.createElement("cfdi:Concepto");
        this.item.setAttribute("cantidad", "1");
        this.item.setAttribute("unidad", "Servicio");

        this.item.setAttribute("descripcion", "Pago de Nomina");
        this.item.setAttribute("valorUnitario", "1");
        this.item.setAttribute("importe", nomina.getObligatorios().getTotalPagar());
        this.elemento.appendChild(this.item);
        this.factura.appendChild(this.elemento);
    }

    private void construirImpuestos() {
        this.elemento = this.documentoXML.createElement("cfdi:Impuestos");
        Element traslados = this.documentoXML.createElement("cfdi:Traslados");
        this.item = this.documentoXML.createElement("cfdi:Traslado");
        this.item.setAttribute("impuesto", "IVA");
        this.item.setAttribute("tasa", "0");
        this.item.setAttribute("importe", "0.0");
        traslados.appendChild(this.item);
        this.elemento.appendChild(traslados);
        this.factura.appendChild(this.elemento);
    }

    private void construirComplementoNomina() {
        this.elemento = this.documentoXML.createElement("cfdi:Complemento");
        this.factura.appendChild(this.elemento);
        this.item = this.documentoXML.createElement("nomina:Nomina");
        this.item.setAttribute("xmlns:nomina", "http://www.sat.gob.mx/nomina");
        this.item.setAttribute("Version", "1.1");
        construirObligatorios();
        construirOpcionales();
        construirPercepciones();
        construirDeducciones();
        this.elemento.appendChild(this.item);
        this.factura.appendChild(this.elemento);
    }

    private void construirObligatorios() {
        Obligatorios o = this.nomina.getObligatorios();
        this.item.setAttribute("RegistroPatronal", o.getRegistroPatronal());
        this.item.setAttribute("TipoRegimen", o.getRegimenContratacion());
        this.item.setAttribute("CURP", o.getCurp());
        this.item.setAttribute("FechaPago", o.getFechaPago());
        this.item.setAttribute("FechaInicialPago",o.getFechaInicialPago());
        this.item.setAttribute("FechaFinalPago", o.getFechaFinalPago());
        this.item.setAttribute("NumSeguridadSocial", o.getNss());
        this.item.setAttribute("NumDiasPagados", o.getNumeroDiasPagados());
        this.item.setAttribute("NumEmpleado", o.getNumEmpleado());
        this.item.setAttribute("PeriodicidadPago", o.getPeriocidadPago());
    }

    private void construirOpcionales() {
        Opcionales o = this.nomina.getOpcionales();
        if (!Utileria.isNullOrEmpty(o.getAntiguedad())) {
            this.item.setAttribute("Antiguedad", o.getAntiguedad());
        }
        if (!Utileria.isNullOrEmpty(o.getBanco())) {
            this.item.setAttribute("Banco", o.getBanco());
        }
        if (!Utileria.isNullOrEmpty(o.getClabe())) {
            this.item.setAttribute("CLABE", o.getClabe());
        }
        if (!Utileria.isNullOrEmpty(o.getDepartamento())) {
            this.item.setAttribute("Departamento", o.getDepartamento());
        }
        if (!Utileria.isNullOrEmpty(o.getFechaInicoLaboral())) {
            this.item.setAttribute("FechaInicioRelLaboral", o.getFechaInicoLaboral());
        }
        if (!Utileria.isNullOrEmpty(o.getPuesto())) {
            this.item.setAttribute("Puesto", o.getPuesto());
        }
        if (!Utileria.isNullOrEmpty(o.getTipoContrato())) {
            this.item.setAttribute("TipoContrato", o.getTipoContrato());
        }
        if (!Utileria.isNullOrEmpty(o.getSalarioBase())) {
            this.item.setAttribute("SalarioBaseCotApor", o.getSalarioBase());
        }
        if (!Utileria.isNullOrEmpty(o.getSalarioDiario())) {
            this.item.setAttribute("SalarioDiarioIntegrado", o.getSalarioDiario());
        }
        if (!Utileria.isNullOrEmpty(o.getTipoJornada())) {
            this.item.setAttribute("TipoJornada", o.getTipoJornada());
        }
        if (!Utileria.isNullOrEmpty(o.getRiesgoPuesto())) {
            this.item.setAttribute("RiesgoPuesto", o.getRiesgoPuesto());
        }
    }

    private void construirPercepciones() {
        List<Percepcion> percepciones = this.nomina.getPercepciones().getPercepciones();
        if ((percepciones == null) || (percepciones.size() < 1)) {
            return;
        }
        this.itemHijo = this.documentoXML.createElement("nomina:Percepciones");
        this.itemHijo.setAttribute("TotalGravado", nomina.getPercepciones().getTotalGravado());
        this.itemHijo.setAttribute("TotalExento", nomina.getPercepciones().getTotalExento());
        for (Percepcion p : percepciones) {
            Element itemA = this.documentoXML.createElement("nomina:Percepcion");
            itemA.setAttribute("TipoPercepcion", p.getClaveSat());
            itemA.setAttribute("Clave", p.getClaveEmpresa());
            itemA.setAttribute("Concepto", p.getConcepto());
            itemA.setAttribute("ImporteExento", convierteImporte(p.getExento()));
            itemA.setAttribute("ImporteGravado",convierteImporte(p.getGravado()));
            this.itemHijo.appendChild(itemA);
            this.item.appendChild(this.itemHijo);
        }
    }

    private void construirDeducciones() {
        List<Deduccion> deducciones = this.nomina.getDeducciones().getDeducciones();
        if ((deducciones == null) || (deducciones.size() < 1)) {
            return;
        }
        this.itemHijo = this.documentoXML.createElement("nomina:Deducciones");
        this.itemHijo.setAttribute("TotalGravado", nomina.getDeducciones().getTotalGravado());
        this.itemHijo.setAttribute("TotalExento", nomina.getDeducciones().getTotalExento());
        for (Deduccion d : deducciones) {
            Element itemA = this.documentoXML.createElement("nomina:Deduccion");
            itemA.setAttribute("TipoDeduccion", d.getClaveSat());
            itemA.setAttribute("Clave", d.getClaveEmpresa());
            itemA.setAttribute("Concepto", d.getConcepto());
            itemA.setAttribute("ImporteExento", convierteImporte(d.getExento()));
            itemA.setAttribute("ImporteGravado", convierteImporte(d.getGravado()));
            this.itemHijo.appendChild(itemA);
            this.item.appendChild(this.itemHijo);
        }
    }

    private void otros() throws IOException {
        Sucursal sucursal = this.nomina.getSucursal();

        this.cer = new AtributosCertificado(new ByteArrayInputStream(sucursal.getCer()));
        this.cer.obtenDatosCertificado();
        this.factura.setAttribute("xmlns:cfdi", "http://www.sat.gob.mx/cfd/3");
        this.factura.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        String schemaLocation = "http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd http://www.sat.gob.mx/nomina http://www.sat.gob.mx/sitio_internet/cfd/nomina/nomina11.xsd";
        this.factura.setAttribute("xsi:schemaLocation", schemaLocation);
        this.factura.setAttribute("version", "3.2");
        this.factura.setAttribute("serie", "Recibos de Nomina");
        this.factura.setAttribute("fecha", formatoFechaSat(new Date()));
        this.factura.setAttribute("formaDePago", "PAGO EN UNA SOLA EXHIBICION");
        this.factura.setAttribute("noCertificado", this.cer.getNoCertificado());

        this.factura.setAttribute("certificado", this.cer.getCertificado());

        this.factura.setAttribute("condicionesDePago", "Contado");
        this.factura.setAttribute("subTotal", "0.00");
        this.factura.setAttribute("TipoCambio", "1");
        this.factura.setAttribute("Moneda", "MXN");
        this.factura.setAttribute("total", nomina.getObligatorios().getTotalPagar());
        this.factura.setAttribute("tipoDeComprobante", "egreso");
        this.factura.setAttribute("metodoDePago", "Efectivo");

        this.factura.setAttribute("LugarExpedicion", sucursal.getDomicilio().toString() + "Mexico");

        this.documentoXML.appendChild(this.factura);
        CadenaOriginal objetoCadenaOriginal = new CadenaOriginal();
        Sello sello = new Sello(sucursal.getPassword(), sucursal.getKy(), objetoCadenaOriginal.formarCadenaOriginal(serializarXML(), CADENA_ORIGINAL));
        this.documentoXML.removeChild(this.factura);
        this.factura.setAttribute("sello", sello.generaSelloDigital());
        this.documentoXML.appendChild(this.factura);
        this.xml = IOUtils.toString(serializarXML(), "UTF-8");
        InputStream miXmlSellado = IOUtils.toInputStream(strWriter.toString(), "UTF-8");
        xmlBytes = new ByteArrayOutputStream();
        IOUtils.copy(miXmlSellado, xmlBytes);
        xml = convertStreamToString((new ByteArrayInputStream(xmlBytes.toByteArray())));
    }
    
    private InputStream serializarXML() throws IOException{
        this.seliarizadorXML = new XMLSerializer();
        this.strWriter = new StringWriter();
        this.formatoSalida = new OutputFormat();
        this.formatoSalida.setEncoding("UTF-8");
        this.formatoSalida.setVersion("1.0");
        this.formatoSalida.setIndenting(true);
        this.formatoSalida.setIndent(4);
        this.seliarizadorXML.setOutputCharStream(this.strWriter);
        this.seliarizadorXML.setOutputFormat(this.formatoSalida);
        this.seliarizadorXML.serialize(this.documentoXML);
        this.strWriter.close();
        return IOUtils.toInputStream(this.strWriter.toString(), "UTF-8");
    }
}
