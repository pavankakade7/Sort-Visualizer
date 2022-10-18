package pavan.sort;
import pavan.*;
public class selectionsort implements Runnable {
	
	private Integer[] toBeSorted;
	private visualizerFrame frame;
	private boolean fast;
	
	public selectionsort(Integer[] toBeSorted, visualizerFrame frame, boolean fast) {
		this.toBeSorted = toBeSorted;
		this.frame = frame;
		this.fast = fast;
	}
	
	public void run() {
		if (fast) {
			sortFast();
		} else {
			sortSlow();
		}
		sortingVisualizer.isSorting=false;
	}
	
	public void sortFast(){
		int temp = 0;
		int selected = 0;
		for(int i = 0; i<toBeSorted.length; i++){
			selected = i;
			for(int j = toBeSorted.length-1; j>i; j--){
				if (toBeSorted[j] <= toBeSorted[selected]){
					selected = j;
				}				
			}
			frame.reDrawArray(toBeSorted);
			try {
				Thread.sleep(sortingVisualizer.sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			temp = toBeSorted[i];
			toBeSorted[i] = toBeSorted[selected];
			toBeSorted[selected]= temp;
		}
	}
	
	public void sortSlow() {
		int temp = 0;
		int selected = 0;
		for(int i = 0; i<toBeSorted.length; i++){
			selected = i;
			for(int j = toBeSorted.length-1; j>i; j--){
				
				if (toBeSorted[j] <= toBeSorted[selected]){
					selected = j;
				}
				frame.reDrawArray(toBeSorted, selected, j-1);
				try {
					Thread.sleep(sortingVisualizer.sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}
			temp = toBeSorted[i];
			toBeSorted[i] = toBeSorted[selected];
			toBeSorted[selected]= temp;
		}
		frame.reDrawArray(toBeSorted);
	}

}
