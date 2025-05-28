package academy.devdojo.maratonajava.javacore.Fmodificadorestatico.dominio;

public class Anime {
    private String nome;
    private static int[] episodios;

    // 0 - Bloco de inicialização estático é executado quando a JVM carregar a classe
    // 1 - Quando está criando um objeto, primeiro é alocado espaço em memória para o objeto
    // 2 - Em seguida cada atributo de classe é criado e inicializado com valores default ou o que for passado
    // 3 - O bloco de inicialização é executado
    // 4 - Em seguida o construtor é executado
    static {
        System.out.println("Dentro do bloco de inicializacao estatico 1");
        episodios = new int[100];
        for (int i = 0; i < episodios.length; i++) {
            episodios[i] = i + 1;
        }
    }

    static {
        System.out.println("Dentro do bloco de inicializacao estatico 2");
    }

    static {
        System.out.println("Dentro do bloco de inicializacao estatico 3");
    }

    {
        System.out.println("Dentro do bloco de inicializacao nao estatico");
    }

    public Anime(String nome) {
        this.nome = nome;
    }

    public Anime() {
        for (int episodio : Anime.episodios) {
            System.out.print(episodio + " ");
        }
        System.out.println();
    }

    public String getNome() {
        return nome;
    }

    public int[] getEpisodios() {
        return episodios;
    }
}
