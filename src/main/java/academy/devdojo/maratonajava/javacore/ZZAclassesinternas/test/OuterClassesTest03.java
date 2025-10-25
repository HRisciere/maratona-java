package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest03 {
    private String name = "Henrique";

    static class Nested {
        private String lastName = "Risciere";
        void print() {
            System.out.println(new OuterClassesTest03().name + " " + lastName);
        }
    }

    public static void main(String[] args) {
        Nested nested = new Nested();
        nested.print();
        // OuterClassesTest03 é chamada de classe Top Level, é o nível mais alto, colocando uma "static class" dentro dela,
        // é como se fosse uma outra classe de alto nível, é mais por uma questão de empacotamento
        // Se "private String name;", fosse "static" eu poderia acessar ele dentro da "static class Nested", sem precisar usar o "new OuterClassesTest03()"
        // Eu crio uma "static class", quando eu quero criar uma classe "Top Level", ou seja uma classe "Mais externa", quando eu já tenho uma classe "Top Level" que não seja "static"
        // Então eu crio uma "static class" e coloco dentro da classe "Top Level" já existente, porque não tem motivos da "static class" ficar fora da classe "Top level"
        // porque a "static class" só vai se comunicar com a classe "Top level" que está contendo a "static class", não tem motivos para colocar as duas classes no mesmo "nível"
        // Trabalhando com Classes aninhadas estáticas
        // Parecido com Nested class, a diferença é que eu posso colocar "static"
    }
}
