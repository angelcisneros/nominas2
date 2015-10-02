/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.entidades;


/**
 *
 * @author vcisneros
 */
public class ExpRegulares {

    public static final String NOMBRES = "^[^\\d\\s][a-zA-Z\\s]{0,";
    public static final String INTEGER = "^([0-9]{1,9})$";
    public static final String PASSWORD = "(?=^.{8,15}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
    //public static final Pattern NOMBRE = compile("^[A-Za-záéíóúñ]{2,}([\\s][A-Za-záéíóúñ]{2,})+$");
    public static final String FECHA = "^((([0-9]{4})(-|\\/)?(1[0-2]|0[1-9])(-|\\/)?(3[01]|0[1-9]|[12][0-9]))|((3[01]|0[1-9]|[12][0-9])(-|\\/)?(1[0-2]|0[1-9])(-|\\/)?([0-9]{4})))$";
    public static final String RFC = "^[A-Z,Ã‘,&]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z,0-9]{3}$";
    public static final String NSS = "^(.{1,15})$";
    public static final String NUM_EMPLEADO = "^(.{1,15})$";
    public static final String CURP = "[A-Z]{1}[AEIOU]{1}[A-Z]{2}[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])[HM]{1}(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)[B-DF-HJ-NP-TV-Z]{3}[0-9A-Z]{1}[0-9]{1}$";
    public static final String REGIMEN_CONTRATACION = "^([2-9]|10)$";
    public static final String PERIODICIDAD_PAGO = "^(.{1,100})$";
    public static final String NOM_EMPLEADO = "^([^\\d\\s][a-zA-ZáéíóúñÁÉÍÓÚÑ\\s]{0,145})$";
    public static final String DIAS_PAGADOS = "^([0-9]{1,3})$";
    public static final String REGISTRO_PATRONAL = "^(.{1,20})$";
    
    public static final String ANTIGUEDAD = "^([0-9]{1,5})$";
    public static final String PUESTO = "^(.{1,45})$";//ATENCION CON PUESTO POSIBLES CAMBIOS A ESTO
    public static final String TIPO_CONTRATO = PUESTO;
    public static final String DEPARTAMENTO = PUESTO;
    public static final String TIPO_JORNADA = PUESTO;
    public static final String DINERO = "^(([0-9]{1,6}.[0-9]{1,6}|[0-9]{1,6}))$";
    public static final String RIESGO_PUESTO = "^([1-5]{1})$"; 
    public static final String CLABE = "^([0-9]{18})$";
    public static final String BANCO = "^([0-9]{3})$";
    public static final String CONCPETO = "^(.{1,100})$";
    
    public static final String CLAVE_SAT = "^([0-9]{3})$";
    public static final String CLAVE_EMPRESA = "^([0-9]{3,15})$";
}
