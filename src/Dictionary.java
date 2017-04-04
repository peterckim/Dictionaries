import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * This Dictionary class exception handles when the file is non-existent or incompatible
 * It also checks through the File object to see if the desired word is present in the text file
 * 
 * @author peterckim
 * @version 2017-03-02
 *
 */
public class Dictionary {
	ArrayList<String> list = new ArrayList<String>();
	ArrayList<String> words = new ArrayList<String>();
	Scanner text;
	
/**
 * Create a Dictionary object with parameters listed below.
 * precondition: f must be an existing compatible file. 
 * @param f
 * 		the file to be read.
 * @throws IllegalArgumentException
 * 		Indicates that the file is unreadable.
 */
	public Dictionary( File f ) throws IllegalArgumentException{
		try{
			text = new Scanner(f);
		}
		catch(FileNotFoundException e){
			System.err.println("File was not found!");
		}
		if(f.canRead()==false){
			throw new IllegalArgumentException("File cannot be read!");
		}
		else{
			while(text.hasNext()){
				String line = text.nextLine();
				
				words.add(line);
				
			}
		}
		
	}
	
/**
 * A public return of the results of a binary search through the file for a given target.	
 * precondition: str must be a String value, words must be an ArrayList.
 * @param str
 * 		the target String to be looked for in the file.
 * @return
 * 		a boolean value stating whether the target String is existent in the file.
 */
	public boolean isWord( String str ){
		return binarySearch1(words, str);
	}
	

/**
* A public return of the results of a binary search through the file for a given prefix.
* precondition: str must be a String value, words must be an ArrayList.
* @param str
* 		the target String to be looked for in the file.
* @return
* 		a boolean value stating whether the target String is existent in the file.
*/
	public boolean isPrefix( String str ){
		return binarySearch2(words, str);
	}
	
	




	
/**
 * A private recursive method conducting a binarySearch through the file for a given String target.
 * precondition: initial must be an ArrayList<String>, target must be a String value.
 * @param initial
 * 		the initial ArrayList<String> to be used for the first binary search step.
 * @param target
 * 		the String to be searched for through the binary search
 * @return
 * 		boolean value stating whether the String target is present in the initial ArrayList.
 */
	public boolean binarySearch1(ArrayList<String> initial, String target){
		int midpoint = initial.size()/2;
		ArrayList<String> temp = new ArrayList<String>();
		if(initial.get(midpoint).equals(target)){
			return true;
		}
		else if(target.compareTo(initial.get(0)) < 0 || target.compareTo(initial.get(initial.size()-1)) > 0){
			return false;
		}
		else if(initial.size() == 1 && initial.get(midpoint).equals(target) == false){
			return false;
		}
		else{
			if(target.compareTo(initial.get(midpoint)) < 0){
				for(int i = 0; i < midpoint; i++){
					temp.add(initial.get(i));
					
				}
				return binarySearch1(temp, target);
			}
			else{
				for(int i = midpoint + 1; i < initial.size(); i++){
					temp.add(initial.get(i));
				}
				return binarySearch1(temp, target);
		}
	
			
			
		}
	
	}
	
	
/**
 * A private recursive method conducting a binarySearch through the file for a given String prefix.
 * precondition: initial must be an ArrayList<String>, prefix must be a String value.
 * @param initial
 * 		the initial ArrayList<String> to be used for the first binary search step.
 * @param prefix
 * 		the String to be searched for through the binary search
 * @return
 * 		boolean value stating whether the String prefix is present in the initial ArrayList.
 */	
	private boolean binarySearch2(ArrayList<String> initial, String prefix){
		int midpoint = initial.size()/2;
		ArrayList<String> temp1 = new ArrayList<String>();
		if(initial.get(midpoint).length() >= prefix.length()){
			if(prefix.equals(initial.get(midpoint).substring(0, prefix.length()))){
				return true;
			}
			else if(prefix.compareTo(initial.get(initial.size()-1)) > 0){ 
				return false;
			}
			else if(initial.size() == 1 && initial.get(midpoint).equals(prefix) == false){
				return false;
			}
			else{
				if(prefix.compareTo(initial.get(midpoint)) < 0){
					for(int i = 0; i < midpoint; i++){
						temp1.add(initial.get(i));
					}
					return binarySearch2(temp1, prefix);
				}
				else{
					for(int i = midpoint + 1; i < initial.size(); i++){
						temp1.add(initial.get(i));
					}
					return binarySearch2(temp1, prefix);
			}
		}
	}
		else{	
			if(prefix.compareTo(initial.get(0)) < 0 || prefix.compareTo(initial.get(initial.size()-1)) > 0){ 
				return false;
			}
			else if(initial.size() == 1 && (initial.get(midpoint).equals(prefix.substring(0,
					initial.get(midpoint).length())) == false)){ 
				return false;
			}
			else if(initial.get(midpoint).compareTo(prefix.substring(0, initial.get(midpoint).length())) > 0){
				for(int i = 0; i < midpoint; i++){
					temp1.add(initial.get(i));				
				}
				return binarySearch2(temp1, prefix);
			}
			else{
				for(int i = midpoint + 1; i < initial.size(); i++){
					temp1.add(initial.get(i));
				}
				return binarySearch2(temp1, prefix);
			}
		}

}
}