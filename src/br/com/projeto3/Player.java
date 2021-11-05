package br.com.projeto3;

import java.util.List;

// Classe que herda da classe warrior que define os adversários e o jogador
// no entanto o jogador tem mais informações, por isso uma classe separada para tal.
public class Player extends Warrior {
	
	private int key; // quantidade de chaves que tem
	private String name; // nome do jogador
	private char sex; // sexo
	private String difficulty; // dificuldade do jogo
	private String motivation; // motivação para jogar
	private String start_game; // como vai passar no corredor.
	
	public Player() {
		this.key = 0;
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		String weapon;
		if (this.sex == 'f') {
			weapon = "Guerreira";
		} else {
			weapon = "Guerreiro";
		}
		return weapon;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		switch(difficulty) {
			case 1:
				this.difficulty = "Fácil";
				break;
			case 2:
				this.difficulty = "Médio";
				break;
			case 3:
				this.difficulty = "Difícil";
				break;
		}
		
	}
	public String getMotivation() {
		return motivation;
	}
	public void setMotivation(int motivation) {
		switch(motivation) {
			case 1:
				this.motivation = "Vingança";
				break;
			case 2:
				this.motivation = "Glória";
				break;
		}
	}
	
	public String getStartGame() {
		return start_game;
	}
	public void setStartGame(int start_game) {
		switch(start_game) {
			case 1:
				this.start_game = "Caminhando";
				break;
			case 2:
				this.start_game = "Correndo";
				break;
			case 3:
				this.start_game = "Saltando";
				break;
		}
		
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

}
