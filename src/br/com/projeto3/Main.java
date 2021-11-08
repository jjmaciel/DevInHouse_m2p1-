package br.com.projeto3;

import java.util.Arrays;
import java.util.List;

import br.com.projeto3.enums.EnumCharacterPlayer;
import br.com.projeto3.enums.EnumWeapon;
import br.com.projeto3.floorplan.*;
import br.com.projeto3.menu.MainMenu;

public class Main {

	public static void main(String[] args) {
		
		int character;
		int weapon;
		
		MainMenu menu = new MainMenu();
		Player player = new Player();
		Hall hall = new Hall();
		SquareRoom square_room = new SquareRoom();
		
		// setando os dados iniciais
		player.setQuality_life(100);
		player.setKey(0);
		
		// definições do nome e sexo do jogador
		player.setName(menu.ControlMenuName());
		
		// o getSex retornará guerreiro ou guerreira conforme o sexo
		player.setSex(menu.ControlMenuSex());
						
		// definição do guerreiro para o jogador
		List<EnumCharacterPlayer> list_charcater = Arrays.asList(EnumCharacterPlayer.values());
		character = menu.ControlMenuCharacter();
		player.setCharacter(list_charcater.get(character).getPower());
				
		// definições de armas de acordo com o guerreiro selecionado.
		weapon = menu.ControlMenuWeapon(character);
		List<EnumWeapon> list_weapon = Arrays.asList(EnumWeapon.values());
		player.setWeapon(list_weapon.get(weapon).getHarm());
				
		// definições da dificuldade do jogo
		player.setDifficulty(menu.ControlMenuDifficulty(player.getSex()));
				
		// definições de motivação
		player.setMotivation(menu.ControlMenuMotivation(player.getSex()));
				
		// define se o jogador vai passar o corredor correndo, caminhando ou saltando
		player.setStartGame(menu.ControlMenuStartGame(player.getSex(), player.getMotivation()));
		
		if (player.getStartGame() == "Caminhando") {
			hall.HallWalking(player);
		}
		
		square_room.SquareRoomInitail(player);
		
	}

}
