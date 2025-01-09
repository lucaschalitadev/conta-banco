package contaBanco;
import java.util.Scanner;
import java.util.Random;

public class ContaBanco {

	public static void main(String[] args) {
		Random entradaAleatoria = new Random();
		Scanner usuario = new Scanner(System.in);
		int controladorDeposito = 0, controladorSaque = 0;
		int i;
		Conta01 c1 = new Conta01();
		do {
		System.out.println("====== B E M  V I N D O (A)   A O   B A N C O  T E S T E! ======");
		System.out.println("====== DIGITE 1 PARA: ABRIR CONTA ======");
		System.out.println("====== DIGITE 2 PARA: CONSULTAR SALDO DA CONTA ======");
		System.out.println("====== DIGITE 3 PARA: FAZER DEPÓSITO ======");
		System.out.println("====== DIGITE 4 PARA: FAZER SAQUE ======");
		System.out.println("====== DIGITE 5 PARA: CONSULTAR STATUS DA CONTA ======");
		System.out.println("====== DIGITE 6 PARA: FECHAR CONTA ======");
		System.out.print("DIGITE AQUI: ");
		i = usuario.nextInt();
		switch (i) {
			case 1:
				System.out.print("DIGITE AQUI SEU NOME: ");
				String dono = usuario.next();
				System.out.print("DIGITE AQUI O TIPO DE CONTA DESEJADO ('CC' para conta corrente e 'CP' para conta poupança: ");
				String tipo = usuario.next();
				System.out.print("DIGITE AQUI SEU DEPÓSITO INICIAL: ");
				double depositoInicial = usuario.nextDouble();
				c1.abrirConta(dono, tipo, depositoInicial);
				break;
			case 2: 
				System.out.print("SEU SALDO É DE: R$" + c1.getSaldoConta() + ".");
				break;
			case 3:
				System.out.print("QUAL VALOR, EM REAIS, VOCÊ DESEJA DEPOSITAR?");
				double deposito = usuario.nextDouble();
				c1.depositar(deposito);
				controladorDeposito++;
				break;
			case 4:
				System.out.print("QUAL VALOR, EM REAIS, VOCÊ DESEJA SACAR?");
				double saque = usuario.nextDouble();
				c1.sacar(saque);
				controladorSaque++;
				break;
			case 5:
				c1.estadoAtual();
				break;
			case 6:
				c1.fecharConta();
				break;
			default: System.out.print("CARACTERE INVÁLIDO.");
			}
		} while (i != 6);
		
	}

}
