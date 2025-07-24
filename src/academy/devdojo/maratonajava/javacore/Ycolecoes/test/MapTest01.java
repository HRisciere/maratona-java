package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest01 {
    public static void main(String[] args) {
        // Map<K, V>  key, value / chave, valor
        // A chave é única, o valor não
        // Para cada chave, tem um valor associado
        // Como tem hash no nome, ele vai ordenar as CHAVES com base no hash e precisa do equals e hashcode implementado
        // No Map não pode ter chaves duplicadas
        // Se colocar duas chaves, ele vai sobrescrever a chave anterior
        // No Set ele não deixa inserir, no Map ele sobrescreve

        Map<String, String> map = new HashMap<>();
        // Map<String, String> map = new LinkedHashMap<>(); Caso eu queira manter a ordem de inserção e continuar utilizando hash
        map.put("telkado", "teclado");
        map.put("mouze", "mouse");
        map.put("vc", "você");
        map.putIfAbsent("vc2", "você2"); // Só adiciona se a chave não existir

//        System.out.println(map);
        // Tem 2 opções, fazer a navegação via chave ou fazer via valor
        // Imprimindo todas as chaves
        // A partir desse for eu posso pegar o valor, porque toda a chave está associada a algum valor
        // Navegando via chave
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }

        System.out.println("------------------");

        // Navegando via valor
        for (String value : map.values()) {
            System.out.println(value);
        }

        System.out.println("----------------");

        //Pegando chave e valor ao mesmo tempo
        for (Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
