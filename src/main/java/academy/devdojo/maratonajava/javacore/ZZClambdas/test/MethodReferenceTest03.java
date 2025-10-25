package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class MethodReferenceTest03 {
    // Reference to an instance method of an arbitrary object of a particular type
    public static void main(String[] args) {
        // Referência a um método de instância de um objeto arbitrário de um tipo específico
        // Aqui eu vou utilizaar a classe, com o método Não Estático
        List<String> list = new ArrayList<>(List.of("Rimuru", "Veldora", "Kimimaro"));
        // Quero fazer a comparação desta lista, eu sei que a String implementa comparable, isso significa que eu vou ter o método compareTo
        // O método compareTo é um método não estátito , que eu posso chamar através do nome da classe
        list.sort(String::compareTo);
        System.out.println(list);
        // agora eu quero criar uma função que vai pegar um número em String e vai transformar em um número, um Integer
        Function<String, Integer> numStringToInteger = Integer::parseInt;
        Integer num = numStringToInteger.apply("10");
        System.out.println(num);
        // Agora eu quero verificar se tenho  um elemento dentro de uma lista, então eu vou precisar de 2 argumentos, a lista e o nome que eu estou procurando
        // Então eu uso  o BiPredicate
        BiPredicate<List<String>, String> checkName = List::contains;
        System.out.println(checkName.test(list, "Kimimaro"));
    }
}
