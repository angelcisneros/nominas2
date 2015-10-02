/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios.vistas;

/**
 *
 * @author vcisneros
 */
import java.io.Serializable;
import java.util.List;
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
public class Deducciones implements Serializable {

    @NotNull(message = "Este campo es obligatorio")
    @Pattern(regexp = "^(([0-9]{1,6}.[0-9]{1,6}|[0-9]{1,6}))$", message = "DINERO invalida")
    @Getter @Setter private String totalGravado;
    @NotNull(message = "Este campo es obligatorio")
    @Pattern(regexp = "^(([0-9]{1,6}.[0-9]{1,6}|[0-9]{1,6}))$", message = "DINERO invalida")
    @Getter @Setter private String totalExento;
    @Getter @Setter private List<Deduccion> deducciones;

    
}
