package academy.devdojo.maratonajava.javacore.ZZDoptional.repositorio;

import academy.devdojo.maratonajava.javacore.ZZDoptional.dominio.Manga;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MangaRepository {
    // Abaixo eu vou simular uma lista de Mangas
    private static List<Manga> mangas = List.of(new Manga(1, "Boku no hero",50), new Manga(2, "Overlod",25));
    // Criar 2 métodos, 1 para achar por title e outro para achar por id
    // Já tenho conhecimento para usar programação funcional, lembrar de usar Predicate, para criar um método
    // Aonde o findByID ou findByTitle vai ser bem simplificado, ou seja, eu tenho um método que vai aceitar o comportamento via parâmetro
    // E não vou usar a lógica de negócio

    // Abaixo é uma maneira não muito legal, porque eu vou precisar criar outro método para encontrar o "id"
//    private static Optional<Manga> findByTitle(String title){
//        Manga found = null;
//        for (Manga manga : mangas) {
//            if(manga.getTitle().equals(title)){
//                found = manga;
//            }
//        }
//        return Optional.ofNullable(found);
//    }

    public MangaRepository() {
    }

    public static Optional<Manga> findById(Integer id){
        return findBy(manga -> manga.getId().equals(id));
    }

    public static Optional<Manga> findByTitle(String title){
        return findBy(manga -> manga.getTitle().equals(title));
    }


    private static Optional<Manga> findBy(Predicate<Manga> predicate){
        Manga found = null;
        for (Manga manga : mangas) {
            if(predicate.test(manga)){
                found = manga;
            }
        }
        return Optional.ofNullable(found);
    }
}
