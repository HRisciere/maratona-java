package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest01 {
    public static void main(String[] args) {
//        fr.read() <<< retorna um integer, ele representa o primeiro caracter do nosso arquivo, tabela ascii
//        read retorna no final do arquivo o valor -1, olhar documentacao do read
        File file = new File("file.txt");
        try (FileReader fr = new FileReader(file)) {
//            char[] in = new char[30];
//            int size = fr.read(in);
//            System.out.println(size);
//            for (char c : in) {
//                System.out.print(c);
//            }   <<<< nao le o arquivo inteiro, apenas 30 posicoes
            int i;
            while ((i=fr.read()) != -1){
                System.out.print((char)i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
