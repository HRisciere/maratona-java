package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceTest02 {

    // Reference to an instance method of a particular object
    public static void main(String[] args) {
        // Referência a um método de instância de um objeto específico
        // Quando o método não é estático, eu preciso criar um objeto
        AnimeComparators animeComparators = new AnimeComparators();
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Dragon Ball Z", 43), new Anime("Bleach", 900), new Anime("Naruto", 500)));
        animeList.sort(animeComparators::compareByEpisodeNonStatic);
        animeList.sort((a1, a2) -> animeComparators.compareByEpisodeNonStatic(a1, a2));
        System.out.println(animeList);

    }
}
