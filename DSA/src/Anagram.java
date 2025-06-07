import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siddhant.
 * This class checks if two strings are anagrams of each other
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once
 *
 * Question
 * Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
 *
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 *
 * Example 1:
 *
 * Input: s = "racecar", t = "carrace"
 *
 * Output: true
 * Example 2:
 *
 * Input: s = "jar", t = "jam"
 *
 * Output: false
 * Constraints:
 *
 * s and t consist of lowercase English letters.
 */
public class Anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        if (s == null || s.length() == 0 || t ==null || t.length() == 0){
            return false;
        }
        s = s.toLowerCase();
        t = t.toLowerCase();
        List<Character> indexOfCharacters = new ArrayList<>();

        for(int i=0; i<s.length();i++){
            indexOfCharacters.add(s.charAt(i));
        }

        for(int i = 0; i<t.length();i++){
            if (indexOfCharacters.contains(t.charAt(i))){
                indexOfCharacters.remove((Character)t.charAt(i));
            }
        }
        return indexOfCharacters.isEmpty();
    }
}
