public class DadosMissao {
    private String coordenadas;
    private String codigoAcesso;
    private double nivelCombustivel;
    private String trajetoria;
    private int numeroTripulantes;

    public DadosMissao(String coordenadas, String codigoAcesso, double nivelCombustivel, String trajetoria, int numeroTripulantes) {
        this.coordenadas = coordenadas;
        setCodigoAcesso(codigoAcesso);
        setNivelCombustivel(nivelCombustivel);
        setTrajetoria(trajetoria);
        setNumeroTripulantes(numeroTripulantes);
    }

    public String getCoordenadas(String codigoInformado) {
        if (validarCodigo(codigoInformado)) {
            return coordenadas;
        }
        return "Acesso negado: código de acesso inválido.";
    }

    public void setCoordenadas(String novasCoordenadas, String codigoInformado) {
        if (!validarCodigo(codigoInformado)) {
            System.out.println("Acesso negado. Coordenadas não alteradas.");
            return;
        }

        if (novasCoordenadas != null && !novasCoordenadas.trim().isEmpty()) {
            this.coordenadas = novasCoordenadas;
            System.out.println("Coordenadas atualizadas com sucesso.");
        } else {
            System.out.println("Coordenadas inválidas.");
        }
    }

    private boolean validarCodigo(String codigoInformado) {
        return codigoAcesso.equals(codigoInformado);
    }

    public void setCodigoAcesso(String codigoAcesso) {
        if (codigoAcesso != null && codigoAcesso.length() >= 4) {
            this.codigoAcesso = codigoAcesso;
        } else {
            this.codigoAcesso = "0000";
        }
    }

    public double getNivelCombustivel() {
        return nivelCombustivel;
    }

    public void setNivelCombustivel(double nivelCombustivel) {
        if (nivelCombustivel >= 0 && nivelCombustivel <= 100) {
            this.nivelCombustivel = nivelCombustivel;
            verificarAlertaCombustivel();
        } else {
            System.out.println("Nível de combustível inválido. Use valor entre 0 e 100.");
        }
    }

    public String getTrajetoria() {
        return trajetoria;
    }

    public void setTrajetoria(String trajetoria) {
        if (trajetoria != null && !trajetoria.trim().isEmpty()) {
            this.trajetoria = trajetoria;
        }
    }

    public int getNumeroTripulantes() {
        return numeroTripulantes;
    }

    public void setNumeroTripulantes(int numeroTripulantes) {
        if (numeroTripulantes >= 0) {
            this.numeroTripulantes = numeroTripulantes;
        } else {
            System.out.println("Número de tripulantes não pode ser negativo.");
        }
    }

    public void verificarAlertaCombustivel() {
        if (nivelCombustivel < 10) {
            System.out.println("CRÍTICO: combustível em nível extremamente baixo!");
        } else if (nivelCombustivel < 20) {
            System.out.println("ALERTA: combustível abaixo de 20%!");
        }
    }

    public void exibirDadosPublicos() {
        System.out.println("\n--- Dados Públicos da Missão ---");
        System.out.println("Trajetória: " + trajetoria);
        System.out.println("Tripulantes: " + numeroTripulantes);
        System.out.println("Combustível: " + nivelCombustivel + "%");
        verificarAlertaCombustivel();
    }
}
