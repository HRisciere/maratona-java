package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapTest01 {
    public static void main(String[] args) {
        // No NavigableSet era obrigado a usar a implementar Comparable ou passar um Comparator
        // No NavigableMap é a mesma coisa, mas para Chave (key)
        NavigableMap<String, String> map = new TreeMap<>();
        map.put("A", "Letra A");
        map.put("D", "Letra D");
        map.put("B", "Letra B");
        map.put("C", "Letra C");
        map.put("E", "Letra E");

        // Basicamente, da mesma forma que o TreeSet organa, o TreeMap também ordena
        // Lembrando que a ordenação do TreeMap é feita pela chave, não precisa implementar o Comparable ou Comparator para o valor

        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : "+ entry.getValue());
        }

        // System.out.println(map.headMap("C"));  retorna todo mundo que está abaixo da letra "C"
        // Se fosse ordenado por preço, seria todo mundo que está abaixo do preço
        // Lembrando que o headMap está linkado com a lista acima "map"

        System.out.println(map.headMap("C").remove("A"));
        System.out.println(map);

        // Caso eu queira incluir a chave que eu estou pasando, ou seja, também irá contar a letra "C", de "C" para baixo
        System.out.println(map.headMap("C", true));
        System.out.println(map);

        // Métodos que são praticamente os mesmo do NavigableSet

        // lower <
        // floor <=
        // higher >
        // ceiling >=

        System.out.println(map.lowerKey("C"));
        System.out.println(map.floorKey("C"));
        System.out.println(map.higherKey("C"));
        System.out.println(map.ceilingKey("C"));
    }
}
