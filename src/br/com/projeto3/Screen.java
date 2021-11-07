package br.com.projeto3;

// a classe screnn é uma classe que imprime algumas coisas na tela para a apresentação
// ficar menos feia.
public class Screen {
  
	public void HorizontalScreen() {
		String horizontal_screen = "";
		
		for (int i = 0; i < 100; i++) {
			horizontal_screen += "#";
		}
		
		System.out.println(horizontal_screen);;
	}
	
	public void VerticalScreen() {
		String vertical_screen = "";
		
		for (int i = 0; i < 10; i++) {
			vertical_screen += "#\n";
		}
		
		System.out.println(vertical_screen);
	}
	
    public void QualityLife(String name, int life) {
    	String qt_life = "";
    	for (int i = 1; i <= life; i++) {
    		qt_life += "|";
    	}
    	System.out.println(String.format("Vida %s: %s", qt_life, name));
    }

	public void GameoverMessage(){
		System.out.println("__________________________________________________________\n");
		System.out.println("#####  ##### ##    ## #####   ##### #        # ##### #####");
		System.out.println("#      #   # # #  # # #       #   #  #      #  #     #   #");
		System.out.println("#  ##  ##### #  #   # ###     #   #   #    #   ###   #####");
		System.out.println("#   #  #   # #      # #       #   #    #  #    #     # #" );
		System.out.println("#####  #   # #      # #####   #####     #      ##### #  #");
		System.out.println("\n__________________________________________________________");
	}

	public void VictoryMessage(Player player){
		System.out.println(String.format("\n\t Jogador, você teve sua %s conforme foi o seu desejo e motivação por esta batalha\n", player.getMotivation()));
		System.out.println("################################################################################################");
		System.out.println("#                                                                                              #");
		System.out.println("# Os prisioneiros estão muito felizes com a derrota do Lider e em poderem voltar para casa!!   #");
		System.out.println("#  \\o/ \\o/ \\0/ \\0/              \\0/ \\o/ \\o/ \\0/               \\o/ \\0/ \\o/ \\0/                  #");
		System.out.println("#                                                                                              #");
		System.out.println("################################################################################################");
	}
}
