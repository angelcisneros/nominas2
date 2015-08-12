/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios.util;

import static com.quadrum.nominas2.servicios.util.MensajesCrud.ADD_CORRECT;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author vcisneros
 */
public class EnviarCorreo {

    private static final String CORREO = "contratos@quadrum.com.mx";
    private static final String HOST = "quadrum.com.mx";
    private static final String PASS = "QuadCoy5087";
    private static final String PORT = "26";

    private MimeMessage msg;

    public EnviarCorreo() {
        iniciarPropiedades();
    }

    public String enviarLinkCornfirmacion(String correo, String url) {
        String link ="<a href=\"" + url + "\">De Clic AQUI para terminar su registro</a>";
        try {
            msg.setSubject("Confirmación de la Cuenta");
            msg.setText(MENSAJE_CONFIRMACION + link, "utf-8", "html");
            msg.setFrom(new InternetAddress(CORREO));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            Transport.send(msg);
            return "Correcto...#Finalize su registro.#Vaya a su correo y visite la liga que le acabaos de enviar.";
        } catch (MessagingException m) {
            System.out.println("Error Mail: " + m);
        }
        return "Ups!...#Tuvimos un problema con su registro.";
    }

    private void iniciarPropiedades() {
        Properties properties = new Properties();
        properties.setProperty("mail.host", HOST);
        properties.setProperty("mail.smtp.port", PORT);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "false");
        properties.put("mail.smtp.socketFactory.port", PORT);
        properties.put("mail.smtp.socketFactory.fallback", "false");
        Authenticator auth = new SMTPAuthenticator(CORREO, PASS);
        Session session = Session.getInstance(properties, auth);
        msg = new MimeMessage(session);
    }

    private class SMTPAuthenticator extends Authenticator {

        private PasswordAuthentication authentication;

        public SMTPAuthenticator(String login, String password) {
            authentication = new PasswordAuthentication(login, password);
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return authentication;
        }
    }

    public static final String MENSAJE_CONFIRMACION
            = "Gracias por registrarse.\n\n"
            + "Este es un correo de verificación\n"
            + "Porfavor haga click en el siguiente enlace  para seguir con la verificación de sus datos\n\n";

}
