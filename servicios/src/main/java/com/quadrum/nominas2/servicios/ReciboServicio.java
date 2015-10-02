/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;


import com.quadrum.nominas2.entidades.Archivo;
import com.quadrum.nominas2.entidades.Recibo;
import com.quadrum.nominas2.servicios.vistas.Nomina;
import com.quadrum.nominas2.servicios.vistas.Respuesta;
import java.util.List;

public interface ReciboServicio {
  String agregar(Recibo paramRecibo);  
  String actualizar(Recibo paramRecibo);  
  String eliminar(Recibo paramRecibo);  
  String eliminar(Integer paramInteger);  
  Respuesta timbrar(Nomina paramNomina, boolean crearArchivo);  
  Recibo buscarPorId(Integer paramInteger);
  List<Recibo> buscarTodos();
  boolean enviarPorCorreo(Archivo archivo, String rfc);
}
