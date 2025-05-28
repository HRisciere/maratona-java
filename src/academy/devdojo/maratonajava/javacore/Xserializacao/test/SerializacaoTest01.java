package academy.devdojo.maratonajava.javacore.Xserializacao.test;

import academy.devdojo.maratonajava.javacore.Xserializacao.dominio.Aluno;
import academy.devdojo.maratonajava.javacore.Xserializacao.dominio.Turma;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializacaoTest01 {
    public static void main(String[] args) {
        // Primeiro preciso de um objeto, para usar a serealização, então vou criar uma classe de domínio
        Aluno aluno = new Aluno(1L, "Henrique Risciere","123412121");
        Turma turma = new Turma("Maratona Java Virado no Jiraya em Breve Ricos");
        aluno.setTurma(turma); // Tentando serializar uma turma, vai dar erro, porque turma nao é serializável
        // quando nao tem acesso ao codigo fonte e nao consigo modificar, eu vou no java e falo assim
        // "quando voce for serializar, voce vai seguir este cainho que eu estou te mandando. Primeira coisa,
        // falar para nao serializar, usar o transiente na classe Aluno no atributo Turma
        // Quero salvar o objeto, o estado do objeto, em um arquivo e depois ler
        // Criar um método que salva
        // Quando está serializando eu estou transformando o objeto em um array de bytes, trabalho em baixo nível
        // geralmente é uma classe stream, para baixo nível
        // serializar serve para armazenar e transmitir
        // escrever 2 métodos para, um para escrever/serializar o objeto e em seguida como ler esse objeto

        serializar(aluno);

        // IMPORTANTE!!! >> Quando está lendo um objeto serializado, o java não utiliza o construtor
        // o construtor nao e executado no momento da desserialização, ou seja, se estiver trabalhando com herança
        // as coisas ficam mais complicadas, na herança o objetivo do construtor é chamar o super, commo ele vai chamr
        // o super, se ele nao é executado?

        deserializar();
    }
    private static void serializar(Aluno aluno){
        Path path = Paths.get("pasta/aluno.ser"); // Nome do arquivo, onde eu quero salvar
        try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            // Quero mandar esse objeto para um arquivo, então eu posso usar o Files.newoutputstream
            // Quando eu estou serelializando um objeto, voce precisa falar para o java que ele e serealizavel
            // vou no objeto aluno e coloco "implements serializable"
        oos.writeObject(aluno);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void deserializar(){
        Path path = Paths.get("pasta/aluno.ser"); // Nome do arquivo, onde eu quero salvar
        // Não preciso de ua variavel de referencia, porque o objeto já se encontra no arquivo
        // Não uso output eu uso input, porque eu quero ler o arquivo serealizado
        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
//            Object object = ois.readObject();  < retorna um objeto, ele nao sabe o que está lendo
            // como eu sei que eu estou lendo, eu vou fazer um cast
            Aluno aluno = (Aluno) ois.readObject();
            System.out.println(aluno);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
