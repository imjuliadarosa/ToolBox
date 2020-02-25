/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencias;

import javax.mail.MessagingException;
import mail.Gmail;

/**
 *
 * @author Julia
 */
public class main {
    public static void main(String [] args) throws MessagingException{
        Persistencia per = new XML();
        //per.gravar("Hey, this is a e-mail sent through a Java API Program, really cool hum?");
        System.out.print(per.ler());
        Gmail mail = new Gmail();
        mail.sendEmail("julia1705rosa@gmail.com", per.ler());
    }
}
