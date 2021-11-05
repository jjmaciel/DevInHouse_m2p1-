package br.com.projeto3.menu;
import br.com.projeto3.Screen;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import br.com.projeto3.enums.EnumCharacterPlayer;
import br.com.projeto3.enums.EnumWeapon;

// esta é a classe de menu utilizada pelo Main para fazer o cadastro do jogador e tomar as primeiras
// decisões 
public class MainMenu {
	
	private Scanner scan;
	private Screen screen;
	
	public MainMenu() {
		this.scan = new Scanner(System.in);
		this.screen = new Screen();
	}
	// verifica o nome, faz um teste para ver se o nome tem menos de 1 caracter
	public String  ControlMenuName() {
		
		String name = "";
		
		while (name.length() < 2) {
			System.out.print("\n\t Nome: ");
			 name = scan.nextLine();
			if (name.length() < 2) {
				this.screen.HorizontalScreen();
				System.out.println("#\n# Vamos melhorar isso, seu nome não pode ter somente uma caracter.\n#");
				this.screen.HorizontalScreen();
			} 		}
		 		
		return name;
	}
	// verifica se o sexo é com a letra F ou M
	public char ControlMenuSex() {
		char sex = ' ';
		while (sex != 'm' && sex != 'f') {
			System.out.println("\t F - Guerreira");
			System.out.println("\t M - Guerreiro");
			System.out.print("\t Sexo: ");
			sex = scan.nextLine().charAt(0);
			sex = Character.toLowerCase(sex);
			if (sex != 'm' && sex != 'f') {
				this.screen.HorizontalScreen();
				System.out.println("#\n# Você precisa digitar F ou M \n#");
				this.screen.HorizontalScreen();
			}
		}
		return sex;
	}
	// este método apresenta o menu com uma lista de guerreuros que o jogador pode escolher
	// esta lista é baseada no enum EnumCharacterPlayer
	public int ControlMenuCharacter() {
		
		int character = -1;
		List<EnumCharacterPlayer> list_charcater = Arrays.asList(EnumCharacterPlayer.values());
		
		while (character < 0 || character > EnumCharacterPlayer.values().length - 1) {
			for (int i = 0; i < EnumCharacterPlayer.values().length; i++) {
				System.out.println(String.format("\t %d - %s", i, list_charcater.get(i).getWarrior()));
			}
			System.out.print("\t Qual personagem você se identifica? ");
			character = scan.nextInt();
			if (character < 0 || character > EnumCharacterPlayer.values().length - 1 ) {
				this.screen.HorizontalScreen();
				System.out.println("#\n# Vamos tentar de novo. Você pode selecionar somente os personagens da lista.\n#");
				this.screen.HorizontalScreen();
			}
		}
		
		return character;
	}
	
	// Essa é uma classe que vai fazer o jogador decidir qual arma escolher entre as armas disponível para
	// o guerreiro que ele escolheu anteriormente.
	// Essa é uma classe quero refatorar se der tempo... não gostei dela dessa forma, já que ela não ficou escalável de forma automática
	public int ControlMenuWeapon(int character) {

		int weapon = -1;

		while(weapon < 0 || weapon > EnumWeapon.values().length) {
			switch(character) {
				case 0:
					System.out.println(String.format("\t %d - %s", EnumWeapon.ARCOEFLECHA.ordinal(), EnumWeapon.ARCOEFLECHA.getWeapon()   ));
					System.out.println(String.format("\t %d - %s", EnumWeapon.LANCA.ordinal(), EnumWeapon.LANCA.getWeapon() ));
					System.out.println(String.format("\t %d - %s", EnumWeapon.BASTEIRO.ordinal(), EnumWeapon.BASTEIRO.getWeapon() ));
					System.out.print("\t Com qual arma você irá lutar? ");
					weapon = scan.nextInt();
					if (weapon != EnumWeapon.ARCOEFLECHA.ordinal() && weapon != EnumWeapon.LANCA.ordinal() && weapon != EnumWeapon.BASTEIRO.ordinal()) {
						weapon = -1;
					}
					break;
				case 1:
					System.out.println(String.format("\t %d - %s", EnumWeapon.ESPADA.ordinal(), EnumWeapon.ESPADA.getWeapon() ));
					System.out.println(String.format("\t %d - %s", EnumWeapon.MACHADINHO.ordinal(), EnumWeapon.MACHADINHO.getWeapon() ));
					System.out.println(String.format("\t %d - %s", EnumWeapon.PUNHAL.ordinal(), EnumWeapon.PUNHAL.getWeapon() ));
					System.out.print("\t Com qual arma você irá lutar? ");
					weapon = scan.nextInt();
					if (weapon != EnumWeapon.ESPADA.ordinal() && weapon != EnumWeapon.MACHADINHO.ordinal() && weapon != EnumWeapon.PUNHAL.ordinal()) {
						weapon = -1;
					}
					break;
				case 2:
					System.out.println(String.format("\t %d - %s", EnumWeapon.ESPADA.ordinal(), EnumWeapon.ESPADA.getWeapon() ));
					System.out.println(String.format("\t %d - %s", EnumWeapon.LANCA.ordinal(), EnumWeapon.LANCA.getWeapon() ));
					System.out.println(String.format("\t %d - %s", EnumWeapon.MANGUAL.ordinal(), EnumWeapon.MANGUAL.getWeapon() ));
					System.out.print("\t Com qual arma você irá lutar? ");
					weapon = scan.nextInt();
					if (weapon != EnumWeapon.ESPADA.ordinal() && weapon != EnumWeapon.LANCA.ordinal() && weapon != EnumWeapon.MANGUAL.ordinal()) {
						weapon = -1;
					}
					break;
			}
			if (weapon < 0 || weapon > EnumWeapon.values().length) {
				this.screen.HorizontalScreen();
				System.out.println("#\n# Que isso Guerreiro(a), você precisa selecionar a arma certa\n#");
				System.out.println("#\n# Vamos tentar novamente, seu guerreiro só tem estas opções de armas.\n#");
				this.screen.HorizontalScreen();
			} 
		}
		return weapon;
	}
	
	// ete método define a dificuldade que vai ser o jogo
	public int ControlMenuDifficulty(String sex) {
		int difficulty = -1;
		while (difficulty < 0) {
			System.out.println("\t 1 - Fácil");
			System.out.println("\t 2 - Médios");
			System.out.println("\t 3 - Difícil");
			System.out.print("\t Nível de dificuldade: ");
			difficulty = scan.nextInt();
			if (difficulty < 1 || difficulty > 3) {
				this.screen.HorizontalScreen();
				System.out.println(String.format("#\n# Vamos lá %s, não tenha medo, escolha um nível de dificuldade confortável para você \n#", sex));
				this.screen.HorizontalScreen();
				difficulty = -1;
			}
		}
		return difficulty;
	}
	
	// O jogador tem suas opções para se motivar a jogar, este método é para tomar essa decisão
	public int ControlMenuMotivation(String sex) {
		int motivation = -1;
		while (motivation < 0) {
			System.out.println("\t 1 - Vingança: O maldito líder finalmente pagará por tanto mal causado na vida de tantos (e principalmente na sua).\n");
			System.out.println("\t 2 - Glória: Você já consegue visualizar na sua mente o povo da cidade te recebendo de braços abertos, bardos criando \n"
					+ "\t canções sobre seus feitos heróicos, nobres te presenteando com jóias e diversas riquezas, taberneiros se recusando a cobrar \n"
					+ "\t por suas bebedeiras e comilanças.\n\n");
			System.out.print(String.format("\t %s, está chegando o grande momento. O que te motiva a entrar nessa batalha: ", sex));
			motivation = scan.nextInt();
			if (motivation < 1 || motivation > 2) {
				this.screen.HorizontalScreen();
				System.out.println(String.format("#\n# Vamos lá %s tudo na vida tem um motivo, escolha o seu\n#", sex));
				this.screen.HorizontalScreen();
				motivation = -1;
			}
		}
		return motivation;
	}
	
	// método que vai determinar se o jogador passa pelo corredor correndo, caminhando ou pulando.
	// esta decisão influenciará se o jogador entra na classe Hall ou não.
	public int ControlMenuStartGame(String sex, String motivation) {
		int start_game = -1;
		screen.HorizontalScreen();
		System.out.println(String.format("#\n# Chegou a hora %s, você está preparado? Sua %s está próxima \n"
				+ "# na primeira fase já é um ponto critico, você terá que descidir em ir \n"
				+ "# com tudo ou de maneira cautelosa. Que inicie o jogo, BOA SORTE!\n#", sex, motivation));
		screen.HorizontalScreen();
		while (start_game < 1 || start_game > 3) {
			System.out.println("\t 1 - De maneira Cautelosa");
			System.out.println("\t 2 - Vou entrar correndo");
			System.out.println("\t 3 - O sistema aqui é bruto! Vou entrar pulando");
			System.out.print("\t Como você pretende passar o corredor: ");
			start_game = scan.nextInt();
			if (start_game < 1 || start_game > 3) {
				this.screen.HorizontalScreen();
				System.out.println(String.format("#\n# Vamos lá %s me parece que você está com medo. Qual opção você vai escolher\n#", sex));
				this.screen.HorizontalScreen();
				start_game = -1;
			}
		}
		return start_game;
	}
	
	
	
}// class
