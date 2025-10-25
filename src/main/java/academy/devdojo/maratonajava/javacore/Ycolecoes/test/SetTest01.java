package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.HashSet;
import java.util.Set;

public class SetTest01 {
    public static void main(String[] args) {
        Set<Manga> mangas = new HashSet<>();
        // Set<Manga> mangas = new LinkedHashSet<>(); Uso isso caso eu queira manter a ordem de inserção e ainda continua utilizando um Hash

        // Set é uma interface, é uma Collection
        // Set não permite elementos duplicados dentro de uma coleção
        // Hashset tem "Hash" no nome, essa é uma coleção aonde permite apenas elementos únicos e eles serão organizados pelo hash, ou seja,
        // não tem como garantir como esses caras estarão dentro da nossa lista, porque ele pode se reajustar baseado no que for inserido
        mangas.add(new Manga(1L, "Dragon Ball Z", 19.9, 0));
        mangas.add(new Manga(2L, "Attack on titan", 11.20, 2));
        mangas.add(new Manga(4L, "Pokemon", 3.2, 0));
        mangas.add(new Manga(3L, "Berserk", 9.5, 5));
        mangas.add(new Manga(5L, "Hellsing Ultimate", 2.99, 0));
        // mangas.getClass() não existe índice, porque o Set não é indexado, precisa navegar sobre a coleção
        // Olhar a classe Manga e o hashCode
        // Se eu adicionar outrao Dragon Ball Z, ele não vai entrar, porque antes de inserir o Java vai checar
        // Através do método equals, por isso é importante ter o método equals sobrescrito na minha classe

        for(Manga manga : mangas){
            System.out.println(manga);
        }

        // outra maneira de usar
        // mangas.forEach(System.out::println);
    }
}
