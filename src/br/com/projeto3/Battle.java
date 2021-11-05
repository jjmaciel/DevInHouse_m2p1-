package br.com.projeto3;
import java.util.Random;

// a classe Battle é a regra de negócio junto com as classes *Door
public class Battle {
	
	private Screen screen;
	
	// define o ataque através de um sorteio de números inteiros
	public int GenerateAtack(int harm) {
		Random random = new Random();
		int total_harm = random.nextInt(harm);
		return total_harm;
	}
	
	// se o jogador perder alguma batalha, o método Gameover é invocado
	public void Gameover(String player_name) {
		System.out.println(String.format("\n\t Não foi dessa fez %s", player_name));
		this.screen = new Screen();
		this.screen.GameoverMessage();		
	}
	
	// Este método é invocado caso o jogador decide desistir
	public void GiveUp(String player_name) {
		System.out.println(String.format("\n Que isso %s. Mas tudo bem, crie mais coragem e volte!", player_name));
	}
	
	// método que define a pontuação conforme a quantidade de flechas recebidas no corredor, caso o jogador opte por entrar caminhando
	public void WalkingHall(Player player, int atack) {
		player.setQuality_life(player.getQuality_life() - atack);
	}
		
	//  regras de negócio se o jogador optar por jogar no modo fácil
	public void EasyWay(Player player, Warrior adversary, int atack_player, int atack_adversary) {
		double sum_atack;
		int total_atack_adversary;
		int total_atack_player;
		sum_atack = ((atack_adversary + adversary.getCharacter() + adversary.getWeapon()) - (atack_adversary + adversary.getCharacter() + adversary.getWeapon()) * 0.2);
		total_atack_adversary = (int)sum_atack;
		player.setQuality_life(player.getQuality_life() - total_atack_adversary);
		
		total_atack_player = (atack_player + player.getCharacter() + player.getWeapon());
		adversary.setQuality_life(adversary.getQuality_life() - total_atack_player);

		System.out.println(String.format("\nVocê foi atingido por %d pontos", total_atack_adversary));
		System.out.println(String.format("Você atingiu seu adversário em %d pontos",total_atack_player));
		this.screen = new Screen();
		this.screen.QualityLife(player.getName(), player.getQuality_life());
		this.screen.QualityLife("Adversario", adversary.getQuality_life());
		System.out.println("");
				
	}

	//  regras de negócio se o jogador optar por jogar no modo normal
	public void NormalWay(Player player, Warrior adversary, int atack_player, int atack_adversary) {
		double sum_atack;
		int total_atack;
		sum_atack = ((atack_adversary + adversary.getCharacter() + adversary.getWeapon()));
		total_atack = (int)sum_atack;
		player.setQuality_life(player.getQuality_life() - total_atack);
		
		total_atack = (atack_player + player.getCharacter() + player.getWeapon());
		adversary.setQuality_life(adversary.getQuality_life() - total_atack);

		System.out.println(String.format("\nVocê foi atingido por %d pontos", (int)sum_atack));
		System.out.println(String.format("Você atingiu seu adversário em %d pontos",total_atack));
		this.screen = new Screen();
		this.screen.QualityLife(player.getName(), player.getQuality_life());
		this.screen.QualityLife("Adversario", adversary.getQuality_life());
		System.out.println("");
				
	}
	
	//  regras de negócio se o jogador optar por jogar no modo difícil
	public void HardWay(Player player, Warrior adversary, int atack_player, int atack_adversary) {
		double sum_atack;
		int total_atack;
		
		total_atack = (atack_adversary + adversary.getCharacter() + adversary.getWeapon());
		player.setQuality_life(player.getQuality_life() - total_atack);
		
		sum_atack = ((atack_player + player.getCharacter() + player.getWeapon()) - ((atack_player + player.getCharacter() + player.getWeapon()) * 0.1));
		total_atack = (int)sum_atack;
		adversary.setQuality_life(adversary.getQuality_life() - total_atack);

		System.out.println(String.format("\nVocê foi atingido por %d pontos", (int)sum_atack));
		System.out.println(String.format("Você atingiu seu adversário em %d pontos",total_atack));
		this.screen = new Screen();
		this.screen.QualityLife(player.getName(), player.getQuality_life());
		this.screen.QualityLife("Adversario", adversary.getQuality_life());
		System.out.println("");
				
	}

}
