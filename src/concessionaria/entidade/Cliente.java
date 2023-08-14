package concessionaria.entidade;

import concessionaria.aplicacao.ArvoreAVL;
import concessionaria.aplicacao.Protocolo;
import concessionaria.aplicacao.Servidor;

import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        ArvoreAVL<Veiculo> cos = new ArvoreAVL();
        Veiculo v = new Veiculo("ABC1B34", "111111111", "Davi", "3214579521", "Kwid", 2020);
        Condutores con = new Condutores("Davi", "111111111");
        cos.inserir(v.getRenavamInt(), v);
        Veiculo v2 = new Veiculo("ABC1B35", "333333333", "Davi", "3214579521", "Kwid", 2020);
        Veiculo v3 = new Veiculo("POK2T34", "222222222", con.getNome(), con.getCpf(), "Forza", 2019);
        cos.inserir(v2.getRenavamInt(), v2);
        cos.inserir(v3.getRenavamInt(), v3);
        cos.buscarPorRenavam(111111111);
        cos.ordem();
        cos.buscar(222222222);
        System.out.println(cos.contarNos());
        cos.remover(333333333);
        cos.ordem();
        System.out.println(cos.contarNos());

        /*
        Scanner scanner = new Scanner(System.in);
        Servidor servidor = new Servidor(); // Crie uma instância do servidor

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Buscar veículo por placa");
            System.out.println("2. Buscar veículo por renavam");
            System.out.println("3. Cadastrar veículo");
            System.out.println("4. Listar veículos");
            System.out.println("5. Alterar veículo");
            System.out.println("6. Remover veículo");
            System.out.println("7. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite a placa do veículo: ");
                    String placaBusca = scanner.nextLine();
                    String mensagemBusca = Protocolo.criarMensagem(Protocolo.BUSCAR, placaBusca);
                    // Envia mensagem ao servidor e recebe resposta
                    String respostaBusca = servidor.enviarMensagem(mensagemBusca);
                    System.out.println("Resposta do servidor: " + respostaBusca);
                    break;
                case 2:
                    System.out.print("Digite o renavam do veículo: ");
                    String renavamBusca = scanner.nextLine();
                    String mensagemRenavam = Protocolo.criarMensagem(Protocolo.BUSCAR, renavamBusca);
                    // Envia mensagem ao servidor e recebe resposta
                    String respostaRenavam = servidor.enviarMensagem(mensagemRenavam);
                    System.out.println("Resposta do servidor: " + respostaRenavam);
                    break;
                case 3:
                    // Solicitar e enviar dados para cadastro de veículo
                    break;
                case 4:
                    String mensagemListar = Protocolo.criarMensagem(Protocolo.LISTAR, "");
                    // Envia mensagem ao servidor e recebe resposta
                    String respostaListar = servidor.enviarMensagem(mensagemListar);
                    System.out.println("Resposta do servidor:\n" + respostaListar);
                    break;
                case 5:
                    // Solicitar e enviar dados para alteração de veículo
                    break;
                case 6:
                    // Solicitar e enviar dados para remoção de veículo
                    break;
                case 7:
                    System.out.println("Encerrando cliente...");
                    return; // Encerra o programa
                default:
                    System.out.println("Opção inválida. Escolha uma opção válida.");
            }
        }*/
    }
}

