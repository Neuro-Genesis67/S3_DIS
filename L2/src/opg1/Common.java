package opg1;

import java.util.Scanner;

public class Common {

	public String text = "Default text";
	public Scanner sc;
	
	public Common() {
		sc = new Scanner(System.in);
	}

	public void getText() {
		System.out.println(text);
	}

	public void setText() {
		
		while(true) {{
			System.out.println("Insert the next word to be printed: ");
			text = sc.nextLine();
		}
	}
	
	
	}
}
