import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Qual o CEP do endereço?");
            String cep = scanner.nextLine();

            EnderecoViaCEP enderecoViaCEP = new ConsultaViaCEP().busca(cep);
            System.out.println(enderecoViaCEP);

            new GeradorDeArquivo().salvaJson(enderecoViaCEP);

        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("O programa finalizou!");

    }

}