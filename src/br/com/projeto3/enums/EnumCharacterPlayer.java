package br.com.projeto3.enums;

public enum EnumCharacterPlayer {
	// tipo de guerreiro e sua força (ou seja o dano que ele provoca no oponente)
	ARQUEIRO("Arqueiro", 3), ESCUDEIRO("Escudeiro", 6), LEGIONARIO("Legionário", 12);
	
	// warrior é o guerreiro e power é o dano que ele pode provocar no oponente.
	private String warrior;
	private int power;
	
	EnumCharacterPlayer(String warrior, int power){
		this.warrior = warrior;
		this.power = power;
	}
	
	public String getWarrior() {
		return this.warrior;
	}
	
	public int getPower() {
		return this.power;
	}

}
