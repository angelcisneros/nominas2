/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.InformacionOpcional;
import java.util.List;

public interface InformacionOpcionalServicio{
  String agregar(InformacionOpcional paramInformacionOpcional);  
  String actualizar(InformacionOpcional paramInformacionOpcional);  
  String eliminar(InformacionOpcional paramInformacionOpcional);  
  String eliminar(Integer paramInteger);  
  InformacionOpcional buscarPorId(Integer paramInteger);  
  List<InformacionOpcional> buscarTodos();
}
