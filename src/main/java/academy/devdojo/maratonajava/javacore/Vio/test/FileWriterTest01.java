package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// File
// FileWriter
// FileReader
// BufferedWriter
// BufferedReader
public class FileWriterTest01 {
    public static void main(String[] args) {
//        fw.write  <<<<< write é baixo nível
//        try (FileWriter fw = new FileWriter(file)){ <<< se deixar assim, ele não acrescenta, apenas sobrescrevi
        File file = new File("file.txt");
        try (FileWriter fw = new FileWriter(file,true)){
            fw.write("O DevDojo é lindo, é o melhor curso do brasillllll\nOlá, como vai?\n");
            fw.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
