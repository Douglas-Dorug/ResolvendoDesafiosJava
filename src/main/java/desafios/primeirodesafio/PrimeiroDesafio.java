package desafios.primeirodesafio;

//        Desafio
//        Leia um valor X. Coloque este valor na primeira posição de um vetor N[100]. Em cada posição subsequente de N
//        (1 até 99),coloque a metade do valor armazenado na posição anterior, conforme o exemplo abaixo. Imprima
//        o vetor N.
//
//        Entrada
//        A entrada contem um valor de dupla precisão com 4 casas decimais.
//
//        Saída
//        Para cada posição do vetor N, escreva "N[i] = Y", onde i é a posição do vetor e Y é o valor armazenado naquela
//        posição. Cada valor do vetor deve ser apresentado com 4 casas decimais.



import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class PrimeiroDesafio {

    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        double X = leitor.nextDouble();
        BigDecimal[] N = new BigDecimal[100];
        N[0] = new BigDecimal(X).setScale(6, RoundingMode.HALF_UP);
        for (int i = 1; i<=99 ;i++) {
            BigDecimal tentativa = N[i - 1];
            N[i] = tentativa.divide(new BigDecimal("2.00"), MathContext.UNLIMITED);

        }
        for (int i = 0; i<=99 ;i++) {
            BigDecimal tentativa = N[i];

            System.out.println(String.format("N[" + i + "] = %.4f", tentativa.setScale(4, RoundingMode.HALF_EVEN)));
        }
    }
}
