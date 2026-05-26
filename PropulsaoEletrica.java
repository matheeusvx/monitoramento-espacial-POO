public class PropulsaoEletrica extends SistemaPropulsao {
    private double consumoEnergiaKw;
    private double eficienciaIonizacao;

    public PropulsaoEletrica(String modelo, double empuxoMaximo, double consumoEnergiaKw, double eficienciaIonizacao) {
        super(modelo, empuxoMaximo);
        setConsumoEnergiaKw(consumoEnergiaKw);
        setEficienciaIonizacao(eficienciaIonizacao);
    }

    @Override
    public void acelerar(double percentualPotencia) {
        if (!validarPotencia(percentualPotencia)) {
            return;
        }

        double potenciaAjustada = percentualPotencia * (eficienciaIonizacao / 100.0);
        setPotenciaAtual(potenciaAjustada);

        System.out.println("Propulsão elétrica acelerada.");
        System.out.println("Consumo estimado: " + String.format("%.2f", consumoEnergiaKw * (percentualPotencia / 100.0)) + " kW");
        System.out.println("Potência solicitada: " + percentualPotencia + "%");
        System.out.println("Potência efetiva: " + String.format("%.2f", potenciaAjustada) + "%");
        System.out.println("Empuxo elétrico gerado: " + String.format("%.2f", calcularEmpuxoGerado()) + " kN");
    }

    public double getConsumoEnergiaKw() {
        return consumoEnergiaKw;
    }

    public void setConsumoEnergiaKw(double consumoEnergiaKw) {
        if (consumoEnergiaKw > 0) {
            this.consumoEnergiaKw = consumoEnergiaKw;
        } else {
            this.consumoEnergiaKw = 10;
        }
    }

    public double getEficienciaIonizacao() {
        return eficienciaIonizacao;
    }

    public void setEficienciaIonizacao(double eficienciaIonizacao) {
        if (eficienciaIonizacao > 0 && eficienciaIonizacao <= 100) {
            this.eficienciaIonizacao = eficienciaIonizacao;
        } else {
            this.eficienciaIonizacao = 90;
        }
    }
}
