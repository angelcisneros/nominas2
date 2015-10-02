/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.Empresa;
import java.util.List;

public interface EmpresaServicio{
  String agregar(Empresa paramEmpresa);  
  String actualizar(Empresa paramEmpresa);  
  String actualizarPerfil(Empresa paramEmpresa1, Empresa paramEmpresa2);  
  String eliminar(Empresa paramEmpresa);  
  String eliminar(Integer paramInteger);  
  Empresa buscarPorId(Integer paramInteger);  
  List<Empresa> buscarTodos();  
  Empresa buscarPorUsuario(String paramString);
  boolean confirmaLink(String paramString1, String paramString2, String paramString3);
  String regresaVista(Empresa paramEmpresa);
}
