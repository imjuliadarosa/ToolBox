package persistencias;

/**
 *
 * @author Julia
 */
public interface Persistencia {
    public void gravar(String corpo);
    public String ler();
}
