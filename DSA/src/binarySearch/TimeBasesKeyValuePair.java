package src.binarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode Problem: 981. Time Based Key-Value Store
 * Link: https://leetcode.com/problems/time-based-key-value-store/
 *
 * This problem requires implementing a data structure that stores key-value pairs,
 * where each value is associated with a timestamp. The `get` operation should
 * retrieve the value associated with a given key at the largest timestamp less than or equal to the given timestamp.
 *
 * Technique Used: Binary Search
 */
public class TimeBasesKeyValuePair {
}
class Value {
    public String value;
    public int timeStamp;

    public Value(String value, int timeStamp){
        this.value = value;
        this.timeStamp = timeStamp;
    }
}

class TimeMap {

    // Stores key-value pairs. Each key maps to a list of Value objects,
    // where each Value object contains a string value and its timestamp.
    // The list of Value objects for a given key is always sorted by timestamp.
    private Map<String, List<Value>> map = new HashMap<>();

    /**
     * Constructor for TimeMap. Initializes the internal map.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public TimeMap() {
        // No specific initialization needed as HashMap is initialized by default.
    }

    /**
     * Stores the key, value, and timestamp in the data structure.
     * If the key does not exist, a new list is created for it.
     * The new Value object is appended to the list, maintaining sorted order by timestamp
     * because `set` operations are guaranteed to have strictly increasing timestamps for a given key.
     *
     * Time Complexity: O(1) on average for HashMap operations (computeIfAbsent, add).
     * Space Complexity: O(1) for storing a single new Value object.
     *                   O(N) total where N is the number of set calls.
     */
    public void set(String key, String value, int timestamp) {
        // Use computeIfAbsent to get the list for the key, or create a new ArrayList if the key is not present.
        // Then, add the new Value object to the list.
        map.computeIfAbsent(key , (k) -> new ArrayList<Value>()).add(new Value(value,timestamp));
    }

    /**
     * Retrieves the value associated with the given key at the largest timestamp less than or equal to the given timestamp.
     * If no such timestamp exists, an empty string is returned.
     *
     * Time Complexity: O(log M) where M is the number of values stored for the given key.
     *                  This is due to the binary search performed on the list of values.
     * Space Complexity: O(1) (excluding the space for the stored data).
     */
    public String get(String key, int timestamp) {
        // Retrieve the list of values for the given key.
        List<Value> values = map.getOrDefault(key,null);
        // If the key does not exist, return an empty string.
        if ( values == null ) {
            return "";
        }
        // Perform binary search on the list of values to find the appropriate value.
        return binarySearch(values, timestamp);
    }

    private String binarySearch(List<Value> list, int searchIndex){
        int end = list.size() - 1;
        int start = 0;
        String out = "";
        // Binary search loop to find the largest timestamp less than or equal to searchIndex.
        while (start <= end){
            // Calculate the middle index to avoid potential integer overflow.
            int mid = start + (end - start) / 2;
            Value value = list.get(mid);

            // If the current value's timestamp is less than or equal to the searchIndex,
            // it means this could be a potential answer. We store its value and try to find
            // a more recent (larger timestamp) value in the right half.
            if (value.timeStamp <= searchIndex ) {
                // Store the current value as a potential result.
                out = value.value;
                // Move to the right half to find a larger timestamp that still satisfies the condition.
                start = mid + 1;
            }
            // If the current value's timestamp is greater than the searchIndex,
            // it means this value is too new. We need to look in the left half for an older value.
            else{
                // Move to the left half.
                end = mid - 1;
            }
        }
        // Return the found value. If no such value was found (e.g., all timestamps are greater than searchIndex),
        // 'out' will remain its initial empty string.
        return out;
    }
}
