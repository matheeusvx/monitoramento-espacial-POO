import java.util.Random;

public class SensorRadiacao implements Sensor {
    private final Random random = new Random();
    private double limiteAlerta;
    private boolean ativo;

    public SensorRadiacao(double limiteAlerta) {
        this.limiteAlerta = limiteAlerta;
        this.ativo = true;
    }

    @Override
    public double lerValor() {
        return random.nextDouble() * 10; // 0 a 10 mSv/h
    }

    @Override
    public boolean verificarFuncionamento() {
        return ativo;
    }

    @Override
    public String retornarTipo() {
        return "Sensor de Radiação";
    }

    @Override
    public void definirLimiteAlerta(double limite) {
        if (limite >= 0) {
            this.limiteAlerta = limite;
        }
    }

    @Override
    public double getLimiteAlerta() {
        return limiteAlerta;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
