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
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;import lombok.NoArgsConstructor;import lombok.Setter;
/**
 *
 * @author vcisneros
 */
@Entity
@Table(name = "administrador", catalog = "nomifast")
@AllArgsConstructor
@NoArgsConstructor
public class Administrador implements Serializable {
    
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @Getter @Setter private int id;
    
    @Column(name = "puesto", length = 45)
    @Getter @Setter private String puesto;
    
    @Valid
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="usuario", nullable=false)
    @Getter @Setter private Usuario usuario;
   
}
