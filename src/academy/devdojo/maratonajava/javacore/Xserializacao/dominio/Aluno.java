package academy.devdojo.maratonajava.javacore.Xserializacao.dominio;

import java.io.*;

public class Aluno implements Serializable {
    @Serial
    private static final long serialVersionUID = 739959230178355186L;
    private Long id;
    private String nome;
    private transient String password;
    private static final String NOME_ESCOLA = "DevDojo Viradão no Jiraya";
    private transient Turma turma;

    // atributo estático não serializa, pois ele não é do objeto, é da classe, mas eu consigo deserializar
    // transient serve para ignorar um campo na serialização, para ele não aparecer
    // quando serializa, um id é criado, para depois poder usar ele para desserializar
    // se eu executar o código, utilizando apenas o transient, vai aparecer um problema, por causa
    // do serialVersionUID, é como se fosse um hash
    // ctrl+shift+a e procurar por Serializable class without 'serialVersionUID'

    public Aluno(Long id, String nome, String password) {
        this.id = id;
        this.nome = nome;
        this.password = password;
    }

    @Serial
    private void writeObject(ObjectOutputStream oos) {
        try {
            oos.defaultWriteObject(); // primeiramente salva da forma padrao
            oos.writeUTF(turma.getNome());
            // em seguita voce precisa salvar tudo o que nao faz parte do defaultWriteObject, ou seja, neste caso a turm
            // voce nao pode salvar o objeto, porque ele nao e serializavel, mas os atributos eu posso pegar e escrever
            // como só tem 1 string, usa o método acima, a ordem é importante, porque a ordem que estou escrevendo,
            // é a ordem que eu vou ter que ler
            // primeiro escreve e depois lê
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Serial
    private void readObject(ObjectInputStream ois) {
        try {
            ois.defaultReadObject(); // primeiramente salva da forma padrao
            String nomeTurma = ois.readUTF();
            turma = new Turma(nomeTurma);
            // em seguita voce precisa salvar tudo o que nao faz parte do defaultWriteObject, ou seja, neste caso a turm
            // voce nao pode salvar o objeto, porque ele nao e serializavel, mas os atributos eu posso pegar e escrever
            // como só tem 1 string, usa o método acima, a ordem é importante, porque a ordem que estou escrevendo,
            // é a ordem que eu vou ter que ler
            // aqui é ao contrário, primeiro você lê e depois escreve
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", password='" + password + '\'' +
                ", NOME_ESCOLA='" + NOME_ESCOLA + '\'' +
                ", Turma='" + turma + '\'' +
                '}';
    }


    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
