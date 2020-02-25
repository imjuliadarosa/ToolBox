/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Julia
 */
public class Gmail {
    public void sendEmail(String recipient, String text) throws MessagingException{
        System.out.println("Preparando mensagem...");
        Properties properties = new Properties();
        String myAccountEmail = "uneedtosettheemailhereoritwontwork@gmail.com";
        String password = "uneedtosetthepasswordhereoritwontwork";
        /* versão ultrpassada
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        Session session = Session.getInstance(properties,new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });*/
        Properties props = new Properties();  
        props.setProperty("mail.transport.protocol", "smtp");     
        props.setProperty("mail.host", "smtp.gmail.com");  
        props.put("mail.smtp.auth", "true");  
        props.put("mail.smtp.port", "465");  
        props.put("mail.debug", "true");  
        props.put("mail.smtp.socketFactory.port", "465");  
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
        props.put("mail.smtp.socketFactory.fallback", "false");  
        Session session = Session.getDefaultInstance(props,  
        new javax.mail.Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication() {  
           return new PasswordAuthentication(myAccountEmail,password);  
        }  
        });
        Message message = prepareMessage(session,myAccountEmail, recipient, text);
        Transport.send(message);
        System.out.print("Mensagem enviada com sucesso via E-Mail!");
    }

    private Message prepareMessage(Session session, String myAccountEmail,String recipient, String text) throws AddressException, MessagingException {
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Registro");
            message.setText(text);
            return message;
        }catch(Exception ex){
            System.err.printf("Erro no envio de email : %s.\n", ex.getMessage());
        }
        return null;
    }
}
