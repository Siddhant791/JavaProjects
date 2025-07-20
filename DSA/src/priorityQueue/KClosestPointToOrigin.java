package src.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode 973 - K Closest Points to Origin
 *
 * Problem Statement:
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane
 * and an integer k, return the k closest points to the origin (0, 0).
 * The distance between two points is the Euclidean distance: sqrt((x1 - x2)² + (y1 - y2)²).
 *
 * Example:
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation: The distance between (-2, 2) and the origin is sqrt(8).
 * The distance between (1, 3) and the origin is sqrt(10).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 *
 * Technique Used:
 * - Priority Queue (Min Heap)
 * - We don't need to calculate actual sqrt as comparing squares is sufficient
 */
public class KClosestPointToOrigin {
    /**
     * Finds k points closest to origin using Priority Queue
     *
     * Algorithm:
     * 1. Create a min heap ordered by distance from origin
     * 2. For each point, calculate distance² = x² + y²
     * 3. Store [distance², x, y] in priority queue
     * 4. Extract k smallest distances to get result
     *
     * Time Complexity: O(n log n) where n is number of points
     * - Building heap: O(n log n) for n insertions
     * - Extracting k elements: O(k log n)
     *
     * Space Complexity: O(n)
     * - Priority Queue stores n elements
     * - Output array stores k elements
     *
     * @param points Array of coordinates [x,y]
     * @param k Number of closest points to return
     * @return k closest points to origin
     */
    public int[][] kClosest(int[][] points, int k) {
        // Min heap ordered by distance from origin
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        // Calculate distance² for each point and add to queue
        // Store as [distance², x, y] to preserve original coordinates
        for (int[] point : points){
            int distance = point[0] * point[0] + point[1] * point[1];
            queue.offer(new int[]{distance, point[0], point[1]});
        }

        // Extract k closest points
        int[][] output = new int[k][2];
        for (int i = 0 ; i < k ; i++){
            int[] coordinates = queue.poll();
            output[i][0] = coordinates[1];  // Original x coordinate
            output[i][1] = coordinates[2];  // Original y coordinate
        }

        return output;
    }
}
