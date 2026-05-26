public abstract class SistemaPropulsao {
    private String modelo;
    private boolean ligado;
    private double potenciaAtual;
    private double empuxoMaximo;

    public SistemaPropulsao(String modelo, double empuxoMaximo) {
        this.modelo = modelo;
        setEmpuxoMaximo(empuxoMaximo);
        this.potenciaAtual = 0;
        this.ligado = false;
    }

    public void ligarMotor() {
        ligado = true;
        System.out.println("Motor " + modelo + " ligado.");
    }

    public void desligarMotor() {
        ligado = false;
        potenciaAtual = 0;
        System.out.println("Motor " + modelo + " desligado.");
    }

    public abstract void acelerar(double percentualPotencia);

    public double calcularEmpuxoGerado() {
        return empuxoMaximo * (potenciaAtual / 100.0);
    }

    protected boolean validarPotencia(double percentualPotencia) {
        if (!ligado) {
            System.out.println("O motor está desligado. Ligue o motor antes de acelerar.");
            return false;
        }

        if (percentualPotencia < 0 || percentualPotencia > 100) {
            System.out.println("Potência inválida. Informe um valor entre 0 e 100.");
            return false;
        }

        return true;
    }

    public String getModelo() {
        return modelo;
    }

    public boolean isLigado() {
        return ligado;
    }

    public double getPotenciaAtual() {
        return potenciaAtual;
    }

    protected void setPotenciaAtual(double potenciaAtual) {
        if (potenciaAtual >= 0 && potenciaAtual <= 100) {
            this.potenciaAtual = potenciaAtual;
        }
    }

    public double getEmpuxoMaximo() {
        return empuxoMaximo;
    }

    public void setEmpuxoMaximo(double empuxoMaximo) {
        if (empuxoMaximo > 0) {
            this.empuxoMaximo = empuxoMaximo;
        } else {
            this.empuxoMaximo = 1;
        }
    }

    public void exibirStatus() {
        System.out.println("Modelo: " + modelo);
        System.out.println("Status: " + (ligado ? "Ligado" : "Desligado"));
        System.out.println("Potência atual: " + potenciaAtual + "%");
        System.out.println("Empuxo gerado: " + String.format("%.2f", calcularEmpuxoGerado()) + " kN");
    }
}
