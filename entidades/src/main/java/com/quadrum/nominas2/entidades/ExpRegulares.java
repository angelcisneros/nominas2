/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.entidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.util.regex.Pattern.compile;

/**
 *
 * @author vcisneros
 */
public class ExpRegulares {

    public static final String NOMBRES = "^[^\\d\\s][a-zA-Z\\s]{0,";
    public static final String PASSWORD = "(?=^.{8,15}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
    public static final Pattern NOMBRE = compile("^[^\\d\\s][a-zA-ZáéíóúñÁÉÍÓÚÑ\\s]{0,}");
    //public static final Pattern NOMBRE = compile("^[A-Za-záéíóúñ]{2,}([\\s][A-Za-záéíóúñ]{2,})+$");
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     Matcher mat = NOMBRE.matcher("Víctor ÁÑñgel"); 
        System.out.println(mat.matches());
    }
    
}
