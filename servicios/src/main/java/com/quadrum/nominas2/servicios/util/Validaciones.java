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
import java.io.InputStream;
public class Validaciones {

    public static String esValidoCerKeyAndPassword(InputStream cer, InputStream key, String password, String rfc) {
        String e = "";
        //ValidacionesCertificado validacionesCertificado = new ValidacionesCertificado(cer, key, password);
        ValidacionesCertificado validacionesCertificado = new ValidacionesCertificado(cer, key, password);
        if (!validacionesCertificado.validaCertificado()) {
            e = e + " EL certificado no es valido";
        }
        if (validacionesCertificado.validateCertificate()) {
            e = e + " El certificado es apocrifo";
        }
        if (validacionesCertificado.validaFecha().equals("caduco")) {
            e = e + " El certificado a caducado";
        }
        if (!validacionesCertificado.validaCorrespondencias()) {
            e = e + " EL password o el archivo .key no corresponden al certificado";
        }
        return e;
    }

    public static boolean validaExtencion(String cadena, String ext) {
        if (cadena.length() + 2 > ext.length()) {
            cadena = cadena.substring(cadena.length() - ext.length(), cadena.length());
            return cadena.equalsIgnoreCase(ext);
        }
        return false;
    }
    
    public static boolean isNullOrEmpty(String cadena) {
        if (cadena == null) {
            return true;
        }
        return cadena.equalsIgnoreCase("");
    }
    
    public static boolean esEntero(String integer) {
        try {
            Integer.parseInt(integer);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
