package pavan;
import java.util.ArrayList;
import java.util.Collections;

import pavan.*;
import pavan.sort.bubbleSort;
import pavan.sort.gnomeSort;
import pavan.sort.insertiionSort;
import pavan.sort.mergeSort;
import pavan.sort.quadrixSort;
import pavan.sort.radixSort;
import pavan.sort.selectionsort;
import pavan.sort.shellSort;

public class sortingVisualizer {
	
	private static Thread sortingThread;

	public static visualizerFrame frame;
	public static Integer[] toBeSorted;
	public static boolean isSorting = false;
	public static int sortDataCount = 100;
	public static int sleep = 20;
	public static int blockWidth;
	// Stepped depicts whether the values are incremental or random. True is incremental.
	public static boolean stepped = false;

	public static void main(String[] args) {
		
		frame = new visualizerFrame();
		resetArray();
		frame.setLocationRelativeTo(null);

	}
	
	public static void resetArray(){
		// If we are currently in a sorting method, then isSorting should be true
		// We do not want to reinitialize/reset the array mid sort.
		if (isSorting) return;
		toBeSorted = new Integer[sortDataCount];
		blockWidth = (int) Math.max(Math.floor(500/sortDataCount), 1);
		for(int i = 0; i<toBeSorted.length; i++){
			if (stepped) {
				toBeSorted[i] = i;
			} else {
				toBeSorted[i] = (int) (sortDataCount*Math.random());
			}
		}
		// If we're using incremental values, they are already sorted. This shuffles it.
		if (stepped) {
			ArrayList<Integer> shuffleThis = new ArrayList<>();
			for (int i = 0; i < toBeSorted.length; i++) {
				shuffleThis.add(toBeSorted[i]);
			}
			Collections.shuffle(shuffleThis);
			toBeSorted = shuffleThis.toArray(toBeSorted);
		}
		frame.preDrawArray(toBeSorted);
	}

	public static void startSort(String type){

		if (sortingThread == null || !isSorting){

			resetArray();

			isSorting = true;

			switch(type){
			case "Bubble":
				sortingThread = new Thread(new bubbleSort(toBeSorted, frame, false));
				break;

			case "Selection":
				sortingThread = new Thread(new selectionsort(toBeSorted, frame, false));
				break;

			case "Insertion":
				sortingThread = new Thread(new insertiionSort(toBeSorted, frame, false));
				break;

			case "Gnome":
				sortingThread = new Thread(new gnomeSort(toBeSorted, frame, true));
				break;

			case "Merge":
				sortingThread = new Thread(new mergeSort());
				break;

			case "Radix LSD":
				sortingThread = new Thread(new radixSort(toBeSorted, frame, true));
				break;

			case "Radix MSD":
				sortingThread = new Thread(new radixSort(toBeSorted, frame, false));
				break;

			case "Shell":
				sortingThread = new Thread(new shellSort());
				break;

			case "Quandrix":
			  sortingThread = new Thread(new quadrixSort());
				break;

			case "Bubble(fast)":
				sortingThread = new Thread(new bubbleSort(toBeSorted, frame, true));
				break;

			case "Selection(fast)":
				sortingThread = new Thread(new selectionsort(toBeSorted, frame, true));
				break;

			case "Insertion(fast)":
				sortingThread = new Thread(new insertiionSort(toBeSorted, frame, true));
				break;

			case "Gnome(fast)":
				sortingThread = new Thread(new gnomeSort(toBeSorted, frame, true));
				break;

			default:
				isSorting = false;
				return;
			}

			sortingThread.start();
		}
	}


}
