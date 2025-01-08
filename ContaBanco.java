package contaBanco;

public class ContaBanco {

	public static void main(String[] args) {
		Conta01 c1 = new Conta01();
		c1.setNumConta(7842);
		c1.setDonoConta("Jubileu");
		c1.abrirConta("CC");
		
		Conta01 c2 = new Conta01();
		c2.setNumConta(6159);
		c2.setDonoConta("Sônia");
		c2.abrirConta("CP");
		
		c1.estadoAtual();
		c2.estadoAtual();
	}

}
