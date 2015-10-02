/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios.util;

/**
 *
 * @author vcisneros
 */
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utileria {

    public static String[] calendario = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    private final DecimalFormat formatoTotales = new DecimalFormat("###########################################0.00");
    
    public static String convierteDateToString(Date fecha) {
        return fecha.getDate() + " de " + calendario[fecha.getMonth()] + " de " + (1900 + fecha.getYear());
    }

    public static Date convierteStringToFecha(String date) {
        date = date.replace("-", "/");
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatoDeFecha.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(Validaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean isNullOrEmpty(String cadena) {
        if (cadena == null) {
            return true;
        }
        return cadena.equalsIgnoreCase("");
    }
    
    public static String convierteImporte(String importe){
        DecimalFormat formatoImporte = new DecimalFormat("######################################0.00####");
        return formatoImporte.format(Double.parseDouble(importe));
    }    
    
    public static String convierteImporte(Double importe){
        DecimalFormat formatoImporte = new DecimalFormat("######################################0.00####");
        return formatoImporte.format(importe);
    }
    
    public static String formatoFecha(String fecha){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(convierteStringToFecha(fecha));
    }
    
    public static String formatoFechaSat(Date fecha){
        SimpleDateFormat formatoSat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return formatoSat.format(fecha);
    }
    public static Date convierteFechaSatToDate(String fecha){
        SimpleDateFormat formatoSat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            return formatoSat.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(Utileria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
