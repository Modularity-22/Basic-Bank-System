package code;

import java.io.IOException;
import java.util.Scanner;

public class PassWord {
	
	FileOperations file = new FileOperations();
	Scanner input = new Scanner(System.in);
	
	public boolean checkPassWord() throws IOException{

		System.out.print("\nEnter the password: ");
		String pass = input.next();
		checkUntilPasswordIsCorrect(pass);

		return true;
			
	}
	
	public void changePassWord() throws IOException{
		
		System.out.print("\nEnter the old Password: ");
		String oldPass = input.next();
		
		if(checkUntilPasswordIsCorrect(oldPass)){
		System.out.print("\nEnter the new Password: ");
		String newPass = input.next();
		file.setPassWord(newPass);
		System.out.print("\nThe password has been changed successfully!");
		}
	}

	private String getPassWord() throws IOException{
		
		String pass = file.getPassWord();
		return pass;
	}

	private boolean checkUntilPasswordIsCorrect(String oldPass) throws IOException {

		while(oldPass.equals(getPassWord()) == false){
			System.out.print("The entered password is incorrect! \n\nRe-enter the password: ");
			oldPass = input.next();

			if(oldPass.equals(getPassWord()))
				break;
			}
		return true;	
			}
}
