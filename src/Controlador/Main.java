package Controlador;

public class Main {
	public static void main(String[] args) {
		boolean erro = false;
		Carregar carregador = new Carregar();

		try {
			carregador.executa(args);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			erro = true;
		}

		if (!erro) {
			if (!carregador.getWrite()) {
				Salvar salvador = new Salvar();
				salvador.salvaDados("dados.dat");
			} else {
				Relatorio relatorio = new Relatorio();
				try {
					relatorio.escreveRelatorios();
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
 
	}

}