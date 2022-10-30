package app.questions;

import java.util.ArrayDeque;
import java.util.Queue;

public class CountOccuranceInArray {

	public int output;

	
	public static void main(String[] args) {
		CountOccuranceInArray c = new CountOccuranceInArray();
		char[][] input = {{'S','N','B','S','N'},
		       {'B','A','K','E','A'},
		       {'B','K','B','B','K'},
		       {'S','E','B','S','E'}};
		String target = "SNAKES";
		c.findOccurrence(input, target);
		System.out.println(c.output);
	}
	
	public int findOccurrence(char mat[][], String target) {
		if (target.length() == 0 || mat.length == 0) {
			return 0;
		}
		// Write your code here
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		// int output = 0;
		int rowSize = mat.length;
		int columnSize = mat[0].length;
		Queue<int[]> qu = new ArrayDeque<>();

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (target.charAt(0) == mat[i][j]) {
					qu.add(new int[] { i, j });
				}
			}
		}
		while (!qu.isEmpty()) {
			int[] coord = qu.poll();
			int x = coord[0];
			int y = coord[1];
			check(dx, dy, rowSize, columnSize, target, 1, x, y, mat);
		}

		return this.output;
	}

	public void check(int[] dx, int[] dy, int rs, int cs, String target, int index, int x, int y, char[][] mat) {
		if (index == target.length()) {
			this.output++;
			return;
		}

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx >= 0 && nx < rs && ny >= 0 && ny < cs) {
				if (target.charAt(index) == mat[nx][ny]) {
					check(dx, dy, rs, cs, target, index+1, nx, ny, mat);
				}
			}
		}
		

	}
}
