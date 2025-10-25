package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Smartphone;

public class EqualsTest01 {
    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("1ABC1", "iPhone");
        Smartphone s2 = new Smartphone("1ABC1", "iPhone");
//        Smartphone s2 = s1; // Aqui o s2 está fazendo referência a s1
        System.out.println(s1.equals(s2)); // Comparando se o valor em memória é igual ao objeto
        // Está comparando se a variável de referência s1 está fazendo referência ao mesmo objeto que s2
        // Todas as vezes que eu quiser comparar dois objetos do tipo smartphone voce precisa levar emm consideração
        // o serialNumber deles
        // Todos os objetos obrigatoriamente passam no teste "é um object", significa que temos acesso a sobrescrita
        // do método equals
        // ATENÇÃO ********* Lembrando que eu fiz uma SOBRESCRITA NO MÉTODO EQUALS, lembrando que estou comparando o serialNumber

    }
}
