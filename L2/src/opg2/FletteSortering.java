package opg2;

import java.util.ArrayList;
import java.util.List;

public class FletteSortering {
	// den liste der skal sorteres skal være global for de rekursive kald

	// den rekursive metode der implementerer del-løs og kombiner skabelonen
	public void mergesort(List<Integer> list, int f, int l) {
		if (f < l) {
			int m = (f + l) / 2;
			mergesort(list, f, m);
			mergesort(list, m + 1, l);
			merge(list, f, m, l);
		}
	}

	private void merge(List<Integer> list, int f, int m, int l) {
		List<Integer> temp = new ArrayList<Integer>();
		int i = f;
		int j = m + 1;
		while (i <= m && j <= l) {
			if (list.get(i).compareTo(list.get(j)) <= 0) {
				temp.add(list.get(i));
				i++;
			} else {
				temp.add(list.get(j));
				j++;
			}

		}
		while (i <= m) {
			temp.add(list.get(i));
			i++;
		}
		while (j <= l) {
			temp.add(list.get(j));
			j++;
		}
		for (int k = 0; k < temp.size(); k++) {
			list.set(f + k, temp.get(k));
		}
	}

}
