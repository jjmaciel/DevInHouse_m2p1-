package br.com.projeto3.floorplan;

// RightDoor estende a classe Doors
public class RightDoor extends Doors {
		
	
	public RightDoor() {

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
	public void RightBattle(Player player) {
		
		do {
			// gera o ataque do adversário
			super.atack_adversary = battle.GenerateAtack(21);
			// chama o menu para decidir se irá atacar ou desistir
			super.decision = menu.ControlMenuDecision();
			if (super.decision == 1) {
				// gera o ataque do jogador
				super.atack_player = battle.GenerateAtack(21);
				if (super.atack_adversary == 20){
					super.battle.Gameover(player.getName());
					super.decision = 0;
					square.SquareRoomReturn(player);
				}
				if (super.atack_player == 20){
					adversary.setQuality_life(0);
					super.decision = 0;
					square.SquareRoomReturn(player);
				}
				// baseado na escolha da dificuldade, chama um determinado método
				switch(player.getDifficulty()){
					case "Fácil":
						System.out.println("Dentro do fácil");
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
			}
			// Verifica se o adversário está morto, para retornar a sala quadrada. Para isso
			// verifica também se o jogador continua vivo
			if (adversary.getQuality_life() < 1 && player.getQuality_life() > 1) {
				player.setKey(player.getKey() + 1);
				super.decision_armor = menu.MenuRigthRoom();
				if (super.decision_armor == 1) {
					// recebe mais 50 pontos de vida se tomar vestir a armadura
					player.setQuality_life(player.getQuality_life() + 50);
					super.decision = 0;
					// volta para a sala quadrada.
					square.SquareRoomReturn(player);
				}
			}
		} while (super.decision == 1);
		
	}

} //class

	