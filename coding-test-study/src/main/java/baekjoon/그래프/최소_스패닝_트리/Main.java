package baekjoon.그래프.최소_스패닝_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수

		// 간선을 저장할 리스트
		ArrayList<ArrayList<Node>> list = new ArrayList<>();

		for (int i = 0; i <= V; i++) {
			list.add(new ArrayList<>());
		}

		// 간선들을 입력받아 리스트에 저장
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			int tmp3 = Integer.parseInt(st.nextToken());

			list.get(tmp1).add(new Node(tmp2, tmp3));
			list.get(tmp2).add(new Node(tmp1, tmp3));
		}

		// 프림 알고리즘을 위한 우선순위큐 생성
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> {
			return o1.dis - o2.dis;
		});
		boolean[] v = new boolean[V + 1]; // 방문 처리 배열
		long result = 0;// 결과값
		int cnt = 0;// 노드 방문 카운트

		q.add(new Node(1, 0));

		// 프림 알고리즘 시작
		while (!q.isEmpty()) {

			// 방문 횟수 추가
			cnt++;
			Node now = q.poll();

			if (v[now.y])
				continue;

			result += now.dis;
			v[now.y] = true;

			// 모든 노드를 방문했을경우 반목분 종료
			if (cnt == V) {
				break;
			}

			// 방문 안했을 경우 큐에 삽입
			for (Node next : list.get(now.y)) {
				if (!v[next.y]) {
					q.add(next);
				}
			}

		}
		System.out.println(result);
	}

}

class Node {

	int y;
	int dis;

	public Node(int y, int dis) {
		this.y = y;
		this.dis = dis;
	}

}
