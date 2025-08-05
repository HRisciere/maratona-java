package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest01 {
    private String name = "Goku";
    // abaixo irei criar uma classe interna
    // Classes aninhadas ou Nested Class
    class Inner {
        // Essa classe é como se fosse um método, mas ela é mais poderosa, porque eu posso declarar atributos
        // Também tenho acesso a todos os objetos da classe mais externa
        // Para criar um objeto NA CLASSE INTERNA você precisa de um OBJETO DA CLASSE EXTERNA
        // Está fortemnte linkado a classe EXTERNA
        // Classes internas são como atributos, se eu quiser poderia fazer o seguinte:
        // private class Inner{}, public class Inner{}, protected class Inner{}, static class Inner{}...


        public void printOuterClassAttribute() {
            System.out.println(name);
            System.out.println(this); //Se refere a classe na qual ele se encontra
            System.out.println(OuterClassesTest01.this); // Referenciando o "this" da classe Externa
        }
    }

    public static void main(String[] args) {
        // Sem trabalhar com interface gráfica é difícil de ver a utilidade de classes internas
        // Por exemplo, eu tenho um chat, geralmente eu tenho a interface gráfica e as ações que podem ser feitas dentro do chat
        // Do ponto de vista de Coesão eu tenho uma classe que toma conta da interface gráfica e outra que toma conta das ações
        // Ou seja são objetos diferentes mas estão fortemente acoplados
        // Esse método main faz parte da OuterClass
        // Eu preciso de um OBJETO DA CLASSE DE FORA, eu não posso fazer "new Inner()"
        // Porque o "main" está dentro da mesma classe que a "class Inner", estão basicamente no mesmo nível
        // E a "class" não é "static"
        OuterClassesTest01 outerClass = new OuterClassesTest01();
        // Eu quero o "new", ou seja, do objeto da classe de fora eu quero criar um novo objeto da classe de dentro
        Inner inner = outerClass.new Inner();
        inner.printOuterClassAttribute();
        // OuterClassesTest01.Inner inner2 = outerClass.new Inner(); Igual ao de cima, estou referenciando completamnte o caminho da Inner Class
        Inner inner3 = new OuterClassesTest01().new Inner();
        inner3.printOuterClassAttribute();

    }
}
