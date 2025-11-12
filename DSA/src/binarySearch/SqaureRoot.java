package src.binarySearch;

public class SqaureRoot {
    /*
     LeetCode 69: Sqrt(x)
     https://leetcode.com/problems/sqrtx/

     Pattern/Technique: Binary Search
     - We perform binary search on the integer range to find the floor of the square root.

     Complexity:
     - Time: O(log x) — binary search on the search range \[1, x/2\] for x >= 2
     - Space: O(1) — constant extra space
    */
    public int mySqrt(int x) {
        // Handle small inputs directly: 0 -> 0, 1 -> 1
        if (x < 2) {
            return x;
        }

        // Initialize binary search bounds:
        // start at 1 because we've handled x < 2 above
        // end at x/2 since sqrt(x) for x>=2 is at most x/2
        int start = 1;
        int end = x/2;

        // ans will keep the last seen integer whose square was <= x
        int ans = 0;

        // Standard binary search loop
        while (start <= end) {
            // Prevent potential overflow in mid computation
            int mid = start + (end - start) / 2;
            // Cast to long before multiplication to avoid integer overflow for mid*mid
            long square = (long) mid * mid;
            if ((square) > x){
                // mid is too large, reduce the upper bound
                end = mid - 1;
            }else if ((square) < x) {
                // mid is a valid floor candidate; record it and try larger values
                ans = mid;
                start = mid + 1;
            }else{
                // exact square found; mid is the sqrt
                return mid;
            }
        }

        // Return the floor of sqrt(x)
        return ans;

    }
}
