package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreamTest01 {
    public static void main(String[] args) {
//        Serve para trabalhar com diretorio, é uma das formas mais fáceis de pegar todos os arquivos de um diretorio
//        ele funciona + ou menos como um "dir" no terminal, ele lista apenas o primeiro level de pastas e arquivos
//        Mas existe outras classes que vao em niveis mais profundos e voce consegue pesquisar por elas
//        Quando trabalha com IO e Stream, voce precisa fechar, para fechar o recurso que esta pegando do SO,
//        entao e melhor criar o DirectoryStream dentro de um try with resources

        Path dir = Paths.get(".");
//        DirectoryStream pede uma classe que seja passada entre o seguinte simbolo "<>", quero criar um
//        DirectoryStream do tipo Path. Basicamente ele vai pegar cada um dos arquivos que tem na variavel "dir" e vai
//        associar um Path, ou seja, da mesma forma que temos um Paths.get("maratona-java"), para um arquivo,
//        o DirectoryStream vai ter um Path para cada um dos arquivos que forem encontrados
//        Onde esta o dir, no files.newDirec... ele está pedindo o caminho inicial
//        preciso iterar sobre o stream, ele e como um fluxo, entao quando fala de fluxo voce esta falando sobre uma
//        quantidade maior do que 1, entao precisa iterar sobre ele, é como se ele fosse um Array
//        não sei quantos paths tem dentro desse diretorio, eu poderia contar, ja que estou usando o maratona-java
//        mas eu poderia receber isso como argumento de um sistema de terceiros, eu nao sei quantos vou ter, mas eu sei
//        que vou iterar sobre todos eles
//        precisei substituir o maratona-java por um ponto ".", para referenciar o diretorio atual, porque o diretorio
//        atual, é o maratona java
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for(Path path : stream){
                System.out.println(path.getFileName());
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
