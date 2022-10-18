package pavan.sort;
import pavan.*;


public class gnomeSort implements Runnable {
	private Integer[] toBeSorted;
	private visualizerFrame frame;
	private boolean fast;
	
	public gnomeSort(Integer[] toBeSorted, visualizerFrame frame, boolean fast) {
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
	
	public void sortFast() {
		int temp = 0;
		for(int i = 0; i<toBeSorted.length-1; i++){
			for(int j = i+1; j>0; j--){
				if (toBeSorted[j] < toBeSorted[j-1]){
					temp = toBeSorted[j];
					toBeSorted[j] = toBeSorted[j-1];
					toBeSorted[j-1] = temp;
				}else{
					break;
				}
			}
			frame.reDrawArray(toBeSorted);
			try {
				Thread.sleep(sortingVisualizer.sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sortSlow() {
		int temp = 0;
		for(int i = 0; i<toBeSorted.length-1; i++){
			for(int j = i+1; j>0; j--){
				if (toBeSorted[j] < toBeSorted[j-1]){
					temp = toBeSorted[j];
					toBeSorted[j] = toBeSorted[j-1];
					toBeSorted[j-1] = temp;
					frame.reDrawArray(toBeSorted, j, j-1);
					try {
						Thread.sleep(sortingVisualizer.sleep);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					break;
				}

}
		}
		
		}
}
