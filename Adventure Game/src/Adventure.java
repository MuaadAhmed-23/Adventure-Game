import java.util.Scanner; 
import java.lang.System;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
public class Adventure extends AdventureExecute {
	int potion = 3;
	void menu() {
		char option = '\0';
		Scanner menu_opt = new Scanner(System.in);
		do {
			System.out.println("======================");
			System.out.println("Welcome to the Dungeon \n 1. Enter Dungeon (E) \n 2. Quit (Q)");
			System.out.println("======================");
			System.out.print("Select choice: ");
			char enter_opt = menu_opt.nextLine().charAt(0);
			option = Character.toUpperCase(enter_opt);
			if(option == 'E') {
				enter_game(25);
			}
		} while(option != 'Q');
	}
	
	void enter_game(int hp_hero) {
		do {
			System.out.print("Would you like to continue (Yes/No)");
			Scanner continue_game = new Scanner(System.in);
			String continue_game_prompt = continue_game.nextLine();
			if(continue_game_prompt.equals("no") || continue_game_prompt.equals("No") || continue_game_prompt.equals("NO")) {
				break;
			} 
			int hp_enemy = 20;
			System.out.println("======================");
			System.out.println("ENEMY HAS APPEARED !!!");
			rand_enemy();
			System.out.println("======================");
			System.out.println("==============");
			System.out.println("Choose option: \n 1. Attack \n 2. Potion \n 3. Run");
			System.out.println("==============");
			char option_enter_game = '\0';
			Scanner enter_game_opt = new Scanner(System.in);
			do {
				System.out.print("Enter Option: ");
				char enter_game_options = enter_game_opt.next().charAt(0);
				option_enter_game = enter_game_options;
					if(option_enter_game == '1') {
						hp_enemy -= 10;
						hp_hero -= 5;
						System.out.println("====================");
						System.out.println("Hero health: " + hp_hero);
						System.out.println("Enemy health: " + hp_enemy);
						System.out.println("Enemy did damage !!!");
						System.out.println("====================");
						if (hp_enemy == 0) {
							potion++;
							System.out.println("Congratulations You defeated the enemy !!!");
						}
					} else if (option_enter_game == '2') {
						if (potion > 0) {
							hp_hero += 15;
							potion--;
						} else if (potion == 0) {
								System.out.println("No More Potions !!!");
						}
						hp_hero -= 5;
						System.out.println("====================");
						System.out.println("Hero health: " + hp_hero);
						System.out.println("Enemy health: " + hp_enemy);
						System.out.println("Enemy did damage !!!");
						System.out.println("====================");
					} else if (option_enter_game == '3') {
						break;
					} else if (option_enter_game == '4') {
						System.exit(0);
					}
			} while (hp_enemy != 0 & hp_hero != 0);
		} while (hp_hero != 0);
	}
	
	void rand_enemy() {
		int rand_enemy_num = (int)(Math.random() * 4 + 1);
		if (rand_enemy_num == 1) {
			System.out.println("The Skeleton has Appeared !!!!");
		} else if (rand_enemy_num == 2) {
			System.out.println("Its the Zombie !!!");
		} else if (rand_enemy_num == 3) {
			System.out.println("A brave Warrior !!!");
		} else if (rand_enemy_num == 4) {
			System.out.println("Ninja Assassin !!!");
		}
	}
}