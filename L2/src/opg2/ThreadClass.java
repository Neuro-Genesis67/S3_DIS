package opg2;

import java.util.List;

public class ThreadClass extends Thread {

	List<Integer> list;
	FletteSortering fs = new FletteSortering();
	int f;
	int l;

	public ThreadClass(List<Integer> list, int firstIndex, int lastIndex) {
		this.list = list;
		this.f = firstIndex;
		this.l = lastIndex;
	}

	@Override
	public void run() {
		fs.mergesort(list, f, l);
	}

	public List<Integer> getList() {
		return list;
	}

}
