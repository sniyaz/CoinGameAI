import java.util.Random;

public class Coin_ai {
	
	private Random random = new Random();
	private int num_coins = random.nextInt(10) + 10;

	public int ai_move(){

			Move best_move = minimax(true);
			int coins_taken = best_move.action;
			num_coins = num_coins - coins_taken;
			
			return coins_taken;
	}

	public int player_move(int player_input){

		if (player_input >= num_coins){
			return 0;
		}

		if (player_input > 3 || player_input < 1){
			return 0;
		}

		num_coins = num_coins - player_input;
		return 1;
	}

	public int coins_remaining(){
		return num_coins;
	}

	private Move minimax(Boolean is_CPU){

		Move myBest = new Move();
		Move reply;
		

		if (num_coins == 1){
			if (is_CPU){
				myBest.score = -1;
				return myBest; //The CPU lost!
			} else {
				myBest.score = 1;
				return myBest; //The Human lost!
			}
		}

		myBest.action = random.nextInt(Math.min(2, num_coins - 1)) + 1;
		for (int i = 1; i < 4; i++){
			
			if (i >= num_coins){
				continue;
			}

			num_coins = num_coins - i;
			reply = minimax(!is_CPU);
			num_coins = num_coins + i;

			if ((is_CPU && reply.score > myBest.score) || (!is_CPU && reply.score < myBest.score)){
				myBest.action = i;
				myBest.score = reply.score;

			}


		}
		return myBest;

	}

}