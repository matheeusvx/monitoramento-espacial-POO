public class ModuloHabitat extends ComponenteEspacial {
    private int capacidadeTripulantes;
    private double nivelOxigenio;

    public ModuloHabitat(String id, String nome, double temperatura, int capacidadeTripulantes, double nivelOxigenio) {
        super(id, nome, temperatura);
        setCapacidadeTripulantes(capacidadeTripulantes);
        setNivelOxigenio(nivelOxigenio);
    }

    @Override
    public void executarDiagnostico() {
        System.out.println("\n--- Diagnóstico do Módulo de Habitat ---");
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Status: " + getStatus());
        System.out.println("Temperatura: " + getTemperatura() + " °C");
        System.out.println("Capacidade de tripulantes: " + capacidadeTripulantes);
        System.out.println("Nível de oxigênio: " + nivelOxigenio + "%");

        if (nivelOxigenio < 40) {
            System.out.println("CRÍTICO: nível de oxigênio muito baixo!");
        } else if (nivelOxigenio < 70) {
            System.out.println("ALERTA: nível de oxigênio abaixo do ideal.");
        } else {
            System.out.println("Sistema de habitat em condição operacional.");
        }
    }

    public int getCapacidadeTripulantes() {
        return capacidadeTripulantes;
    }

    public void setCapacidadeTripulantes(int capacidadeTripulantes) {
        if (capacidadeTripulantes > 0) {
            this.capacidadeTripulantes = capacidadeTripulantes;
        }
    }

    public double getNivelOxigenio() {
        return nivelOxigenio;
    }

    public void setNivelOxigenio(double nivelOxigenio) {
        if (nivelOxigenio >= 0 && nivelOxigenio <= 100) {
            this.nivelOxigenio = nivelOxigenio;
        }
    }
}
