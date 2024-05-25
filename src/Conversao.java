import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Conversao {
    public static void main(String[] args) throws IOException, InterruptedException {
        ArrayList<String> historico = new ArrayList<>();
        Scanner leitura = new Scanner(System.in);
        String de = "";
        String para = "";
        double valor = 0;

        ObterDados.converterDados(de, para, valor);

        System.out.println("\n Olá, seja bem-vindo ao conversor de moedas!");

        while (true) {
            System.out.println("\n**********************************");
            System.out.println("Selecione a conversão desejada:");
            System.out.println("1 - Real(BRL) -> Dólar(USD)");
            System.out.println("2 - Dólar(USD) -> Real(BRL)");
            System.out.println("3 - Real(BRL) -> Euro(EUR)");
            System.out.println("4 - Euro(EUR) -> Real(BRL)");
            System.out.println("5 - Real(BRL) -> Won(KRW)");
            System.out.println("6 - Won(KRW) -> Real(BRL)");
            System.out.println("7 - Sair");
            System.out.println("**********************************");

            int opcao = leitura.nextInt();

            if (opcao == 7) {
                System.out.println("Finalizando...");
                break;
            }
            switch (opcao) {
                case 1:
                    de = "BRL";
                    para = "USD";
                    break;
                case 2:
                    de = "USD";
                    para = "BRL";
                    break;
                case 3:
                    de = "BRL";
                    para = "EUR";
                    break;
                case 4:
                    de = "EUR";
                    para = "BRL";
                    break;
                case 5:
                    de = "BRL";
                    para = "KRW";
                    break;
                case 6:
                    de = "KRW";
                    para = "BRL";
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, selecione novamente.");
                    continue;
            }

            System.out.println("Informe o valor a ser convertido:");
            String valorStr = leitura.next();

            if (valorStr.contains(",")) {
                System.out.println("Erro ao converter, valores com ',' não são aceitos. Por favor, tente novamente.");
                break;
            } else {
                valor = Double.parseDouble(valorStr);
                double valorConvert = ObterDados.converterDados(de, para, valor);
                String resultado = valor + " " + de + " = " + valorConvert + " " + para;
                System.out.println(resultado);
                historico.add(resultado);
            }

            System.out.println("\nDeseja continuar fazendo conversões? (S/N)");
            char resposta = leitura.next().charAt(0);
            if (resposta == 'N' || resposta == 'n') {
                System.out.println("Finalizando...\n");
                break;
            }
        }
        System.out.println("Histórico de conversões:");
        for (String conversao : historico) {
            System.out.println(conversao);
        }
        leitura.close();
    }
}
