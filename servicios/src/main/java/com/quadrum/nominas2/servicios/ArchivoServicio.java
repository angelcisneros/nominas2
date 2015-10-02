/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.Archivo;
import java.util.List;

public interface ArchivoServicio{
  String agregar(Archivo paramArchivo); 
  Archivo agregar(int numeroEmpresa);
  String actualizar(Archivo paramArchivo);  
  String eliminar(Archivo paramArchivo);  
  String eliminar(Integer paramInteger);  
  Archivo buscarPorId(Integer paramInteger);  
  List<Archivo> buscarTodos();
}
