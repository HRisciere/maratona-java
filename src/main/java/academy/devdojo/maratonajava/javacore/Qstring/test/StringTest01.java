package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringTest01 {
    public static void main(String[] args) {
        String nome = "William"; // String constant pool
        String nome2 = "William";
        nome = nome.concat(" Suane"); // nome += " Suane"
        System.out.println(nome);
        System.out.println(nome == nome2); // compara as referencias
        String nome3 = new String("William"); // 1 variavel de referencia, 2 objeto do tipo string, 3 Cria uma string no pool de string, caso ela nao exista
        System.out.println(nome2 == nome3);
        System.out.println(nome2 == nome3.intern());
    }
}
