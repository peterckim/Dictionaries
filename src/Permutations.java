import java.util.ArrayList;
import java.util.Collections;


/**
 * This Permutations class contains all the methods necessary to generate all
 * permutations of a given string.
 * This class establishes data fields to allow the generation of all the permutations
 * @author peterckim
 * @version 2017-03-02
 */
public class Permutations {
	ArrayList<String> perms = new ArrayList<String>();
	ArrayList<String> perms1 = new ArrayList<String>();
	String letter;
	Dictionary dict;
	
/**
 * Creates a Permutations object with parameters listed below. 
 * precondition: letters must be a String value
 * @param letters
 * 		the letters to be permutated
 * @throws IllegalArgumentException
 * 		Indicates that the argument inputed is invalid.
 */
	Permutations(String letters) throws IllegalArgumentException{
		for(int i = 0; i < letters.length(); i++){
			if(Character.isLetter(letters.charAt(i)) == false){
				System.err.println("All characters are not letters!");
				System.exit(1);
			}
		}
		this.letter = letters.toLowerCase();
	}

	
	
/**
 * A public method with the return of the results of the method createPermutations1
 * precondition: none
 * @return
 * 		return the results of the recursive method createPermutations1
 */
	public ArrayList<String> getAllPermutations(){
		ArrayList<String> x = new ArrayList<String>();
		x = createPermutations1(letter,"");
		return x;
		
		
	}
	
/**
 * A public method with the return of the results of the method createPermutations2
 * precondition: none
 * @param dictionary
 * 		the dictionary object to be used to create permutations
 * @return
 * 		return the results of the recursive method createPermutation2
 */
	public ArrayList<String> getAllWords(Dictionary dictionary){
		dict = dictionary;
		ArrayList<String> y = new ArrayList<String>();
		y = createPermutations2(letter,"");
		Collections.sort(y);
		if(y.size() >= 1){
			System.out.println("Found " + y.size() + " words:");
			for(int i = 0; i < y.size(); i++){
				System.out.println(y.get(i));
		}
		}
		else{
			System.out.println("No Words Found!");
		}
		return y;
		
	}

	
/**
 * Method lacking backtracking but using recursion to create all the permutations of a given String
 * @param letters
 * 		The String input that will be used to create all permutations or the remaining letters
 * 		not yet put into String seq
 * @param seq
 * 		The String that all the letters end up being a part of
 * @return
 * 		An ArrayList of all the permutations
 */
	private ArrayList<String> createPermutations1(String letters, String seq){
		if(letters.length() == 0 && !(perms.contains(seq))){
			perms.add(seq);
		}
		else{
			for(int i = 0; i < letters.length(); i ++){
				createPermutations1(letters.substring(0, i) + letters.substring(i+1, letters.length()), seq
						+ letters.charAt(i));
			}
		}
		return perms;
		
	}

	
/**
 * Method with backtracking and recursion to create all the permutations of a given String	
 * @param letters
 * 		The String input that will be used to create all permutations or the remaining letters not yet
 * 		put into String seq
 * @param seq
 * 		The String that all the letters end up being a part of
 * @return
 * 		An ArrayList of all the permutations
 */
	private ArrayList<String> createPermutations2(String letters, String seq){
		if(letters.length() == 0 && dict.isWord(seq) && !(perms1.contains(seq))){
			perms1.add(seq);
		}
		else{
			if(dict.isPrefix(seq) == true){
			for(int i = 0; i < letters.length(); i++){
				createPermutations2(letters.substring(0, i) + letters.substring(i+1, letters.length()),
						seq + letters.charAt(i));
			}
			}
		}
		return perms1;
	}
}
