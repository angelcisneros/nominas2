/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios.impl;

import com.quadrum.nominas2.entidades.Sucursal;
import com.quadrum.nominas2.repositorios.SucursalRepositorio;
import com.quadrum.nominas2.servicios.SucursalServicio;
import com.quadrum.nominas2.servicios.util.Validaciones;
import static com.quadrum.nominas2.servicios.util.Validaciones.esValidoCerKeyAndPassword;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SucursalServicioImpl implements SucursalServicio {

    @Autowired
    SucursalRepositorio sucursalRepositorio;
    private static final String ALUMNO_CLASE = "un sucursal.#";

    @Override
    public String agregar(Sucursal sucursal) {
        sucursal.setFoliosConsumidos(0);
        if (this.sucursalRepositorio.agregar(sucursal)) {
            return "Correcto...#Se ha agregado un sucursal.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String actualizar(Sucursal sucursal) {
        if (this.sucursalRepositorio.actualizar(sucursal)) {
            return "Correcto...#Se ha actualizado un sucursal.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String eliminar(Sucursal sucursal) {
        if (this.sucursalRepositorio.eliminar(sucursal)) {
            return "Correcto...#Se ha eliminado un sucursal.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public List<Sucursal> buscarTodos() {
        return this.sucursalRepositorio.buscarTodos(Sucursal.class);
    }

    @Override
    public String eliminar(Integer id) {
        Sucursal sucursal = (Sucursal) this.sucursalRepositorio.buscarPorId(Sucursal.class, id);
        if (this.sucursalRepositorio.eliminar(sucursal)) {
            return "Correcto...#Se ha eliminado un sucursal.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public Sucursal buscarPorId(Integer id) {
        return (Sucursal) this.sucursalRepositorio.buscarPorId(Sucursal.class, id);
    }

    @Override
    public List<ObjectError> validarCertificados(Sucursal sucursal, MultipartFile cer, MultipartFile ky) {
        List<ObjectError> errores = new ArrayList();
        if (cer == null) {
            errores.add(new ObjectError("nombre", new String[]{"", "cer.cer"}, null, "EL archivo de ser un certificado (.cer)"));
            return errores;
        }
        if (ky == null) {
            errores.add(new ObjectError("nombre", new String[]{"", "ky.ky"}, null, "EL archivo de ser una llave (.key)"));
            return errores;
        }
        if (cer.isEmpty()) {
            errores.add(new ObjectError("nombre", new String[]{"", "cer.cer"}, null, "El certificado est� vacio"));
            return errores;
        }
        if (ky.isEmpty()) {
            errores.add(new ObjectError("nombre", new String[]{"", "ky.ky"}, null, "EL archivo key est� vacio"));
            return errores;
        }
        if (!Validaciones.validaExtencion(cer.getOriginalFilename(), "cer")) {
            errores.add(new ObjectError("nombre", new String[]{"", "cer.cer"}, null, "EL archivo de ser un certificado (.cer)"));
            return errores;
        }
        if (!Validaciones.validaExtencion(ky.getOriginalFilename(), "key")) {
            errores.add(new ObjectError("nombre", new String[]{"", "ky.ky"}, null, "EL archivo de ser una llave (.key)"));
            return errores;
        }
        String e = "";
        try {
            e = esValidoCerKeyAndPassword(cer.getInputStream(), ky.getInputStream(), sucursal.getPassword(), sucursal.getRfc());
        } catch (IOException ex) {
            Logger.getLogger(SucursalServicioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!"".equals(e)) {
            errores.add(new ObjectError("nombre", new String[]{"", "cer.cer"}, null, e));
            return errores;
        }
        return errores;
    }

    @Override
    public Sucursal buscarMatriz(Integer empresa) {
        return this.sucursalRepositorio.buscarPorMatriz(empresa);
    }

    @Override
    public List<Sucursal> buscarPorEmpresa(Integer empresa) {
        return this.sucursalRepositorio.buscarPorEmpresa(empresa);
    }

    @Override
    public Sucursal buscarPorIdAndEmpresa(Integer sucursal, Integer empresa) {
        return this.sucursalRepositorio.buscarPorIdAndEmpresa(sucursal, empresa);
    }
}
