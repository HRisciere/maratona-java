package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;
import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Smartphone;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

class SmartphoneMarcaComparator implements Comparator<Smartphone>{

    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o1.getMarca().compareTo(o2.getMarca());
    }
}

class MangaPrecoComparator implements Comparator<Manga>{

    @Override
    public int compare(Manga o1, Manga o2) {
        return Double.compare(o1.getPreco(), o2.getPreco());
    }
}
public class NavigableSetTest01 {
    public static void main(String[] args) {
        // NavigableSet não vai deixar entar duplicata, por causa do equals
        // Basicamente adiciona alguns métodos para pegar elementos baseados em posições já existentes
        // Uma das classes que implementa a interface NavigableSet é a TreeSet
        // Geralmente as classes que aparecem com "Tree" trabalham diretamente linkado a parte de ter um "sort"
        // Elas precisam que as classes que eu estou adicionando dentro da coleção Tree, precisam que elas tem um Comparable ou Comparator
        // O TreeSet não segue o contrato do "Set", ele não utiliza o equals para verificar se dois elementos são iguais
        // Então eu posso ter dois objetos com o mesmo "id" nesse exemplo, mas com nomes diferentes, tudo depende de como eu fiz o compareTo
        NavigableSet<Smartphone> set = new TreeSet<>(new SmartphoneMarcaComparator());
        Smartphone smartphone = new Smartphone("123", "Nokia");
        set.add(smartphone);
//        System.out.println(set);

        NavigableSet<Manga> mangas = new TreeSet<>(new MangaPrecoComparator());
        mangas.add(new Manga(1L, "Dragon Ball Z", 19.9, 0));
        mangas.add(new Manga(2L, "Attack on titan", 11.20, 2));
        mangas.add(new Manga(4L, "Pokemon", 3.2, 0));
        mangas.add(new Manga(3L, "Berserk", 9.5, 5));
        mangas.add(new Manga(5L, "Hellsing Ultimate", 2.99, 0));
        mangas.add(new Manga(10L, "Aaragon", 2.99, 0));
        mangas.add(new Manga(1111L, "Aaragonasas", 2.99, 0));
        // Lembrando que ele está imprimindo em ordem alfabética do nome, usando o compareTo da classe Manga
        // O TreeSet automaticamente vai fazer a organização baseado no meu compareTo
//        for (Manga manga : mangas) {
//            System.out.println(manga);
//        }

        // Utilizando os métodos do NavigableSet, lembrando que os mangas estão sendo organizaados em ordem alfabética, de acordo com o compareTo
        // Vou ordenar em ordem alfabética inversa
//        for (Manga manga : mangas.descendingSet()) {
//            System.out.println(manga);
//        }

        // Lembrando, se o preço for o mesmo, ele não vai inserir
        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        Manga yuyu = new Manga(21L, "Yuyu Hakusho", 3.2, 5);

        // Métodos para comparações

        // lower, vai trazer o que é imediatamente menor  <
        // floor, retorna o mesmo elemento ou o imediato logo abaixo dele <=
        // higher, traz o primeiro maior >
        // ceiling, retorna o mesmo elemento ou o imediato logo acima dele >=
        System.out.println("-----------------");
        System.out.println(mangas.lower(yuyu));
        System.out.println(mangas.floor(yuyu));
        System.out.println(mangas.higher(yuyu));
        System.out.println(mangas.ceiling(yuyu));

        System.out.println(mangas.size());
        System.out.println(mangas.pollFirst()); // Retorna e remove o primeiro elemento da lista
        System.out.println(mangas.size());
        System.out.println("------------------");
        System.out.println(mangas.size());
        System.out.println(mangas.pollLast()); // Retorna e remove o último elemento da lista
        System.out.println(mangas.size());
    }
}
