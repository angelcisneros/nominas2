/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios.util;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.ObjectError;

/**
 *
 * @author vcisneros
 */
public class MensajesCrud {
    public static final String ERROR_DATOS = "Ups!...#Los datos que proporciono no son validos";
    public static final String ERROR_ALGO = "Ups!...#Ocurrio un problema durante la operación. Intente más tarde";
    public static final String SESION_CADUCA = "-1";
    public static final String ADD_CORRECT = "Correcto...#Se ha agregado ";
    public static final String DELETE_CORRECT = "Correcto...#Se ha eliminado ";
    public static final String UPDATE_CORRECT = "Correcto...#Se ha actualizado ";
    public static final String ERROR_HIBERNATE = "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente más tarde.";
    public static final String CORRECTO_IMAGEN = "Correcto...#Se subio la imagen correctamente.";
    public static final String ERROR_IMAGEN = "Ups!...#No se pudo subir la imagen, intente otra vez.";
    public static final String IMAGEN_INVALIDA = "Ups!...#Debe subir una imagen.";
    
    public static final String LOGEATE = "Ups!...#Debe acceder primero con una cuenta";
    public static final String LOGIN = "login";
    
    public static final List<String> errores( List<ObjectError> e){
        List<String> errores = new ArrayList<String>();
        for(ObjectError o: e){
            errores.add(o.getDefaultMessage());
        }
        return errores;
    }
}
