import static org.junit.Assert.*;

import org.junit.Test;
//Ruby Abrams and Irene Moreno

public class BoggleTest {

	   @Test 
	   public void testGetWordsFoundAfterPrepareResultsCalledWithSetBoggleTray() {
	    char[][] tray = {
	    { 'E', 'R', 'H', 'I' },
	    { 'T', 'C', 'O', 'Z' },
	    { 'I', 'E', 'S', 'E' },
	    { 'V', 'E', 'V', 'W' } };

	    BoggleTray dt = new BoggleTray(tray);
	    Boggle game = new Boggle();
	    game.setBoggleTray(dt);
	    game.addGuess("see");
	    game.addGuess("see");
	    game.addGuess("tEeS");
	    game.addGuess("Receives");
	    game.addGuess("Sort");
	    game.addGuess("cites");
	    game.addGuess("seCreTive");
	    game.addGuess("NotHere");
	    game.addGuess("NotHere");
	    game.addGuess("sew");

	    assertEquals(28, game.getScore());
	    assertEquals("[cites, receives, secretive, see, sew, sort, tees]", 
	                  game.getWordsFound().toString());
	    assertEquals("[nothere]", game.getWordsIncorrect().toString());
	   System.out.println(game.getWordsNotGuessed().toString() + "\n" + game.getWordsNotGuessed().size());
	    assertTrue(game.getWordsNotGuessed().contains("secret"));
	    assertTrue(game.getWordsNotGuessed().contains("recite"));
	  }


}
