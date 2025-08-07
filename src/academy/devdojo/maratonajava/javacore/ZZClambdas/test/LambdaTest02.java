package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaTest02 {
    public static void main(String[] args) {
        // Function é uma Interface Funcional, o tipo T é o que você vai receber e o R é o que vai voltar, pode ser qualquer coisa
        //Quando você tem que  transformar alguma coisa e retornar alguma coisa completamente diferente é chamado de "map"
        // <T, R> (o que eu quero retornar, nesse caso uma lista de R) (nome do método, nesse caso é "map", o que eu quero receber, quero uma lista de T
        //  list, parâmetro que vai receber a expressão, que é uma função Function <T, R> function)
        // Você pode passar um tipo como parâmetro e o retorno ser do mesmo tipo por exemplo (Passar String como parâmetro e o retorno ser uma String)
        List<String> strings = List.of("Vegeta", "Madara");
        List<Integer> integers = map(strings, s -> s.length());
        List<String> map = map(strings, s -> s.toUpperCase());
        System.out.println(integers);
        System.out.println(map);
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for(T e : list){
            R r = function.apply(e);
            result.add(r);
        }
        return result;
    }
}
