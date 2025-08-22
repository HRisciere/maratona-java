package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest05 {
    public static void main(String[] args) {
        List<String> words = List.of("Gomu", "Gomu", "no", "Mi");
        String[] letters = words.get(0).split("");
        System.out.println(Arrays.toString(letters));

        List<String[]> collect = words.stream().map(l -> l.split("")).collect(Collectors.toList());
        // Queroo extrair a coleção "String[]" da lista, ou seja, eu quero achatar (flattening)
        Stream<String> stream = Arrays.stream(letters); // Aqui eu estou pegando  um Array em um stream


        List<String> letters2 = words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());// Stream<String>

        System.out.println(letters2);

        // Abaixo tem outra maneira de fazer
        List<String> collect1 = words.stream().flatMap(l -> Arrays.stream(l.split(""))).collect(Collectors.toList());
        System.out.println(collect1);


    }
}
