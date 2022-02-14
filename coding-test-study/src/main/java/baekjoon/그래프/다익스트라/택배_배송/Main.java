package baekjoon.그래프.다익스트라.택배_배송;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader             br   = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer            st   = new StringTokenizer(br.readLine());

		int                        N    = Integer.parseInt(st.nextToken());
		int                        M    = Integer.parseInt(st.nextToken());

		int                        INF  = 987654321;

		ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Node>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x   = Integer.parseInt(st.nextToken());
			int y   = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());

			list.get(x)
				.add(new Node(y, dis));
			list.get(y)
				.add(new Node(x, dis));
		}

		Node[]    nodeList = new Node[N + 1];
		boolean[] v        = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {

			if (i == 1) {
				nodeList[i] = new Node(i, 0);
			} else {
				nodeList[i] = new Node(i, INF);
			}

		}

		PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> {
			return o1.dis - o2.dis;
		});

		q.add(nodeList[1]);

		while (!q.isEmpty()) {
			Node now = q.poll();

//			}
			for (Node next : list.get(now.y)) {
				if (v[next.y])
					continue;

				if (nodeList[next.y].dis > nodeList[now.y].dis + next.dis) {

					nodeList[next.y].dis = nodeList[now.y].dis + next.dis;

					q.remove(nodeList[next.y]);
					q.add(nodeList[next.y]);

				}
			}

		}

		System.out.println(nodeList[N].dis);

	}
}

class Node {

	int y;
	int dis;

	public Node(int y, int dis) {

		this.y   = y;
		this.dis = dis;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "y : " + y + ", dis : " + dis;
	}
}