package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.util.Locale;

public class LocaleTest02 {
    public static void main(String[] args) {
        System.out.println(Locale.getDefault());
        System.out.println();

        String[] isoLanguages = Locale.getISOLanguages();
        String[] isoCountries = Locale.getISOCountries();

        for (String isoLanguage : isoLanguages) {
            System.out.print(isoLanguage+" ");
        }
        System.out.println();
        System.out.println();

        for (String isoCountry : isoCountries) {
            System.out.print(isoCountry+" ");
        }


    }
}
