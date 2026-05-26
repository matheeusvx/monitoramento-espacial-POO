import java.util.Random;

public class SensorTemperatura implements Sensor {
    private final Random random = new Random();
    private double limiteAlerta;
    private boolean ativo;

    public SensorTemperatura(double limiteAlerta) {
        this.limiteAlerta = limiteAlerta;
        this.ativo = true;
    }

    @Override
    public double lerValor() {
        return -20 + (random.nextDouble() * 120); // -20 a 100 °C
    }

    @Override
    public boolean verificarFuncionamento() {
        return ativo;
    }

    @Override
    public String retornarTipo() {
        return "Sensor de Temperatura";
    }

    @Override
    public void definirLimiteAlerta(double limite) {
        if (limite > -273.15) {
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
