package academy.devdojo.maratonajava.javacore.ZZBcomportamento.interfaces;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Car;

@FunctionalInterface
public interface CarPredicate {
    boolean test(Car car);
    // qualquer interface funcional pode ser utilizado lambdas
    // o próprio método da interface funcional diz como a lambda vai funcionar
    // lambda são anônimas, as lambdas são chamadas de funções (function), porque elas não estão atreladas a nenhuma classe
    // objetivo é fazer o código ser mais conciso, o fato da lambda reduzir o código por si só, já fiz isso
    // Para lambda funcionar a interface que eu estou trabalhando seja uma interface funcional
    // Interface funcional é uma interface que eu tenho APENAS 1 MÉTODO ABSTRATO, eu posso ter outros métodos usando  com corpo, usando "default"
    // Neste método, ele diz tudo de como a lambda irá se comportar, a lambda tem o parâmetro e o corpo
    // (parametro) -> <expressão>
    // Function Descriptor, diz como a lambda tem que se comportar
    // (Car car ou apenas car ) -> nesse caso a expressão precisa retornar um boolean, ex: car.getColor().equals("green");
}
