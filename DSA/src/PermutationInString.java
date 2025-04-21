import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] characterCheckForS1 = new int[26];
        int window = s1.length();
        Set<String> checkSet = new HashSet<>();

        for(char c:s1.toCharArray()){
            characterCheckForS1[c -'a'] = characterCheckForS1[c - 'a']+=1;
        }
        checkSet.add(Arrays.toString(characterCheckForS1));
        int i = 0;
        while (i <= s2.length() - window){
            int[] characterCheck = new int[26];
            String windowString = s2.substring(i,i+window);

            for (char c : windowString.toCharArray()){
                characterCheck[c - 'a'] = characterCheck[c - 'a']+=1;
            }
            if (checkSet.contains(Arrays.toString(characterCheck)))
            {
                return true;
            }
            i++;
        }
        return false;
    }

}
