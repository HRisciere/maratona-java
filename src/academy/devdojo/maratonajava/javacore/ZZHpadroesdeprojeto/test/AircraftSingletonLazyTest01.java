package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.AircraftSingletonLazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AircraftSingletonLazyTest01 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        bookSeat("1A");
        bookSeat("1A");
        System.out.println(AircraftSingletonLazy.getINSTANCE());
        System.out.println(AircraftSingletonLazy.getINSTANCE());
        // Java tem um conceito chamado de "Reflection", é muito utilizado por Frameworks, que basicamente utiliza as propriedades / metadados da sua classe
        // para fazer as coisas sem saber exatamente o que existe lá dentro
        // Posso por exemplo, fazer atributos que são privados virarem públicos, ou pegar todos os atributos que estão listados na sua classe...
        // É interessante mas afeta a performance de maneira absurda no meu programa
        // Posso fazer o construtor ficar público, por exemplo
        // Na vida real, em um pull request, isso não acontece
        // Tem uma forma para evitar este tipo de problema, utilizarei enumerações para criação de singletons
        // O problema ocorre tanto do Singleton Eager quanto no Lazy
        Constructor<AircraftSingletonLazy> constructor = AircraftSingletonLazy.class.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        AircraftSingletonLazy aircraftSingletonLazy = constructor.newInstance("787-900");
        System.out.println(aircraftSingletonLazy);
    }

    private static void bookSeat(String seat) {
        System.out.println(AircraftSingletonLazy.getINSTANCE());
        AircraftSingletonLazy aircraft = AircraftSingletonLazy.getINSTANCE();
        System.out.println(aircraft.bookSeat(seat));
    }
}
