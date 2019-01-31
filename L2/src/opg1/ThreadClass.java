package opg1;

public class ThreadClass extends Thread {

	private String functionality;
	private Common common;
	
	public ThreadClass(String functionality, Common common) {
		this.functionality = functionality;
		this.common = common;
	}
	
	public void run() {
	
		if (this.functionality.equals("Input")) {
			try {
				common.setText();
			} catch (Exception e) {
				System.out.println(functionality + " had an error");
				e.printStackTrace();
			}
					
		} else {
			try {
				while(true) {
					this.sleep(3000);
					common.getText();
				}
				
			} catch (Exception e) {
				System.out.println(functionality + " had an error");
				e.printStackTrace();
			}
		}
	}
}
