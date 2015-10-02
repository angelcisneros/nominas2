/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios.vistas;

import static com.quadrum.nominas2.entidades.ExpRegulares.ANTIGUEDAD;
import static com.quadrum.nominas2.entidades.ExpRegulares.BANCO;
import static com.quadrum.nominas2.entidades.ExpRegulares.CLABE;
import static com.quadrum.nominas2.entidades.ExpRegulares.DEPARTAMENTO;
import static com.quadrum.nominas2.entidades.ExpRegulares.DINERO;
import static com.quadrum.nominas2.entidades.ExpRegulares.FECHA;
import static com.quadrum.nominas2.entidades.ExpRegulares.PUESTO;
import static com.quadrum.nominas2.entidades.ExpRegulares.RIESGO_PUESTO;
import static com.quadrum.nominas2.entidades.ExpRegulares.TIPO_CONTRATO;
import static com.quadrum.nominas2.entidades.ExpRegulares.TIPO_JORNADA;
import java.io.Serializable;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Opcionales implements Serializable {

    @Pattern(regexp = ANTIGUEDAD, message = "ANTIGUEDAD invalida")
    @Getter @Setter private String antiguedad;
    @Pattern(regexp = BANCO, message = "BANCO invalida")
    @Getter @Setter private String banco;
    @Pattern(regexp = CLABE, message = "CLABE invalida")
    @Getter @Setter private String clabe;
    @Pattern(regexp = DEPARTAMENTO, message = "DEPARTAMENTO invalida")
    @Getter @Setter private String departamento;
    @Pattern(regexp = FECHA, message = "Fecha invalida")
    @Getter @Setter private String fechaInicoLaboral;
    @Pattern(regexp = PUESTO, message = "PUESTO invalida")
    @Getter @Setter private String puesto;
    @Pattern(regexp = RIESGO_PUESTO, message = "RIESGO_PUESTO invalida")
    @Getter @Setter private String riesgoPuesto;
    @Pattern(regexp = DINERO, message = "DINERO invalida")
    @Getter @Setter private String salarioBase;
    @Pattern(regexp = DINERO, message = "DINERO invalida")
    @Getter @Setter private String salarioDiario;
    @Pattern(regexp = TIPO_CONTRATO, message = "TIPO_CONTRATO invalida")
    @Getter @Setter private String tipoContrato;
    @Pattern(regexp = TIPO_JORNADA, message = "TIPO_JORNADA invalida")
    @Getter @Setter private String tipoJornada;
    @Pattern(regexp = DINERO, message = "DINERO invalida")
    @Getter @Setter private String totalDeduccionesExentas;
    @Pattern(regexp = DINERO, message = "DINERO invalida")
    @Getter @Setter private String totalDeduccionesGravadas;
    @Pattern(regexp = DINERO, message = "DINERO invalida")
    @Getter @Setter private String totalPercepcionesExentas;
    @Pattern(regexp = DINERO, message = "DINERO invalida")
    @Getter @Setter private String totalPercepcionesGravadas;

    
}
