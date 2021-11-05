package br.com.projeto3.enums;

public enum EnumWeapon {
	// Tipos de armas e sua pontuação para somar no momento do ataque.
	ARCOEFLECHA("Arco e Flecha", 3), MANGUAL("Mangal", 3), BASTEIRO("Basteiro", 6),
	PUNHAL("Punhal", 6), LANCA("Lança", 9), MACHADINHO("Machadinho", 9), ESPADA("Espada", 12);
	
	// weapon é a arma e harm é o seu dano
	private String weapon;
	private int harm;
	
	EnumWeapon(String weapon, int harm){
		this.weapon = weapon;
		this.harm = harm;
	}
	
	public String getWeapon() {
		return this.weapon;
	}
	
	public int getHarm() {
		return this.harm;
	}
}
