package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

class Animal{
    public void walk(){
        System.out.println("Animal walking");
    }
}

public class AnonymousClassesTest01 {
    public static void main(String[] args) {
        // Classes Anônimas são classes que irão existir por um determinado período de tempo
        // Classes Anônimas são feitas para utilizar em um determinado ponto específico
        // Não pode ser reutilizada em nenhum outro lugar
        Animal animal = new Animal(){
            @Override
            public void walk() {
                System.out.println("Walking in the shadows");
            }
        };
        animal.walk();
    }
}
