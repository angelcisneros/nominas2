/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios;

import com.quadrum.nominas2.entidades.Sucursal;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface SucursalRepositorio{
    Boolean agregar(Sucursal sucursal);
    Boolean actualizar(Sucursal sucursal);
    Boolean eliminar(Sucursal sucursal);
    Boolean eliminar(Integer id);
    
    Sucursal buscarPorId(Integer id);
    List<Sucursal> buscarTodos();
}
