package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Agora eu quero ordenar por ID, em um específico ponto do meu software, então eu não vou utilizar o comparable em
// uma classe, igual foi feito na classe Manga, eu vou utilizar o COMPARATOR. Eu preciso ter um objeto que passa no
// teste "é um, COMPARATOR"
// Tenho que falar em qual classe eu estou fazendo a comparação então eu coloco Comparator<Manga> e faço a sobrescrita
// do commpare.

class MangaByIdComparator implements Comparator<Manga> {

    @Override
    public int compare(Manga manga1, Manga manga2) {
//        Como eu não estou no OBJETO manga, eu estou no OBJETO MangaByIdComparator, então eu tenho acesso a manga1 e
//        manga2. Quem vai mandar o manga1 e manga2? O próprio JAVA.
//        Só sei que eu quero ordernar por ID, então eu faço o que eu mesmo coloquei abaixo
        return manga1.getId().compareTo(manga2.getId());
    }
}


public class MangaSortTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(1L, "Dragon Ball Z", 19.9));
        mangas.add(new Manga(2L, "Attack on titan", 11.20));
        mangas.add(new Manga(4L, "Pokemon", 3.2));
        mangas.add(new Manga(3L, "Berserk", 9.5));
        mangas.add(new Manga(5L, "Hellsing Ultimate", 2.99));
        for (Manga manga : mangas) {
            System.out.println(manga);
        }
        Collections.sort(mangas);
        System.out.println("-------------------");
        for (Manga manga : mangas) {
            System.out.println(manga);
        }


//      Fazendo a comparação por ID, esse método é sobrecarregado
//      Quem vai se encarregar de chamar os objetos é o próprio Java
//      Collections.sort(mangas, new MangaByIdComparator()); Posso fazer desta mandeira ou utilizando a de baixo
//      Tem maneiras mais simples de fazer isso, utilizando classes anônimas, mas ainda não foi ensinado
        mangas.sort(new MangaByIdComparator()); // Neste caso a própria LISTA mangas está fazendo a ordenação
        System.out.println("-------------------");
        for (Manga manga : mangas) {
            System.out.println(manga);
        }
    }
}
