package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.Scanner;

public class ScannerTest02 {
    public static void main(String[] args) {
//        delimitador padrao do scanner e o espaco em branco
//        a classe scanner tem 2 ponteiros, um verifica se existe um proximo valor e o outro pega o valor, se existir
//        scanner.useDelimiter(","); <<< quebrou a string em varios valores(token) utilizando o delimitador  virgula

        String texto = "Levi,Eren,Mikasa,true,200";
        Scanner scanner = new Scanner(texto);
        scanner.useDelimiter(",");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int i = scanner.nextInt();
                System.out.println("Int: " + i);
            } else if (scanner.hasNextBoolean()) {
                boolean b = scanner.nextBoolean();
                System.out.println("Boolean: " + b);
            } else {
                System.out.println(scanner.next());
            }
        }


    }
}
