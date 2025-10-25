package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class PathMatcherTest01 {
    public static void main(String[] args) {
//        Classe que foi criada, para facilitar um pouco a busca de paths
//        tambem tem como usar as expressoes regulares  (regex)

        Path path1 = Paths.get("pasta/subpasta/file.bkp");
        Path path2 = Paths.get("pasta/subpasta/file.txt");
        Path path3 = Paths.get("pasta/subpasta/file.java");
//        Quero ver se o path da um matcher, sendo que o arquivo tem uma extensao .bkp
        matches(path1, "glob:**.bkp"); // < sem usar "glob:" , apenas um "*", nao considera os diretorios, se quiser
        //use dois "**", estou ignorando tudo antes do .bkp, só me importo é que o final desse path termine .bkp
        matches(path1, "glob:**/*.bkp"); // < mesmo resultado, mas se eu quiser posso substituir o ultimo asterisco
        //por outro valor, e continuo ignorando o que esta antes dele
        matches(path1, "glob:**/*.{bkp,txt,java}"); // < estou procurando por bkp ou txt ou java, sem espaços
        matches(path2, "glob:**/*.{bkp,txt,java}"); // < lembra de mudar o path
        matches(path3, "glob:**/*.{bkp,txt,java}");
        matches(path1, "glob:**/*.???"); // << quero exatamente 3 letras depois do ponto, nao me importo com
        //diretorio(**), nao me importo com nome(*), quero 3 letras depois do ponto
        matches(path2, "glob:**/*.???");
        matches(path3, "glob:**/*.???");
        matches(path3, "glob:**/file.???"); // < nome do arquivo "file", nao importa o nome do diretorio, mas
        // depois do ponto (.), precisa ter 3 letras
    }

    private static void matches(Path path, String glob) {
//        glob é parecido com expressao regular (regex), só que é mais simplificada
//        como estamos trabalhando com Path e ele e baseado no SO que estamos trabalhando, usa FileSystems
//        FileSystems.getDefault().getPathMatcher(glob); <<< posso utilizar glob ou regex
//        matcher.matches(path)) <<< serve para ver se deu matcher nesse path
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob + ": " + matcher.matches(path));
    }
}
