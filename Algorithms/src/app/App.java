package app;

import java.util.Arrays;

import app.dp.Knapsack;

class Parent {
	protected void task() {
	}
}

class Child extends Parent {
	// void task() {}
}

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MIN_VALUE);
//		int[] arr = { 5, 3, 0, 7, 4 };
//			int[] arr = {6,8,4,5,2,3};
		int[] arr = {1,1,5,2,7,6,1,4,2,3,2,2,1,6,8,5,7,6,1,8,9,2,7,9,5,4,3,1};
		int n = 28;
		Arrays.sort(arr);
		String first = "";
		String second = "";
		for (int i = 0; i < arr.length; i++) {
			if(i%2==0) {
				first+=Integer.toString(arr[i]);
			}else {
				second+=Integer.toString(arr[i]);
			}
		}
		long out = Long.valueOf(first)+Long.valueOf(second);
		System.out.println(out);
	}

}
