/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios.vistas;

import com.quadrum.nominas2.servicios.facturacion.ErroresTimbrado;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author vcisneros
 */

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Respuesta {
    @Getter @Setter private String curp;
    @Getter @Setter private String uuid;
    @Getter @Setter private String mensaje;
    @Getter @Setter private boolean ok;
    @Getter @Setter private List<ErroresTimbrado> errores;
    @Getter @Setter private String fechaTimbrado;

    public Respuesta(String mensaje, boolean ok) {
        this.mensaje = mensaje;
        this.ok = ok;
        errores = new ArrayList<ErroresTimbrado>();
    }
    
    public void addError(String codigo, String error){
        errores.add(new ErroresTimbrado(codigo, mensaje));
    }
    
}
