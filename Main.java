import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<String> palavrasChave = lerPalavrasChave("C:\\Users\\joaoi\\OneDrive\\Desktop\\palavras-chave.txt");

        TabelaHash tabelaHash = new TabelaHash(palavrasChave.size());

        lerTexto("C:\\Users\\joaoi\\OneDrive\\Desktop\\texto.txt", tabelaHash, palavrasChave);

        tabelaHash.imprimeIndice("C:\\Users\\joaoi\\OneDrive\\Desktop\\resultado.txt");

        File resultado = new File("C:\\Users\\joaoi\\OneDrive\\Desktop\\resultado.txt");
        Desktop desktop = Desktop.getDesktop();
        desktop.open(resultado);
    }

    private static List<String> lerPalavrasChave(String arquivo) throws IOException {
        List<String> palavrasChave = new ArrayList<>();
        Scanner scanner = new Scanner(new File(arquivo));
        while (scanner.hasNextLine()) {
            palavrasChave.add(scanner.nextLine().trim().toLowerCase());
        }
        scanner.close();
        return palavrasChave;
    }

    private static void lerTexto(String arquivo, TabelaHash tabelaHash, List<String> palavrasChave) throws IOException {
        Scanner scanner = new Scanner(new File(arquivo));
        int numeroLinha = 0;
        while (scanner.hasNextLine()) {
            numeroLinha++;
            String linha = scanner.nextLine();
            String[] palavras = linha.split("\\W+");
            for (String palavra : palavras) {
                palavra = palavra.toLowerCase();
                if (palavrasChave.contains(palavra)) {
                    tabelaHash.insere(palavra, numeroLinha);
                }
            }
        }
        scanner.close();
    }
}
