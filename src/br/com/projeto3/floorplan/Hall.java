package br.com.projeto3.floorplan;

import br.com.projeto3.Screen;

import br.com.projeto3.Player;
import br.com.projeto3.Battle;

// Hall é a classe que representa o corredor e só é instanciada se o Jogador entrar camihando no jogo
public class Hall {
		
	public void HallWalking(Player player) {
		
		int atack;
		Battle battle = new Battle();
		Screen screen = new Screen();
		
		atack = battle.GenerateAtack(10);
		battle.WalkingHall(player, atack);
		System.out.println("\n\n");
		
		screen.HorizontalScreen();
		// Esse if só mostra uma mensagem diferente para a quantidade de fléchas que o jogador foi acertado no corredor
		if (atack > 0 && atack < 4) {
			System.out.println(String.format("#\n# Ter entrado de forma cautelosa talvez não tenha sido a melhor opção %s.\n"
					+ "# Ainda assim seus ferimentos são leves, continua firme que sua %s está próxima. \n#\n"
					+ "# Você foi atingido por %d flechas.\n#", player.getSex(), player.getMotivation(), atack));
		} 
		if (atack > 3 && atack < 11) {
			System.out.println(String.format("#\n# É %s, me parece que sua estratégia para passar o corredor não foi a melhor.\n"
					+ "# Mas você ainda está vivo e com grande chaces de conquistar sua %s.\n#\n"
					+ "# Você foi atingido por %d flechas.\n#", player.getSex(), player.getMotivation(), atack));
		}
		screen.HorizontalScreen();
				
	}

}
