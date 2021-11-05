package br.com.projeto3.menu;

import br.com.projeto3.Screen;
import java.util.Scanner;

// esta classe é a classe de menu das decições das batalhas
public class BattleMenu {
	
	private int door;
	private Scanner scan;
	private Screen screen;
	
	
	public BattleMenu() {
		this.door = -1;
		this.scan = new Scanner(System.in);
		this.screen = new Screen();
		
	}
	
	// aqui o jodador deve decidir em qual porta quer entrar primeiro
	public int ControlMenuSquareRoom() {
		
		while (this.door < 1 || this.door > 2) {
			System.out.println("\t 1 - Porta da Direita");
			System.out.println("\t 2 - Porta da Esquerda");
			System.out.print("\t Escolha uma pota e boa sorte: ");
			this.door = scan.nextInt();
			if (this.door < 1 || this.door > 2) {
				this.screen.HorizontalScreen();
				System.out.println("#\n# Vamos lá, agora que você chgou até aqui, você vai conseguir\n#");
				this.screen.HorizontalScreen();
				this.door = -1;
			}
		}
		return this.door;
	}
	
	// este método é para o jogador decidir se entrará na próxima porta, que pode ser da direita
	// ou da esquerda, dependendo de onde ele está vindo
	public int ControlMenuNextDoor() {
		while (this.door < 1 || this.door > 2) {
			System.out.println("\t 1 - Bora entrar na próxima porta?");
			System.out.println("\t 2 - Não, estou cansando e prefiro sair");
			System.out.print("\t Qual é sua decisão? ");
			this.door = scan.nextInt();
			if (this.door < 1 || this.door > 2) {
				this.screen.HorizontalScreen();
				System.out.println("#\n# Não tem outra opção, ou entra na próxima porta ou desiste!\n#");
				this.screen.HorizontalScreen();
				this.door = -1;
			}
		}
		return this.door;
	}
	
	
	
	// método invocado para o jogador tomar a decisão de atacar ou desistir
	public int ControlMenuDecision() {
		int decision = -1;
		while (decision < 1 || decision > 2) {
			System.out.println("\t 1 - Atacar");
			System.out.println("\t 2 - Desistir");
			System.out.print("\t Qual vai ser sua atitude: ");
			decision = scan.nextInt();
			if (decision < 1 || decision > 2) {
				this.screen.HorizontalScreen();
				System.out.println("#\n# Ou você ataca ou desiste!\n#");
				this.screen.HorizontalScreen();
				decision = -1;
			}
		}
		return decision;
	}
	
	
	// se o jogador vencer na sala da direita, ele deve decidir se vai ou não vestir a armadura
	public int MenuRigthRoom() {
		int decision_armor = -1;
		this.screen.HorizontalScreen();
		System.out.println("#\n# Parabéns, você derrotou seu adversário. Além de você conseguir uma das chaves que você precisa\n"
				+ "# Se você quiser, você pode se beneficiar das armas do adversário e aumentar sua proteção.\n#");
		this.screen.HorizontalScreen();
		
		while (decision_armor < 1 || decision_armor > 2) {
			System.out.println("\t 1 - Vestir a armadura");
			System.out.println("\t 2 - Não preciso disso");
			System.out.print("\t Vai vestir ou não? ");
			decision_armor = scan.nextInt();
			if (decision_armor < 1 || decision_armor > 2) {
				this.screen.HorizontalScreen();
				System.out.println("#\n# Vamos lá, uma das informações é preciso\n#");
				this.screen.HorizontalScreen();
				decision_armor = -1;
			}
			if (decision_armor == 2) {
				this.screen.HorizontalScreen();
				System.out.println("#\n# Você decide que não precisa utilizar nada que venha das mãos do inimigo");
				this.screen.HorizontalScreen();
			}
		}
		return decision_armor;
	}
	

	// se o jogador vencer o adversário na sala da esquerda ele deve decidir em tomar ou não a poção
	public int MenuLeftRoom() {
		int decision_armor = -1;
		this.screen.HorizontalScreen();
		System.out.println("#\n# Parabéns, você derrotou seu adversário. Além de você conseguir uma das chaves que você precisa.1\n"
				+ "# Se você quiser, você pode se beneficiar das armas do adversário e aumentar sua proteção.\n#");
		this.screen.HorizontalScreen();
		
		while (decision_armor < 1 || decision_armor > 2) {
			System.out.println("\t 1 - Tomar a Poção Mágica");
			System.out.println("\t 2 - Não preciso disso");
			System.out.print("\t Vai vestir ou não? ");
			decision_armor = scan.nextInt();
			if (decision_armor < 1 || decision_armor > 2) {
				this.screen.HorizontalScreen();
				System.out.println("#\n# Vamos lá, uma das informações é preciso\n#");
				this.screen.HorizontalScreen();
				decision_armor = -1;
			}
			if (decision_armor == 2) {
				this.screen.HorizontalScreen();
				System.out.println("#\n# Você decide que não precisa utilizar nada que venha das mãos do inimigo");
				this.screen.HorizontalScreen();
			}
		}
		return decision_armor;
	}

}
