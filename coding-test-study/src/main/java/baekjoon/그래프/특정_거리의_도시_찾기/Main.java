package baekjoon.그래프.특정_거리의_도시_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Node>> nodeList = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			nodeList.add(new ArrayList<Node>());
		}

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());

			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());

			nodeList.get(tmp1).add(new Node(tmp2, 1));
		}

		Node[] arr = new Node[N + 1];

		for (int i = 0; i <= N; i++) {
			if (i == X) {
				arr[i] = new Node(i, 0);
			} else {
				arr[i] = new Node(i, Integer.MAX_VALUE);
			}
		}

		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> {
			return o1.dis - o2.dis;
		});
		q.add(arr[X]);

		while (!q.isEmpty()) {
			Node now = q.poll();

			if (now.dis == Integer.MAX_VALUE)
				break;

			for (Node next : nodeList.get(now.next)) {

				if (arr[next.next].dis > next.dis + now.dis) {
					arr[next.next].dis = next.dis + now.dis;
					q.add(arr[next.next]);
				}
			}

		}

		StringBuilder sb = new StringBuilder();

		for (Node n : arr) {
			if (n.dis == K) {
				sb.append(n.next + "\n");
			}
		}

		String result = sb.toString();

		System.out.println(result.equals("") ? -1 : result);

	}
}

class Node {
	int next;
	int dis;

	public Node(int next, int dis) {
		this.next = next;
		this.dis = dis;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[next : " + next + ", dis : " + dis + "]";
	}
}