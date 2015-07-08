/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios;

import com.quadrum.nominas2.entidades.Domicilio;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface DomicilioRepositorio{
    Boolean agregar(Domicilio domicilio);
    Boolean actualizar(Domicilio domicilio);
    Boolean eliminar(Domicilio domicilio);
    Boolean eliminar(Integer id);
    
    Domicilio buscarPorId(Integer id);
    List<Domicilio> buscarTodos();
}
