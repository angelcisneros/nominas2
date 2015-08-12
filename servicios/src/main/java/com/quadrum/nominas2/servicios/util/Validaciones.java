/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios.util;

import java.io.InputStream;
import com.quadrum.nominas2.servicios.util.ValidacionesCertificado;
/**
 *
 * @author vcisneros
 */
public class Validaciones {
    public static String esValidoCerKeyAndPassword(InputStream cer, InputStream key, String password, String rfc) {
        String e = "";
        ValidacionesCertificado validacionesCertificado = new ValidacionesCertificado(cer, key, password);
        if(!validacionesCertificado.validaCertificado()){
            e += " EL certificado no es valido";
        }
        if(validacionesCertificado.validateCertificate()){
            e += " El certificado es apocrifo";
        }
        if(validacionesCertificado.validaFecha().equals("caduco")){
            e += " El certificado a caducado";
        }
//        if(!validacionesCertificado.validaCertificado(rfc)){
//            errores.add("El RFC no corresponde a la empresa en sesión");
//        }
        if(!validacionesCertificado.validaCorrespondencias()){
            e += " EL password o el archivo .key no corresponden al certificado";
        }
        return e;
    }
    
    public static boolean validaExtencion(String cadena, String ext){
        if (cadena.length() + 2 > ext.length()) {
            cadena = cadena.substring(cadena.length() - ext.length(), cadena.length());
            return cadena.equalsIgnoreCase(ext);
        }
        return false;
    }
}
