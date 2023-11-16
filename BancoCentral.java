
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
	
	
	public BancoCentral(String nome, String conta, String endereco, TipoAgencia tipoAgencia, List<Agencia> agencia) {
		super();
		this.nome = nome;
		this.conta = conta;
		this.endereco = endereco;
		this.tipoAgencia = tipoAgencia;
		this.agencia = agencia;
	}
	
	public static void incluirAgencia() {
		
	}
	
	public static void alterarAgencia() {
		
	}
	
	public static void excluirAgencia() {
		
	}
	
	public static void listarAgencia() {
		
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
