/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;
import com.quadrum.nominas2.entidades.RegimenFiscal;
import java.util.List;

public interface RegimenFiscalServicio{
  String agregar(RegimenFiscal paramRegimenFiscal);  
  String actualizar(RegimenFiscal paramRegimenFiscal);  
  String eliminar(RegimenFiscal paramRegimenFiscal);  
  String eliminar(Integer paramInteger);  
  RegimenFiscal buscarPorId(Integer paramInteger);  
  List<RegimenFiscal> buscarTodos();
}
