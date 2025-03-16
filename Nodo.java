import java.util.LinkedList;
import java.util.List;

public class Nodo {
    public String palavra;
    public List<Integer> linhas;
    public Nodo esquerdo, direito;

    public Nodo(String palavra, int linha) {
        this.palavra = palavra;
        this.linhas = new LinkedList<>();
        this.linhas.add(linha);
        this.esquerdo = null;
        this.direito = null;
    }

    public void adicionaLinha(int linha) {
        this.linhas.add(linha);
    }
}
