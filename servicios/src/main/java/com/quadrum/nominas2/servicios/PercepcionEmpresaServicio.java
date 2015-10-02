/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.PercepcionEmpresa;
import com.quadrum.nominas2.entidades.PercepcionEmpresaId;
import java.util.List;
/**
 *
 * @author vcisneros
 */
public interface PercepcionEmpresaServicio{
  String agregar(PercepcionEmpresa paramPercepcionEmpresa);  
  String actualizar(PercepcionEmpresa paramPercepcionEmpresa);  
  String eliminar(PercepcionEmpresa paramPercepcionEmpresa);  
  String eliminar(PercepcionEmpresaId paramPercepcionEmpresaId);  
  PercepcionEmpresa buscarPorId(PercepcionEmpresaId paramPercepcionEmpresaId);  
  List<PercepcionEmpresa> buscarTodos();
}
