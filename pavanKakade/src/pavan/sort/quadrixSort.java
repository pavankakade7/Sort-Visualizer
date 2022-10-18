package pavan.sort;
import pavan.*;

public class quadrixSort implements Runnable {
	
	public void run() {
		int temp = 0;
		Integer[] toBeSorted = sortingVisualizer.toBeSorted;
		int i = 0;

		if (toBeSorted.length % 3 == 0) {
			sortingVisualizer.isSorting=false;
			return;
		}

		boolean swapped = false;
		int doubleCheck = 0;
		boolean end = false;
		while(doubleCheck < 3){
			if (end) {
				swapped = false;
				end = false;
			}

			int j = i + 1;
			int k = j + 1;

			if (k < toBeSorted.length) {
				if (toBeSorted[k] < toBeSorted[j]) {
					temp = toBeSorted[j];
					toBeSorted[j] = toBeSorted[k];
					toBeSorted[k] = temp;
					swapped = true;
				}
				sortingVisualizer.frame.reDrawArray(toBeSorted, k, j);
				try {
					Thread.sleep(sortingVisualizer.sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (j < toBeSorted.length) {
				if (toBeSorted[j] < toBeSorted[i]) {
					temp = toBeSorted[i];
					toBeSorted[i] = toBeSorted[j];
					toBeSorted[j] = temp;
					swapped = true;
				}
				sortingVisualizer.frame.reDrawArray(toBeSorted, j, i);
				try {
					Thread.sleep(sortingVisualizer.sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (k < toBeSorted.length) {
					if (toBeSorted[k] < toBeSorted[j]) {
						temp = toBeSorted[j];
						toBeSorted[j] = toBeSorted[k];
						toBeSorted[k] = temp;
						swapped = true;
					}
					sortingVisualizer.frame.reDrawArray(toBeSorted, k, j);
					try {
						Thread.sleep(sortingVisualizer.sleep);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			i += 3;
			if (i >= toBeSorted.length) {
				i = i % toBeSorted.length;
				end = true;
				if (!swapped) {
					doubleCheck++;
				} else {
					doubleCheck = 0;
				}
			}
		}

		sortingVisualizer.isSorting=false;

}
}
