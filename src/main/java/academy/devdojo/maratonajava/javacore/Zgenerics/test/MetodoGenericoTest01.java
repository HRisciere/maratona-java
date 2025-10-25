package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;

import java.util.List;

public class MetodoGenericoTest01 {
    public static void main(String[] args) {
        criarArrayComUmObjeto(new Barco("Canoa"));
        List<Barco> barcoList = criarArrayComUmObjeto2(new Barco("Canoa Marota"));
        System.out.println(barcoList);

//        Não funciona, porque Barco não é um Comparable
//        List<T> barcoList2 = criarArrayComUmObjeto3(new Barco("Canoa Marota 2"));
    }

    private static <T> void criarArrayComUmObjeto(T t){
        List<T> list = List.of(t);
        System.out.println(list);
    }
    // Caso eu queira retornar a lista
    private static <T> List<T> criarArrayComUmObjeto2(T t){
        return List.of(t);
    }
    // Caso eu queira receber apenas objetos do tipo Comparable
    // Se o objeto que eu passaar não for um Comparable, ele não aceita
    // Precisa passar no "Teste é um Comparable"
    private static <T extends Comparable> List<T> criarArrayComUmObjeto3(T t){
        return List.of(t);
    }
    private static <T extends Comparable<T>> List<T> criarArrayComUmObjeto4(T t){
        return List.of(t);
    }
}
