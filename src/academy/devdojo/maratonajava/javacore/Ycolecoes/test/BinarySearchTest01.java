package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest01 {
    public static void main(String[] args) {
//     Outra forma para fazer busca em uma coleção, arrays, a diferença é que ele retorna a
//     posição que eu deveria inserir o elemento, caso ele não exista
//     O BinarySearch vai fazer uma busca na lista que eu passar e vai retornar para a gente
//     o índice caso ele encontre o que nós estamos procurando ou caso ele nao encontre, ele vai
//     retornar algo seguindo a regra abaixo
//     (-(ponto de inserção) -1)
//      index 0,1,2,3
//      value 0,2,3,4
        List<Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(0);
        numeros.add(4);
        numeros.add(3);

        // Precisa que a lista seja ORDENADA, pode definir que  as classes sejam ordenadas por
        // Wrappers ou definir por Comparator, se não o resultado não é confiável.
        Collections.sort(numeros);
        System.out.println(Collections.binarySearch(numeros, 0));
        System.out.println(Collections.binarySearch(numeros, -1));

    }
}
