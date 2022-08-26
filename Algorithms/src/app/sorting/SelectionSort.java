package app.sorting;

public class SelectionSort {

	public static void sort(Integer[] array) {
		for (int i = array.length - 1; i > 0; i--) {
			int largest = array[i];
			int index = i;
			for (int j = 0; j < i; j++) {
				if(array[j]>largest) {largest=array[j];index=j;}
			}
			Swap.swap(array, i,index);
		}
	}
}
