/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.controller.empresa;

import com.quadrum.nominas2.entidades.Empresa;
import com.quadrum.nominas2.entidades.Sucursal;
import com.quadrum.nominas2.servicios.SucursalServicio;
import static com.quadrum.nominas2.servicios.util.Llave.EMPRESA;
import static com.quadrum.nominas2.servicios.util.Llave.P_EMPRESA;
import java.util.Enumeration;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author vcisneros
 */
@Controller
@RequestMapping(P_EMPRESA)
public class SucursalController {

    @Autowired
    SucursalServicio sucursalServicio;
    
    @RequestMapping(value = "sucursales")
    public String sucursales(Model model, HttpSession session) {
        Empresa empresa = (Empresa) session.getAttribute(EMPRESA);
        model.addAttribute("sucursales", sucursalServicio.buscarPorEmpresa(empresa.getId()));
        return P_EMPRESA + "sucursales";
    }
    
    @RequestMapping(value = "agregarSucursal", method = RequestMethod.POST)
    public String agregarSucursal(MultipartHttpServletRequest archivos) {
        Object sucursal =  archivos.getAttribute("sucursal");
        System.out.println(sucursal.toString());
        Enumeration e = archivos.getParameterNames();
        while(e.hasMoreElements()){
            System.out.println(e.nextElement().toString());
        }
        System.out.println("entreeee");
        return P_EMPRESA + "sucursales";
    }
}
