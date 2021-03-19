package registro;


public class Equipamentos {
    private String nomeP;
    private int precoAq;
    private int nserie;
    private int data;
    private String fabricante;

    public Equipamentos(String nome, int precoAq, int nserie, int data, String fabricante) {
        this.nomeP = nome;
        this.precoAq = precoAq;
        this.nserie = nserie;
        this.data = data;
        this.fabricante = fabricante;
    }

    public String getNomeP() {
        return nomeP;
    }

    public void setNomeP(String nomeP) {
        this.nomeP = nomeP;
    }

    public int getPrecoAq() {
        return precoAq;
    }

    public void setPrecoAq(int precoAq) {
        this.precoAq = precoAq;
    }

    public int getNserie() {
        return nserie;
    }

    public void setNserie(int nserie) {
        this.nserie = nserie;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return "Equipamentos{" + "Nome: " + nomeP +  ", Número de série: " + nserie +  ", Fabricante: " + fabricante + '}';
    }
    
    
}
