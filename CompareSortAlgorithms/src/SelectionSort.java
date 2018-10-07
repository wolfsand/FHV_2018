
public class SelectionSort implements SortStrategy {

	@Override
	public void sort(int[] numbers) {
		// TODO Auto-generated method stub
		int min;
		for (int i=0; i<numbers.length-1; i++) {
			min = i;
			for ( int j=i+1; j<numbers.length; j++) {
				if (numbers[j] < numbers[min]) {
					min = j;
				}					
			}
			int temp = numbers[min];
			numbers[min] = numbers[i];
			numbers[i] = temp;
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ("Selection Sort");
	}

}
