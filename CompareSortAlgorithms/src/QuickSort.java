
public class QuickSort implements SortStrategy {
    // Function quickSort() implemented separately from sort() to keep sort()'s parameter signature clean.
    // This function gets called by sort()
    private int[] quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return array;
        }

        int x = array[left];
        int i = left;
        int j = right;

        while (i <= j) {
            while (array[i] < x) {
                i++;
            }
            while (array[j] > x) {
                j--;
            }
            if (i <= j) {
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
                i++;
                j--;
            }
        }

        // call recursively
        quickSort(array, left, j);
        quickSort(array, i, right);

        return array;
    }

    @Override
    public void sort(int[] numbers) {
        quickSort(numbers,0,numbers.length-1);

    }

    @Override
    public String getName() {
        return ("QuickSort");
    }
}