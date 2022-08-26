package app.search;

public class BinarySearch {
	public static boolean binarySearchIterative(int[] a, int search) {
		int left = 0;
		int right = a.length - 1;
//		int mid = (left+right)/2;

		while (left <= right) {
			int mid = (left + right) / 2;
//			int mid =left + ((right-left)/2);
			if (a[mid] == search) {
				return true;
			} else if (a[mid] > search) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return false;
	}

	public static boolean binarySearchRecursive(int[] a, int left, int right, int k) {
		if (left > right) {
			return false;
		}
		int mid = (left + right) / 2;
		if (a[mid] == k) {
			return true;
		}
		if (k > a[mid]) {
			return binarySearchRecursive(a, mid+1, right, k);
		}
		return binarySearchRecursive(a, left, mid-1, k);

	}

}
