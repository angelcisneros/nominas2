/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios.util;

import com.quadrum.nominas2.entidades.Usuario;
import java.util.Random;
import org.jasypt.util.text.BasicTextEncryptor;

/**
 *
 * @author vcisneros
 */
public class LinkConfirmacion {

    private static final String DOMINIO = "http://localhost:8080/nomifast2/confirmacion?usuario=";
    private static final String REGISTRO = "registro";
    private static final String PASWWORD = "password";

    public static String generarLinkRegistro(Usuario usuario) {
        return DOMINIO + usuario.getUserName() + "&confirmacion=" + generarCadenaAleatoria() + "&opcion=" + encriptar(REGISTRO, usuario.getUserName());
    }

    public static String generarLinkPassword(Usuario usuario) {
        return DOMINIO + usuario.getUserName() + "&confirmacion=" + generarCadenaAleatoria() + "&opcion=" + encriptar(PASWWORD, usuario.getUserName());
    }

    public static String encriptar(String text, String key) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(key);
        return textEncryptor.encrypt(text);
    }

    public static String desencriptar(String text, String key) {
        text = text.replace(" ", "+");
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(key);
        return textEncryptor.decrypt(text);
    }

    public static String generarCadenaAleatoria() {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < 10) {
            char c = (char) r.nextInt(255);
            //System.out.println("char:"+c);
            if ((c >= '0' && c <= 9) || (c >= 'A' && c <= 'Z')) {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }

    public static boolean comprubarLinkRegistro(Usuario usuario, String link) {
        BasicTextEncryptor textDecryptor = new BasicTextEncryptor();
        textDecryptor.setPassword(usuario.getPassword());
        return textDecryptor.decrypt(link).equals(usuario.getUserName());
    }

    public static String reconstruirLinkRegistro(String usuario, String confirmacion, String opcion) {
        String x = DOMINIO;
        if (REGISTRO.equals(desencriptar(opcion, usuario))) {
             x += usuario + "&confirmacion=" + confirmacion + "&opcion=" + opcion;
        }
        System.out.println(x);
        return x;
    }
}
