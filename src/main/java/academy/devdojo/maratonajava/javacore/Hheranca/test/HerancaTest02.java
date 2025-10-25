package academy.devdojo.maratonajava.javacore.Hheranca.test;

import academy.devdojo.maratonajava.javacore.Hheranca.dominio.Funcionario;

public class HerancaTest02 {
    // 0 - Bloco de inicialização estático da superclasse é executado quando a JVM carregar a classe pai
    // 1 - Bloco de inicialização estático da subclasse é executado quando a JVM carregar a classe filha
    // 2 - Quando está criando um objeto, primeiro é alocado espaço em memória para o objeto da superclasse
    // 3 - Em seguida cada atributo da superclasse é criado e inicializado com valores default ou o que for passado
    // 4 - O bloco de inicialização da superclasse é executado na ordem em que aparece
    // 5 - Em seguida o construtor da superclasse é executado

    // 6 - Quando está criando um objeto, primeiro é alocado espaço em memória para o objeto da sub classe
    // 7 - Em seguida cada atributo da subclasse é criado e inicializado com valores default ou o que for passado
    // 8 - O bloco de inicialização da subclasse é executado na ordem em que aparece
    // 9 - Em seguida o construtor da subclasse é executado
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Jiraya");
    }
}
