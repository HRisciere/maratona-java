package academy.devdojo.maratonajava.javacore.Minterfaces.dominio;

public interface DataLoader {
    // Por padrao todos os atributos em uma INTERFACE sao CONSTANTES
    // Metodos estaticos nunc serao sobrescritos, ja que tudo que e estatico PERTENCE A CLASSE
    public static final int MAX_DATA_SIZE = 10;
    void load();

    default void checkPermission() {
        System.out.println("Fazendo checagem de permissoes");
    }

    public static void retrieveMaxDataSize(){
        System.out.println("Dentro do retrieveMaxDataSize na interface");
    }

}
