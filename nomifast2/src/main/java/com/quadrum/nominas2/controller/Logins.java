/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vcisneros
 */
@Controller
public class Logins {
    @RequestMapping(value = {"/", "spring_security_login"})
    public String homeController(HttpSession session, Model model) {
        return "index";
    }
    @RequestMapping(value = "failEmpresa")
    public String hola(Model model) {
        model.addAttribute("errorEmpresa", true);
        return "index";
    }
}
