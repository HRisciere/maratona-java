package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import java.util.List;
import java.util.function.Consumer;

public class LambdaTest01 {
    public static void main(String[] args) {
        // Uso da Interface Funcional "consumer", parecida dom Predicate
        // Ele executa uma operação e não retorna nada, é void
        List<String> strings = List.of("William", "Suane", "Goku", "Ichigo");
        List<Integer> integers = List.of(1, 2, 3, 4, 5);

        forEach(strings,s -> System.out.println(s));
        forEach(integers,i -> System.out.println(i));

//        forEach(strings, (String s) -> System.out.println(s));
//        forEach(integers, (Integer i) -> System.out.println(i));

    }
    private static <T> void forEach(List<T> list, Consumer<T> consumer){
        for (T e : list) {
            // vou definir o comportamento através da lambda, também poderia fazer através de uma classe anônima
            consumer.accept(e);
        }
    }
}
