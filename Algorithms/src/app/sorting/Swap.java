package app.sorting;

public class Swap {
	public static void swap(Integer[] array, int a, int b) {
		// TODO Auto-generated method stub
		if(a==b) {return;}
		array[a] = array[a]+array[b];
		array[b] = array[a]-array[b];
		array[a] = array[a]-array[b];
		
	}
}
