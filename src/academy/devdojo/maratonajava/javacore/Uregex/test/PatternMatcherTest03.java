package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest03 {
    public static void main(String[] args) {
//        regex = expressões regulares

//        Meta-Caracteres abaixo:
//        \d = Todos os digitos (números)
//        \D = Tudo o que nao for digito (letras e caracteres especiais, tudo o que nao for número)
//        \s = Todos os espaços em branco \t \n \f \r
//        \S = Todos os caracteres, excluindo os brancos (tudo o que nao esta no /s)
//        \w = Tudo o que estiver entre a-z ou A-Z, dígitos, underscore(_)
//        \W = Tudo o que nao for incluso no \w
//        \ [] = Traz um range. Vai trazer o que estiver dentro dele, por exemplo >> [abc] > vai trazer a,b ou c.
//        Continuando sobre o de cima, também pode utilizar assim [a-zA-C] > vai trazer de a até z minúsculo e
//        de A até C maiúsculo
//        String texto2 = "12 0x 0X 0xFFABC 0x109 0x1";
//        String regex = "0[xX][0-9a-fA-F]";  >> vai encontrar 0xF   0x1   0x1
//        Quero pegar completo 0xFFABC < por exemplo

//        String regex = "[a-zA-C]";
        String regex = "0[xX][0-9a-fA-F]";
//        String texto = "abaaba";
        String texto2 = "12 0x 0X 0xFFABC 0x109 0x1";
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
