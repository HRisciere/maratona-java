package academy.devdojo.maratonajava.javacore.Ycolecoes.dominio;

import java.util.Objects;

public class Manga implements Comparable<Manga> {
    private Long id;
    private String nome;
    private double preco;

    public Manga(Long id, String nome, double preco) {
        Objects.requireNonNull(id, "Id não pode ser null"); // Este atributo não pode ser null
        Objects.requireNonNull(nome, "Nome não pode ser null"); // Este atributo não pode ser null
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manga manga = (Manga) o;
        return Double.compare(preco, manga.preco) == 0 && Objects.equals(id, manga.id) && Objects.equals(nome, manga.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, preco);
    }

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public int compareTo(Manga outroManga) {
        // negativo se o this < outroManga
        // se this == outroManga, return 0
        // positivo se this > outroManga
//        if(this.id < outroManga.getId()){
//            return -1;
//        }else if (this.id.equals(outroManga.getId())){
//            return 0;
//        }else {
//            return 1;
//        }
        // O wrapper do Long, já implementou o compareTo, ele já é um comparable
        // O id é um wrapper, então eu posso fazer igual ao de baixo, mas com tipo primitivo, eu preciso fazer
        // igual ao de cima, ou transformar o tipo primitivo em Wrapper, por exemplo abaixo
//        return Double.valueOf(preco).compareTo(outroManga.getPreco()); // Posso usar a de baixo
        return this.nome.compareTo(outroManga.getNome());
//        return Double.compare(preco, outroManga.getPreco());
//        return this.id.compareTo(outroManga.getId()); // delegando a responsabilidade para o compareTo do Long
    }
}
