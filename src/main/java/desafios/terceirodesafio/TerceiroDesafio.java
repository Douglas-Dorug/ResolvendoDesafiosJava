package desafios.terceirodesafio;

//        Desafio
//        O professor Girafales organizou a confecção de um uniforme para as turmas da escola para comemorar o final do
//        ano. Após algumas conversas, ficou decidido com os alunos que eles poderiam escolher a cor do uniforme entre
//        branco ou vermelho. Assim sendo, Girafales precisa de sua ajuda para organizar as listas de quem quer o
//        uniforme em cada uma das turmas, relacionando estas camisetas pela cor, tamanho (P, M ou G) e por último pelo
//        nome.
//
//        Entrada
//        Cada caso de teste inicia com um valor N, (1 ≤ N ≤ 60) inteiro e positivo, que indica a quantidade de
//        uniformes a serem feitas para aquela turma. As próximas N*2 linhas contém informações de cada um dos uniformes
//        (serão duas linhas de informação para cada uniforme). A primeira linha irá conter o nome do estudante e a
//        segunda linha irá conter a cor do uniforme ("branco" ou "vermelho") seguido por um espaço e pelo tamanho do
//        uniforme "P" "M" ou "G". A entrada termina quando o valor de N for igual a zero (0) e esta valor não deverá
//        ser processado.
//
//        Saída
//        Para cada caso de entrada deverão ser impressas as informações ordenadas pela cor em ordem ascendente, seguido
//        pelos tamanhos em ordem descendente e por último por ordem ascendente de nome, conforme o exemplo abaixo.
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class TerceiroDesafio {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        int N = leitor.nextInt();
        leitor.nextLine();
        ArrayList<Tshirt> arrayUniform = new ArrayList<>(N);
        String owner, details ,color, size;

        for(int i = 0; i < N; i++){
            owner = leitor.nextLine();
            details = leitor.nextLine();
            color = details.split(" ")[0];
            size = details.split(" ")[1];
            arrayUniform.add(new Tshirt(color,size,owner));
        }

        leitor.close();
        Collections.sort(arrayUniform, new UniformComparator());

        for(var student : arrayUniform)
        {
            student.printStudents();
        }

        }

        static class UniformComparator implements Comparator<Tshirt>
        {
            @Override
            public int compare(Tshirt student0, Tshirt student1)
            {
                int res = student0.getColor().compareTo(student1.getColor());

                if(res == 0)
                {
                    res = student0.getSize().compareTo(student1.getSize());

                    if(res == 0)
                    {
                        res = student0.getOwner().compareTo(student1.getOwner());
                    } else {
                        res = -res;
                    }
                }
                return res;
            }
        }

    }

class Tshirt {

    private String size;
    private String color;
    private String owner;

    public Tshirt(String color,String size, String owner) {
        this.size = size;
        this.color = color;
        this.owner = owner;
    }

    public void printStudents()
    {
        System.out.println(this.color + " " + size + " " + owner);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return this.getColor() + " " + this.getSize() + " " + this.getOwner();
    }
}