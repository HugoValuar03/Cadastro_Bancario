import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int opcao;
		
		Scanner scan = new Scanner(System.in);

		do {
			BancoCentral.menu();
			opcao = scan.nextInt();
			
			switch (opcao) {
			case 1:
				BancoCentral.incluirAgencia();
				break;
			case 2:
				BancoCentral.alterarAgencia();
				break;
			case 3:
				BancoCentral.excluirAgencia();
				break;
			case 4:
				BancoCentral.listarAgencia();
				break;
			case 0:
				System.out.println("Saindo do programa.");
				break;
			default:
				System.out.println("Opcao invalida. Tente novamente.");
				break;
			}

		} while (opcao != 0);
	}
	
}
