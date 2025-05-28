package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LocaleTest01 {
    public static void main(String[] args) {
        // pt-BR
        Locale localeItalia = new Locale("it", "IT");
        Locale localeTurquia = new Locale("tr", "TR");
        Locale localeJapao = new Locale("ja", "JP");
        Locale localeNoruega = new Locale("no", "NO");
        Locale localeSuecia = new Locale("sv", "SE");
        Locale localeSuica = new Locale("de", "CH");
        Locale localeUcrania = new Locale("uk", "UA");

        Calendar calendar = Calendar.getInstance();

        DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL,localeItalia);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL,localeTurquia);
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL,localeJapao);
        DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL,localeNoruega);
        DateFormat df5 = DateFormat.getDateInstance(DateFormat.FULL,localeSuecia);
        DateFormat df6 = DateFormat.getDateInstance(DateFormat.FULL,localeSuica);
        DateFormat df7 = DateFormat.getDateInstance(DateFormat.FULL,localeUcrania);

        System.out.println(df1.format(calendar.getTime()));
        System.out.println(df2.format(calendar.getTime()));
        System.out.println(df3.format(calendar.getTime()));
        System.out.println(df4.format(calendar.getTime()));
        System.out.println(df5.format(calendar.getTime()));
        System.out.println(df6.format(calendar.getTime()));
        System.out.println(df7.format(calendar.getTime()));

        System.out.println("______________________");

        System.out.println(localeItalia.getDisplayCountry(localeJapao));
        System.out.println(localeTurquia.getDisplayCountry(localeJapao));
        System.out.println(localeJapao.getDisplayCountry(localeJapao));
        System.out.println(localeNoruega.getDisplayCountry(localeJapao));
        System.out.println(localeSuecia.getDisplayCountry(localeJapao));
        System.out.println(localeSuica.getDisplayCountry(localeJapao));
        System.out.println(localeUcrania.getDisplayCountry(localeJapao));
    }
}
