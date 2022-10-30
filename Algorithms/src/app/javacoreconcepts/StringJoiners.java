package app.javacoreconcepts;

import java.util.StringJoiner;

public class StringJoiners {
	private StringJoiner sj;
	
	public String join(String input,String joiner) {
		StringJoiner sj1 = new StringJoiner(joiner);
		for(int i=0;i<input.length();i++) {
			sj1.add(Character.toString(input.charAt(i)));
		}
		return sj1.toString();
	}
	public String merge(String s1,String s2) {
		StringJoiner s1j = new StringJoiner("","{","}");
		StringJoiner s2j = new StringJoiner("");
		s1j.add(s1);
		s2j.add(s2);
		return s1j.merge(s2j).toString();
	}
}
