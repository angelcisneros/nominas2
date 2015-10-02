/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;
import com.quadrum.nominas2.entidades.Percepcion;
import java.util.List;

public interface PercepcionServicio{
  String agregar(Percepcion paramPercepcion);  
  String actualizar(Percepcion paramPercepcion);  
  String eliminar(Percepcion paramPercepcion);  
  String eliminar(Integer paramInteger);  
  Percepcion buscarPorId(Integer paramInteger);  
  List<Percepcion> buscarTodos();
}
