package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleDateFormatTest01 {
    public static void main(String[] args) {

        String pattern = "'Canaa' dd 'de' MMMM 'de' YYYY";
        SimpleDateFormat sdf =  new SimpleDateFormat(pattern);
        System.out.println(sdf.format(new Date()));
        try {
            System.out.println(sdf.parse("Canaa 07 de novembro de 2024"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
