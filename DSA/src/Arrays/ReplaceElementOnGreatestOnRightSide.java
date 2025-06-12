package src.Arrays;

public class ReplaceElementOnGreatestOnRightSide {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        int temp = 0;
        for(int j = arr.length - 1; j >=0 ; j--){
            temp = arr[j];
            arr[j] = max;
            max = Math.max(temp, arr[j]);
        }
        return arr;
    }
}
