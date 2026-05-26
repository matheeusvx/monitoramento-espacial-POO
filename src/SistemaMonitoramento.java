import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaMonitoramento {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Sensor> sensores = new ArrayList<>();
    private static final List<SistemaPropulsao> propulsores = new ArrayList<>();
    private static DadosMissao dadosMissao;
    private static ModuloHabitat moduloHabitat;

    public static void main(String[] args) {
        inicializarSistema();
        executarMenuPrincipal();
    }

    private static void inicializarSistema() {
        sensores.add(new SensorTemperatura(70));
        sensores.add(new SensorPressao(180));
        sensores.add(new SensorRadiacao(5));

        propulsores.add(new PropulsaoQuimica("QMX-900", 1500, "Hidrogênio líquido", 85));
        propulsores.add(new PropulsaoEletrica("ION-45", 450, 300, 95));

        dadosMissao = new DadosMissao("X: 8421 | Y: 3912 | Z: 7710", "1234", 75, "Órbita baixa terrestre para Marte", 6);
        moduloHabitat = new ModuloHabitat("HAB-01", "Módulo Habitat Principal", 22, 6, 92);
    }

    private static void executarMenuPrincipal() {
        int opcao;

        do {
            System.out.println("\n========================================");
            System.out.println(" PLATAFORMA DE MONITORAMENTO ESPACIAL");
            System.out.println("========================================");
            System.out.println("1 - Verificar sensores");
            System.out.println("2 - Controlar propulsão");
            System.out.println("3 - Gerenciar dados da missão");
            System.out.println("4 - Simular alertas");
            System.out.println("5 - Exibir status completo");
            System.out.println("0 - Encerrar sistema");
            System.out.print("Escolha uma opção: ");

            opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    verificarSensores();
                    break;
                case 2:
                    controlarPropulsao();
                    break;
                case 3:
                    gerenciarDadosMissao();
                    break;
                case 4:
                    simularAlertas();
                    break;
                case 5:
                    exibirStatusCompleto();
                    break;
                case 0:
                    System.out.println("Sistema encerrado. Boa viagem espacial!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void verificarSensores() {
        System.out.println("\n--- Verificação de Sensores ---");

        for (Sensor sensor : sensores) {
            double valor = sensor.lerValor();
            System.out.println("\nTipo: " + sensor.retornarTipo());
            System.out.println("Funcionamento: " + (sensor.verificarFuncionamento() ? "Operacional" : "Falha detectada"));
            System.out.println("Valor lido: " + String.format("%.2f", valor));
            System.out.println("Limite de alerta: " + sensor.getLimiteAlerta());
            emitirAlerta(sensor, valor);
        }
    }

    private static void emitirAlerta(Sensor sensor, double valor) {
        if (!sensor.verificarFuncionamento()) {
            System.out.println("CRÍTICO: o " + sensor.retornarTipo() + " está com falha de funcionamento!");
            return;
        }

        double limite = sensor.getLimiteAlerta();

        if (valor >= limite * 1.5) {
            System.out.println("CRÍTICO: " + sensor.retornarTipo() + " muito acima do limite!");
        } else if (valor >= limite * 1.2) {
            System.out.println("ALERTA: " + sensor.retornarTipo() + " acima do limite seguro!");
        } else if (valor >= limite) {
            System.out.println("ATENÇÃO: " + sensor.retornarTipo() + " atingiu o limite de alerta.");
        } else {
            System.out.println("Status: valor dentro da faixa segura.");
        }
    }

    private static void controlarPropulsao() {
        System.out.println("\n--- Controle de Propulsão ---");
        listarPropulsores();
        System.out.print("Escolha o propulsor: ");
        int indice = lerInteiro() - 1;

        if (indice < 0 || indice >= propulsores.size()) {
            System.out.println("Propulsor inválido.");
            return;
        }

        SistemaPropulsao propulsor = propulsores.get(indice);

        System.out.println("\n1 - Ligar motor");
        System.out.println("2 - Desligar motor");
        System.out.println("3 - Acelerar");
        System.out.println("4 - Exibir status do motor");
        System.out.print("Escolha uma ação: ");
        int acao = lerInteiro();

        switch (acao) {
            case 1:
                propulsor.ligarMotor();
                break;
            case 2:
                propulsor.desligarMotor();
                break;
            case 3:
                System.out.print("Informe a potência desejada (0 a 100): ");
                double potencia = lerDouble();
                propulsor.acelerar(potencia);
                break;
            case 4:
                propulsor.exibirStatus();
                break;
            default:
                System.out.println("Ação inválida.");
        }
    }

    private static void listarPropulsores() {
        for (int i = 0; i < propulsores.size(); i++) {
            System.out.println((i + 1) + " - " + propulsores.get(i).getModelo());
        }
    }

    private static void gerenciarDadosMissao() {
        System.out.println("\n--- Gerenciamento de Dados da Missão ---");
        System.out.println("1 - Exibir dados públicos");
        System.out.println("2 - Consultar coordenadas protegidas");
        System.out.println("3 - Atualizar coordenadas protegidas");
        System.out.println("4 - Atualizar combustível");
        System.out.println("5 - Atualizar trajetória");
        System.out.println("6 - Atualizar número de tripulantes");
        System.out.print("Escolha uma opção: ");
        int opcao = lerInteiro();

        switch (opcao) {
            case 1:
                dadosMissao.exibirDadosPublicos();
                break;
            case 2:
                scanner.nextLine();
                System.out.print("Informe o código de acesso: ");
                String codigoConsulta = scanner.nextLine();
                System.out.println("Coordenadas: " + dadosMissao.getCoordenadas(codigoConsulta));
                break;
            case 3:
                scanner.nextLine();
                System.out.print("Informe o código de acesso: ");
                String codigoAlteracao = scanner.nextLine();
                System.out.print("Informe as novas coordenadas: ");
                String novasCoordenadas = scanner.nextLine();
                dadosMissao.setCoordenadas(novasCoordenadas, codigoAlteracao);
                break;
            case 4:
                System.out.print("Informe o novo nível de combustível (0 a 100): ");
                dadosMissao.setNivelCombustivel(lerDouble());
                break;
            case 5:
                scanner.nextLine();
                System.out.print("Informe a nova trajetória: ");
                dadosMissao.setTrajetoria(scanner.nextLine());
                System.out.println("Trajetória atualizada.");
                break;
            case 6:
                System.out.print("Informe o número de tripulantes: ");
                dadosMissao.setNumeroTripulantes(lerInteiro());
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void simularAlertas() {
        System.out.println("\n--- Simulação de Alertas ---");
        System.out.println("Executando simulação com leituras automáticas...");
        verificarSensores();
        dadosMissao.setNivelCombustivel(15);
        System.out.println("Simulação concluída.");
    }

    private static void exibirStatusCompleto() {
        System.out.println("\n--- Status Completo da Plataforma ---");
        moduloHabitat.executarDiagnostico();

        dadosMissao.exibirDadosPublicos();

        System.out.println("\n--- Status dos Propulsores ---");
        for (SistemaPropulsao propulsor : propulsores) {
            System.out.println();
            propulsor.exibirStatus();
        }

        System.out.println("\n--- Status dos Sensores ---");
        for (Sensor sensor : sensores) {
            System.out.println(sensor.retornarTipo() + " - Limite: " + sensor.getLimiteAlerta());
        }
    }

    private static int lerInteiro() {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Digite um número inteiro: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double lerDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Entrada inválida. Digite um número: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
