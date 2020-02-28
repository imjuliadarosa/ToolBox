/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;

/**
 *
 * @author julia.rosa
 */
public interface Mail {
    public Message prepareMessage(Session session, String myAccountEmail,String recipient, String text)throws AddressException, MessagingException;
    public void sendEmail(String recipient, String text) throws MessagingException;
}
