package br.com.projeto3.floorplan;

import br.com.projeto3.Screen;
import br.com.projeto3.Battle;
import br.com.projeto3.Player;
import br.com.projeto3.menu.BattleMenu;

// SquareRoom é a sala quadrada onde o jogador toma as decições de acessar as portas
// da esquerda da direita e a porta do lider, caso ele tenha as 2 chaves
public class SquareRoom {
	
	private int what_door;
	private Screen screen;
	
	public SquareRoom() {
		this.screen = new Screen();
	}
	
	// este método é invocado quando o jogador passa pelo corredor e acessa pela primeira vez a sala quadrada
	public void SquareRoomInitail(Player player) {
		BattleMenu menu = new BattleMenu();
		this.screen.HorizontalScreen();
		System.out.println(String.format("#\n# Agora você está na sala quadrada. A porta na sua frente da acesso a sala do Lider\n"
				+ "# Mas pode ver que ela está tancada com duas chaves, essas chaves você só vai conseguir acessando as portas laterais\n"
				+ "# O que tem ali, só Deus sabe, a escolha é sua %s, qual porta você quer entar primeiro? \n#", player.getSex()));
		this.screen.HorizontalScreen();
		System.out.print("\n");
		// invoca o método QualityLife para mostrar a quantidade de vida
		this.screen.QualityLife(player.getName(), player.getQuality_life());
		System.out.print("\n");
		// chama o menu para tomada de decisão de qual porta vai entrar
		this.what_door = menu.ControlMenuSquareRoom();
		
		// ou entra na porta da esquerda ou da direita, já que neste momento o jogador não tem
		// nenhuma chave, logo a porta do líder não aparece no menu
		if (this.what_door == 1) {
			RightDoor door = new RightDoor();
			door.PreparingAdversary();
			door.RightBattle(player);

		} else {
			LeftDoor door = new LeftDoor();
			door.PreparingAdversary();
			door.LeftBattle(player);
		}
	}
	
	
	// o método de retorno para a sala quadrada, é quando o jogador já passpou por uma das portas
	// ou a da esquerda ou a da direita. Neste método as decições são tomadas baseadas na quantidade de
	// chaves que ele tem.
	public void SquareRoomReturn(Player player) {
		int next_door;
		BattleMenu menu = new BattleMenu();
		Battle battle = new Battle();
		System.out.print("\n");
		this.screen.QualityLife(player.getName(), player.getQuality_life());
		System.out.print("\n");
		this.screen.HorizontalScreen();
		// a chave da porta da direita vale 1 ponto e da esquerda vale 2 pontos
		// se a soma no getKey for 1, significa que ele só poderá acessar a porta da esquerda ainda
		// por isso ele chama a porta da esquerda no case 1
		switch(player.getKey()) {
			case 1:
				System.out.println(String.format("#\n# Muito bem %s, uma chave você já tem\n#", player.getName()) );
				this.screen.HorizontalScreen();
				next_door = menu.ControlMenuNextDoor();
				if (next_door == 1) {
					LeftDoor door = new LeftDoor();
					door.PreparingAdversary();
					door.LeftBattle(player);
				} else {
					battle.GiveUp(null);
				}
				break;
		// Se a soma das chaves for 2, significa que o jogador só tem a chave da esquerda e então só da a opção
		// de entrar na porta da direita
			case 2:
				System.out.println(String.format("#\n# Muito bem %s, uma chave você já tem\n#", player.getName()) );
				this.screen.HorizontalScreen();
				next_door = menu.ControlMenuNextDoor();
				if (next_door == 1) {
					RightDoor door = new RightDoor();
					door.PreparingAdversary();
					door.RightBattle(player);
				} else {
					battle.GiveUp(null);
				}
				break;

			// se a soma das chaves for 3, então ele tem as duas chaves e livera o acesso para a sala do lider
			case 3:
				System.out.println(String.format("#\n# Chegou o grande momento %s. Se você derrotar o Lider você alcança a sua tão desejada %s\n#", player.getName(), player.getMotivation() ) );
				this.screen.HorizontalScreen();
				LidersRoom door = new LidersRoom();
				door.PreparingAdversary();
				door.LiderBattle(player);
				break;
		}
		
	}

} // class
