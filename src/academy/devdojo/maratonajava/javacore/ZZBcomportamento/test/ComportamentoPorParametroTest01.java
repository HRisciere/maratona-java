package academy.devdojo.maratonajava.javacore.ZZBcomportamento.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Car;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest01 {
    private static List<Car> cars = List.of(new Car("green", 2011), new Car("black", 1998), new Car("red", 2019));

    public static void main(String[] args) {
        // lembrar de sobrescrever o toString da classe "Car"
        // Aqui eu vou simular algumas coisas que acontecem na vida real, então faz de conta que o cliente pediu uma alteração
        // Agora o cliente quer filtrar também pela cor "red"
        // Agora pediu para filtrar pelo "year"
        // Praticamente só uma pequena parte do meu código está sendo alterado que é o "if", na verdade foi só a condição
        // A pergunta é: E se a gente pudessa passar essa condição como parâmetro?
        System.out.println(filterGreenCar(cars));
        System.out.println(filterByColor(cars, "red"));
        System.out.println(filterByYearBefore(cars, 2015));

    }

    private static List<Car> filterGreenCar(List<Car> cars) {
        List<Car> filteredCar = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equals("green")) {
                filteredCar.add(car);
            }
        }
        return filteredCar;
    }
    private static List<Car> filterByColor(List<Car> cars, String color) {
        List<Car> filteredCar = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equals(color)) {
                filteredCar.add(car);
            }
        }
        return filteredCar;
    }
    private static List<Car> filterByYearBefore(List<Car> cars, int year) {
        List<Car> filteredCar = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() < year) {
                filteredCar.add(car);
            }
        }
        return filteredCar;
    }
}
