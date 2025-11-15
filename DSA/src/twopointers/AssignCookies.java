package src.twopointers;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int numberOfChildren = g.length;
        int numberOfCookies = s.length;
        int i = 0;
        int j = 0;
        int output = 0;

        while (i < numberOfChildren && j < numberOfCookies) {
            if (s[j] >= g[i]) {
                i++;
                j++;
                output++;
            }else {
                j++;
            }
        }

        return output;
    }
}
