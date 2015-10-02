/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios.impl;

/**
 *
 * @author vcisneros
 */
import com.quadrum.nominas2.entidades.Archivo;
import com.quadrum.nominas2.repositorios.ArchivoRepositorio;
import com.quadrum.nominas2.servicios.ArchivoServicio;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArchivoServicioImpl implements ArchivoServicio {

    @Autowired
    ArchivoRepositorio periodicidadPagoRepositorio;
    private static final String ALUMNO_CLASE = "un periodicidadPago.#";

    @Override
    public String agregar(Archivo periodicidadPago) {
        if (this.periodicidadPagoRepositorio.agregar(periodicidadPago)) {
            return "Correcto...#Se ha agregado un periodicidadPago.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String actualizar(Archivo archivo) {
        archivo.setFin(new Date());
        if (this.periodicidadPagoRepositorio.actualizar(archivo)) {
            return "Correcto...#Se ha actualizado un periodicidadPago.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String eliminar(Archivo periodicidadPago) {
        if (this.periodicidadPagoRepositorio.eliminar(periodicidadPago)) {
            return "Correcto...#Se ha eliminado un periodicidadPago.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public List<Archivo> buscarTodos() {
        return this.periodicidadPagoRepositorio.buscarTodos(Archivo.class);
    }

    @Override
    public String eliminar(Integer id) {
        Archivo periodicidadPago = (Archivo) this.periodicidadPagoRepositorio.buscarPorId(Archivo.class, id);
        if (this.periodicidadPagoRepositorio.eliminar(periodicidadPago)) {
            return "Correcto...#Se ha eliminado un periodicidadPago.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public Archivo buscarPorId(Integer id) {
        return (Archivo) this.periodicidadPagoRepositorio.buscarPorId(Archivo.class, id);
    }

    @Override
    public Archivo agregar(int numeroEmpresa) {
        Archivo a = new Archivo();
        a.setNumeroEmpresa(numeroEmpresa);
        a.setInicio(new Date());
        if (this.periodicidadPagoRepositorio.agregar(a)) {
            return a;
        }
        return null;
    }
}
