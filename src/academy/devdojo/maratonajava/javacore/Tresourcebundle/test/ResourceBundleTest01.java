package academy.devdojo.maratonajava.javacore.Tresourcebundle.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest01 {
    public static void main(String[] args) {
        System.out.println(Locale.getDefault());
        ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));
        System.out.println(bundle.getString("hello"));
        System.out.println(bundle.getString("good.morning"));
        System.out.println(bundle.getString("hi"));

        bundle = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        System.out.println(bundle.getString("hello"));
        System.out.println(bundle.getString("good.morning"));

        System.out.println(bundle.getString("hi"));
//        Cuidado com o fall back, é quando ele procura alguma coisa e não tem, então vai procurar em outro lugar
//        Por exemplo, eu tenho um local abaixo e o java procura igual ao que eu tenho
//        Locale("fr", "CA");
//        message_fr_CA.properties  << O java não encontrou esse arquivo
//        message_fr.properties  << vai procurar um arquivo que só tenha a língua, nessa ordem
//        message_pt_BR.properties  <<< vai procurar um arquivo que tenha o local padrão da máquina
//        message_pt.properties << vai procurar dessa forma
//        message.properties <<< vai procurar por último desta forma, o base, é o último possível
//        Quando tem mensagens que possuem o mesmo valor em todos os arquivos, você não precisa traduzir eles em todos
//        os idiomas


    }
}
