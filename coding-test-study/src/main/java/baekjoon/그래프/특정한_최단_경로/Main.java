package baekjoon.그래프.특정한_최단_경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int V;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Node>> nodeList = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			nodeList.add(new ArrayList<Node>());

		}

		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());

			int from     = Integer.parseInt(st.nextToken());
			int to       = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());

			nodeList.get(from)
				.add(new Node(to, distance));
			nodeList.get(to)
				.add(new Node(from, distance));

		}

		st = new StringTokenizer(br.readLine());

		int mustNode1 = Integer.parseInt(st.nextToken());
		int mustNode2 = Integer.parseInt(st.nextToken());

		int a         = dijkstra(1, mustNode1, nodeList) + dijkstra(mustNode1, mustNode2, nodeList)
				+ dijkstra(mustNode2, N, nodeList);
		int b         = dijkstra(1, mustNode2, nodeList) + dijkstra(mustNode2, mustNode1, nodeList)
				+ dijkstra(mustNode1, N, nodeList);
		int result    = Math.min(a, b);

		System.out.println(result == INF - 2 ? -1 : result);

	}

	static public int dijkstra(int start, int end, ArrayList<ArrayList<Node>> nodeList) {

		Node[]              d = new Node[N + 1];

		PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> {
									return o1.distance - o2.distance;
								});

		for (int i = 0; i <= N; i++) {
			if (i == start) {
				d[i] = new Node(i, 0);
			} else {
				d[i] = new Node(i, INF);
			}

		}
		q.add(d[start]);
		while (!q.isEmpty()) {
			Node now = q.poll();

			if (now.distance == INF)
				break;

			for (Node nextNode : nodeList.get(now.next)) {

				if (d[nextNode.next].distance > d[now.next].distance + nextNode.distance) {
					d[nextNode.next].distance = d[now.next].distance + nextNode.distance;
					q.offer(d[nextNode.next]);
				}

			}
		}

		return d[end].distance;

	}

}

class Node {
	int next;
	int distance;

	Node(int next, int distance) {
		this.next     = next;
		this.distance = distance;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + "next : " + next + ", distance : " + distance + "]";
	}

}