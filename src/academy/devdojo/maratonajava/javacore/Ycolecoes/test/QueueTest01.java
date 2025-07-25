package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest01 {
    public static void main(String[] args) {
        // Mais uma coleção disponível, que tem por padrão a característica FIFO
        // É parecido com os "SortedSet, SorteMap...", porque a classe que foi definida precisa ser um Comparable ou usar Comparator
        Queue<String> fila = new PriorityQueue<>();
        fila.add("C");
        fila.add("A");
        fila.add("B");
        // A PriorityQueue vai manter a ordem, mas não necessariamente quando os objetos estiverem em memória, dentro do heap
        // Quando for tirar os valores vai ter de volta a ordem, a forma ordenada, a forma que foi definida no comparable ou no comparator
        for(String s : fila){
            System.out.println(s);
        }
        System.out.println("--------");

        System.out.println(fila);

        System.out.println("--------");
        // O certo é utilizar os seguintes métodos
//        fila.add(); Retorna uma exceção caso atingir a capacidade limite
//        fila.offer(); Retorna um booleano se não conseguir inserir em uma Queue com capacidade restrita
//        fila.peek(); Sempre mostra o primeiro elemento, sempre retorna o primeiro elemento
//        fila.poll(); Pega o primeiro elemento da fila e remove
//        fila.remove(); também remove  e retorna o primeiro elemento, tambem da para usar o remove passando um objeto, ele vai usar o equals para achar o objeto e remover
//        não é muito aconselhavel usar o remove, é melhor usar o poll, pois é para isso que ele foi feito
        while (!fila.isEmpty()){
            System.out.println(fila.poll());
        }
        // Enquanto estava na memória, na heap, ele não está necessariamente em ordem
        // No momento em que começamos a remover os elementos, eles ficaram ordenados, na ordem que o Comparable ou Comparator indicou
        // Funcionou muito bem para String
    }
}
