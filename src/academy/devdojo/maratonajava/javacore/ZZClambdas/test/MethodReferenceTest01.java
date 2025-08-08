package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

// Reference to a static method
public class MethodReferenceTest01 {
    public static void main(String[] args) {
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Dragon Ball Z", 43), new Anime("Bleach", 900), new Anime("Naruto", 500)));

        // Aqui eu falei sobre Method Reference a MÉTODOS ESTÁTICOS

        // Quero organizar os animes por nome
        // Se eu quiser, posso usar Classes Anônimas, mas eu vou utilizar lambda
        // O List.of() é imutável, então eu vou colocar dentro de um arrayList
        // Do jeito que está abaixo, não podemos usar  Method Reference, mas será feita algumas alterações para usar
        // O lambda só se importa com o "target type" e o "functional descriptor"
        // target type é o contexto aonde a lambda está inserida
        // Isso significa que pode criar um método que é exatamente o que o compareTo faz ( basicamente é o function descriptor )
        // compareTo pede 2 atributos do tipo "t" e retorna um "int"
        // então eu vou na classe AnimeComparators e criar um método que irá fazer exatamente a mesma coisa mas não irá passar no teste "é um comparator"

        // animeList.sort((a1, a2) -> a1.getTitle().compareTo(a2.getTitle()));
        // Criar objeto é diferente de usar lambda então eu não posso fazer o seguinte: animeList.sort(animeList, new AnimeComparators);
        // Como eu tenho o mesmo function descriptor, ele está retornando exatamente o que o compareTo está retornando, nesse caso retorna um int e aceita 2 argumento
        // por isso que consigo fazer o de baixo funcionar

        animeList.sort(AnimeComparators::compareByTitle);
        System.out.println(animeList);
        System.out.println("-------------");
        animeList.sort(AnimeComparators::compareByEpisode);
        System.out.println(animeList);
    }
}
