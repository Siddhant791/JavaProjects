package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetection {
	public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		// Code here
		boolean[] visited = new boolean[V];
		int parent = -1;
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				if (cycleDetected(i, adj, parent, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean cycleDetected(int v, ArrayList<ArrayList<Integer>> adj, Integer par, boolean[] visited) {

		Queue<int[]> qu = new LinkedList<int[]>();
		qu.add(new int[] { v, par });
		visited[v] = true;

		while (!qu.isEmpty()) {
			int[] node = qu.poll();
			int current = node[0];
			int parent = node[1];

			for (Integer neighbor : adj.get(current)) {
				if (visited[neighbor] && neighbor != parent) {
					return true;
				}

				if (!visited[neighbor]) {
					visited[neighbor] = true;
					qu.add(new int[] { neighbor, current });
				}
			}

		}
		return false;
	}
}
