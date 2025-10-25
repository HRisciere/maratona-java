package academy.devdojo.maratonajava.javacore.ZZBcomportamento.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ComportamentoPorParametroTest02 {
    private static List<Car> cars = List.of(new Car("green", 2011), new Car("black", 1998), new Car("red", 2019));

    public static void main(String[] args) {
        // chamei o método de "filter", porque agora a responsabilidade da regra de negócio, será enviada pela Interface "CarPredicate"
        // A INTERFACE não tem comportamento, o comportamento será da subclasse que eu criei ( A classe anônima )

//        List<Car> greenCars = filter(cars, new CarPredicate() {
//            @Override
//            public boolean test(Car car) {
//                return car.getColor().equals("green");
//            }
//        });

        // A meneira abaixo é utilizando lambda, é a mesma coisa da forma de cima, só que melhor
        List<Car> greenCars = filter(cars, car -> car.getColor().equals("green"));
        List<Car> redCars = filter(cars, car -> car.getColor().equals("red"));
        List<Car> yearBeforeCars = filter(cars, car -> car.getYear() < 2015);
        // O método é 1 só, abaixo eu irei passar o carro por ano, só preciso fazer um pequeno ajuste na lógica "car.getColor().equals("red")"
        // Já existe uma interface no Java que já faz o "Predicate"
        // Fiz o método "filter2" usando o Predicate já existente no java
        // Agora vou fazer um método para filtrar qualquer coisa, um método bem genérico


        System.out.println(greenCars);
        System.out.println(redCars);
        System.out.println(yearBeforeCars);
    }

//    private static List<Car> filter(List<Car> cars, CarPredicate carPredicate) {
//        List<Car> filteredCar = new ArrayList<>();
//        for (Car car : cars) {
//            // O teste ainda não foi definido, irei definir o teste através de uma classe anônima
//            if (carPredicate.test(car)) {
//                filteredCar.add(car);
//            }
//        }
//        return filteredCar;
//    }

    private static List<Car> filter(List<Car> cars, Predicate<Car> carPredicate) {
        List<Car> filteredCar = new ArrayList<>();
        for (Car car : cars) {
            // O teste ainda não foi definido, irei definir o teste através de uma classe anônima
            if (carPredicate.test(car)) {
                filteredCar.add(car);
            }
        }
        return filteredCar;
    }
}
