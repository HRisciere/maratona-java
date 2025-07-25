package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;
import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest02 {
    public static void main(String[] args) {
        // O classe Manga está com o Comparable para nomes
        // Vou colocar para ordenar por preço descendente, usando o Comparator
        Queue<Manga> mangas = new PriorityQueue<>(new MangaPrecoComparator().reversed());
        mangas.add(new Manga(1L, "Dragon Ball Z", 19.9, 0));
        mangas.add(new Manga(2L, "Attack on titan", 11.20, 2));
        mangas.add(new Manga(4L, "Pokemon", 3.2, 0));
        mangas.add(new Manga(3L, "Berserk", 9.5, 5));
        mangas.add(new Manga(5L, "Hellsing Ultimate", 2.99, 0));
        mangas.add(new Manga(10L, "Aaragon", 2.99, 0));

        while (!mangas.isEmpty()){
            System.out.println(mangas.poll());
        }
    }
}
