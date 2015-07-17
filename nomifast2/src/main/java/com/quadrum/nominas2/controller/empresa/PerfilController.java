/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.controller.empresa;

import com.quadrum.nominas2.entidades.Empresa;
import static com.quadrum.nominas2.servicios.util.Llave.EMPRESA;
import static com.quadrum.nominas2.servicios.util.MensajesCrud.LOGEATE;
import static com.quadrum.nominas2.servicios.util.MensajesCrud.LOGIN;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vcisneros
 */
@Controller
@RequestMapping(value = "empresa/")
public class PerfilController {

    @RequestMapping(value = "perfil")
    public String perfil(HttpSession session, Model model) {
        //model.addAttribute("empresa", e);
        return "empresa/perfil";
    }

}
