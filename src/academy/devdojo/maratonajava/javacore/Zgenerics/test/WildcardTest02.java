package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import java.util.ArrayList;
import java.util.List;

public class WildcardTest02 {
    public static void main(String[] args) {
        // Vou criar um método que se baseia de forma diferente de quando eu estou trabalhando com Arrays ou Listas
        // Da maneira feita abaixo, ele irá funcionar, porque o Java, especialmente para o Arrays em tempo de execução, qual é o tipo de objeto que você está trabalhando
        // Quando cria um Array de Cachorro, ele sabe que é um array de cachorro...
        // Ele também sabe o que tem dentro do Array em tempo de execução
        // Fazendo para Lista, não funciona assim, então eu vou precisar usar o Wildcard

        // Aqui eu irei trabalhar com Listas
        List<Cachorro> cachorros = List.of(new Cachorro(), new Cachorro());
        List<Gato> gatos = List.of(new Gato(), new Gato());
        printConsulta(cachorros);
        printConsulta(gatos);
        List<Animal> animals = new ArrayList<>();
        printConsultaAnimal(animals);
        printConsultaAnimal(cachorros);

        //Type erasure
        // printConsulta(cachorros); Vai acontecer um erro de compilação, ele existe porque uma vez que o código é compilado, o Java não sabe que tipo de lista você está passando
        // O Java não sabe, depois que compila, que o que eu estou passando no método é uma lista de cachorros e que ela pode ser referenciada por uma lista de Animais
        // Quando se está trabalhando com Listas o TIPO Da Lista, quando está passando através de parâmetros, o objeto precisa passar exatamente o que foi definido na Sintaxe, por isso existe o Wildcard


    }

    // Type erasure
    // Independente se é uma classe ou interface, sempre será "extends"
//    private static void printConsulta(List<Animal> animals) {
//        for (Animal animal : animals) {
//            // Como o método é void, não pode ter "sout"
//            animal.consulta();
//        }
//        // animals[1] = new Gato(); o código irá compilar normalmente, porque o Java sabe que o primeiro Array
//        // que irá entrar no Array de Animal é um Array de Cachorro e não é um Array de Gato
//        // animals.add(new Cachorro()); Consigo adicionar dentro da lista de animais, objetos independentes, que sejam filho de Animal
//        // Animal a = new Cachorro(); é como se eu estivesse fazendo isso aqui, eu tenho um Animal criando referência para um objeto do tipo cachorro
//    }

    // O Wildcard é uma "?"
    // Quero aceitar qualquer tipo de lista que aceite que seja um Animal que "extends Animal"
    // Ao fazer isso, você está assinando um contrato, não posso adicionar elementos nesta lista
    // Fazendo da meneira abaixo, é apenas para leitura
    // Aqui eu estou falando assim "Eu posso receber qualquer ANIMAL ou qualquer um que seja FILHO
    private static void printConsulta(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            // Como o método é void, não pode ter "sout"
            animal.consulta();
        }
        // faz de conta que eu faça isso dentro do método animals.add(new Cachorro());
        // Mas nos parâmetros eu passo uma lista de Gato
        // List<? extends Animal> lista = new ArrayList<Gato>();
        // Eu estou adicionando um Cachorro em uma lista de Gato, isso não pode
        // Então o JAVA não permite fazer isso usando o List<? extends Animal> animals
        // Eu apenas posso fazer consultas
        // Por quê? Porque o compilador não tem certeza de que a lista aceita Cachorro.
        // Ela foi declarada como "? extends Animal", e pode ser, por exemplo, uma lista de Gato. Se fosse, adicionar um Cachorro violaria o tipo.
        //Então Java proíbe adicionar qualquer objeto que não seja null a esse tipo de lista.
    }

    // Aqui eu estou falando que eu posso receber ANIMAL ou qualquer um que seja PAI
    // Primeiro eu vou começar usando cachorro
    private static void printConsultaAnimal(List<? super Cachorro> animals){
        // Nesta lista só pode vir uma lista de Cachorro ou algo mais específico, por exemplo um Pitbull que é um cachorro
        //
    }
}
