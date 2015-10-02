/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;


import com.quadrum.nominas2.entidades.RiesgoPuesto;
import java.util.List;

public interface RiesgoPuestoServicio {
  String agregar(RiesgoPuesto paramRiesgoPuesto);  
  String actualizar(RiesgoPuesto paramRiesgoPuesto);  
  String eliminar(RiesgoPuesto paramRiesgoPuesto);  
  String eliminar(Integer paramInteger);  
  RiesgoPuesto buscarPorId(Integer paramInteger);
  List<RiesgoPuesto> buscarTodos();
}
