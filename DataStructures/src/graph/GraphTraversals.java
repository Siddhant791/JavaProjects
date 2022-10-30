package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class GraphTraversals {
	public static void bfsGraph(int v, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
		Queue<Integer> queue = new ArrayDeque<Integer>();

		if (!visited[v]) {
			queue.add(v);
			visited[v] = true;
			while (!queue.isEmpty()) {
				int node = queue.poll();
				System.out.println(node);
				for (Integer adjNode : graph.get(node)) {
					if (!visited[adjNode]) {
						queue.add(adjNode);
						visited[adjNode] = true;
					}
				}
			}
		}

	}

}
