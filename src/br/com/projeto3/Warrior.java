package br.com.projeto3;

// classe que define o tipo de jogador e do adversário, não pode ser abstrata pois é instanciada
// para a definir o adversário.
public class Warrior {

	private int quality_life;
	private int character;
	private int weapon;
	
	public int getQuality_life() {
		return quality_life;
	}
	public void setQuality_life(int quality_life) {
		this.quality_life = quality_life;
	}
	public int getCharacter() {
		return character;
	}
	public void setCharacter(int character) {
		this.character = character;
	}
	public int getWeapon() {
		return weapon;
	}
	public void setWeapon(int weapon) {
		this.weapon = weapon;
	}
	
	

}
