package br.com.projeto3.floorplan;

import java.util.Arrays;
import java.util.List;

import br.com.projeto3.Battle;
import br.com.projeto3.Warrior;
import br.com.projeto3.enums.EnumCharacterAdversary;
import br.com.projeto3.enums.EnumWeapon;
import br.com.projeto3.menu.BattleMenu;
import br.com.projeto3.Screen;

// A classe Doors é uma classe que é estendida para ouras 3 classes do jogo RightDoor, LeftDoor e LiderDoor
// Esta classe nunca é instanciada. Seus métodos e atributos são utilizados pelas classes filhas.
public class Doors {
	
	protected int what_adversary;
	protected int what_weapon;
	protected int atack_player;
	protected int atack_adversary;
	protected int decision;
	protected int decision_armor;
	
	protected Warrior adversary;
	protected Battle battle;
	protected BattleMenu menu;
	protected SquareRoom square;
	protected Screen screen;
	
	public Doors() {
		this.decision = -1;
	}

	// este método prepara o adversário do jogo. O Adversário acontece através de um sorteio, logo indiferente da porta q o jogador escolher
	// para entrar o adversário será sorteado baseado no enum EnumCharacterAdversary
	public void PreparingAdversary() {
		List<EnumCharacterAdversary> list_adversary = Arrays.asList(EnumCharacterAdversary.values());
		List<EnumWeapon> list_weapon = Arrays.asList(EnumWeapon.values());
		// chama o método GenerateAtack com todos os adversários menos o último que é o Lider, que nunca fará parte do sorteio.
		// posteriormente com todas as armas disponíveis em no enum EnumWeapon
		this.what_adversary = this.battle.GenerateAtack(EnumCharacterAdversary.values().length - 1);
		this.what_weapon = this.battle.GenerateAtack(EnumWeapon.values().length);
		// seta os dados do adversário na classe Warrior
		this.adversary.setCharacter(list_adversary.get(what_adversary).getPower());
		this.adversary.setWeapon(list_weapon.get(what_weapon).getHarm());
		this.screen.HorizontalScreen();
		System.out.println(String.format("#\n# Olha quem está lhe esperando, o %s tem jeito de ser durão e já está lhe atacando.\n#", list_adversary.get(what_adversary).getWarrior()));
		this.screen.HorizontalScreen(); 
	
	}
}
