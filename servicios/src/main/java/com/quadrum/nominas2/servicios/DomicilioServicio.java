/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.Domicilio;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface DomicilioServicio {

    String agregar(Domicilio paramDomicilio);

    String actualizar(Domicilio paramDomicilio);

    String eliminar(Domicilio paramDomicilio);

    String eliminar(Integer paramInteger);

    Domicilio buscarPorId(Integer paramInteger);

    List<Domicilio> buscarTodos();
}
