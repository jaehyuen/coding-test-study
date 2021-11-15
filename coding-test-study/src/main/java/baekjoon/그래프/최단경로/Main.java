package baekjoon.그래프.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader             br       = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer            st       = new StringTokenizer(br.readLine());

		int                        V        = Integer.parseInt(st.nextToken());
		int                        E        = Integer.parseInt(st.nextToken());

		int                        K        = Integer.parseInt(br.readLine());

		ArrayList<ArrayList<Edge>> edgeList = new ArrayList<ArrayList<Edge>>();

		for (int i = 0; i <= V; i++) {
			edgeList.add(new ArrayList<Edge>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			int tmp3 = Integer.parseInt(st.nextToken());

			edgeList.get(tmp1)
				.add(new Edge(tmp2, tmp3));

		}
		PriorityQueue<Edge> q   = new PriorityQueue<>((o1, o2) -> {
									return o1.dis - o2.dis;
								});

		boolean[]           v   = new boolean[V + 1];
		Edge[]              arr = new Edge[V + 1];

		for (int i = 1; i <= V; i++) {
			if (i == K) {

				arr[i] = new Edge(i, 0);
			} else {
				arr[i] = new Edge(i, Integer.MAX_VALUE);
			}
			q.add(arr[i]);
		}

		// System.out.println(q);

		while (!q.isEmpty()) {

			Edge e = q.poll();
			if (e.dis == Integer.MAX_VALUE)
				break;

			for (Edge nextEdge : edgeList.get(e.node)) {

				if (v[nextEdge.node])
					continue;

				
//				
				
				if (arr[nextEdge.node].dis > arr[e.node].dis + nextEdge.dis) {
					arr[nextEdge.node].dis = arr[e.node].dis + nextEdge.dis;

					q.remove(arr[nextEdge.node]);
					q.add(arr[nextEdge.node]);
				}
			}
		}
		for (int i = 1; i <= V; i++) {
			System.out.println(arr[i].dis == Integer.MAX_VALUE ? "INF" : arr[i].dis);

		}
//		int[][]         arr = new int[V + 1][V + 1];
//		int             INF = 987654321;
//
//		for (int i = 1; i <= V; i++) {
//			for (int j = 1; j <= V; j++) {
//				arr[i][j] = INF;
//				if (i == j) {
//					arr[i][j] = 0;
//				}
//			}
//		}
//
//		for (int i = 0; i < E; i++) {
//			st = new StringTokenizer(br.readLine());
//
//			int tmp1 = Integer.parseInt(st.nextToken());
//			int tmp2 = Integer.parseInt(st.nextToken());
//			int tmp3 = Integer.parseInt(st.nextToken());
//
//			arr[tmp1][tmp2] = tmp3;
////			arr[tmp2][tmp1] = tmp3;
//		}
//
//		for (int k = 1; k <= V; k++) {
//			for (int i = 1; i <= V; i++) {
//				for (int j = 1; j <= V; j++) {
//					arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
//				}
//			}
//		}
//

	}

	static class Edge {
		int node, dis;

		public Edge(int node, int dis) {
			this.node = node;
			this.dis  = dis;
		}

	}
}
