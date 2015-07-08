/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.DeduccionEmpresa;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface DeduccionEmpresaServicio{
    String agregar(DeduccionEmpresa deduccionEmpresa);
    String actualizar(DeduccionEmpresa deduccionEmpresa);
    String eliminar(DeduccionEmpresa deduccionEmpresa);
    String eliminar(Integer id);
    
    DeduccionEmpresa buscarPorId(Integer id);
    List<DeduccionEmpresa> buscarTodos();
}
