package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest04 {
    public static void main(String[] args) {
        List<List<String>> devdojo = new ArrayList<>();
        List<String> graphicDesigners = List.of("Wildnei Suane", "Catarina Santos", "Sandy Carolina");
        List<String> developers = List.of("William", "David", "Harisson");
        List<String> students = List.of("Édipo", "Gustavo Lima", "Gustavo Mendes", "Guilherme");
        devdojo.add(graphicDesigners);
        devdojo.add(developers);
        devdojo.add(students);

        for (List<String> people : devdojo) {
            for (String person : people) {
                System.out.println(person);
            }
        }
        System.out.println("----------------");

        // Se eu fizer da maneira abaixo, ele vai gerar um Stream<Stream<String>> como variável local
        // O objetido é ficar Stream<String>
        // Stream<Stream<String>> streamStream = devdojo.stream().map(l -> l.stream());

        // Uso o flatMap quando eu quero retirar um atributo que está aninhado (nested), quero retirar de dentro
        // Quando eu estou tirando um atributo que está aninhado, eu estou fazendo "flatening" ou seja, estou achatando, tirando um atributo de dentro
        // O map trabalho no "primeiro nível" o flatMap "vai mais para dentro" e ele achata, retirando os valores aninhados mais para dentro
        //  "Collection::stream" ou  "l -> l.stream", quer dizer que eu quero retornar um "stream<strings>"
        // uso flatMap quando eu quero retirar uma coleção ou um atributo de dentro de outro lugar, por ex: lista aninhada
        devdojo.stream().flatMap(Collection::stream).forEach(System.out::println);

    }
}
