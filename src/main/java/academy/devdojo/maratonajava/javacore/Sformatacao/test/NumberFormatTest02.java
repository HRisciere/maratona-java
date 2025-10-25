package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest02 {
    public static void main(String[] args) {

        Locale localeCN = Locale.CHINA;
        Locale localeIT = Locale.ITALY;
        Locale localeJP = Locale.JAPAN;

        NumberFormat[] nfa = new NumberFormat[4];
        nfa[0] = NumberFormat.getCurrencyInstance();
        nfa[1] = NumberFormat.getCurrencyInstance(localeCN);
        nfa[2] = NumberFormat.getCurrencyInstance(localeIT);
        nfa[3] = NumberFormat.getCurrencyInstance(localeJP);

        double moeda = 1000.2130;

        for (NumberFormat numberFormat : nfa) {
            System.out.println(numberFormat.getMaximumFractionDigits());
            System.out.println(numberFormat.format(moeda));
        }

        String valorString = "¥1,000.21";

        try {
            System.out.println(nfa[1].parse(valorString));
//            System.out.println(NumberFormat.getInstance().parse(valorString));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
