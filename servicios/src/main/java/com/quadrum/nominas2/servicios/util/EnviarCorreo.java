/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios.util;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EnviarCorreo {

    private static final String CORREO = "contratos@quadrum.com.mx";
    private static final String HOST = "quadrum.com.mx";
    private static final String PASS = "QuadCoy5087";
    private static final String PORT = "26";
    private MimeMessage msg;
    public static final String MENSAJE_CONFIRMACION = "Gracias por registrarse.\n\nEste es un correo de verificación\nPorfavor haga click en el siguiente enlace  para seguir con la verificación de sus datos\n\n";

    public EnviarCorreo() {
        iniciarPropiedades();
    }

    public String enviarLinkCornfirmacion(String correo, String url) {
        String link = "<a href=\"" + url + "\">De Clic AQUI para terminar su registro</a>";
        try {
            msg.setSubject("Confirmación de la Cuenta");
            msg.setText("Gracias por registrarse.\n\nEste es un correo de verificación\nPorfavor haga click en el siguiente enlace  para seguir con la verificación de sus datos\n\n" + link, "utf-8", "html");
            msg.setFrom(new InternetAddress("contratos@quadrum.com.mx"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            Transport.send(msg);
            return "Correcto...#Finalize su registro.#Vaya a su correo y visite la liga que le acabaos de enviar.";
        } catch (MessagingException m) {
            System.out.println("Error Mail: " + m);
        }
        return "Ups!...#Tuvimos un problema con su registro.";
    }

    public boolean enviarZip(String correo, File zip) {
        try {
            String text = "Estimado usuario le hacemos llegar sus recibos de nomina en un formato <strong>:ZIP</strong>";
            Multipart multipart = new MimeMultipart();
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
//            BodyPart bodyPart = new MimeBodyPart();
//            bodyPart.setText(text);
//            multipart.addBodyPart(bodyPart);
            mimeBodyPart.attachFile(zip);
            multipart.addBodyPart(mimeBodyPart);
            msg.setSubject("Confirmación de la Cuenta");
            msg.setText(text, "utf-8", "html");
            msg.setFrom(new InternetAddress("contratos@quadrum.com.mx"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            Transport.send(msg);
            return true;
        } catch (MessagingException m) {
            System.out.println("Error Mail: " + m);
        } catch (IOException ex) {
            Logger.getLogger(EnviarCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private void iniciarPropiedades() {
        Properties properties = new Properties();
        properties.setProperty("mail.host", "quadrum.com.mx");
        properties.setProperty("mail.smtp.port", "26");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "false");
        properties.put("mail.smtp.socketFactory.port", "26");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        Authenticator auth = new SMTPAuthenticator("contratos@quadrum.com.mx", "QuadCoy5087");
        Session session = Session.getInstance(properties, auth);
        msg = new MimeMessage(session);
    }

    private class SMTPAuthenticator
            extends Authenticator {

        private PasswordAuthentication authentication;

        public SMTPAuthenticator(String login, String password) {
            authentication = new PasswordAuthentication(login, password);
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return authentication;
        }
    }
}
