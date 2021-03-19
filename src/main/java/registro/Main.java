package registro;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class Main {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Equipamentos> ListaEquipamentos = new ArrayList();
    static ArrayList<Chamadas> ListaChamadas = new ArrayList();
    public static void main(String[] args) {
        Registro registro = new Registro("regitstro", ListaEquipamentos);
        Chamadas chamadas = new Chamadas("1", "1","1");
        
        //estrutura de repeticao até o usuario digitar x 
        String opcaoUsuario = ObterOpcaoUsuario();
        while (!"X".equals(opcaoUsuario.toUpperCase())){
            switch (opcaoUsuario){
                //opções para o funcionario
                case "1":
                    RegistrarEquipamentos();
                    registro.setEquipamentos(ListaEquipamentos);
                    break;
                case "2":
                    ListarEquipamentos();
                    break;
                case "3":
                    EditarEquipamentos();
                    break;
                case "4":
                    ExcluirEquipamentos();
                    break;
                case "5":
                    RegistrarChamada();
                    break;
                case "6":
                    ListarChamadas();
                    break;
                case "7":
                    EditarChamada();
                    break;
                case "8":
                    ExcluirChamada();
                    break;
            }
        opcaoUsuario = ObterOpcaoUsuario();
    }
}
    
    //obtem escolha de funcionario
    private static String ObterOpcaoUsuario(){
        System.out.println("------------------------------------");
        System.out.println("Informe a opção desejada: ");
        System.out.println("1- Registrar equipamentos");
        System.out.println("2- Vizualisar equipamentos");
        System.out.println("3- Editar um equipamento");
        System.out.println("4- Excluir um equipamento");
        System.out.println("5- Registrar uma chamada");
        System.out.println("6- Vizualizar chamadas");
        System.out.println("7- Editar uma chamada");
        System.out.println("8- Excluir uma chamada");
        System.out.println("X- Sair do programa. ");
        String opcaoUsuario = input.nextLine().toUpperCase();
        return opcaoUsuario;
        
    }
    //lista os equipamentos
    private static void ListarEquipamentos(){
        if (ListaEquipamentos.isEmpty()) {
            System.out.println("Nenhum produto registrado!");
            return;
        }
        System.out.println("-------Lista de equipamentos--------");
        for (Equipamentos equipamentos: ListaEquipamentos) {
            System.out.println(equipamentos);
        }
    }
    
    //registras os equipamentos
    private static void RegistrarEquipamentos(){
        System.out.println("Digite o nome do equipamento: ");
        String nomeP = input.nextLine();
        
        //minimo de 6 caracteres
        while(nomeP.length()<6){
            System.out.println("O nome deve ter no mínimo 6 letras, digite o nome do equipamento novamente! ");
            nomeP = input.nextLine();
        }
        
        //solicita informacoes 
        System.out.println("Digite o preço do equipamento");
        int precoAq = Integer.valueOf(input.nextLine());
        System.out.println("Digite o número da série: ");
        int nserie = Integer.valueOf(input.nextLine());
        System.out.println("Digite a data de fabricação: ");
        int data = Integer.valueOf(input.nextLine());
        System.out.println("Digite a fabricante: ");
        String fabricante = input.nextLine();
        Equipamentos equipamentos = new Equipamentos(nomeP, precoAq, nserie, data, fabricante);
        ListaEquipamentos.add(equipamentos); 
        System.out.println("Equipamento registrado com sucesso!");
    }
    
    //edita os equipamentos
    private static void EditarEquipamentos(){
        System.out.println("--------Editar Equipamento----------");
        System.out.println("Digite o número de série: ");
        int num_serie = Integer.valueOf(input.nextLine());
            
        //limita o número de letras como no registro
        System.out.println("Digite o novo nome do equipamento: ");
        String nomeP = input.nextLine();   
        while(nomeP.length()<6){
            
        System.out.println("O nome deve ter no mínimo 6 letras, digite o novo nome do equipamento novamente! ");
        nomeP = input.nextLine();
        }
            
        //pede as informações assim como no requisito 1 
        System.out.println("Digite o novo preço do equipamento");
        int precoAq = Integer.valueOf(input.nextLine());
        System.out.println("Digite o novo número da série: ");
        int nserie = Integer.valueOf(input.nextLine());
        System.out.println("Digite a nova data de fabricação: ");
        int data = Integer.valueOf(input.nextLine());
        System.out.println("Digite a nova fabricante: ");
        String fabricante = input.nextLine();
            
        Equipamentos equipamentos = new Equipamentos(nomeP, precoAq, nserie, data, fabricante);
        ListaEquipamentos.set(num_serie-1, equipamentos);
        System.out.println("Equipamento de série "+num_serie+" editado com sucesso!");
    }
    
    //deleta os equipamentos, de acordo com o numero de serie dos mesmos
    //porem este método só funcionou quando o numero de serie dos equipamentos 
    //que fossem deletados começassem em do 1 ou em ordem crescente 
    //por ex: ao registrar 2 equipamentos, se eu deletar o equipamento número 1, 
    //logo em sequida se eu tentar apagar o número 2 daria erro,
    //pois ele iria buscar o 2-1 = 1, e só teria equipamento na posição 0
    private static void ExcluirEquipamentos(){
        System.out.println("---------Excluir Equipamento--------");
        System.out.println("Digite o número de série do equipamento: ");
        int num_serie = Integer.valueOf(input.nextLine());
        
        ListaEquipamentos.remove(num_serie-1);
        System.out.println("Equipamento de série "+num_serie+" removido com sucesso! ");
    }
    
    //registra chamada
    private static void RegistrarChamada(){
        System.out.println("Digite o nome da chamada: ");
        String nomeC = input.nextLine();
        System.out.println("Digite a descrição da chamada: ");
        String desc = input.nextLine();
        System.out.println("Digite o nome do equipamento: ");
        String equipamentoC = input.nextLine();

        diasAposChamado();

        Chamadas chamadas = new Chamadas (nomeC, desc, equipamentoC);
        ListaChamadas.add(chamadas);
        
    }
    
    //lista as chamadas
    private static void ListarChamadas(){
        if (ListaChamadas.isEmpty()) {
            System.out.println("Nenhuma chamada registrado!");
            return;
        }
        System.out.println("--------Lista de chamadas--------");
        for (Chamadas chamadas: ListaChamadas) {
            System.out.println(chamadas);
        }
    }
    
    //editar chamadas, nao consegui da realizar da melhor forma, pra ficar funcional
    //pedi que o usuario desse entrada com a numeracao da chamada de acordo com a lista que aparecia no console,
    //assim eu conseguia chamar a chamada e edita-lá,
    //mas o mesmo problema do registar equipamento aqui aparece e foi aonde eu tive
    //mais dificuldade.
    private static void EditarChamada(){
        System.out.println("---------Editar Chamada------------");
        System.out.println("Lista de chamdas: ");
        for (Chamadas chamadas: ListaChamadas) {
            System.out.println(chamadas);
        }
        
        System.out.println("Qual camada deseja editar? (Digite pela numeração, ex: primeira chamada será 1(...)");
        int escolha = Integer.valueOf(input.nextLine());
        
        System.out.println("Digite o novo nome da chamada: ");
        String nomeC = input.nextLine();
        System.out.println("Digite a nova descrição da chamada: ");
        String desc = input.nextLine();
        System.out.println("Digite o novo nome do equipamento: ");
        String equipamentoC = input.nextLine();
        System.out.println("Digite a nova data de abertura da chamada: ");
        
        diasAposChamado();
        
        Chamadas chamadas = new Chamadas (nomeC, desc, equipamentoC );
        ListaChamadas.set(escolha-1, chamadas);
        System.out.println("Chamada nº: "+escolha+" editada com sucesso!");     
    }
    
    //deleta chamadas, baseado no mesmo esquema do EditarChamadas agora removendo a chamada
    private static void ExcluirChamada(){
        System.out.println("----------Excluir Chamada-----------");
        System.out.println("Lista de chamdas: ");
        for (Chamadas chamadas: ListaChamadas) {
            System.out.println(chamadas);
        }
        
        System.out.println("Qual camada deseja excliur? (Digite pela numeração, ex: primeira chamada será 1(...)");
        int escolha = Integer.valueOf(input.nextLine());
        ListaChamadas.remove(escolha-1);
        System.out.println("Chamada nº: "+escolha+" removida com sucesso!");
 
    }
    
    //dias que o chamado esteve aberto
    public static void diasAposChamado(){
        System.out.println("Data de abertura");
        Scanner sc = new Scanner(System.in);
        
        //usuario da entrada nos dados
        System.out.println("Ano:");
        int ano = sc.nextInt();

        System.out.println("Digite a data no formato exato: dd.MM. HH:mm");
        sc.nextLine();
        sc.findInLine("(\\d\\d)\\.(\\d\\d)\\. (\\d\\d):(\\d\\d)");
        try {
            MatchResult mr = sc.match();
            int mes = Integer.parseInt(mr.group(2));
            int dia = Integer.parseInt(mr.group(1));
            int hora = Integer.parseInt(mr.group(3));
            int minuto = Integer.parseInt(mr.group(4));
            LocalDateTime dt = LocalDateTime.of(ano, mes, dia, hora, minuto);
            System.out.println(dt);
            LocalDateTime hoje = LocalDateTime.now();
            
            //calcula a diferenca
            long dias = dt.until(hoje, ChronoUnit.DAYS);
            System.out.println("Dias que o chamado esteve aberto: "+dias);
            
        } catch (IllegalStateException e) {
            System.err.println("Formato de data inválida!");
        }
    }
}    

