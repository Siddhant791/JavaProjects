package src.binarySearch;

public class SqaureRoot {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int start = 1;
        int end = x/2;

        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            long square = (long) mid*mid;
            if ((square) > x){
                end = mid - 1;
            }else if ((square) < x) {
                ans = mid;
                start = mid + 1;
            }else{
                return mid;
            }
        }

        return ans;

    }
}
