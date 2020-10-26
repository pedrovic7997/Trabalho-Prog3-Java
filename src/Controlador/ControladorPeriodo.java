public class ControladorPeriodo extends Controlador{
    public void menuPeriodo(){
		String opcao = "s";
		Scanner scan = new Scanner(System.in);
		LeitorPeriodo lPeriodo = LeitorPeriodo.obterInstancia();
		while(opcao.toLowerCase().equals("s")){
			System.out.println("------------------------");
			System.out.println("Periodos cadastrados:");
			lPeriodo.listar();    
			System.out.println("\nDeseja cadastrar novo periodo?(Digite 's' caso queira ou qualquer tecla caso não" 
							+" queira)");
			
			opcao = scan.next();
			if(opcao.toLowerCase().equals("s")){
				Periodo periodo = lPeriodo.ler();
				if(lPeriodo.busca(periodo.obterCodigo()) != null)
					throw new IllegalArgumentException("Cadastro repetido: "+periodo+".");
				lPeriodo.anexaHash(periodo);
				System.out.println();
			}
		}
  	}
}
