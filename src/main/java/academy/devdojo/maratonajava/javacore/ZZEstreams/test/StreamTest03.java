package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest03 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game no life", 2.99),
            new LightNovel("Fullmetal Alchemist", 5.99),
            new LightNovel("Kumo desuga", 1.99),
            new LightNovel("Kumo desuga", 1.99),
            new LightNovel("Monogatari", 4.00)
    ));

    public static void main(String[] args) {
        // o forEach tem um consumer, então eu posso fazer uma ação
        // Fazer o que eu fiz abaixo não é uma boa prática, porque a própria List<> tem um forEach, se eu fizer o de baixo eu estou disperdiçando processamento
        // lightNovels.stream().forEach(System.out::println); Dessa forma eu tenho uma operação terminal
        lightNovels.forEach(System.out::println);
        Stream<LightNovel> stream = lightNovels.stream();

        long count = stream.filter(lightNovel -> lightNovel.getPrice() <= 4).count();
        System.out.println(count);

        // Agora eu quero os elementos distintos
        // Eu não posso fazer da meneira abaixo, porque o stream já fechou acima
        // long count2 = stream.distinct().filter(lightNovel -> lightNovel.getPrice() <= 4).count();
        long count2 = lightNovels.stream().distinct().filter(lightNovel -> lightNovel.getPrice() <= 4).count();
        // Preciso lembrar de fazer o equals e o hashcode, se não o distinct não irá funcionar
        System.out.println(count2);
    }
}
