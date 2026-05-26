public abstract class ComponenteEspacial {
    private String id;
    private String nome;
    private boolean ligado;
    private double temperatura;

    public ComponenteEspacial(String id, String nome, double temperatura) {
        this.id = id;
        this.nome = nome;
        setTemperatura(temperatura);
        this.ligado = false;
    }

    public void ligar() {
        ligado = true;
        System.out.println(nome + " foi ligado com sucesso.");
    }

    public void desligar() {
        ligado = false;
        System.out.println(nome + " foi desligado com sucesso.");
    }

    public abstract void executarDiagnostico();

    public String getStatus() {
        return ligado ? "Ligado" : "Desligado";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        }
    }

    public boolean isLigado() {
        return ligado;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        if (temperatura >= -273.15) {
            this.temperatura = temperatura;
        } else {
            System.out.println("Temperatura inválida. Valor não alterado.");
        }
    }
}
