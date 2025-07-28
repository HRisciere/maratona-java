package academy.devdojo.maratonajava.javacore.Zgenerics.test;

abstract class Animal {
    public abstract void consulta();
}

class Cachorro extends Animal {

    @Override
    public void consulta() {
        System.out.println("Consultando doguinho");
    }
}

class Gato extends Animal {

    @Override
    public void consulta() {
        System.out.println("Consultando Gato");
    }
}

public class WildcardTest01 {
    public static void main(String[] args) {
        // Vou criar um método que se baseia de forma diferente de quando eu estou trabalhando com Arrays ou Listas
        // Da maneira feita abaixo, ele irá funcionar, porque o Java, especialmente para o Arrays em tempo de execução, qual é o tipo de objeto que você está trabalhando
        // Quando cria um Array de Cachorro, ele sabe que é um array de cachorro...
        // Ele também sabe o que tem dentro do Array em tempo de execução
        // Fazendo para Lista, não funciona assim, então eu vou precisar usar o Wildcard
        Cachorro[] cachorros = {new Cachorro(), new Cachorro()};
        Gato[] gatos = {new Gato(), new Gato()};
        printConsulta(cachorros);
        printConsulta(gatos);

        Animal[] animals = {new Gato(), new Cachorro()}; // Posso fazer isso, por causa do Polimorfismo
        Animal animal = new Gato(); // Posso fazer isso, por causa do Polimorfismo
        printConsulta(animals);

    }

    private static void printConsulta(Animal[] animals) {
        for (Animal animal : animals) {
            // Como o método é void, não pode ter "sout"
            animal.consulta();
        }
        // animals[1] = new Gato(); o código irá compilar normalmente, porque o Java sabe que o primeiro Array
        // que irá entrar no Array de Animal é um Array de Cachorro e não é um Array de Gato
    }
}
