/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mail;

import javax.mail.MessagingException;

/**
 *
 * @author julia.rosa
 */
public class Notificacao {
    protected Mail mail;

    public Notificacao(Mail mail) {
        this.mail = mail;
    }
    public void sendEmail(String recipient, String text) throws MessagingException{
        mail.sendEmail(recipient, text);
    }
}
