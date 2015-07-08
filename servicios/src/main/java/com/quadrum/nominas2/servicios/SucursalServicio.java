/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.Sucursal;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface SucursalServicio{
    String agregar(Sucursal sucursal);
    String actualizar(Sucursal sucursal);
    String eliminar(Sucursal sucursal);
    String eliminar(Integer id);
    
    Sucursal buscarPorId(Integer id);
    List<Sucursal> buscarTodos();
}
