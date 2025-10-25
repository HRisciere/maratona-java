package academy.devdojo.maratonajava.javacore.Ycolecoes.dominio;

public class Smartphone {
    private String serialNumber;
    private String marca;

    public Smartphone(String serialNumber, String marca) {
        this.serialNumber = serialNumber;
        this.marca = marca;
    }
    // ****** Regras do método equals ******
    // Reflexivo: x.equals(x) tem que ser true para tudo que for diferente de null
    // Simétrico: para x e y diferentes de null, se x.equals(y) == true, y.equals(x) == true
    // Transitividade: para x, y, z diferentes de null, se x.equals(y) == true, e x.equals(z) true logo, y.equals(z) == true
    // Consistente: x.equals(x) sempre retorna true se x for diferente de null
    // para x diferente de null, x.equals(null) tem que retornar false.
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this == obj) return true;
        if(this.getClass() != obj.getClass()) return false; // verificando se o obj é um Smartphone
        Smartphone smartphone = (Smartphone) obj; // Eu tenho certeza que é um Smartphone, então eu faço o casting
        return serialNumber != null && serialNumber.equals(smartphone.serialNumber);
    }

    // se x.equals(y) == true, y.hashCode() == x.hashCode
    // y.hashCode() == x.hashCode() não necessariamente o equals de y.equals(x) tem que ser true
    // x.equals(y) == false o hashCode tem que ser diferente
    // y.hashCode() != x.hashCode() x.equals(y) deverá ser false
    @Override
    public int hashCode() {
        return serialNumber == null ? 0 : this.serialNumber.hashCode();
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "serialNumber='" + serialNumber + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
