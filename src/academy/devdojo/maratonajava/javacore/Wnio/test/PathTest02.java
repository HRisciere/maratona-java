package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.*;

public class PathTest02 {
    public static void main(String[] args) throws IOException {
        Path pastaPath = Paths.get("pasta");
        if (Files.notExists(pastaPath)) {
            Path pastaDirectory = Files.createDirectory(pastaPath);
        }

        Path subPastaPath = Paths.get("pasta/subpasta/subsubpasta");
        Path subPastaDirectory = Files.createDirectories(subPastaPath);

        Path filePath = Paths.get(subPastaPath.toString(), "file.txt");
        if (Files.notExists(filePath)){
            Path filePatchCreated = Files.createFile(filePath);
        }

        Path source = filePath;   // Origem do arquivo que será copiado
//        Path target = Paths.get(subPastaPath.toString(),"file_copia.txt");  <<< Outra maneira de fazer
        Path target = Paths.get(filePath.getParent().toString(),"file_copia.txt");
//        StandardCopyOption.REPLACE_EXISTING <<<<< Substitui o que foi escrito no arq original para a copia
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
    }
}
