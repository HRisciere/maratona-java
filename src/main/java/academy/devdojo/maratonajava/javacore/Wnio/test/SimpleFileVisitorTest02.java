package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class ListAllFiles extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        System.out.println(file.getFileName());
        return FileVisitResult.CONTINUE; // << Retorna todos os arquivos
//        return FileVisitResult.SKIP_SIBLINGS; // << Retorna apenas o primeiro arquivo da pasta
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
//        Antes de entrar no diretorio, ele imprime, como se fosse um trigger, um gatilho
        System.out.println("pre visit "+dir.getFileName());
        return FileVisitResult.CONTINUE;
//        return FileVisitResult.SKIP_SIBLINGS; // <<< Nesse caso, tem o mesmo comportamento de SUBTREE
//        return FileVisitResult.SKIP_SUBTREE; // << Ignora as subpastas
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return super.visitFileFailed(file, exc); // << Se tentar ler o arquivo e nao tiver permissao de leitura, ou
        // se tiver qualquer tipo de problema para pegar aquele arquivo, entao pode usar ele, para conceito, tipo
        //para exibir, eu tentei ler o arquivo no diretorio tal e falhou
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("post visit "+dir.getFileName());
        return FileVisitResult.CONTINUE;
//       return FileVisitResult.SKIP_SUBTREE; //Nao funciona no post, n visitou nenhum descendente, entao n faz sentido
//       return FileVisitResult.SKIP_SIBLINGS; //Nao funciona no post, n visitou nenhum descendente, entao n faz sentido
    }
}

public class SimpleFileVisitorTest02 {
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
        Path root = Paths.get("pasta");
        Files.walkFileTree(root, new ListAllFiles());
    }
}
