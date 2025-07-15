//multiple inputs from system and pass it to method

import java.util.Arrays;
import java.util.Scanner;
public class Inputscan{
	public static void input() {
		Scanner scanner= new Scanner(System.in);
		
		System.out.println("Enter the name");
		String name=scanner.nextLine();
		
		System.out.println("Enter the age");
		int age=scanner.nextInt();
		
		details(name,age);
		scanner.close();
		
	}
	public static void details(String name,int age) {
		
		System.out.println("Display output"+name +" "+ age);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stubs
		
		Inputscan inp=new Inputscan();
		inp.input();
		
		
		
		
	}

}
