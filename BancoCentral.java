
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BancoCentral {

	private String nome;
	private String conta;
	private String endereco;
	private TipoAgencia tipoAgencia;
	private List<Agencia> agencia;
	private static Map<String, BancoCentral> bancoMap = new HashMap<>();
	private static Scanner scan = new Scanner(System.in);
	
	public BancoCentral(){
    }
    
	public BancoCentral(String nome, String conta, String endereco, TipoAgencia tipoAgencia, List<Agencia> agencia) {
		super();
		this.nome = nome;
		this.conta = conta;
		this.endereco = endereco;
		this.tipoAgencia = tipoAgencia;
		this.agencia = agencia;
	}
	
	public static void incluirAgencia() {
		BancoCentral agencia = new BancoCentral();

		List<Agencia> agencias = new ArrayList<Agencia>();
		
		System.out.println("Informe o nome da agencia: ");
		agencia.setNome(scan.next());
		
		System.out.println("Informe o tipo de agencia:");
		for (TipoAgencia tipo : TipoAgencia.values()) {
			System.out.println(tipo.getId() + " - " + tipo.getDescricao());
		}

		agencia.setTipoAgencia(TipoAgencia.valueOf(scan.nextInt()));
		
		System.out.println("Informe o numero da conta: ");
		agencia.setConta(scan.next());
		
		System.out.println("Informe o numero da agencia:");
		String numero = scan.next();
		
		System.out.println("Informe o estado da agencia:");
		String estado = scan.next();
		
		System.out.println("Informe a cidade da agencia:");
		String cidade = scan.next();
		
		agencias.add(new Agencia(numero, estado, cidade));
		agencia.setAgencia(agencias);
		
		System.out.println("Informe o endereco da agencia: ");
		agencia.setEndereco(scan.next());

		bancoMap.put(agencia.getNome(), agencia);
		System.out.println("Agencia Cadastrada!");
	}
	
	public static void alterarAgencia() {
		
	}
	
	public static void excluirAgencia() {
		
	}
	
	public static void listarAgencia() {
		if (bancoMap.isEmpty()) {
			System.out.println("Nenhuma agencia cadastrada.");
		} else {
			List<BancoCentral> agenciasOrdenados = new ArrayList<>(bancoMap.values());

			agenciasOrdenados.sort((o1, o2) -> o1.getNome().compareTo(o2.getNome()));
			
			System.out.println("Lista das agencias");
			agenciasOrdenados.forEach(agencia -> System.out.println(agencia));

		}
	}
	
	public static void menu() {
		System.out.println("Menu:");
		System.out.println("1 - Incluir Agencia");
		System.out.println("2 - Alterar Agencia");
		System.out.println("3 - Excluir Agencia");
		System.out.println("4 - Listar Agencia");
		System.out.println("0 - Sair");
		System.out.print("Escolha uma opcao: \n");
	}
	
	@Override
	public String toString() {
		return "nome: " + nome + ", conta: "+ conta + ", agencia: " + agencia.toString() + ", endereco: " + endereco + ", tipoAgencia: "
				+ tipoAgencia.getDescricao();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getConta() {
		return conta;
	}
	
	public void setConta(String conta) {
		this.conta = conta;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public TipoAgencia getTipoAgencia() {
		return tipoAgencia;
	}
	
	public void setTipoAgencia(TipoAgencia tipoAgencia) {
		this.tipoAgencia = tipoAgencia;
	}
	
	public List<Agencia> getAgencia() {
		return agencia;
	}
	
	public void setAgencia(List<Agencia> agencia) {
		this.agencia = agencia;
	}
}
