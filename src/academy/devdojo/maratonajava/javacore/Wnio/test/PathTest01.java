package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest01 {
    public static void main(String[] args) {
//        Files é uma Classe para trabalhar com arquivos
//        Path é uma interface
        Path p1 = Paths.get("C:\\Users\\User\\ws-IntelliJ\\maratona-java\\file.txt");
        Path p2 = Paths.get("C:\\Users\\User\\ws-IntelliJ\\maratona-java", "file.txt");
        Path p3 = Paths.get("C:", "Users\\User\\ws-IntelliJ\\maratona-java", "file.txt");
        Path p4 = Paths.get("C:", "Users", "User", "ws-IntelliJ", "maratona-java", "file.txt");
        System.out.println(p1.getFileName());
        System.out.println(p2.getFileName());
        System.out.println(p3.getFileName());
        System.out.println(p4.getFileName());
    }
}
