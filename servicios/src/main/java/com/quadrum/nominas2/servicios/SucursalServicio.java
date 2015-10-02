package com.quadrum.nominas2.servicios;


import com.quadrum.nominas2.entidades.Sucursal;
import java.util.List;
import org.springframework.validation.ObjectError;
import org.springframework.web.multipart.MultipartFile;

public interface SucursalServicio {
  String agregar(Sucursal paramSucursal);  
  String actualizar(Sucursal paramSucursal);  
  String eliminar(Sucursal paramSucursal);  
  String eliminar(Integer paramInteger);  
  Sucursal buscarPorId(Integer paramInteger);  
  Sucursal buscarMatriz(Integer paramInteger);  
  Sucursal buscarPorIdAndEmpresa(Integer paramInteger1, Integer paramInteger2);  
  List<Sucursal> buscarTodos();  
  List<Sucursal> buscarPorEmpresa(Integer paramInteger);  
  List<ObjectError> validarCertificados(Sucursal paramSucursal, MultipartFile paramMultipartFile1, MultipartFile paramMultipartFile2);
}
