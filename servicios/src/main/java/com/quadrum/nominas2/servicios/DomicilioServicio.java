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
public interface DomicilioServicio{
    String agregar(Domicilio domicilio);
    String actualizar(Domicilio domicilio);
    String eliminar(Domicilio domicilio);
    String eliminar(Integer id);
    
    Domicilio buscarPorId(Integer id);
    List<Domicilio> buscarTodos();
}
