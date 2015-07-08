/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios.util;

import com.quadrum.nominas2.servicios.AdministradorServicio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vcisneros
 */
@AllArgsConstructor
@NoArgsConstructor
@Service
public class LoginQuadrum {
    
//    @Pattern(regex)
    @Getter @Setter private String password;
    
    @Email(message="Verifique la estructura del RFC")
    @Getter @Setter private String mail;

    @Autowired
    AdministradorServicio administradorServicio;
    

}
