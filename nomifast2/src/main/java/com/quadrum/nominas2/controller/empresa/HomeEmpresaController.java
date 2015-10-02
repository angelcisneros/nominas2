/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.controller.empresa;

import com.quadrum.nominas2.entidades.Empresa;
import com.quadrum.nominas2.servicios.EmpresaServicio;
import static com.quadrum.nominas2.servicios.util.Llave.EMPRESA;
import static com.quadrum.nominas2.servicios.util.Llave.P_EMPRESA;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vcisneros
 */
@Controller
@RequestMapping(value = P_EMPRESA)
public class HomeEmpresaController {

    @Autowired
    EmpresaServicio empresaServicio;
    
    @RequestMapping(value = "*")
    public String error404(Model model) {
        return "templates/404";
    }

    @RequestMapping(value = "inicio")
    public String inicio(Model model, HttpSession session) {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        if("anonymousUser".equals(a.getPrincipal())){
            model.addAttribute("url", "../");
            return "util/redireccionador";
        }
        User user = (User) a.getPrincipal();
        Empresa empresa = empresaServicio.buscarPorUsuario(user.getUsername());
        session.setAttribute(EMPRESA, empresa);
        return empresaServicio.regresaVista(empresa);
    }


    @RequestMapping(value = "empleados")
    public String empleados(Model model) {

        return P_EMPRESA + "empleados";
    }

   

    @RequestMapping(value = "recibos")
    public String recibos(Model model) {

        return P_EMPRESA + "recibos";
    }

   

    @RequestMapping(value = "cancelar")
    public String cancelar(Model model) {

        return P_EMPRESA + "cancelar";
    }

    @RequestMapping(value = "logo")
    public String logo(Model model) {

        return P_EMPRESA + "logo";
    }

    @RequestMapping(value = "percepciones")
    public String percepciones(Model model) {

        return P_EMPRESA + "percepciones";
    }

    @RequestMapping(value = "deducciones")
    public String deducciones(Model model) {

        return P_EMPRESA + "deducciones";
    }
}
