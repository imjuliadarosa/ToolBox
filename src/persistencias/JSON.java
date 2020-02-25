/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencias;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Julia
 */
public class JSON implements Persistencia {
    public void gravar(String corpo) {
            System.out.println("Gravando...");
        try {
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                FileWriter gravarArq = new FileWriter("registro.json");
                gravarArq.write(corpo);
                gravarArq.close ();
                System.out.println("Gravado em JSON com sucesso!");
            } catch (IOException e) {
               System.err.printf("Erro ao gravar em JSON: %s.\n", e.getMessage());
            }
    }
    public String ler() {
        System.out.println("Lendo...");
        String registro;
        try {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("registro.json"));
            registro = bufferedReader.readLine();		
            bufferedReader.close();
            System.out.println("Lido de JSON com sucesso!");
            return registro;
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo em JSON : %s.\n", e.getMessage());
            return null;
        }
    }
}
