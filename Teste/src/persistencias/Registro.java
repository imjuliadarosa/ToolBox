/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencias;

/**
 *
 * @author julia.rosa
 */
public class Registro {
    protected Persistencia persistencia;

    public Registro(Persistencia persistencia) {
        this.persistencia = persistencia;
    }
    public void gravar(String mensagem){
        persistencia.gravar(mensagem);
    }
    public String ler(){
        return persistencia.ler();
    }
}
