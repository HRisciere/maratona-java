package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest02 {
    public static void main(String[] args) {
//        regex = expressões regulares

//        Meta-Caracteres abaixo:
//        \d = Todos os digitos (números)
//        \D = Tudo o que nao for digito (letras e caracteres especiais, tudo o que nao for número)
//        \s = Todos os espaços em branco \t \n \f \r
//        \S = Todos os caracteres, excluindo os brancos (tudo o que nao esta no /s)
//        \w = Tudo o que estiver entre a-z ou A-Z, dígitos, underscore(_)
//        \W = Tudo o que nao for incluso no \w

        String regex = "\\W";
//        String texto = "abaaba";
        String texto2 = "h3j_2h3 2uj3huh@!@#";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto2);
        System.out.println("texto:  " + texto2);
        System.out.println("indice: 0123456789");
        System.out.println("regex " + regex);
        System.out.println("Posicoes encontradas");
        while (matcher.find()) {
            System.out.print(matcher.start() + " " + matcher.group() + "\n");
        }

    }
}
