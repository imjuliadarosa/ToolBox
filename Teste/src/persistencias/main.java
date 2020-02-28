/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencias;

import Mail.Gmail;
import Mail.Notificacao;
import java.util.Scanner;
import javax.mail.MessagingException;

/**
 *
 * @author Julia
 */
public class main {
    public static void main(String [] args) throws MessagingException{
        JSON json = new JSON();
        CSV csv = new CSV();
        XML xml = new XML();
        Registro registro = null;
        //registro = new Registro(xml);
        //registro.gravar("Registro em xml.");
        //System.out.println(registro.ler());
        Notificacao notificacao;
        Gmail gmail = new Gmail();
        //notificacao = new Notificacao(gmail);
        //notificacao.sendEmail("julia1705rosa@gmail.com", registro.ler());
        Scanner read = new Scanner(System.in);
        int opcao;
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
                        System.out.println("Informe sua mensagem:");
                        texto = read.nextLine();
                        texto = read.nextLine();
                        registro=new Registro(json);
                        registro.gravar(texto);
                        break;
                    case 2:
                        System.out.println("Informe sua mensagem:");
                        texto = read.nextLine();
                        texto = read.nextLine();
                        registro=new Registro(xml);
                        registro.gravar(texto);
                        break;
                    case 3:
                        System.out.println("Informe sua mensagem:");
                        texto = read.nextLine();
                        texto = read.nextLine();
                        registro=new Registro(csv);
                        registro.gravar(texto);
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
                        registro=new Registro(json);
                        System.out.println(registro.ler());
                        break;
                    case 2:
                        registro=new Registro(xml);
                        System.out.println(registro.ler());
                        break;
                    case 3:
                        registro=new Registro(csv);
                        System.out.println(registro.ler());
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
                notificacao = new Notificacao(gmail);
                notificacao.sendEmail(email, registro.ler());
                
            break;
            }
        }while(opcao!=4);
    }
}
