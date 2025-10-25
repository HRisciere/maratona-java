package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamTest16 {

    public static void main(String[] args) {
        // Ctrl + alt + O  remove os imports
        // Streams paralelo, é uma forma que o Java fez de abstrair a complexidade de ficar desenvolvendo
        // Quando desenvolve código que vai ser utiliazdo paralelamente  é um código complicado, precisa pensar em muitas coisas
        // e o Java meio que abstraiu isso através da utiliação da Parallel streams

        // Primeiro preciso ver quantos processadores o meu stream pode usar
        // Geralmente desktop tem 1 processador mas em servidores você tem mais do que 1
        // Tem o processador físico e o processador virtual ( os núcleos )
        // Abaixo eu vejo quantas threads os Parallel stream vai usar, por padrão é 8, da para aumentar, mas nem sempre significa que a performance vai melhorar
        System.out.println(Runtime.getRuntime().availableProcessors());
        long num = 10_000_000;
        sumFor(num);
        sumStreamIterate(num);
        sumParallelStreamIterate(num);
        sumLongStreamIterate(num);
        sumParallelLongStreamIterate(num);
    }

    private static void sumFor(long num) {
        System.out.println("Sum for");
        long result = 0;
        long init = System.currentTimeMillis();
        for (long i = 1; i <= num; i++) {
            result += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }

    private static void sumStreamIterate(long num) {
        System.out.println("Sum sumStreamIterate");
        long init = System.currentTimeMillis();
        long result = Stream.iterate(1L, i -> i + 1).limit(num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }

    // o .parallel() eu posso colocar em qualquer lugar do stream, porque ele funciona como uma "flag", é um aviso
    // é um aviso que fala assim "você vai executar em multiplas threads"
    // Nesse caso ele vai demorar mais, mesmo usando multiplas threads, porque eu estou iterando de 1 por 1
    // Porque não sabe qual é o tamanho, já que é o Iterate, as threads não sabem como trabalhar, não tem como separar para trabalhar antecipadamente
    // Se quer usar parallel stream, precisa ter algo já definido
    private static void sumParallelStreamIterate(long num) {
        System.out.println("Sum sumParallelStreamIterate");
        long init = System.currentTimeMillis();
        long result = Stream.iterate(1L, i -> i + 1).parallel().limit(num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }

    // Se quer usar parallel stream, precisa ter algo já definido
    private static void sumLongStreamIterate(long num) {
        System.out.println("Sum sumLongStreamIterate");
        long init = System.currentTimeMillis();
        long result = LongStream.rangeClosed(1L, num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }

    // Se quer usar parallel stream, precisa ter algo já definido
    private static void sumParallelLongStreamIterate(long num) {
        System.out.println("Sum sumParallelLongStreamIterate");
        long init = System.currentTimeMillis();
        long result = LongStream.rangeClosed(1L, num).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }

}
