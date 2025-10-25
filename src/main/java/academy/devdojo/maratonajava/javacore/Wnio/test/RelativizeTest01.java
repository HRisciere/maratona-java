package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizeTest01 {
    public static void main(String[] args) {
        // Faz de conta que tem 2 paths, como que você chega no path 2 a partir do path 1?

        Path dir = Paths.get("/home/henrique");
        Path clazz = Paths.get("/home/henrique/devdojofoda/OlaMundo.java");
        // Quero saber dado o meu diretorio, como eu faco para chegar nessa clazz? Como faço para pegar onde esse
        //OlaMundo.java se encontra?

        Path pathToClazz = dir.relativize(clazz);
        System.out.println(pathToClazz);

        Path absoluto1 = Paths.get("/home/henrique");
        Path absoluto2 = Paths.get("/user/local");
        Path absoluto3 = Paths.get("/home/henrique/devdojofoda/OlaMundo.java");
        Path relativo1 = Paths.get("temp");
        Path relativo2 = Paths.get("temp/temp.2021921");

        System.out.println("1 "+absoluto1.relativize(absoluto3));
        System.out.println("2 "+absoluto3.relativize(absoluto1));
        System.out.println("3 "+absoluto1.relativize(absoluto2));
        System.out.println("4 "+relativo1.relativize(relativo2));
        System.out.println("5 "+absoluto1.relativize(relativo1)); // ele volta para a raiz, mas nao sabe para onde vai
    }
}
