package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest05 {
    public static void main(String[] args) {
//        regex = expressões regulares

//        Meta-Caracteres abaixo:
//        \d = Todos os digitos (números)
//        \D = Tudo o que nao for digito (letras e caracteres especiais, tudo o que nao for número)
//        \s = Todos os espaços em branco \t \n \f \r
//        \S = Todos os caracteres, excluindo os brancos (tudo o que nao esta no \s)
//        \w = Tudo o que estiver entre a-z ou A-Z, dígitos, underscore(_)
//        \W = Tudo o que nao for incluso no \w
//        \ [] = Traz um range. Vai trazer o que estiver dentro dele, por exemplo >> [abc] > vai trazer a,b ou c.
//        Continuando sobre o de cima, também pode utilizar assim [a-zA-C] > vai trazer de a até z minúsculo e
//        de A até C maiúsculo
//        String texto = "12 0x 0X 0xFFABC 0x109 0x1";
//        String regex = "0[xX][0-9a-fA-F]";  >> vai encontrar 0xF   0x1   0x1
//        Quero pegar completo 0xFFABC < por exemplo

//        Quantifidadores
//        ? Zero ou uma ocorrência
//        * Zero ou mais ocorrências
//        + Uma ou mais ocorrências
//        {n,m} de n até m ocorrências  >> por exemplo: de 5 até 15 ocorrências
//        ()  >>>> meta caractere de agrupaento, usa ele quanto algo pode acontecer mais de 1 vez
//        |   >>>> exemplo usando este e o de cima >>>> o(c|v)o   vai encontrar "oco" ou "ovo"
//        $ >>> Representa o fim da linha
//        .  1.3 >> Por exemplo estou procurando a expressão 1.3 >>> vai procurar 123, 133, 1@3, 1A3 tudo o que estiver
//        entre o 1 e 3, ele ira procurar >>> caracter coringa
//        ^   >>>> Pode ser utilizado para encontrar exatamente o que eu quero no inicio da linha ex:
//        ^\w+ >>> tudo o que for letras a-z ou A-Z, digitos(números) ou underscore (_), até ele encontrar algo
//        que nao faça parte do \w, ele vai retornar o começo daquela linha
//        tambem tem como usar como negação, precisa estar dentro disso [], exemplo abaixo:
//        [^abc]  >> tudo o que NAO for a,b,c MINUSCULO OU MAIUSCULO, ele é case sensitive
//        https://regexr.com/

        String regex = "([a-zA-Z0-9\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
        String texto = "luffy@hotmail.com, 123jotaro@gmail.com, #@!zoro@mail.br, teste@gmail.com.br, sakura@mail";
        System.out.println("Email valido");
        System.out.println("#@!zoro@mail.br".matches(regex));
//        System.out.println(Arrays.toString(texto.split(",")));
        System.out.println(texto.split(",")[1].trim());
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("texto:  " + texto);
        System.out.println("indice: 0123456789");
        System.out.println("regex " + regex);
        System.out.println("Posicoes encontradas");
        while (matcher.find()) {
            System.out.print(matcher.start() + " " + matcher.group() + "\n");
        }

    }
}
