import java.util.Scanner;

//Ruby Abrams and Irene Moreno
public class Boggle3Console {
	public static void main (String [] args){
		Boggle game = new Boggle();
		BoggleTray tray = new BoggleTray();
		game.setBoggleTray(tray);
		String dice = tray.toString();
		System.out.println("Play one game of Boggle: ");
		System.out.println(dice);
		
		System.out.println("Enter words or ZZ to quit: \n");
		
		Scanner scan = new Scanner(System.in);
		String input = "";
		
		while(!input.equalsIgnoreCase("ZZ")){
			input = scan.next();
			if(!input.equalsIgnoreCase("ZZ"))
				game.addGuess(input);	
		}
		
		System.out.println("Your Score: "+ game.getScore()+"\n");
		System.out.println("Words You found: \n"+ game.getWordsFound()
				+"\nIncorrect Words: \n"+ game.getWordsIncorrect()
				+"\nYou could have found "+game.getWordsNotGuessed().size()+" more words.\n"
				+"The computer found all of your words plus these: \n"+ game.getWordsNotGuessed());
	}
}
