package baekjoon.그래프.다익스트라.간선_이어가기_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Node>> list = new ArrayList<>();

		// 다익스트라 알고리즘을 이용하기위한 리스트 초기화
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		// 각 간선의 가중치를 리스트에 저장한다
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list.get(a).add(new Node(b, c));
			list.get(b).add(new Node(a, c));
		}

		// 시작, 종료 정점 입력
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		Node[] nodeList = new Node[n + 1];
		boolean[] v = new boolean[n + 1];

		
		//s -> t 가중치 초기화 (자기자신일땐 0)
		for (int i = 1; i <= n; i++) {
			if (i == s) {

				nodeList[i] = new Node(i, 0);
			} else {
				nodeList[i] = new Node(i, 987654321);
			}

		}

		//다익스트라 알고리즘을 위한 큐 선언
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> {
			return o1.dis - o2.dis;
		});
		q.add(nodeList[s]);
		v[s] = true;

		while (!q.isEmpty()) {
			Node now = q.poll();
			v[now.y] = true;

			for (Node next : list.get(now.y)) {
				if (v[next.y])
					continue;

				// 다른곳을 거쳐가는 가중치가 더 작을떄 큐 업데이트
				if (nodeList[next.y].dis > nodeList[now.y].dis + next.dis) {

					nodeList[next.y].dis = nodeList[now.y].dis + next.dis;

					q.remove(nodeList[next.y]);
					q.add(nodeList[next.y]);

				}
			}
		}
		
		System.out.println(nodeList[t].dis);

	}
}

class Node {
	int y;
	int dis;

	Node(int y, int dis) {
		this.y = y;
		this.dis = dis;
	}
}
