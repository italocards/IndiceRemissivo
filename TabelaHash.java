import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TabelaHash {
    private ArvoreBinariaBusca[] tabela;
    private int tamanho;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new ArvoreBinariaBusca[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new ArvoreBinariaBusca();
        }
    }

    private int funcaoHash(String palavra) {
        return Math.abs(palavra.hashCode() % tamanho);
    }

    public void insere(String palavra, int linha) {
        int indice = funcaoHash(palavra);
        tabela[indice].insere(palavra, linha);
    }

    public void imprimeIndice(String arquivo) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo));
        for (int i = 0; i < tamanho; i++) {
            tabela[i].imprimeEmOrdem(writer);
        }
        writer.close();
    }
}






