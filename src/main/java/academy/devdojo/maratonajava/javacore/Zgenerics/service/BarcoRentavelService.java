package academy.devdojo.maratonajava.javacore.Zgenerics.service;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;

import java.util.ArrayList;
import java.util.List;

public class BarcoRentavelService {
    // Fiz praticamente a mesma classe de CarroRentavelService, mas eu precisei usar
    // Eu usei "ctrl+c" + "ctrl + f" + "ctrl + r"
    // Então é melhor aprender a usar uma classe genéricas, para evitar esse trabalho
    // A única diferença é o TIPO do Parâmetro que estou trabalhando, a lista de barco...
    // São poucas diferenças, o que eu estou trocando é apenas o tipo do Objeto que eu estou trabalhando
    private List<Barco> barcosDisponiveis = new ArrayList<>(List.of(new Barco("Lancha"), new Barco("Canoa")));

    public Barco buscarBarcoDisponivel() {
        System.out.println("Buscando barco disponível...");
        Barco barco = barcosDisponiveis.remove(0);
        System.out.println("Alugando barco: " + barco);
        System.out.println("Barcos disponíveis para alugar:");
        System.out.println(barcosDisponiveis);
        return barco;
    }

    public void retornarBarcoAlugado(Barco barco) {
        System.out.println("Devolvendo barco" + barco);
        barcosDisponiveis.add(barco);
        System.out.println("Barcos disponíveis para alugar: ");
        System.out.println(barcosDisponiveis);
    }
}
