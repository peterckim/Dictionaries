import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This ScrabbleHelper class serves as the main class
 * It establishes all the data fields and calls all the args.
 * It also calls the methods from the other classes.
 * @author peterckim
 * @version 2017-03-02
 *
 */
public class ScrabbleHelper {
	
	
/**
 * Serves as the main class.
 * It establishes all the data fields and calls all the args.
 * It also calls the methods from the other classes.
 * @param args
 * 		The arguments to be read from Run Configurations
 * @throws FileNotFoundException
 * 		Indicates that the File name is not found in the Run Configurations.
 */
	public static void main(String[] args) throws FileNotFoundException{
		String filename = args[0];
		File textfile = new File(filename);
		String testword = args[1];
		
		//Dictionary d = new Dictionary(textfile);
		//Permutations p = new Permutations(testword);
		//p.getAllWords(d);
		count7(7717);
	}
	
	
	
	
	public static int count7(int number){
		if(number < 10 && number == 7){
			return 1;
		}
		else if(number<10 && number != 7){
			return 0;
		}
		else{
			if(number % 10 == 7){
				return 1 + count7(number/10);
			}
			else{
				return 0 + count7(number/10);
			}
		}
}
}
