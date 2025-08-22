package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest02 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game no life", 2.99),
            new LightNovel("Fullmetal Alchemist", 5.99),
            new LightNovel("Kumo desuga", 1.99),
            new LightNovel("Monogatari", 4.00)
    ));

    public static void main(String[] args) {
        // Lembrando que o "map" faz o mapeamento de um atributo específico de uma classe
        // o map aceita uma "function", ou seja, ele recebe um "T" e retorna um "R", ou seja, se ele recebe um LightNovel, ele pode retornar o título do LightNovel
        // Maioria das coleções tem um método chamado "stream"
        // Eu vou trabalhar com essa sequência de elementos
        // O que  que eu vou fazer com essa sequência? Tem várias "operações", ou elas são intermediária ou elas são finais
        // Ação Intermediária -> Ela retorna um próprio "stream", você pode encadear ações, você quer filtrar, ordenar, limitar...Tudo isso retorna outro stream
        // Geralmente trabalha com stream até chegar no final
        // Nesse  caso, depois do map eu preciso de uma operação "final", para fechar o stream e ele vai retornar uma coleção
        // Uma das operações finais é o "collect", ou seja, eu ordenei, filtrei, limitei, peguei somente o título e agora eu vou falar "Tire do tempo e mova para o espaço"
        // Dentro do Collect eu falo como eu quero retornar, nesse caso eu vou usar o  "Collectors.toList()", ele vai retornar uma List<>
        List<String> titles = lightNovels.stream()
                .sorted(Comparator.comparing(LightNovel::getTitle))
                .filter(ln -> ln.getPrice() <= 4).limit(3)
                .map(LightNovel::getTitle)
                .collect(Collectors.toList());

        System.out.println(titles);
    }
}
