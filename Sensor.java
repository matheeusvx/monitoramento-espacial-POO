public interface Sensor {
    double lerValor();
    boolean verificarFuncionamento();
    String retornarTipo();
    void definirLimiteAlerta(double limite);
    double getLimiteAlerta();
}
