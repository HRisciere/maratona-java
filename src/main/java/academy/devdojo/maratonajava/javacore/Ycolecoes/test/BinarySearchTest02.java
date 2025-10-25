package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest02 {
    public static void main(String[] args) {
//     Outra forma para fazer busca em uma coleção, arrays, a diferença é que ele retorna a
//     posição que eu deveria inserir o elemento, caso ele não exista
//     O BinarySearch vai fazer uma busca na lista que eu passar e vai retornar para a gente
//     o índice caso ele encontre o que nós estamos procurando ou caso ele nao encontre, ele vai
//     retornar algo seguindo a regra abaixo
//     (-(ponto de inserção) -1)
//      index 0,1,2,3
//      value 0,2,3,4
//        List<Integer> numeros = new ArrayList<>();
//        numeros.add(2);
//        numeros.add(0);
//        numeros.add(4);
//        numeros.add(3);

        // Precisa que a lista seja ORDENADA, pode definir que  as classes sejam ordenadas por
        // Wrappers ou definir por Comparator, se não o resultado não é confiável.
//        Collections.sort(numeros);
//        System.out.println(Collections.binarySearch(numeros, 0));
//        System.out.println(Collections.binarySearch(numeros, -1));


//        Para nao ficar duplicando código, fazer o seguinte, criar uma variável de referência
//        para o mangaByIdComparator.

        MangaByIdComparator mangaByIdComparator = new MangaByIdComparator();
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(1L, "Dragon Ball Z", 19.9));
        mangas.add(new Manga(2L, "Attack on titan", 11.20));
        mangas.add(new Manga(4L, "Pokemon", 3.2));
        mangas.add(new Manga(3L, "Berserk", 9.5));
        mangas.add(new Manga(5L, "Hellsing Ultimate", 2.99));

        Collections.sort(mangas);

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        Manga mangaToSearch = new Manga(1L, "Dragon Ball Z", 19.9);

        // Procurando dentro de mangas o manga "mangaToSearch"
        System.out.println(Collections.binarySearch(mangas, mangaToSearch));

//        Collections.sort(mangas, new MangaByIdComparator());
        System.out.println("-------------------------------------");
        System.out.println("Comparando por ID");
        mangas.sort(mangaByIdComparator);

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        System.out.println(Collections.binarySearch(mangas, mangaToSearch));

        // Ele se perdeu o resultado saiu por -4, então eu também preciso passar o objeto
        // por ordenação, quando eu faço uma ordenação customizada

        System.out.println("------------------");
//      Maneira correta, quando eu uso customizaçao personalizada

        for (Manga manga : mangas) {
            System.out.println(manga);
        }
        System.out.println(Collections.binarySearch(mangas, mangaToSearch, mangaByIdComparator));

        // Lembrar que ele nao esta usando equals para encontrar
//        Arrays.binarySearch(); << Tambem precisa ordenar antes
    }
}
