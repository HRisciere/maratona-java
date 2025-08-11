package academy.devdojo.maratonajava.javacore.ZZDoptional.test;

import academy.devdojo.maratonajava.javacore.ZZDoptional.dominio.Manga;
import academy.devdojo.maratonajava.javacore.ZZDoptional.repositorio.MangaRepository;

import java.util.Optional;

public class OptionalTest02 {
    public static void main(String[] args) {
        Optional<Manga> mangaByTitle = MangaRepository.findByTitle("Boku no hero");
        mangaByTitle.ifPresent(manga -> manga.setTitle("Boku no hero 2"));
        System.out.println(mangaByTitle);

        // orElseThrow irá lança uma exceção
        // Ele retornou um Manga e não um Optional, porque como eu tenho o orElseThrow, ou ele vai retornar um Manga, ou lança uma Exceção
        // Ele não retorna um Optional, ele vai extrair o objeto do Wrapper que é o Optional
        Manga mangaById = MangaRepository.findById(2).orElseThrow(IllegalArgumentException::new);
        System.out.println(mangaById);

        // MangaRepository.findByTitle("Drifters").orElse(new Manga(3, "Drifters", 20)); Mesma coisa do de baixo
        // O de baixo eu usei lambda, por causa do supplier
        Manga newManga = MangaRepository.findByTitle("Drifters").orElseGet(() -> new Manga(3, "Drifters", 20));
        System.out.println(newManga);
    }
}
