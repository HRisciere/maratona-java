package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamTest01 {
    public static void main(String[] args) {
        // Quando ver Output significa que esta mandando para algum lugar, quando tem input(entrada), voce esta lendo
        // isso vai gerar alguma coisa, nesse caso vai gerar um zip
        // quando aparecer "stream", significa que esta trabalhando com dados de baixo nivel, praticamente binário
        Path arquivoZip = Paths.get("pasta/arquivo.zip"); // Arquivo gerado
        Path arquivosParaZipar = Paths.get("pasta/subpasta1/subsubpasta1"); // Onde eu quero zipar
        zip(arquivoZip, arquivosParaZipar);
    }

    private static void zip(Path arquivoZip, Path arquivosParaZipar) {
        try (ZipOutputStream zipStream = new ZipOutputStream(Files.newOutputStream(arquivoZip));
             DirectoryStream<Path> directoryStream = Files.newDirectoryStream(arquivosParaZipar)) {
//      ZipOutputStream zipStream = new ZipOutputStream(Files.newOutputStream(arquivoZip)) < arquivo zip que sera criado
//      Precisamos navegar dentro da pasta pasta/subpasta1/subsubpasta1 e pegar cada um dos arquivos
//      Zipar e um processo que acontece em etapas, primeiro voce prepara falando o seguinte:
//      Olha eu vou criar uma entrada em seguida voce pega essa entrada e coloca no zip e depois voce copia
//      esse objeto e o que estou preparando e depois voce vai la no arquivo, no zip e fala, prepara um lugar para
//      esse arquivo
//      eu preciso fazer 3 coisas
            for (Path file : directoryStream) {
                ZipEntry zipEntry = new ZipEntry(file.getFileName().toString());
                // < Preparando o primeiro passo, "eu vou mandar esse arquivo", para o zip, so preparei o objeto
                zipStream.putNextEntry(zipEntry); // < estou falando assim "coloque essa proxima entrada"
                Files.copy(file, zipStream); // O que voce quer copiar? Para onde?
                zipStream.closeEntry(); // < nao estou fechando o ZipOutputStream zipStream, estou fechando a entrada
                // o arquivos apareceram em branco, eu preparei o arquivo, criei o esqueleto do arquivo dentro do zip
                // atraves do zipStream.putNextEntry(zipEntry), mas nao copiei o conteudo
            }
            System.out.println("Arquivo criado com sucesso!!!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
