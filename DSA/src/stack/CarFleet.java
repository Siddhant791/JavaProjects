package src.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] time = new double[position.length];
        Stack<Double> stack = new Stack<>();

        Map<Integer,Integer> map = new HashMap<>();


        // Store position and there corresponding speed since we're going to sort the position array
        for (int i = 0; i < position.length; i++){
            map.put(position[i], speed[i]);
        }


        // sort position array
        Arrays.sort(position);

        // Calculate time

        for (int i = 0; i < position.length; i++){
            int currentSpeedOfTheCar = map.get(position[i]);
            time[i] = (double) ( target - position[i] ) / currentSpeedOfTheCar;
        }

        stack.add(time[time.length - 1]);

        for (int j = time.length - 1 ; j >=0; j--){
            if (stack.peek()<time[j]){
                stack.add(time[j]);
            }
        }


        return stack.size();
    }
}
