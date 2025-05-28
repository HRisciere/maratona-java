package academy.devdojo.maratonajava.introducao;

import java.util.Date;

public class Aula03TiposPrimitivosExercicio {
    public static void main(String[] args) {
        String nome = "Henrique";
        String endereco = "Rua boa sorte, nº26, bairro Canaã, Viana";
        double salario = 53450.54; // Geralmente moeda usa um tipo chamado Big Decimal
        String dataRecebimentoSalario = "31/07/2024";
        String relatorio = "Eu "+nome+", morando no endereço "+endereco+", confirmo que recebi o salário de "+salario+", na data "+dataRecebimentoSalario;
        System.out.println(relatorio);
    }
}
