package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.IOException;

public class FileTest02 {
    public static void main(String[] args) throws IOException {
        File fileDiretorio = new File("pasta");
        boolean isDiretorioCreated = fileDiretorio.mkdir();
        System.out.println("Pasta criada? " + isDiretorioCreated);

//        abaixo está uma outra forma de criar um arquivo
//        File fileArquivoDiretorio = new File(fileDiretorio,"C:\\Users\\User\\ws-IntelliJ\\maratona-java\\pasta\\arquivo.txt");

        File fileArquivoDiretorio = new File(fileDiretorio, "arquivo.txt");
        boolean isFileCreated = fileArquivoDiretorio.createNewFile();
        System.out.println("Arquivo criado? " + isFileCreated);

        File fileRenamed = new File(fileDiretorio, "arquivo_renomeado.txt");
        boolean isRenamed = fileArquivoDiretorio.renameTo(fileRenamed);
        System.out.println("arquivo.txt renomeado? " + isRenamed);

        File DiretorioRenamed = new File("pasta2");
        boolean isDiretorioRenamed = fileDiretorio.renameTo(DiretorioRenamed);
        System.out.println("Diretorio renomeado? " + isDiretorioRenamed);
    }
}
