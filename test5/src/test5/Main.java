package test5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) throws UserDefinedExeption {
		Scanner sc = new Scanner(System.in);
		int input = 0;
		while(true) {
			System.out.println("Choose from given below menu \n 1.) ArrayList \n 2.) LinkedHashSet \n 3.)TreeSet \n 4.) Exit ");
			input = sc.nextInt();sc.nextLine();
			if(input == 1) {
				List<String> ll = new ArrayList<String>();
				System.out.println("Enter names \n");
				for(int i=0;i<5;i++) {
					ll.add(sc.nextLine());
				}
				Collections.sort(ll);
				System.out.println(ll);
			}else if(input == 2) {
				LinkedHashSet<String> lh= new LinkedHashSet<String>();
				System.out.println("Enter names \n");
				for(int i=0;i<5;i++) {
					lh.add(sc.nextLine());
				}	
			}else if(input == 3) {
				TreeSet<String> tt = new TreeSet<String>();
				System.out.println("Enter names /n");
				for(int i=0;i<5;i++) {
					tt.add(sc.nextLine());
				}
				System.out.println(tt);
			}else if(input == 4){
				break;
			}else {
				throw new UserDefinedExeption("Invalid choice exception");
			}
		}
	}

	
}

class UserDefinedExeption extends Exception{
	
	public UserDefinedExeption(String s) {
		// TODO Auto-generated constructor stub
		super(s);
	}
}

