package academy.devdojo.maratonajava.javacore.ZZKjunit.dominio;

import java.util.Objects;

public record Manga(String name, int episodes) {
    // É uma classe final, ela não pode ser estendida
    // Todos os atributos não podem ser alterados
    // Não tem os accessor, por exemplo os "setters"
    // Posso usar modificadores de acesso, da mesma forma que uma classe, coloquei um exemplo dentro da classe "Person",
    // , da mesma forma que eu criaria uma ENUMERAÇÃO
    // Não posso criar atributos diretaente ex:   private String name;
    // private static String name; <<<< posso
    // Posso criar atributos estáticos mas não posso criar atributos de instância
    // basicamente tudo que é relacionado a instância eu não posso fazer
    // também não posso criar blocos de inicialização "normal" ex:  {}
    // posso criar bloco de inicialização estático ex: static {}
    // Posso utilizar Generics ex:  public record Manga<T>(String name, int episodes) {}
    // O construtor eu posso fazer Canonical, Compact ou customizado. Não é legal utilizar o Canonical
    // Não é legal utilizar o Canonical, porque basicamente eu estou repetindo o que já foi declarado na linha 3

    // Estou usando o construtor compact
    // Abaixo eu esto utilizando o construtor para verificar se o nome não é nulo
    // Dessa forma, na hora que eu estiver criando, eu posso verificar, como se fosse uma validação no construtor de uma classe normal
    public Manga {
        Objects.requireNonNull(name);
    }
}
