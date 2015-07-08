/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios;

import com.quadrum.nominas2.entidades.Deduccion;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface DeduccionRepositorio{
    
    Boolean agregar(Deduccion deduccion);
    Boolean actualizar(Deduccion deduccion);
    Boolean eliminar(Deduccion deduccion);
    Boolean eliminar(Integer id);
    
    Deduccion buscarPorId(Integer id);
    List<Deduccion> buscarTodos();
}
