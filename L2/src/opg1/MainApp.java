package opg1;

public class MainApp {

	public static void main(String[] args) {
		Common common = new Common();
		ThreadClass in = new ThreadClass("Input", common);
		ThreadClass out = new ThreadClass("Printer", common);
		in.start();
		out.start();
		
		
	}

}
