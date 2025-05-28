package academy.devdojo.maratonajava.introducao;

public class Aula02TiposPrimitivos {
    public static void main(String[] args) {
        // int, double, float, char, byte, short, long, boolean
        int idade = (int) 10000000000L; // Números inteiro // Quero colocar esse long dentro do int, lembrando que eu preciso colocar L
                        // para informar que é um long
        long numeroGrande = (long) 155.23; // Números inteiro
        double salarioDouble = 2000.0D; // Números decimais
        float salarioFloat = (float) 2500.0D; // Números decimais // Especificando que é um float, usar F MAIÚSCULO
        byte idadeByte = 127;
        short idadeShort = 32000;
        boolean verdadeiro = true;
        boolean falso = false;
        char caractere = '\u0041';
        String nome = "Goku";

        System.out.println("A idade é "+idade+" anos");
        System.out.println(falso);
        System.out.println("char "+caractere);
        System.out.println(numeroGrande);
        System.out.println("Oi meu nome é "+nome);
    }
}
