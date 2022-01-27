package ps;
import java.io.*;

public class PScipher			// Encapsulated class-- All member variables are private and member methods are public 
{ 
		
		/* All Class variables are private to protect input data in it from outside accidental change
		   by other coder while using this class in their program
		   
		 * Class variables are part of implementation of class, so they shouldn't be visible outside
		 
		 * Input and output of class is accepted and sent only through parameters of methods */
		
		private int data;
		private String outputFileName;
		private FileInputStream fis;
		private FileOutputStream fos;
		
		public final void encrypt(String inputFileName, int key)	// Accepts input from parameters as public gateway of class 
		{
			try
			{	
				fis=new FileInputStream(inputFileName);				// Opening file for encryption

				
				/*
				  Finding only name of received file without extension by using dot, which separates name and extension of file
				*/
		
				int i=inputFileName.indexOf('.');					// Finds index position of .(dot) in inputFileName string
				outputFileName=inputFileName.substring(0,i)+".ps";	// Joins file name with .ps extension
				fos=new FileOutputStream(outputFileName);			// Creates and opens new file to store encrypted data
		
				
				
				/*
				  Encrypting input file data with key through loop
				*/
				while((data=fis.read())!=-1)  // End of file always contains -1, Which terminates loop in end
				{
					data=((data)+(key));	 // Input Data is using utf-32 encoding format so it is added with 32-bit key 	
					fos.write(data);		 // Writing encrypted output data to output file
					fos.flush();			 // Flushing the buffer everytime in case of buffer overflow
				}
				
				fis.close();				// Closing all opened and created files
				fos.close();
				
				System.out.println("Encryption Successful.");
			
			}catch(FileNotFoundException fnfe)				// If file name entered by user doesn't exist on storage device
			{
				System.out.println("File Not Found.");
			}
			catch(IOException ioe)							// If key entered by user is out of range or alphabetic
			{
				System.out.println("Invalid Key.");
			}
			catch(java.util.InputMismatchException ime)
			{
				System.out.println("Invalid Key");
			}
		}
		
		public final void decrypt(String inputFileName, int key)	// Accepts input from parameters as public gateway of class
		{
			try
			{	
				fis=new FileInputStream(inputFileName);				// Opening file for decryption
			
				int i=inputFileName.indexOf('.');
				outputFileName=inputFileName.substring(0,i)+".txt";
				fos=new FileOutputStream(outputFileName);
			
				
				/*
				  Decrypting input file data with key through loop
				*/
				while((data=fis.read())!=-1)	// End of file always contains -1, Which terminates loop in end
				{
					data=((data)-(key));		// Encrypted data from file is decrypted by using key
					fos.write(data);			// Writing decrypted output data to output file
					fos.flush();				// Flushing the buffer everytime in case of buffer overflow
				}
				
				fis.close();					// Closing all opened and created files
				fos.close();	
				
				System.out.println("Decryption Successful.");
			
			}catch(FileNotFoundException fnfe)			// If file name entered by user doesn't exist on storage device
			{
				System.out.println("File Not Found.");
			}
			catch(IOException ioe)
			{
				System.out.println("Invalid Key.");		// If key entered by user is out of range or alphabetic
			}
			catch(java.util.InputMismatchException ime)
			{
				System.out.println("Invalid Key.");
			}
		}
}