package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaArrayConversaoTest01 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        // Utilizou new Integer[0], porque se utilizar [0] o Java vai utilizar reflexion para descobrir o tamanho do
        // Array que ele precisa criar, também tem a opção de passar numeros.size()
        // Tem um artigo que fala que usando "new Integer[0]", o desempenho é mais rápido.
        // Passando um ArrayList para Array
        Integer[] listToArray = numeros.toArray(new Integer[0]);
        System.out.println(Arrays.toString(listToArray));
        System.out.println("-----------------------");

        Integer[] numerosArray = new Integer[3];
        numerosArray[0] = 1;
        numerosArray[1] = 2;
        numerosArray[2] = 3;

        // Transformando em uma lista
        // Primeira opção
        // Tomar cuidado ao usar o Arrays.asList, porque ele meio que cria um "link" com o
        // Integer[] numerosArray = new Integer[3];
        // o Arrays.asList é imutável, se estiver criando com um Array, ele vai manter o link com o Array Original
        List<Integer> arrayToList = Arrays.asList(numerosArray);
        // Utilizando a maneira abaixo, tanto o meu arrayToList quando o numerosArray, irá mudar
        arrayToList.set(0, 12);
        // Usando o método abaixo eu não consigo fazer alterações, vai dar um erro
//        arrayToList.add(19);
        System.out.println(Arrays.toString(numerosArray));
        System.out.println(arrayToList);

        System.out.println("------------");
        // Assim eu quebro o vínculo utilizando apenas o Arrays.asList(numerosArray);
        // A maneira abaixo eu consigo utilizar o Arrays.asList e consigo fazer alterações, como o add e não tenho erros
        List<Integer> numerosList = new ArrayList<>(Arrays.asList(numerosArray));
        numerosList.add(15);
        System.out.println(numerosList);

        // Outras maneiras de criar um ArrayList na mesma linha
        // o asList pede um varArgs
//        Arrays.asList(1, 2, 3, 4, 5); // Criando um arrayList de Integer
//        Arrays.asList("1", "2", "3", "4", "5"); // Criando um arrayList de String
//        List.of(1, 2, 3, 4, 5); // Criando um arrayList de Integer
//        List.of("1", "2", "3", "4", "5"); // Criando um arrayList de String
    }
}
