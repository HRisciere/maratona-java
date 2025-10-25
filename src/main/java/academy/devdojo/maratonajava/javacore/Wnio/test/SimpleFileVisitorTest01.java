package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class ListJavaFiles extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (file.getFileName().toString().endsWith(".java")) {
            System.out.println(file.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }
}

public class SimpleFileVisitorTest01 {
    public static void main(String[] args) throws IOException {
        //Serve para navegar nos diretórios
        //Ele precisa de um path para startar e depois um FileVisitor, basicamente define o comportamento que voce
        //quer fazer enquanto voce esta navegando por esse diretorios
        //precisa de um objeto, que passe no teste "é um FileVisitor?", a melhor forma de fazer isso é criar outra class
        //podemos criar uma classe dentro do pacote ou podemos criar dentro desta classe, porque eu irei usar ela aqui
        //no java a gente pode criar quantas classes quisermos, mas precisa de uma classe publica e precisa
        //obrigatoriamente ter o mesmo nome do arquivo
        //como é uma classe, eu nao sou obrigado a sobrescrever todos os métodos
        // SimpleFileVisitor<Path> <<< Quer dizer que todos os métodos que tem o "T", nós vamos ter o Path
        //quem vai chamar o metodo visitFile, é o proprio java, atraves do polimorfismo, a gente so precisa definir
        //o que a gente que fazer
        Path root = Paths.get(".");
        Files.walkFileTree(root, new ListJavaFiles());
    }
}
