package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.List;
import java.util.Optional;

public class StreamTest07 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        // reduce é uma operação final dos streams que vai possibilitar obter um resultado único a partir de uma sequencia de elementos
        // Ele vai repetidamente aplicar a operação aos elementos e no final vai obter um resultado
        // Fazendo da meneira abaixo, ele vai somando assim "1+2", depois "3+3", depois "6+4", até acabar...
        integers.stream().reduce((x, y) -> x + y)
                .ifPresent(System.out::println);// Retorna Optional porque não sabe, pode ser que a lista esteja vazia

        // Se quiser colocar um valor inicial, eu posso fazer abaixo, "identity" é para colocar um valor inicial
        // Como eu tenho um valor inicial, ele sabe que eu vou retornar um Integer de qualquer forma
        Integer reduce = integers.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduce);

        integers.stream().reduce(Integer::sum).ifPresent(System.out::println);


        Integer reduce1 = integers.stream().reduce(0, Integer::sum);
        System.out.println(reduce1);

        System.out.println("------------");

        integers.stream().reduce((x, y) -> x * y)
                .ifPresent(System.out::println);

        Integer reduce2 = integers.stream().reduce(1, (x, y) -> x * y);
        System.out.println(reduce2);

        System.out.println("------------");

        integers.stream().reduce((x, y) -> x > y ? x : y)
                .ifPresent(System.out::println);

        integers.stream().reduce(Integer::max).ifPresent(System.out::println);
        Integer reduce3 = integers.stream().reduce(0, Integer::max);
        System.out.println(reduce3);
    }
}
