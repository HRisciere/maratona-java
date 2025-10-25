package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class MethodReferenceTest04 {
    // Reference to a constructor
    public static void main(String[] args) {
        // Referência a um construtor
        // Podemos usar lambdas para criar objetos
        // Primeiro eu preciso de um Supplier
        // A Interface Funcional Supplier não recebe nenhum argumento e retorna um tipo T

        // Agora eu tenho uma interface funcional que não argumento mas ela retorna um Anime, ou seja, isso pode virar Method Reference

        Supplier<AnimeComparators> newAnimeComparators = AnimeComparators::new; // Não é nessa linha que o objeto está sendo criado
        AnimeComparators animeComparators = newAnimeComparators.get(); // Aqui sim, retorna um objeto
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Dragon Ball Z", 43), new Anime("Bleach", 900), new Anime("Naruto", 500)));

        animeList.sort(animeComparators::compareByEpisodeNonStatic);
        System.out.println(animeList);

        // Se não declarar nenhum construtor na classe, o compilador automaticamente cria um construtor padrão (também chamado de construtor sem parâmetros) para você.
        // Supplier<AnimeComparators> newAnimeComparators = AnimeComparators::new;    AnimeComparators o construtor é vazio

        // Para um construtor sem parâmetro funciona muito bem, e se eu fosse criar um Objeto do tipo Anime?
        // Supplier<Anime> animeSupplier = Anime::new; Assim não funciona porque o construtor tem parâmetros
        // Para resolver isso, primeiro eu preciso definir algo que vai RECEBER 2 ARGUMENTOS DIFERENTES E RETORNAR UM TERCEIRO ARGUMENTO
        // O Function RECEBE um T e retornar um R, eu quero RECEBER UM "T,U e retornar um r R"

        BiFunction<String, Integer, Anime> animeBiFunction = (title,episodes) -> new Anime(title, episodes);
        BiFunction<String, Integer, Anime> animeBiFunction2 = Anime::new;
        System.out.println(animeBiFunction2.apply("Super campeões", 36)); // O apply irá criar o objeto

    }
}
