package br.com.projeto3.floorplan;

import br.com.projeto3.Player;
import br.com.projeto3.Warrior;
import br.com.projeto3.enums.EnumCharacterAdversary;
import br.com.projeto3.enums.EnumWeapon;
import br.com.projeto3.Battle;
import br.com.projeto3.menu.BattleMenu;
import br.com.projeto3.Screen;

public class LidersRoom extends Doors{
	
	public LidersRoom() {

		super.adversary = new Warrior();
		super.battle = new Battle();
		super.menu = new BattleMenu();
		super.square = new SquareRoom();
		super.adversary.setQuality_life(100);
		super.screen = new Screen();
		
	}
	
	// subscreve o método PreparingAdversary da classe mãe, já que o Lider não é sorteado
	public void PreparingAdversary() {
				
		super.adversary.setCharacter(EnumCharacterAdversary.LIDER.getPower());
		super.adversary.setWeapon(EnumWeapon.ESPADA.getHarm());
		
		super.screen.HorizontalScreen();
		System.out.println(String.format("#\n# Olha quem está lhe esperando, o %s tem jeito de ser durão e já está lhe atacando.\n#", EnumCharacterAdversary.LIDER.getWarrior()));
		super.screen.HorizontalScreen();
		
	}
	
	// Este método junto com os métodos EasyWay, NormalWay e HardWay é que gerenciam as
	// regras das batalhas. Poderia ter deixado esse método na classe Doors, no entanto se desse
	// tempo eu iria implementar regras diferentes para as portas da esquerda e da direita e sala do Lider.
	public void LiderBattle(Player player) {
		
		do {
			// gera o ataque do adversário
			super.atack_adversary = battle.GenerateAtack(21);
			// chama o menu para decidir se irá atacar ou desistir
			super.decision = menu.ControlMenuDecision();
			if (super.decision == 1) {
				// gera o ataque do jogador
				super.atack_player = battle.GenerateAtack(21);
				// baseado na escolha da dificuldade, chama um determinado método
				switch(player.getDifficulty()){
					case "Fácil":
						super.battle.EasyWay(player, adversary, atack_player, atack_adversary);
						break;
					case "Médio":
						super.battle.NormalWay(player, adversary, atack_player, atack_adversary);
						break;
					case "Difícil":
						super.battle.HardWay(player, adversary, atack_player, atack_adversary);
						break;
				}
			
			// se a decisão for por desistir o método GiveUp é invocado
			} else {
				super.battle.GiveUp(player.getName());
				super.decision = 0;
			}
			// verifica se o jogador está vivo
			if (player.getQuality_life() < 1) {
				super.battle.Gameover(player.getName());
				super.decision = 0;
			}
			// Verifica se o adversário está morto, para terminar o jogo. Para isso
			// verifica também se o jogador continua vivo.
			if (adversary.getQuality_life() < 1 && player.getQuality_life() > 1) {
				super.decision = 0;
				screen.VictoryMessage(player);
			}

		}while (super.decision == 1);
 
		
	}


}
