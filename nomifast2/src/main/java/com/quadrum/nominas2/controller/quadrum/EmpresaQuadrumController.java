/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.controller.quadrum;

import com.quadrum.nominas2.entidades.Administrador;
import com.quadrum.nominas2.servicios.EmpresaServicio;
import static com.quadrum.nominas2.servicios.util.Llave.QUADRUM;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author vcisneros
 */
@Controller
@RequestMapping("administrador/")
public class EmpresaQuadrumController {
    
    @Autowired
    EmpresaServicio empresaServicio;
    
    @RequestMapping(value = "empresas", method = RequestMethod.GET)
    public String empresas(HttpSession session, Model model){
        Administrador admin = (Administrador) session.getAttribute(QUADRUM);
        if(admin == null){
            return "administrador/inicio";
        }
        model.addAttribute("empresas", empresaServicio.buscarTodos());
        return "administrador/empresa";
    }
}
