import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//Ruby Abrams and Irene Moreno
public class Boggle {

	// Boggle will use your well-tested BoggleTray.
	// If you need one (did not get 100% problem coverage,
	// ask Rick for his BoggleTray: mercer@cs.arizona.edu
	private BoggleTray boggleTray;
	private String guess;
	private Scanner scan;
	private HashMap<Integer, String> officialWords;
	private List<String> guesses;
	private List<String> correct;
	private List<String> incorrect;
	private List<String> notGuessed;

	// Other instance variables will be needed to store collections such
	// as the 80,000+ BoggleWords ...

	// Initialize a new game. Random dice not needed until part 3
	public Boggle() {
		scan = null;
		try {
			scan = new Scanner(new File("BoggleWords"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		officialWords = new HashMap<Integer, String>();
		int i = 0;
		while (scan.hasNext()) {
			String temp = scan.next();
			officialWords.put(i, temp);
			i++;
		}
		boggleTray = new BoggleTray(new char[4][4]);
		guesses = new ArrayList<String>();
		correct = new ArrayList<String>();
		incorrect = new ArrayList<String>();
		notGuessed = new ArrayList<String>();

	}

	// Allow testers to set the BoggleTray to a known one (not random).
	public void setBoggleTray(BoggleTray dt) {
		this.boggleTray = dt;
	}

	// Return the BoggleTray object as a textual representation as a String
	public String getBoggleTrayAsString() {
		return boggleTray.toString();
	}

	// Record one word (a string with no whitespace) as one of the users'
	// guesses.
	// Do what you want with it, but oneGuess should be processed so all methods
	// can return the correct values such as getScore() and getWordsFound().
	public void addGuess(String oneGuess) {
		guess = oneGuess.trim();
		guesses.add(oneGuess.toLowerCase().trim());
	}

	// Return a list of all words the user entered that count for the score. The
	// found words
	// must be in their natural ordering. This method should return an empty
	// list until
	// addGuess(String) is called at least once. The returned List<E> could also
	// be empty if
	// no attempts actually counted for anything. There must be no duplicates!
	public List<String> getWordsFound() {
		addToCorrectList();
		return correct;
	}

	private void addToCorrectList() {
		int i = 0;
		int size = guesses.size();
		while (i < size) {
			if (officialWords.containsValue(guesses.get(i))
					&& boggleTray.foundInBoggleTray(guesses.get(i))
					&& !correct.contains(guesses.get(i))) {
				correct.add(guesses.get(i));
			} else {
				if (!incorrect.contains(guesses.get(i))
						&& !correct.contains(guesses.get(i)))
					incorrect.add(guesses.get(i));
			}
			i++;
		}
		Collections.sort(correct);
		Collections.sort(incorrect);
	}

	// Return a list of all words the user entered that do not count for the
	// score
	// in their natural order. This list may be empty with no words guessed or
	// all
	// guessed words actually count for points. There must be no duplicates!
	public List<String> getWordsIncorrect() {
		return incorrect;
	}

	// All words the user could have guessed but didn't in their natural order.
	// This list could also be empty at first or if the user guessed ALL words
	// in the board and in the list of 80K words (unlikely).
	// There must be no duplicates!
	
	public List<String> getWordsNotGuessed() {
		int i = 0;
		while (i < officialWords.size()) {
			if (boggleTray.foundInBoggleTray(officialWords.get(i))
					&& !correct.contains(officialWords.get(i)))
				notGuessed.add(officialWords.get(i));
			i++;
		}
		return notGuessed;
	}

	// Return the correct score.
	public int getScore() {
		List<String> temp = new ArrayList<String>();
		temp = getWordsFound();
		return totalScore(temp);
	}

	private int totalScore(List<String> correct) {
		//System.out.println(correct.toString());
		int score = 0;
		int index = 0;
		while (index < correct.size()) {
			if (correct.get(index).length() < 3
					|| correct.get(index).length() > 16)
				score += 0;
			else if (correct.get(index).length() == 3
					|| correct.get(index).length() == 4)
				score += 1;
			else if (correct.get(index).length() == 5)
				score += 2;
			else if (correct.get(index).length() == 6)
				score += 3;
			else if (correct.get(index).length() == 7)
				score += 5;
			else
				score += 11;
			index++;
		}
		//System.out.println(correct.toString());
		return score;
	}
}
