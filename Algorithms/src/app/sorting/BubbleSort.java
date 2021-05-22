package app.sorting;

public class BubbleSort{
		
	public static void sort(Integer[] array) {
		for(int i=array.length-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(array[j]>array[j+1]) {
					swap(array,j,j+1);
				}
			}
		}
	}
	
	public static void sort(Float[] array) {
		for(int i=array.length-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(array[j]>array[j+1]) {
					swap(array,j,j+1);
				}
			}
		}
	}

	private static void swap(Integer[] array, int a, int b) {
		// TODO Auto-generated method stub
		Integer temp;
		temp = array[a];
		array[a]=array[b];
		array[b]=temp;
	}
	
	private static void swap(Float[] array, int a, int b) {
		// TODO Auto-generated method stub
		Float temp;
		temp = array[a];
		array[a]=array[b];
		array[b]=temp;
	}
}
