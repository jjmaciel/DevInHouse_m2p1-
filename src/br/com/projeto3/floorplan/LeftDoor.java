package br.com.projeto3.floorplan;

// LeftDoor estende a classe Doors
public class LeftDoor extends Doors{
	
	
	public LeftDoor() {
		
		super.adversary = new Warrior();
		super.battle = new Battle();
		super.menu = new BattleMenu();
		super.square = new SquareRoom();
		super.adversary.setQuality_life(100);
		super.screen = new Screen();
	}
	// Este método junto com os métodos EasyWay, NormalWay e HardWay é que gerenciam as
	// regras das batalhas. Poderia ter deixado esse método na classe Doors, no entanto se desse
	// tempo eu iria implementar regras diferentes para as portas da esquerda e da direita.
	public void LeftBattle(Player player) {
		
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
						this.battle.EasyWay(player, adversary, atack_player, atack_adversary);
						break;
					case "Médio":
						this.battle.NormalWay(player, adversary, atack_player, atack_adversary);
						break;
					case "Difícil":
						this.battle.HardWay(player, adversary, atack_player, atack_adversary);
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
			// Verifica se o adversário está morto, para retornar a sala quadrada. Para isso
			// verifica também se o jogador continua vivo
			if (adversary.getQuality_life() < 1 && player.getQuality_life() > 1) {
				player.setKey(player.getKey() + 2);
				super.decision_armor = menu.MenuLeftRoom();
				if (super.decision_armor == 1) {
					// recebe 100% da vida se tomar a poção
					player.setQuality_life(100);
					super.decision = 0;
					// volta para a sala quadrada.
					square.SquareRoomReturn(player);
				}
			}
		} while (super.decision == 1);
		
	}

}
