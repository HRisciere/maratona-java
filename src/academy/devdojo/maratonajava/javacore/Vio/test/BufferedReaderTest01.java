package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest01 {
    public static void main(String[] args) {
//        fr.read() <<< retorna um integer, ele representa o primeiro caracter do nosso arquivo, tabela ascii
//        read retorna no final do arquivo o valor -1, olhar documentacao do read
        File file = new File("file.txt");
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
             String texto;
             while ((texto = br.readLine()) != null){
                 System.out.println(texto);
             }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
