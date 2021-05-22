package app;

import app.sorting.BubbleSort;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Float[] inputArray = {12.1f,3.2f,-2.3f,4.5f,6.4f};
		BubbleSort.sort(inputArray);
		for(Float i:inputArray) {System.out.print(i+" ");}
	}

}
