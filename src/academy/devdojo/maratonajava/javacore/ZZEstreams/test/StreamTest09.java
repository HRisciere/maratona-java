package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest09 {
    public static void main(String[] args) {
        //Criando stream diretamente
        // Quero uma stream de inteiros
        // Bom para para trabalhar com alta performance

        // Criando número sequenciais via IntStream
        // range(1,50) vai de 1 até o 49, ele não inclui o 50
        // rangeClosed(1,50) vai de 1 até o 50, ele inclui o 50
        IntStream.rangeClosed(1, 50).filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
        System.out.println();
        IntStream.range(1, 50).filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Quero criar um stream de palavras
        // Stream.of() aceita um varArgs de T, pode ser qualquer coisa, um objeto, um string, valor numérico...
        Stream.of("Eleve ", "O ", "Cosmo ", "no seu coração")
                .map(String::toUpperCase)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();

        int num[] = {1, 2, 3, 4, 5};
        // retorna um IntStream, nesse caso, isso é muito bom porque ele já um stream "Tipado"
        // Ele já tem alguns métodos úteis
        // Lembrando que quando volta algo como OptionalDouble, por exemplo, ele evita o autoboxing e o unboxing
        Arrays.stream(num).sum();
        Arrays.stream(num).min();
        Arrays.stream(num).max();
        Arrays.stream(num)
                .average()
                .ifPresent(System.out::println);

        // Trabalhando com streams e arquivo
        // Quero ler as linhas no arquivo file.txt e filtrar as linhas que tenham "Java"

        try (Stream<String> lines = Files.lines(Paths.get("file.txt"))) {

            lines.filter(l -> l.contains("Java")).forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
