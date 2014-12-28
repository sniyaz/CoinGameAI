import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;


class Cmd_interface {

	public static void main(String[] args) throws IOException {

		Coin_ai game_ai = new Coin_ai();
		System.out.println(" ");
	    System.out.println("There are " + Integer.toString(game_ai.coins_remaining()) + " coins starting on the table."); 

		//Coin toss that lets CPU go first!
		Random coin_toss = new Random();
		int toss_result = coin_toss.nextInt(2);
		if (toss_result == 0){
			System.out.println(" ");
			System.out.println("CPU WON COIN TOSS AND GOES FIRST.");
			int ai_num = game_ai.ai_move();
			System.out.println(" ");
			System.out.println("CPU took " + Integer.toString(ai_num) + " coins from the table!");
		} else {
			System.out.println(" ");
			System.out.println("YOU WON THE COIN TOSS AND GO FIRST.");
		}


		while (true){

			while (true){
				System.out.println(" ");
				int coins_remaining = game_ai.coins_remaining();
				System.out.println("There are " + Integer.toString(coins_remaining) + " coins left on the table."); 
				System.out.println(" ");
				System.out.println("How many coins will you take?");

				BufferedReader user_input = new BufferedReader(new InputStreamReader(System.in));
				String user_text = user_input.readLine();

				int user_num = 0;
				try {
					user_num = Integer.parseInt(user_text);
				} catch (NumberFormatException exception) {
					System.out.println(" ");
					System.out.println("Sorry, looks like that wasn't a number. Can you try again?");
					continue;
				}

				int player_move_result = game_ai.player_move(user_num);
				if (player_move_result == 0){
					System.out.println(" ");
					System.out.println("Sorry, that isn't a valid move! Let's try again.");
					continue;
				} else {
					System.out.println(" ");
					System.out.println("Successfully took " + Integer.toString(user_num) + " coins from the table!");
					if (game_ai.coins_remaining() == 1){
						System.out.println(" ");
					    System.out.println("There are " + Integer.toString(coins_remaining) + " coins left on the table."); 
						System.out.println(" ");
						System.out.println("Congratulations. You won!");
						System.exit(0);
					}
					break;
				}

			}


			int ai_num = game_ai.ai_move();
			System.out.println(" ");
			System.out.println("CPU took " + Integer.toString(ai_num) + " coins from the table!");
			if (game_ai.coins_remaining() == 1){
				System.out.println(" ");
			    System.out.println("There are " + Integer.toString(game_ai.coins_remaining()) + " coins left on the table."); 
			    System.out.println(" ");
				System.out.println("Sorry, you lost. Better luck next time!");
				System.exit(0);
			}

			continue;
		}
	}







}