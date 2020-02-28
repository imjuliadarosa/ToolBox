/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencias;

import java.util.Scanner;
import javax.mail.MessagingException;
import mail.Gmail;

/**
 *
 * @author Julia
 */
public class main {
    public static void main(String [] args) throws MessagingException{
        Scanner read = new Scanner(System.in);
        int opcao;
        Persistencia persistencia = new JSON();
        Gmail mail = new Gmail();
        String email ;
        do{
            System.out.println("O que deseja fazer?\n 1 - gravar mensagem \n 2 - ler mensagem em persistencia \n 3 - enviar mensagem em persistencia por email \n 4 - sair");
            opcao = read.nextInt();
            switch(opcao){
                case 1:
                    String texto;
                    System.out.println("Informe qual tipo de arquivo deseja: \n1 - JSON\n 2 - XML \n 3 - CSV");
                    int tipo = read.nextInt();
                    switch (tipo){
                        case 1:
                        persistencia = new JSON();
                        System.out.println("Informe sua mensagem:");
                        texto = read.nextLine();
                        texto = read.nextLine();
                        persistencia.gravar(texto);
                        break;
                    case 2:
                        persistencia = new XML();
                        System.out.println("Informe sua mensagem:");
                        texto = read.nextLine();
                        texto = read.nextLine();
                        persistencia.gravar(texto);
                        break;
                    case 3:
                        persistencia = new CSV();
                        System.out.println("Informe sua mensagem:");
                        texto = read.nextLine();
                        texto = read.nextLine();
                        persistencia.gravar(texto);
                        break;
                    default:
                        System.out.println("Informação incorreta.");
                        break;
                }
                    break;
            case 2:
                System.out.println("Informe qual tipo de arquivo deseja ler: \n1 - JSON\n2 - XML \n3 - CSV");
                    int tipo2 = read.nextInt();
                    switch (tipo2){
                        case 1:
                        persistencia = new JSON();
                        System.out.println(persistencia.ler());
                        break;
                    case 2:
                        persistencia = new XML();
                        System.out.println(persistencia.ler());
                        break;
                    case 3:
                        persistencia = new CSV();
                        System.out.println(persistencia.ler());
                        break;
                    default:
                        System.out.println("Informação incorreta.");
                        break;
                }
                    break;
            case 3:
                System.out.println("Informe o email:");
                email = read.nextLine();
                email = read.nextLine();
                mail.sendEmail(email, persistencia.ler());
                
            break;
            }
        }while(opcao!=4);
    }
}
