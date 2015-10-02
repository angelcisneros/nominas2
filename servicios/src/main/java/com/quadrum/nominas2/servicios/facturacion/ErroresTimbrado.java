/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios.facturacion;

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
public class ErroresTimbrado {
    @Getter @Setter private String codigo;
    @Getter @Setter private String Mensaje;
}
