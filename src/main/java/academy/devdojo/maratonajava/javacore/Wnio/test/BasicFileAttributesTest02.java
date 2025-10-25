package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class BasicFileAttributesTest02 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("pasta2/new.txt");

        // O metodo abaixo diz assim "quando a classe files ler, executar o metodo, o objeto que tem que ser
        //retornado é um objeto que passe no teste que é um BasicFileAttributes. Nao importa o que ele vai retornar
        //porque eu vou trabalhar orientado a interface, o BasicFileattributes é uma interface, vamos executar os
        //metodos atraves da interface, vai chamar os metodos atraves da interface, os objetos em si, para a gente
        //nao importa, o java vai tomar conta disso
        BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);

        FileTime creationTime = basicFileAttributes.creationTime();
        FileTime lastModifiedTime = basicFileAttributes.lastModifiedTime();
        FileTime lastAccessTime = basicFileAttributes.lastAccessTime();

        System.out.println("creationTime " + creationTime);
        System.out.println("lastModifiedTime " + lastModifiedTime);
        System.out.println("lastAccessTime " + lastAccessTime);
        System.out.println("---------------------------------");

//        BasicFileAttributes, DosFileAttributes, PosixFileAttributes   <<<< Só fazem a leitura
//        BasicFileAttributesView, DosFileAttributesView, PosixFileAttributesView   <<<< Basicamente, as classes que
//        podem alterar ou dar a possibilidade de alteracao de alguns atributos, terminam com "View"

        BasicFileAttributeView basicFileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        FileTime newCreationTime = FileTime.fromMillis(System.currentTimeMillis());
        basicFileAttributeView.setTimes(lastModifiedTime, newCreationTime, creationTime);

        creationTime = basicFileAttributeView.readAttributes().creationTime();
        lastModifiedTime = basicFileAttributeView.readAttributes().lastModifiedTime();
        lastAccessTime = basicFileAttributeView.readAttributes().lastAccessTime();

        System.out.println("creationTime " + creationTime);
        System.out.println("lastModifiedTime " + lastModifiedTime);
        System.out.println("lastAccessTime " + lastAccessTime);

    }
}
