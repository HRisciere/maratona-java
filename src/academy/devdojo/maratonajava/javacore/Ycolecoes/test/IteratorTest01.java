package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(1L, "Dragon Ball Z", 19.9, 0));
        mangas.add(new Manga(2L, "Attack on titan", 11.20, 2));
        mangas.add(new Manga(4L, "Pokemon", 3.2, 0));
        mangas.add(new Manga(3L, "Berserk", 9.5, 5));
        mangas.add(new Manga(5L, "Hellsing Ultimate", 2.99, 0));
        // Não se usa for-each para fazer remoção
//        for (Manga manga : mangas) {
//            if(manga.getQuantidade() == 0){
//                mangas.remove(manga);
//            }
//        }
        // Iterator é uma classe que meio que "checa" antes de fazer alguma ação
        Iterator<Manga> mangaIterator = mangas.iterator();
//        while (mangaIterator.hasNext()){
//            Manga manga = mangaIterator.next();
//            if (manga.getQuantidade() == 0){
//                mangaIterator.remove();
//            }
//        }
//        System.out.println(mangas);

        // Simplificando, para ficar em 1 linha só
//        while (mangaIterator.hasNext()){
//            if (mangaIterator.next().getQuantidade() == 0){
//                mangaIterator.remove();
//            }
//        }
//        System.out.println(mangas);

        // primeiro eu utilizo uma variável de referência e depois eu uso a lógica de negócio depois da seta
        // a variável de referência é como se fosse o "manga" no for-each abaixo
//        for (Manga manga : mangas) {
//
//        }
        mangas.removeIf(manga -> manga.getQuantidade() == 0);
        System.out.println(mangas);
    }
}
