package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;
import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest03 {
    public static void main(String[] args) {
        Consumidor consumidor1 = new Consumidor("Henrique Risciere");
        Consumidor consumidor2 = new Consumidor("DevDojo Academy");

        Manga manga1 = new Manga(1L, "Dragon Ball Z", 19.9);
        Manga manga2 = new Manga(2L, "Attack on titan", 11.20);
        Manga manga3 = new Manga(4L, "Pokemon", 3.2);
        Manga manga4 = new Manga(3L, "Berserk", 9.5);
        Manga manga5 = new Manga(5L, "Hellsing Ultimate", 2.99);

        // Associando um consumidor como CHAVE e um manga como VALOR
        // Fazendo da seguinte maneira o Consumidor pode ter vários mangas associados
        List<Manga> mangaConsumidor1List = List.of(manga1, manga2, manga3);
        List<Manga> mangaConsumidor2List = List.of(manga3, manga4);
        Map<Consumidor, List<Manga>> consumidorMangaMap = new HashMap<>();
        consumidorMangaMap.put(consumidor1, mangaConsumidor1List);
        consumidorMangaMap.put(consumidor2, mangaConsumidor2List);

        for (Map.Entry<Consumidor, List<Manga>> entry : consumidorMangaMap.entrySet()) {
            System.out.println("----------" + entry.getKey().getNome());
            // System.out.println(entry.getValue()); Assim funciona, mas fica feio
            // Como é uma List, o melhor é eu iterar ela
            for (Manga manga : entry.getValue()) {
                System.out.println("-" + manga.getNome());
            }
        }


    }
}
