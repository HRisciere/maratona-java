package academy.devdojo.maratonajava.javacore.Zgenerics.service;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Carro;

import java.util.List;

public class RentalService<T> {
    // A Lista abaixo está muito específica para o tipo, criar um objeto com um tipo genérico não é legal, é possível, mas não é bom fazer isso
    // Estou usando o "(List.of(new Carro("BMW"), new Carro("Fusca")))" dentro do ArrayList, não é legal fazer isso, para a situação que iremos fazer
    // Ou seja, usar Generics
    // private List<Carro> objetosDisponiveis = new ArrayList<>(List.of(new Carro("BMW"), new Carro("Fusca")));

    // Vamos imaginar que a lista está vindo de outro lugar, para não usar a de cima
    // Eu sei que eu vou precisar trocar o Tipo do Objeto que eu estou trabalhando, para generalizar ele...
    // Eu só sei quem vai ser no momento que eu compilar o código, então eu coloco <T> na classe e na lista também, o <T> é de Type, mas eu poderia colocar outras coisas
    // Nas coleções eles geralmente colocam <E> de element
    // Eu não sei de qual tipo é a Lista, mas eu sei que ela vai set do tipo de que passar
    // No momento em que eu criar um objeto, eu vou saber qual é o tipo, ele será definido no futuro
    private List<T> objetosDisponiveis;

    public RentalService(List<T> objetosDisponiveis) {
        this.objetosDisponiveis = objetosDisponiveis;
    }

    public T buscarObjetoDisponivel() {
        System.out.println("Buscando objeto disponível...");
        T t = objetosDisponiveis.remove(0);
        System.out.println("Alugando objeto: " + t);
        System.out.println("Objetos disponíveis para alugar:");
        System.out.println(objetosDisponiveis);
        return t;
    }

    public void retornarObjetoAlugado(T t) {
        System.out.println("Devolvendo objeto" + t);
        objetosDisponiveis.add(t);
        System.out.println("Objetos disponíveis para alugar: ");
        System.out.println(objetosDisponiveis);
    }
}
