package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest01 {
    public static void main(String[] args) {

        Locale localeCN = Locale.CHINA;
        Locale localeIT = Locale.ITALY;
        Locale localeJP = Locale.JAPAN;

        NumberFormat[] nfa = new NumberFormat[4];
        nfa[0] = NumberFormat.getInstance();
        nfa[1] = NumberFormat.getInstance(localeCN);
        nfa[2] = NumberFormat.getInstance(localeIT);
        nfa[3] = NumberFormat.getInstance(localeJP);

        double moeda = 1_000.2130;

        for (NumberFormat numberFormat : nfa) {
            numberFormat.setMaximumFractionDigits(2);
//            System.out.println(numberFormat.getMaximumFractionDigits());
            System.out.println(numberFormat.format(moeda));
        }

        String valorString = "1000,2130";

        try {
            System.out.println(nfa[0].parse(valorString));
//            System.out.println(NumberFormat.getInstance().parse(valorString));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
