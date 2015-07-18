/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.controller.empresa;


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
