package com.quadrum.nominas2.entidades;
// Generated 26/06/2015 12:29:26 PM by Hibernate Tools 3.6.0

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * DeduccionEmpresaId generated by hbm2java
 */
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public @Data  class DeduccionEmpresaId implements java.io.Serializable {

    @Column(name = "deduccion", nullable = false)
    private int deduccion;

    @Column(name = "EMPRESA", nullable = false)
    private int empresa;

}