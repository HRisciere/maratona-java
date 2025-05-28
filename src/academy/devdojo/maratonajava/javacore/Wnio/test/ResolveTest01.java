package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolveTest01 {
    public static void main(String[] args) {
        Path dir = Paths.get("home/henrique");// <<< Caminho relativo, ou seja, eu estou na pasta raiz e quero ir para
//      home/henrique    é um caminho relativo, porque eu nao tenho "/" no inicio

        Path arquivo = Paths.get("dev/arquivo.txt");
        Path resolve = dir.resolve(arquivo);
        System.out.println(resolve);

        Path absoluto = Paths.get("/home/henrique");
        Path relativo = Paths.get("dev");
        Path file = Paths.get("file.txt");

        System.out.println("1 "+absoluto.resolve(relativo));
        System.out.println("2 "+absoluto.resolve(file));
        System.out.println("3 "+relativo.resolve(absoluto));  // quando tenta resolver um absoluto, ele apenas devolve
        // o absoluto, nao tem nada para resolver
        System.out.println("4 "+relativo.resolve(file));
        System.out.println("5 "+file.resolve(absoluto)); // mesma coisa do terceiro
        System.out.println("6 "+file.resolve(relativo));
    }
}
