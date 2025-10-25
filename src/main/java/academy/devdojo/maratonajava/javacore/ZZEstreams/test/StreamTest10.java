package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class StreamTest10 {
    public static void main(String[] args) {
        // Tem 2 formas de gerar stream de "maneiras infinitas"
        // seed é o valor inicial ele é do tipo <T>, UnaryOperator (é uma classe), é um método que retorna o que passou como argumento

        Stream.iterate(1, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        // Série de fibonacci
        // 0,1,1,2,3,5,8,13,21,34

        // Faz de conta que eu estou utilizando array
        // 0 (índice 0), 1 (índice 1)
        // Quero fazer agrupando, é apenas um exemplo
        // (0,1) (1,1) (1,2) (2,3) (3,5) (5,8)
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .forEach(a -> System.out.println(Arrays.toString(a)));

        // Pegando uma posição específica
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .map(a -> a[0])
                .forEach(System.out::println);

        // Ele não aceita um UnaryOperator
        // Quero gerar 100 número aleatórios
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Stream.generate(() -> random.nextInt(1, 500))
                .limit(90)
                .forEach(System.out::println);
    }
}
