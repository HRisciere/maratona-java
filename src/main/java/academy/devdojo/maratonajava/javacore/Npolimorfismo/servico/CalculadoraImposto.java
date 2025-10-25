package academy.devdojo.maratonajava.javacore.Npolimorfismo.servico;

import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Produto;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Tomate;

public class CalculadoraImposto {
    // Se nao estiver acessando nenhum atributo de classe voce pode transformar os seus metodos em estaticos
    // Entao nao precisa utilizar new calcularImposto

    public static void calcularImposto(Produto produto) {
        System.out.println("Relatorio de imposto");
        double imposto = produto.calcularImposto();
        System.out.println("Produto: " + produto.getNome());
        System.out.println("Preco: " + produto.getValor());
        System.out.println("Imposto a ser pago: " + imposto);
        if (produto instanceof Tomate) {
//            Tomate tomate = (Tomate) produto;
//            System.out.println(tomate.getDataValidade());
            String dataValidade = ((Tomate)produto).getDataValidade();

            System.out.println(dataValidade);
        }
    }
}
