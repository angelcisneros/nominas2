/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.PercepcionEmpresa;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface PercepcionEmpresaServicio{
    String agregar(PercepcionEmpresa percepcionEmpresa);
    String actualizar(PercepcionEmpresa percepcionEmpresa);
    String eliminar(PercepcionEmpresa percepcionEmpresa);
    String eliminar(Integer id);
    
    PercepcionEmpresa buscarPorId(Integer id);
    List<PercepcionEmpresa> buscarTodos();
}
