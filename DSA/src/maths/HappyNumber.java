package src.maths;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    class Solution {
        Set<Integer> set = new HashSet<>();
        public boolean isHappy(int n) {
            int squareNumber = n;
            while(true){
                squareNumber = getSquareNumber(squareNumber);
                if (!set.add(squareNumber)) {
                    return false;
                }

                if (squareNumber == 1){
                    return true;
                }
            }
        }

        private int getSquareNumber(int n){
            int out = 0;
            int d = 0;
            while (n > 0){
                d = n%10;
                out+=d*d;
                n=n/10;
            }
            return out;
        }
    }
}
