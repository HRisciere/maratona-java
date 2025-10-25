package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizeTest01 {
    public static void main(String[] args) {
        String diretorioProjeto = "home/henrique/dev";
        String arquivoTxt = "../../arquivo.txt";   // <<<< assim é utilizado no linux, nao esta normalizado
        Path path1 = Paths.get(diretorioProjeto, arquivoTxt);
        System.out.println(path1);
        System.out.println(path1.normalize());  // <<< normalizando
        Path path2 = Paths.get("/home/./william/./dev/");  // Mesma coisa >> /home/william/dev/ < se normalizar
        System.out.println(path2);
        System.out.println(path2.normalize());


    }
}
