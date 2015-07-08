/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.InformacionOpcional;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface InformacionOpcionalServicio{
    String agregar(InformacionOpcional informacionOpcional);
    String actualizar(InformacionOpcional informacionOpcional);
    String eliminar(InformacionOpcional informacionOpcional);
    String eliminar(Integer id);
    
    InformacionOpcional buscarPorId(Integer id);
    List<InformacionOpcional> buscarTodos();
}
