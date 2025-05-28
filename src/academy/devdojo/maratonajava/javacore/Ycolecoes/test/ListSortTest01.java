package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortTest01 {
    public static void main(String[] args) {
        List<String> mangas = new ArrayList<>(6);
        mangas.add("Dragon Ball Z");
        mangas.add("Attack on titan");
        mangas.add("Pokemon");
        mangas.add("Berserk");
        mangas.add("Hellsing Ultimate");

        Collections.sort(mangas); // Serve para ordenar, Collections é uma classe utilitária

        List<Double> dinheiros = new ArrayList<>();
        dinheiros.add(100.21);
        dinheiros.add(23.98);
        dinheiros.add(21.21);
        dinheiros.add(98.10);

        Collections.sort(dinheiros);
//        dinheiros.add(23D); // É para double, por isso que uso o D, estou fazendo casting

        for(String manga : mangas){
            System.out.println(manga);
        }

        System.out.println("-------------------");

        for (Double dinheiro : dinheiros) {
            System.out.println(dinheiro);
        }
    }
}
