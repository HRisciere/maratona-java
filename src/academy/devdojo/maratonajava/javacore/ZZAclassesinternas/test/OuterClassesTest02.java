package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest02 {
    private String name = "Kyōjurō";
    // Local Class ou Classes Locais é quando você tem uma classe dentro de um método
    // Também da para criar dentro de blocos de inicialização

    void print(String parametro) {
        String lastName = "Rengoku"; // Quando eu tenho o atributo aqui, também posso usar ele na minha classe
        // Tem 1 detalhe, o atributo que eu estou usando tem que ser "final" ou "efetivamente final"
        // Não precisa colocar "final" antes de String, mas mesmo não colocando, ele será final
        // os modificadores de acesso só podem ser 2 "abstract ou final"
        // O mesmo vale para "parametro", contando que ele seja "efetivamente final"
        class LocalClass {
            // Ainda tenho acesso aos atributos na classe externa, posso ter construtores, métodos...
            public void printLocal() {
                System.out.println(parametro);
                System.out.println(name + " " + lastName);
            }
        }
        // Se usar isso " new LocalClass(); ", ele cria um atributo
        LocalClass localClass = new LocalClass();
        localClass.printLocal();
        // new LocalClass().printLocal();    também posso fazer assim
    }

    public static void main(String[] args) {
        // Quando cria uma classe local, não se tem acesso a classe local, uma vez que o método termina
        // Sempre que se cria uma classe local, você precisa inicializar ela diretamente no método, se não, não terá acesso a essa classe
        OuterClassesTest02 outer = new OuterClassesTest02();
        outer.print("oi");
    }
}
