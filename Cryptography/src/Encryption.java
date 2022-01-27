import ps.PScipher;
import java.util.*;

public class Encryption {

	public static void main(String[] args) throws Exception {
		
		Scanner sc=new Scanner(System.in);
		
		try
		{	
			System.out.println("Enter Text File Path for Encryption: ");

			String fileName=sc.next();		//  Inputting file path from user
		
			System.out.println("Enter 8 Digit and Nonzero Number as Key: ");
			int key=sc.nextInt();			// Inputting key from user
		
			PScipher psc=new PScipher();	// Instantiating PScipher class reference variable
			psc.encrypt(fileName, key);		// Calling encrypt method and passing file name and key as parameter for encryption
		
		}catch(InputMismatchException ime)	// If key entered by user is out of range or alphabetic
		{
			System.out.println("Invalid Key.");
		}
			
	}

}
