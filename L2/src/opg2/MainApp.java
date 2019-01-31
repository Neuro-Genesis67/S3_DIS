package opg2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainApp {

	public static void main(String[] args) {

		FletteSortering sort = new FletteSortering();

		// Creates an int ArrayList and fill it with 25 random numbers.
		List<Integer> list = new ArrayList<Integer>();
		Random r = new Random();
		for (int i = 0; i < 1000000; i++) {
			list.add(Math.abs(r.nextInt() % 10000));
		}
		;
		ThreadClass tc1 = new ThreadClass(list, 0, ((list.size() - 1) / 2)); // list.size()-1?
		ThreadClass tc2 = new ThreadClass(list, ((list.size() - 1) / 2), list.size() - 1);
		List<Integer> sortedList = new ArrayList<Integer>();

		// System.out.println("Before mergesort: \n" + list);

		// Tager tid på mergesort
		long t1, t2;
		t1 = System.nanoTime();
		try {
			tc1.start();
			tc2.start();
			tc1.join();
			tc2.join();
			sortedList.addAll(tc1.getList());
			sortedList.addAll(tc2.getList());
			sort.mergesort(sortedList, 0, sortedList.size() - 1);
		} catch (InterruptedException e) {
			System.out.println("I never get errors because I'm perfect. Obviously.");
			e.printStackTrace();
		}

		t2 = System.nanoTime();

		System.out.println("\nIt took " + (t2 - t1) / 1000000 + " milliseconds to apply mergesort");
		// System.out.println("\nAfter mergesort: \n" + list);
	}

}
