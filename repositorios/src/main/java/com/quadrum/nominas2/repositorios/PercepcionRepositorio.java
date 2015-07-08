/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios;

import com.quadrum.nominas2.entidades.Percepcion;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface PercepcionRepositorio{
    Boolean agregar(Percepcion percepcion);
    Boolean actualizar(Percepcion percepcion);
    Boolean eliminar(Percepcion percepcion);
    Boolean eliminar(Integer id);
    
    Percepcion buscarPorId(Integer id);
    List<Percepcion> buscarTodos();
}
