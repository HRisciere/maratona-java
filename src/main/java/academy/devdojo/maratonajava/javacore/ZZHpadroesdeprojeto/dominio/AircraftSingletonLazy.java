package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;

public class AircraftSingletonLazy {

    private static AircraftSingletonLazy INSTANCE;
    private final Set<String> availableSeats = new HashSet<>();
    private final String name;

    private AircraftSingletonLazy(String name) {
        this.name = name;
    }

    {
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

    // Eu posso ter duas "threads" acessando o if(INSTANCE==null), se eu deixar da maneira abaixo, isso da problema, porque 2 pessoas podem pegar o mesmo assento
    // Então eu posso colocar "synchronized" antes do "static", mas se eu fizer isso eu irei perder PERFORMANCE, porque estou aplicando em todo o método
    // Para resolver isso eu faço um "Double-checked locking ", então eu faço da maneira abaixo

    public static AircraftSingletonLazy getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (AircraftSingletonLazy.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AircraftSingletonLazy("787-900");
                }
            }
        }
        return INSTANCE;
    }

    public boolean bookSeat(String seat) {
        return availableSeats.remove(seat);
    }
}
