/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author vcisneros
 */
@Entity
@Table(name = "admin", catalog = "nomifast")
@AllArgsConstructor
@NoArgsConstructor
public @Data class Administrador implements Serializable {
    
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    
    @Column(name = "puesto", length = 45)
    private String correo;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="usuario", nullable=false)
    private Usuario usuario;
   
}
