
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
		String numero;
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
		numero = scan.next();
		
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
		if(bancoMap.isEmpty()){
			System.out.println("Nenhuma agência cadastrada");
		} else {
			System.out.println("Digite o nome da agência que deseja alterar: ");
			String nomeAgencia = scan.next();

			BancoCentral bancoCentral = bancoMap.get(nomeAgencia);
			if (bancoCentral == null) {
				System.out.println("Agencia não encontrada.");
			} else {

				System.out.println("O que deseja alterar");

				List<BancoCentral> agenciasOrdenados = new ArrayList<>(bancoMap.values());

				agenciasOrdenados.sort((o1, o2) -> o1.getNome().compareTo(o2.getNome()));
				
				System.out.println("Lista das agencias");
				agenciasOrdenados.forEach(agencia -> System.out.println(agencia));
				
				
				System.out.println(" ");
				
				System.out.println("1 - Nome da conta");
				System.out.println("2 - Número da conta");
				System.out.println("3 - Número da agência");
				System.out.println("4 - Nome do Estado");
				System.out.println("5 - Nome da Cidade");
				System.out.println("6 - Endereço");

				System.out.println();
				
				int opcao = scan.nextInt();

				switch (opcao) {
					case 1:
						System.out.println("Digite o novo nome da agência: ");
						String novoNome = scan.next();
			
						BancoCentral banco = bancoMap.get(nomeAgencia);
						if (banco == null) {
							System.out.println("Agência não encontrada");
						} else {
							bancoCentral.setNome(novoNome);
							bancoMap.remove(nomeAgencia);
							bancoMap.put(novoNome, banco);
							System.out.println("O nome da Agência foi alterado para: " + novoNome);
						}
						break;
						
					case 2:
						System.out.println("Digite o novo número da conta: ");
						String novoNumeroConta = scan.next();

						banco = bancoMap.get(nomeAgencia);
						if (banco == null) {
							System.out.println("Agência não encontrada.");
						} else {
							banco.setConta(novoNumeroConta);
							bancoMap.put(nomeAgencia, banco);
							System.out.println("O número da conta foi alterado para: " + novoNumeroConta);
						}
						break;
						
					case 3:
						System.out.println("Digite o novo número da agência: ");
						String novoNumeroAgencia = scan.next();
						
						banco = bancoMap.get(nomeAgencia);
						if (banco == null) {
							System.out.println("Agência não encontrada.");
						} else {
							List<Agencia> agencias = banco.getAgencia();
							
							for (Agencia agencia : agencias) {
								agencia.setNumero(novoNumeroAgencia);
							}
							bancoMap.put(nomeAgencia, banco);
							System.out.println("O número da agência foi alterado para: " + novoNumeroAgencia);
						}
					break;

					case 4:
						System.out.println("Digite o novo nome do estado: ");
						String novoNomeEstado = scan.next();
						
						banco = bancoMap.get(nomeAgencia);
						if (banco == null) {
							System.out.println("Agência não encontrada.");
						} else {
							List<Agencia> agencias = banco.getAgencia();
							
							for (Agencia agencia : agencias) {
								agencia.setEstado(novoNomeEstado);
							}
							bancoMap.put(nomeAgencia, banco);
							System.out.println("O nome do estado foi alterado para: " + novoNomeEstado);
						}
					break;
					
					case 5:
						System.out.println("Digite o novo nome da cidade: ");
						String novoNomeCidade = scan.next();
						
						banco = bancoMap.get(nomeAgencia);
						if (banco == null) {
							System.out.println("Agência não encontrada.");
						} else {
							List<Agencia> agencias = banco.getAgencia();
							
							for (Agencia agencia : agencias) {
								agencia.setCidade(novoNomeCidade);
							}
							bancoMap.put(nomeAgencia, banco);
							System.out.println("O nome da cidade foi alterado para: " + novoNomeCidade);
						}
						
						break;

					case 6:
						System.out.println("Digite o novo endereço: ");
						String novoEndereco = scan.next();

						banco = bancoMap.get(nomeAgencia);
						if (banco == null) {
							System.out.println("Agência não encontrada.");
						} else {
							banco.setEndereco(novoEndereco);
							bancoMap.put(nomeAgencia, banco);
							System.out.println("O número da conta foi alterado para: " + novoEndereco);
						}
						break;
						
					default:
						System.out.println("Opção inexistente");
						break;
				}
			}
		}
	}
	
	public static void excluirAgencia() {
		if (bancoMap.isEmpty()) {
			System.out.println("Nenhuma agência cadastrada.");
		} else {
			System.out.println("Digite o nome da agência que deseja excluir: ");
			String nomeAgencia = scan.next();
	
			BancoCentral bancoCentral = bancoMap.get(nomeAgencia);
			if (bancoCentral == null) {
				System.out.println("Agência não encontrada.");
			} else {
				bancoMap.remove(nomeAgencia);
				System.out.println("Agência '" + nomeAgencia + "' excluída com sucesso.");
			}
		}
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
		return "nome: " + nome + "\nconta: "+ conta + "\nagencia: " + agencia.toString() + "\nendereco: " + endereco + "\ntipoAgencia: "
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
