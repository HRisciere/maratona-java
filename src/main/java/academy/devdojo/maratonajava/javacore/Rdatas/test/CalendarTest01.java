package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest01 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        if(c.getFirstDayOfWeek() == Calendar.SUNDAY){
            System.out.println("Domingão é o primeiro dia da semana!!");
        }
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(c.get(Calendar.DAY_OF_YEAR));
        System.out.println(c.get(Calendar.DAY_OF_WEEK_IN_MONTH));

        c.add(Calendar.DAY_OF_MONTH,0); // Método add vai virar o dia / mes / ano, se colocar um valor muito alto
        c.roll(Calendar.HOUR,2); // O método não vira o dia / mes / ano, mas acrescenta no mesmo dia
        Date date = c.getTime();
        System.out.println(date);
    }
}
