/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios;

import com.quadrum.nominas2.entidades.InformacionOpcional;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface InformacionOpcionalRepositorio{
    Boolean agregar(InformacionOpcional informacionOpcional);
    Boolean actualizar(InformacionOpcional informacionOpcional);
    Boolean eliminar(InformacionOpcional informacionOpcional);
    Boolean eliminar(Integer id);
    
    InformacionOpcional buscarPorId(Integer id);
    List<InformacionOpcional> buscarTodos();
}
