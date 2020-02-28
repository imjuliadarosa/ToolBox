/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencias;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Julia
 */
public class CSV implements Persistencia {
	
	public void gravar(String corpo) {
            System.out.println("Gravando...");
            try {
            Scanner ler = new Scanner(System.in);
            FileWriter arq = new FileWriter("registro.csv");
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(corpo);
            arq.close();
            System.out.print("Gravado em CSV com sucesso!");
            }catch (IOException e) {
            System.err.printf("Erro ao gravar em CSV: %s.\n", e.getMessage());
            }
	}
	
	public String ler(){
		System.out.println("Lendo...");
                String registro;
		try {
			FileReader arq = new FileReader("registro.csv");
			BufferedReader lerArq = new BufferedReader(arq);
			registro = lerArq.readLine();
			arq.close();
                        System.out.println("Lido de CSV com sucesso!");
			return registro;
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo em CSV : %s.\n" , e.getMessage());
			return null;
		}
	}

}
