package registro;
import java.util.Date;


public class Chamadas {
    private String nomeC;
    private String desc;
    private String equipamentoC;

    public Chamadas(String nomeC, String desc, String equipamentoC) {
        this.nomeC = nomeC;
        this.desc = desc;
        this.equipamentoC = equipamentoC;
    }

    public String getNomeC() {
        return nomeC;
    }

    public void setNomeC(String nomeC) {
        this.nomeC = nomeC;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getEquipamentoC() {
        return equipamentoC;
    }

    public void setEquipamentoC(String equipamentoC) {
        this.equipamentoC = equipamentoC;
    }

    @Override
    public String toString() {
        return "Chamadas{" + "Nome da chamada: " + nomeC + ", Equipamento: " 
                + equipamentoC + '}';
    }
   
    
    
}
