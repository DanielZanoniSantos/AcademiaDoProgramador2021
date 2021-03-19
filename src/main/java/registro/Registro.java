package registro;


import java.util.ArrayList;


public class Registro {
    private String nome;
    private ArrayList<Equipamentos> equipamentos;

    public Registro(String nome, ArrayList<Equipamentos> equipamentos) {
        this.nome = nome;
        this.equipamentos = equipamentos;
    }

    public Registro() {
    
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Equipamentos> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(ArrayList<Equipamentos> equipamentos) {
        this.equipamentos = equipamentos;
    }

    @Override
    public String toString() {
        return "Registro{" + "nome=" + nome + ", equipamentos=" + equipamentos + '}';
    }
  
    
}
