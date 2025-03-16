import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class ArvoreBinariaBusca {
    public Nodo raiz;

    public ArvoreBinariaBusca() {
        this.raiz = null;
    }


    public void insere(String palavra, int linha) {

        this.raiz = insereRec(this.raiz, palavra, linha);
    }


    private Nodo insereRec(Nodo raiz, String palavra, int linha) {

        if (raiz == null) {
            raiz = new Nodo(palavra, linha);
            return raiz;
        }

        if (palavra.compareTo(raiz.palavra) < 0)
            raiz.esquerdo = insereRec(raiz.esquerdo, palavra, linha);

        else if (palavra.compareTo(raiz.palavra) > 0)
            raiz.direito = insereRec(raiz.direito, palavra, linha);

        else
            raiz.adicionaLinha(linha);
        return raiz;
    }


    public void imprimeEmOrdem(BufferedWriter writer) throws IOException {

        imprimeEmOrdemRec(this.raiz, writer);
    }


    private void imprimeEmOrdemRec(Nodo raiz, BufferedWriter writer) throws IOException {

        if (raiz != null) {

            imprimeEmOrdemRec(raiz.esquerdo, writer);

            writer.write(raiz.palavra + " " + formataLinhas(raiz.linhas) + "\n");

            imprimeEmOrdemRec(raiz.direito, writer);
        }
    }


    private String formataLinhas(List<Integer> linhas) {
        StringBuilder sb = new StringBuilder();
        for (int linha : linhas) {

            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(linha);
        }
        return sb.toString();
    }

    public Nodo busca(String palavra) {
        return buscaRec(this.raiz, palavra);
    }
    
    private Nodo buscaRec(Nodo raiz, String palavra) {
        if (raiz == null || raiz.palavra.equals(palavra)) {
            return raiz;
        }
        if (palavra.compareTo(raiz.palavra) < 0) {
            return buscaRec(raiz.esquerdo, palavra);
        } else {
            return buscaRec(raiz.direito, palavra);
        }
    }
}
