public class PropulsaoQuimica extends SistemaPropulsao {
    private String tipoCombustivel;
    private double eficienciaCombustao;

    public PropulsaoQuimica(String modelo, double empuxoMaximo, String tipoCombustivel, double eficienciaCombustao) {
        super(modelo, empuxoMaximo);
        this.tipoCombustivel = tipoCombustivel;
        setEficienciaCombustao(eficienciaCombustao);
    }

    @Override
    public void acelerar(double percentualPotencia) {
        if (!validarPotencia(percentualPotencia)) {
            return;
        }

        double potenciaAjustada = percentualPotencia * (eficienciaCombustao / 100.0);
        setPotenciaAtual(potenciaAjustada);

        System.out.println("Propulsão química acelerada.");
        System.out.println("Combustível utilizado: " + tipoCombustivel);
        System.out.println("Potência solicitada: " + percentualPotencia + "%");
        System.out.println("Potência efetiva: " + String.format("%.2f", potenciaAjustada) + "%");
        System.out.println("Empuxo químico gerado: " + String.format("%.2f", calcularEmpuxoGerado()) + " kN");
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        if (tipoCombustivel != null && !tipoCombustivel.trim().isEmpty()) {
            this.tipoCombustivel = tipoCombustivel;
        }
    }

    public double getEficienciaCombustao() {
        return eficienciaCombustao;
    }

    public void setEficienciaCombustao(double eficienciaCombustao) {
        if (eficienciaCombustao > 0 && eficienciaCombustao <= 100) {
            this.eficienciaCombustao = eficienciaCombustao;
        } else {
            this.eficienciaCombustao = 80;
        }
    }
}
