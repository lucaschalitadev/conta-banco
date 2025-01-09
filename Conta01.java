package contaBanco;

public class Conta01 {
	//Atributos
	public int numConta;
	protected String tipoConta;
	private String donoConta;
	private double saldoConta;
	private boolean statusConta;
	
	//Método Construtor
	public Conta01() {
		this.setSaldoConta(0);
		this.setStatusConta(false);
	}
	
	//Métodos Getter e Setter
	public void setNumConta(int n) {
		this.numConta = n;
	}
	public int getNumConta() {
		return this.numConta;
	}
	public void setTipoConta (String t) {
		this.tipoConta = t;
	}
	public String getTipoConta() {
		return this.tipoConta;
	}
	public void setDonoConta (String d) {
		this.donoConta = d;
	}
	public String getDonoConta() {
		return this.donoConta;
	}
	public void setSaldoConta(double s) {
		this.saldoConta = s;
	}
	public double getSaldoConta() {
		return this.saldoConta;
	}
	public void setStatusConta (boolean status) {
		this.statusConta = status;
	}
	public boolean getStatusConta() {
		return this.statusConta;
	}
	
	//Métodos personalizados
	public void estadoAtual() {
		System.out.println("--------------------------------------------");
		System.out.println("Status da conta: " + this.getStatusConta());
		System.out.println("Conta: " + this.getNumConta());
		System.out.println("Dono: " + this.getDonoConta());
		System.out.println("Tipo: " + this.getTipoConta());
		System.out.println("Saldo: " + this.getSaldoConta());
	}
	public void abrirConta(String d, String t, double s) {
		this.setDonoConta(d);
		this.setTipoConta(t);
		this.setSaldoConta(s);
		this.setStatusConta(true);
		if (t == "CC") {
			this.setSaldoConta(this.getSaldoConta() + 50);
		} else if (t == "CP"){
			this.setSaldoConta(this.getSaldoConta() + 150);
		}
		System.out.println("CONTA ABERTA COM SUCESSO!");
	}
	
	public void fecharConta() {
		if (this.getSaldoConta() > 0.00) {
			System.out.print("A conta ainda está em uso. Esvazie-a para que seja possível fechá-la permanentemente.");
		} else if (this.getSaldoConta() < 0.00) {
			System.out.print("Você possui débito pendente na conta. Regularize quaisquer pagamentos para que seja possível fechar a conta permanentemente.");
		} else {
			this.setStatusConta(false);
			System.out.println("CONTA FECHADA COM SUCESSO!");
		}
	}
	
	public void depositar(double v) {
		if (this.getStatusConta()) {
			this.setSaldoConta(this.getSaldoConta() + v);
			System.out.println("Depósito realizado com sucesso na conta de " + this.getDonoConta() + "!");
		} else {
			System.out.print("A conta não existe.");
		}
	}
	
	public void sacar(double v) {
		if (this.getStatusConta()) {
			if (this.getSaldoConta() >= v) {
				this.setSaldoConta(this.getSaldoConta() - v);
				System.out.println("Saque realizado com sucesso na conta de " + this.getDonoConta() + "!");
			} else {
				System.out.print("Saldo insuficiente para realizar saque.");
			}
		} else {
			System.out.print("ERRO! CONTA INVÁLIDA.");
		}
	}
	
	public void pagarMensal(String t) {
		double v = 0;
		if (this.getTipoConta() == "CC") {
			v = 12.00;
		} else if (this.getTipoConta() == "CP"){
			v = 20.00;
		}
		
		if (this.getStatusConta()) {
			if (this.getSaldoConta() > v ) {
				this.setSaldoConta(this.getSaldoConta() - v);
				System.out.println("Mensalidade paga com sucesso!");
			} else {
				System.out.print("Conta em débito!");
			}
		} else {
			System.out.print("ERRO! CONTA INVÁLIDA.");
		}
	}
}
