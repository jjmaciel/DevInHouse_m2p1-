package br.com.projeto3.enums;

public enum EnumCharacterAdversary {
	// tipo de guerreiro e sua força (ou seja o dano que ele provoca no oponente)
	ARMEIRO("Armeiro", 3), ALQUIMISTA("Alquimista", 6), CARRASCO("Carrasco", 9), LIDER("Lider", 12);
	
	// warrior é o guerreiro e power é o dano que ele pode provocar no oponente.
	private String warrior;
	private int power;
	
	EnumCharacterAdversary(String warrior, int power){
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
