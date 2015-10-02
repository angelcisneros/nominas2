/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.controller.empresa;

import com.quadrum.nominas2.entidades.Archivo;
import com.quadrum.nominas2.entidades.Empresa;
import com.quadrum.nominas2.entidades.Sucursal;
import com.quadrum.nominas2.servicios.ArchivoServicio;
import com.quadrum.nominas2.servicios.EmpresaServicio;
import com.quadrum.nominas2.servicios.ReciboServicio;
import com.quadrum.nominas2.servicios.SucursalServicio;
import static com.quadrum.nominas2.servicios.util.Llave.EMPRESA;
import static com.quadrum.nominas2.servicios.util.Llave.P_EMPRESA;
import com.quadrum.nominas2.servicios.vistas.Nomina;
import com.quadrum.nominas2.servicios.vistas.Respuesta;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author vcisneros
 */
@Controller
@RequestMapping(P_EMPRESA)
public class TimbrarController {

    @Autowired
    ReciboServicio reciboServicio;

    @Autowired
    SucursalServicio sucursalServicio;

    @Autowired
    EmpresaServicio empresaServicio;

    @Autowired
    ArchivoServicio archivoServicio;

    @RequestMapping(value = "timbrar")
    public String timbrar(Model model, HttpSession session) {
        Empresa empresa = (Empresa) session.getAttribute(EMPRESA);
        if (empresa == null) {
            return "SIN SESION";
        }
        model.addAttribute("sucursales", sucursalServicio.buscarPorEmpresa(empresa.getId()));
        return P_EMPRESA + "timbrar";
    }

    @ResponseBody
    @RequestMapping(value = "timbrarRecibo", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public Respuesta sucursales(@Valid @RequestBody Nomina nomina, BindingResult result, HttpSession session) {
        Empresa empresa = null;
        Sucursal sucursal = null;
        if (result.hasErrors()) {
            for (ObjectError e : result.getAllErrors()) {
                System.out.println(e.getCodes()[1] + ": " + e.getDefaultMessage());
            }
            return new Respuesta("TIENE ERRORES", false);
        }
        empresa = (Empresa) session.getAttribute(EMPRESA);
        if (empresa == null) {
            return new Respuesta("SIN SESION", false);
        }
        sucursal = sucursalServicio.buscarPorIdAndEmpresa(nomina.getSucursal().getId(), empresa.getId());
        if (sucursal == null) {
            return new Respuesta("NO encontre la sucursal", false);
        }
        nomina.parsearNomina(empresa, sucursal, sucursalServicio.buscarMatriz(empresa.getId()).getDomicilio());
        return reciboServicio.timbrar(nomina, true);
    }

    @ResponseBody
    @RequestMapping(value = "getCourrentFile", method = RequestMethod.POST)
    public int getCourrentFile(HttpSession session) {
        Empresa empresa = (Empresa) session.getAttribute(EMPRESA);
        if (empresa == null) {
            return -2;
        }
        int numero = empresa.getArchivosTimbrados() + 1;
        empresa.setArchivosTimbrados(numero);
        Archivo archivo = archivoServicio.agregar(numero);
        if (archivo != null) {
            if (empresaServicio.actualizar(empresa).contains("Correcto")) {
                return archivo.getId();
            }else{
                archivoServicio.eliminar(archivo);
            }
        }
        return -1;
    }
    
    @ResponseBody
    @RequestMapping(value = "setCourrentFile", method = RequestMethod.POST)
    public int setCourrentFile(@RequestBody Archivo archivo, HttpSession session) {
        Empresa empresa = (Empresa) session.getAttribute(EMPRESA);
        if (empresa == null) {
            return -2;
        }
        int numero = empresa.getArchivosTimbrados() + 1;
        empresa.setArchivosTimbrados(numero);
        archivo = archivoServicio.buscarPorId(archivo.getId());
        if (archivo != null) {
            archivoServicio.actualizar(archivo);
            return archivo.getId();
        }
        return -1;
    }
    
    @ResponseBody
    @RequestMapping(value = "enviarPorCorreo", method = RequestMethod.POST)
    public boolean enviarPorCorreo(@RequestBody Archivo archivo, HttpSession session){
        Empresa empresa = (Empresa) session.getAttribute(EMPRESA);
        if (empresa == null) {
            return false;
        }
        return reciboServicio.enviarPorCorreo(archivo,"AAD990814BP7");
    }
}
