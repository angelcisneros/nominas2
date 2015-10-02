/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios.vistas;

import static com.quadrum.nominas2.entidades.ExpRegulares.CURP;
import static com.quadrum.nominas2.entidades.ExpRegulares.DIAS_PAGADOS;
import static com.quadrum.nominas2.entidades.ExpRegulares.DINERO;
import static com.quadrum.nominas2.entidades.ExpRegulares.FECHA;
import static com.quadrum.nominas2.entidades.ExpRegulares.NOM_EMPLEADO;
import static com.quadrum.nominas2.entidades.ExpRegulares.NSS;
import static com.quadrum.nominas2.entidades.ExpRegulares.NUM_EMPLEADO;
import static com.quadrum.nominas2.entidades.ExpRegulares.PERIODICIDAD_PAGO;
import static com.quadrum.nominas2.entidades.ExpRegulares.REGIMEN_CONTRATACION;
import static com.quadrum.nominas2.entidades.ExpRegulares.REGISTRO_PATRONAL;
import static com.quadrum.nominas2.entidades.ExpRegulares.RFC;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Obligatorios implements Serializable {

    @NotNull(message = "Este campo es obligatorio")
    @Pattern(regexp = FECHA, message = "Fecha invalida")
    @Getter @Setter private String fechaFinalPago;
    @NotNull(message = "Este campo es obligatorio")
    @Pattern(regexp = FECHA, message = "Fecha invalida")
    @Getter @Setter private String fechaInicialPago;
    @NotNull(message = "Este campo es obligatorio")
    @Pattern(regexp = FECHA, message = "Fecha invalida")
    @Getter @Setter private String fechaPago;
    @NotNull(message = "Este campo es obligatorio")
    @Pattern(regexp = NOM_EMPLEADO, message = "Nombre invalido")
    @Getter @Setter private String nombre;
    @NotNull(message = "Este campo es obligatorio")
    @Pattern(regexp = NSS, message = "NSS invalido")
    @Getter @Setter private String nss;
    @NotNull(message = "Este campo es obligatorio")
    @Pattern(regexp = NUM_EMPLEADO, message = "Numero de empleado invalido")
    @Getter @Setter private String numEmpleado;
    @NotNull(message = "Este campo es obligatorio")
    @Pattern(regexp = DIAS_PAGADOS, message = "Dias pagados invalido")
    @Getter @Setter private String numeroDiasPagados;
    @NotNull(message = "Este campo es obligatorio")
    @Pattern(regexp = REGIMEN_CONTRATACION, message = "Regimen de contratcion invalido")
    @Getter @Setter private String regimenContratacion;
    @NotNull(message = "Este campo es obligatorio")
    @Pattern(regexp = REGISTRO_PATRONAL, message = "REGISTRO PATRONAL invalido")
    @Getter @Setter private String registroPatronal;
    @NotNull(message = "Este campo es obligatorio")
    @Pattern(regexp = RFC, message = "RFC invalido")
    @Getter @Setter private String rfc;
    @NotNull(message = "Este campo es obligatorio")
    @Pattern(regexp = CURP, message = "CURP invalido")
    @Getter @Setter private String curp;
    @NotNull(message = "Este campo es obligatorio")
    @Pattern(regexp = PERIODICIDAD_PAGO, message = "Periodicidad invalido")
    @Getter @Setter private String periocidadPago;
    @NotNull(message = "Este campo es obligatorio")
    @Pattern(regexp = DINERO, message = "DIENRO invalido")
    @Getter @Setter private String totalPagar;
    
}
