package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import app.pojos.Student;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		HashSet<Integer> hash = new HashSet<Integer>();
//		hash.add(2);
//		int i=3;
//		if(hash.contains(i)) {
//			hash.remove(i);
//		}else {
//			hash.add(i);
//		}
//		Set<Integer> temp = new HashSet<Integer>(hash);
//		hash.remove(2);
//		System.out.println(temp);
//		System.out.println(hash);

//		ArrayList<Student> list = new ArrayList<Student>();
//		list.add(new Student(1, "siahesh"));
//		list.add(new Student(3, "ab"));
//		list.add(new Student(2, "sid"));
//		list.add(new Student(4, "zi"));
//		
//		Collections.sort(list, (student1,student2) -> {
//			return student1.name.compareToIgnoreCase(student2.name);
//		});
//		
//		Collections.sort(list, (student1,student2) -> {
//			return student1.rollNo-student2.rollNo;
//		});
//		
//		System.out.println(list);
		countOfSubstrings("aabab", 3);
	}

	static int countOfSubstrings(String S, int K) {
		// code here
		int[] alphabet = new int[26];
		int start = 0;
		int end = K;
		int output = 0;
		
		for (int i = 0; i < K; i++) {
			alphabet[S.charAt(i) - 'a']++;
		}
		
		if (Arrays.stream(alphabet).sum() == K - 1) {
			output++;
		}
		
		while (end < S.length()) {
			alphabet[S.charAt(start) - 'a']--;
			if (alphabet[S.charAt(end) - 'a'] == 0) {
				alphabet[S.charAt(end) - 'a']++;
			}
			if (Arrays.stream(alphabet).sum() == K - 1) {
				output++;
			}
			start++;
			end++;
		}

		return output;
	}

}
