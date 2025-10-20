package src.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/**
 * LeetCode Problem: 853. Car Fleet
 * Link: https://leetcode.com/problems/car-fleet/
 *
 * Problem Description:
 * N cars are going to the same destination at the same target distance.
 * Each car i has a initial position[i] and speed[i].
 *
 * A car fleet is a non-empty group of cars driving at the same position and same speed.
 * A car can't pass another car, but it can catch up to it and drive bumper to bumper.
 * The faster car will slow down to match the slower car's speed.
 *
 * The distance to the target is target - position[i].
 *
 * Return the number of car fleets that will arrive at the destination.
 *
 * Technique/Pattern: Stack, Sorting, Monotonic Stack (implicitly)
 *
 * Complexity Analysis:
 * - Time Complexity: O(N log N) due to sorting the `position` array.
 *   - Storing position-speed pairs: O(N)
 *   - Sorting `position` array: O(N log N)
 *   - Calculating arrival times: O(N)
 *   - Populating and processing the stack: O(N)
 * - Space Complexity: O(N)
 *   - `time` array: O(N)
 *   - `stack`: O(N) in the worst case (e.g., all cars form separate fleets)
 *   - `map`: O(N) to store position-speed pairs.
 */
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        // Array to store the time it takes for each car to reach the target.
        double[] time = new double[position.length];
        // Stack to keep track of the arrival times of the leading cars in fleets.
        Stack<Double> stack = new Stack<>();

        // Map to store the original speed corresponding to each car's position.
        // This is necessary because we will sort the `position` array,
        // and we need to retrieve the correct speed for each sorted position.
        Map<Integer,Integer> map = new HashMap<>();


        // Store position and there corresponding speed since we're going to sort the position array
        // Time Complexity: O(N)
        // Space Complexity: O(N) for the map.
        for (int i = 0; i < position.length; i++){
            map.put(position[i], speed[i]);
        }


        // sort position array
        // Sorting the positions allows us to process cars from the closest to the target
        // to the farthest, which is crucial for the stack-based approach.
        // Time Complexity: O(N log N)
        Arrays.sort(position);

        // Calculate time
        // Iterate through the sorted positions to calculate the time each car takes to reach the target.
        // Time Complexity: O(N)
        for (int i = 0; i < position.length; i++){
            // Retrieve the original speed for the current position from the map.
            int currentSpeedOfTheCar = map.get(position[i]);
            // Calculate time = distance / speed.
            // Distance is (target - current position).
            time[i] = (double) ( target - position[i] ) / currentSpeedOfTheCar;
        }

        // Initialize the stack with the arrival time of the car closest to the target.
        // This car will always form a new fleet as there are no cars ahead of it to merge with.
        // Time Complexity: O(1)
        stack.add(time[time.length - 1]);

        // Iterate through the cars from the second closest to the target (index `time.length - 2`)
        // down to the farthest car (index 0).
        // This is a reverse iteration because we want to simulate cars approaching the target.
        // Time Complexity: O(N)
        for (int j = time.length - 1 ; j >=0; j--){
            // If the current car's arrival time is greater than the arrival time of the
            // car currently at the top of the stack (which represents the leading car of the fleet ahead),
            // it means the current car will arrive later than the fleet ahead.
            // Therefore, it cannot merge with the fleet ahead and forms a new fleet.
            // We push its arrival time onto the stack.
            if (stack.peek()<time[j]){
                stack.add(time[j]);
            }
            // If the current car's arrival time is less than or equal to the arrival time
            // of the car at the top of the stack, it means this car will catch up to or
            // arrive at the same time as the fleet ahead. In this scenario, it merges
            // with the fleet ahead, and we don't need to add it to the stack as it
            // doesn't form a new leading car for a fleet. The existing top of the stack
            // still represents the arrival time of this combined fleet.
        }

        // The size of the stack at the end represents the total number of distinct car fleets.
        return stack.size();
    }
}
