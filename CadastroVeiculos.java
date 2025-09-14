import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroVeiculos {
    static Scanner scan = new Scanner(System.in);
    static List<Veiculo> veiculos = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("==== Bem vindo ao Controle de Frotas ====");
        String menu = """
                MENU
                Escolha uma das opções abaixo:
                1 - Cadastro de Veículo
                2 - Listar Veículos
                3 - Excluir Veículo
                4 - Pesquisar Veículo
                0 - Sair
                """;
        int opcao;
        do {
            System.out.println(menu);
            opcao = Input.scanInt("Escolha uma opção: ", scan);
            switch (opcao) {
                case 1:
                    cadastraVeiculo();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine(); // Forçar uma parada
                    break;
                case 2:
                    listaVeiculos();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine(); // Forçar uma parada
                    break;
                case 3:
                    removeVeiculo();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine();
                    break;
                case 4:
                    pesquisaVeiculo();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine();
                    break;
                case 0:
                    System.out.println("Volte Sempre!!!!");
                    break;
                default:
                    System.out.println("Opção Inválida!!!");
                    break;
            }
        } while (opcao != 0);
    }

    static void cadastraVeiculo() {
        System.out.println("==== Cadastrando novo veículo ====");
        String marca = Input.scanString("Marca: ", scan);
        String modelo = Input.scanString("Modelo: ", scan);
        int ano = Input.scanInt("Ano: ", scan);
        String placa = Input.scanString("Placa: ", scan);
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println("Placa já cadastrada!");
                return;
            }
        }
        Veiculo veiculo = new Veiculo(marca, modelo, ano, placa);
        veiculos.add(veiculo);
    }

    static void listaVeiculos() {
        System.out.println("==== Veículos cadastrados ====");
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo.toString());
        }
    }

    static void removeVeiculo() {
        listaVeiculos();
        String placa = Input.scanString("Qual a placa do veículo você quer remover? ", scan);
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                veiculos.remove(veiculo);
                System.out.println("Veículo da placa " + veiculo.getPlaca() + " removido");
                return;
            }
        }
        System.out.println("Placa não encontrada");
    }

    static void pesquisaVeiculo() {
        int opcao = Input.scanInt("""
                MENU DE PESQUISA
                Escolha uma das opções abaixo:
                1 - Pesquisar por Placa
                2 - Pesquisar por Modelo
                0 - Voltar ao Menu Principal
                """, scan);
        switch (opcao) {
            case 1:
                pesquisaPorPlaca();
                break;
            case 2:
                pesquisaPorModelo();
                break;
            case 0:
                return;
            default:
                System.out.println("Opção Inválida!!!");
                break;
        }
    }

    static void pesquisaPorPlaca() {
        String pesquisaPlaca = Input.scanString("Digite a placa do veículo que deseja pesquisar: ", scan);
        boolean encontrado = false;
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(pesquisaPlaca)) {
                System.out.println("Veículos encontrados: ");
                System.out.println(veiculo.toString());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum veículo encontrado com a placa: " + pesquisaPlaca);
        }
    }

    static void pesquisaPorModelo() {
        String pesquisaModelo = Input.scanString("Digite o modelo do veículo que deseja pesquisar: ", scan);
        boolean encontrado = false;
        System.out.println("Veículos encontrados: ");
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getModelo().contains(pesquisaModelo)) {
                System.out.println(veiculo.toString());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum veículo encontrado.");
        }
    }
}
