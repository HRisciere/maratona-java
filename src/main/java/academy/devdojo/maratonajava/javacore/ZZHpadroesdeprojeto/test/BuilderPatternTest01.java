package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.Person;

public class BuilderPatternTest01 {
    public static void main(String[] args) {
        Person build = Person.PersonBuilder
                .aPerson()
                .firstName("Henrique")
                .lastName("Risciere")
                .username("ViradoNoJiraya")
                .email("henrique.risciere@devdojo.academy")
                .build();
        System.out.println(build);
//        Person build = new Person.PersonBuilder()
//                .firstName("Henrique")
//                .lastName("Risciere")
//                .username("ViradoNoJiraya")
//                .email("henrique.risciere@devdojo.academy")
//                .build();
//        System.out.println(build);
    }
}
