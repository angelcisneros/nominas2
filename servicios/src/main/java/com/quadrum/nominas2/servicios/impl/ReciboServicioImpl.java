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
import com.quadrum.nominas2.entidades.Recibo;
import com.quadrum.nominas2.repositorios.EmpleadoRepositorio;
import com.quadrum.nominas2.repositorios.ReciboRepositorio;
import com.quadrum.nominas2.servicios.ReciboServicio;
import com.quadrum.nominas2.servicios.facturacion.ProcesarTimbrado;
import com.quadrum.nominas2.servicios.util.EnviarCorreo;
import com.quadrum.nominas2.servicios.util.GeneradorZip;
import static com.quadrum.nominas2.servicios.util.ManejadorArchivos.crearPath;
import static com.quadrum.nominas2.servicios.util.ManejadorArchivos.crearArchivoContenido;
import static com.quadrum.nominas2.servicios.util.Rutas.SERVER;
import com.quadrum.nominas2.servicios.vistas.Nomina;
import com.quadrum.nominas2.servicios.vistas.Respuesta;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReciboServicioImpl implements ReciboServicio {

    @Autowired
    ReciboRepositorio reciboRepositorio;

    @Autowired
    EmpleadoRepositorio empleadoRepositorio;

    private static final String ALUMNO_CLASE = "un recibo.#";

    @Override
    public String agregar(Recibo recibo) {
        if (this.reciboRepositorio.agregar(recibo)) {
            return "Correcto...#Se ha agregado un recibo.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente más tarde.";
    }

    @Override
    public String actualizar(Recibo recibo) {
        if (this.reciboRepositorio.actualizar(recibo)) {
            return "Correcto...#Se ha actualizado un recibo.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente más tarde.";
    }

    @Override
    public String eliminar(Recibo recibo) {
        if (this.reciboRepositorio.eliminar(recibo)) {
            return "Correcto...#Se ha eliminado un recibo.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente más tarde.";
    }

    @Override
    public List<Recibo> buscarTodos() {
        return this.reciboRepositorio.buscarTodos(Recibo.class);
    }

    @Override
    public String eliminar(Integer id) {
        Recibo recibo = (Recibo) this.reciboRepositorio.buscarPorId(Recibo.class, id);
        if (this.reciboRepositorio.eliminar(recibo)) {
            return "Correcto...#Se ha eliminado un recibo.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente más tarde.";
    }

    @Override
    public Recibo buscarPorId(Integer id) {
        return (Recibo) this.reciboRepositorio.buscarPorId(Recibo.class, id);
    }

    @Override
    public Respuesta timbrar(Nomina nomina, boolean crearArchivo) {
        ProcesarTimbrado procesarTimbrado = new ProcesarTimbrado();
        Respuesta r = procesarTimbrado.timbrar(nomina);
        if (r.isOk()) {
            if (reciboRepositorio.guradarConEmpleado(nomina.getRecibo())) {
                if (crearArchivo) {
                    String path = SERVER + nomina.getRecibo().getSucursal().getRfc() + "\\" + nomina.getArchivo().getId() + "\\";
                    if (crearPath(path)) {
                        try {
                            if (crearArchivoContenido(path + nomina.getRecibo().getUuid() + ".xml", nomina.getRecibo().getReciboXML().getBytes("utf-8"))) {
                                //CREAR REPRESENTACION IMPRESA

                            } else {
                                //DECIR QUE NO SE ENVIO EL CORREO
                            }
                        } catch (UnsupportedEncodingException ex) {
                            Logger.getLogger(ReciboServicioImpl.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        //SI NO SE CREA SE DICE QUE SE ENVIA DESPUES
                    }
                }
                //RepresentacionImpresa representacionImpresa();
//                EnviarCorreo enviarCorreo = new EnviarCorreo();
//                enviarCorreo.enviarZip(ALUMNO_CLASE, null);
            } else {
                r.addError("001", "No se pudo guardar en base (Recibo)");
            }
        }
        return r;
    }

    @Override
    public boolean enviarPorCorreo(Archivo archivo, String rfc) {
        //Validar que el archivo existe
        //Validar que la ruta existe
        String path = SERVER + rfc + "\\" + archivo.getId();
        GeneradorZip gz = new GeneradorZip(path);
        return gz.generarZip();
    }
}
