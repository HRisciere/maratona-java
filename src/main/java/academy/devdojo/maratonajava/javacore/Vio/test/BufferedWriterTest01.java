package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest01 {
    public static void main(String[] args) {
//        buffer é melhor do que usar sem o buffer, porque voce nao esta escrevendo diretamente no disco, ele primeiro
//        escreve em uma memoria temporaria e depois joga no disco
//        flush serve para garantir que tudo sera escrito antes de fechar o arquivo
//        lembrando que o \n (quebra de linha) nao e uma boa ideia usar ele, nem todo o sistema operacional entende ele
//        como quebra de linha, como BufferedWriter e uma classe mais nova, ela sabe disso entao foi criado o
//        br.newLine()  <<< ele usa o System.lineSeparator() do sistema operacional, pula linha baseado no SistemaOpera.
        File file = new File("file.txt");
        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("O DevDojo é lindo, é o melhor curso do brasillllll");
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
