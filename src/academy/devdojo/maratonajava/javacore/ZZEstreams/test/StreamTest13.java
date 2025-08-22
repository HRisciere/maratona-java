package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Category;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Promotion;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest13 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99, Category.FANTASY),
            new LightNovel("Overlord", 10.99, Category.FANTASY),
            new LightNovel("Violet Evergarden", 5.99, Category.DRAMA),
            new LightNovel("No Game no life", 2.99, Category.FANTASY),
            new LightNovel("Fullmetal Alchemist", 5.99, Category.FANTASY),
            new LightNovel("Kumo desuga", 1.99, Category.FANTASY),
            new LightNovel("Kumo desuga", 1.99, Category.FANTASY),
            new LightNovel("Monogatari", 4.00, Category.ROMANCE)
    ));

    public static void main(String[] args) {
        // Fazer o seguinte agrupamento, se o preço for menor do que 6 ele é UNDER_PROMOTION, se for maior é o NORMAL_PRICE
        // O groupingBy carregado aceita outros groupingBy, então ele aceita outros coletores

        Map<Promotion, List<LightNovel>> collect = lightNovels
                .stream()
                .collect(Collectors.groupingBy(ln -> ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE));
        System.out.println(collect);
        System.out.println("--------------------");

        // Fazer agrupamento pela Category e também pela Promotion
        // Map<Category, Map<Promotion, List<LightNovel>>>
        // A primeira parte está agrupando por Category e a segunda é por Promotion
        // Category como chave geral e depois um agrupamento de promoção e lista de lightnovels
        // Não é aconselhável fazer isso, pois ele fica muito grande, é melhor jogar em um banco de dados
        // O que eu posso fazer para diminuir é importar estaticamente
        // Ctrl + Alt + M >> cria um método, é um "extract", depois eu posso usar um Method Reference, aí ele fica mais legível
        // Refactor > Extract > Method
        Map<Category, Map<Promotion, List<LightNovel>>> collect1 = lightNovels
                .stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.groupingBy(ln -> ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE
                )));
        System.out.println(collect1);

    }
}
