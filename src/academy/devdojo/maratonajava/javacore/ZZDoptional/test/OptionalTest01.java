package academy.devdojo.maratonajava.javacore.ZZDoptional.test;

import java.util.List;
import java.util.Optional;

public class OptionalTest01 {
    public static void main(String[] args) {
        // Optional é um objeto que vai encapsular outros objetos
        // Optional é uma classe que tem o intuito, falando de maneira simplista, "tentar evitar o NullPointerException",
        // mas não é para tentar evitar todos tipos de NullPointerException
        // O principal objeto é "ser muito fácil identificar que o retorno de um método pode ser opcional, ele pode não vir"
        // Ao invés de retornar null ele retorna optional
        // Optional<Aqui entra o tipo do que você quer retornar> o1 = aqui escreve o que você quer retornar
        // Optional.of() no caso abaixo, eu posso colocar qualquer String
        // Abaixo teremos algumas maneiras de criar Optional

        Optional<String> o1 = Optional.of("Aha uhu o DevDojo é foda."); // .of() quer que retorne um objeto NÃO NULO
        Optional<String> o2 = Optional.ofNullable(null); // Caso eu não sei se o objeto vai ser Nulo ou Não nulo
        Optional<String> o3 = Optional.empty(); // Caso eu queira criar um vazio
        // As 3 formas acima que podemos criar um Optional através da própria classe Optional
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);
        System.out.println("------------------");

        // Optional<String> nameOptional = Optional.ofNullable(findName("William")); // Foi usar o Nullable, porque talvez não tenha o nome procurado
        // Se for feito com o método que utiliza Optional, eu não preciso mais usar Optional.ofNullable acima, deixo apenas da maneira abaixo
        Optional<String> nameOptional = findName("William");
        System.out.println(nameOptional);
        String empty = nameOptional.orElse("EMPTY");// é como se fosse um if-else, se a String "william" não existir, ele vai retornar "EMPTY"
        // Se existir, ele retorna o nome procurado
        System.out.println(empty);
        nameOptional.ifPresent(s -> System.out.println(s.toUpperCase()));


        // String name = (findName("william"));
        // System.out.println(name.toUpperCase()); vai dar um NullPointerException,porque ele não conseguiu encontrar
        // para facilitar esse problema, foi criado o Optional

    }
    // O intuito da Oracle, era fazer o que eu irei passar abaixo
    // Dessa forma abaixo, como desenvolvedor, quando eu olhar o retorno "Optional", já me força a pensar no caso negativo
    // O que eu faço se encontrar e o que eu faço se eu não encontrar
    // Optional não é indicado para passagem de PARÂMETROS e também não utilizar como VARIÁVEL DE CLASSE ex: Optional<String> name;
    // Não criar atributos com Optional, usar apenas como RETORNO DOS MÉTODOS
    // porque não é uma classe serializavel
    private static Optional<String> findName(String name){
        List<String> list = List.of("William", "DevDojo");
        int i = list.indexOf(name);
        if(i != -1){
            return Optional.of(list.get(i));
        }
        return Optional.empty();
    }
//    private static String findName(String name){
//        List<String> list = List.of("William", "DevDojo");
//        int i = list.indexOf(name);
//        if(i != -1){
//            return list.get(i);
//        }
//        return null;
//    }

}
