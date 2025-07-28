package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest01 {
    public static void main(String[] args) {
        // Antes era feito assim, porque não existia generics, então você podia colocar o que você quisesse dentro da Lista
        // O problema começava quando era necessário manipular
        // O Java, durante todas as atualizações, tenta manter a compatibilidade com todas as vesões anteriores
        // Então a solução foi utilizar em tempo de compilação, então Generics é algo que foi adicionado em tempo de compilação
        // Quando o Java manda o bytecode para a JVM ele envia assim: List lista = new ArrayList();
        // Dentro da JVM você não sabe o que tem dentro da lista, por isso que é feito o check em tempo de compilação e com isso mantém a compatibilidade
        // Esse conceito é chamado de "Type erasure", porque ele está apagando o tipo depois que o código é compilado
        // List<String> lista = new ArrayList<>();
        List lista = new ArrayList();
        lista.add("Midoriya");
        lista.add(123L);
        lista.add(new Consumidor("Goku"));

        for (Object o : lista) {
            System.out.println(o);
        }
        System.out.println("-----------");

        for (Object o : lista) {
            if (o instanceof String){
                System.out.println(o);
            }
            if (o instanceof Long){
                System.out.println(o);
            }
            if (o instanceof Consumidor){
                Consumidor c = (Consumidor) o;
                System.out.println(o);
            }
        }
        // Abaixo irei mostrar o que pode acontecer
        // O add irá funcionar normalmente, mas quando iterar com o for, ele vai dar problema
        // Não tem garantia que se fizer um código sem generics ele irá falhar, então o uso de generics é importante
        // Ele irá fazer a validação em tempo de compilação, ou seja, ele não deixa o código passar para a JVM, se não tomar cuidado e colocar o tipo incorretamente
        // Olhar a aula 183 - Generics pt 01 - Introdução
        add(lista, new Consumidor("Midoriya"));
        for (Object o : lista) {
            System.out.println(o);
        }

    }
    private static void add(List lista, Consumidor consumidor){
        lista.add(consumidor);
    }
}
