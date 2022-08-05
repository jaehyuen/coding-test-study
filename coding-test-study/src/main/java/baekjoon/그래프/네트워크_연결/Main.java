package baekjoon.그래프.네트워크_연결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader                    br  = new BufferedReader(new InputStreamReader(System.in));

		// 컴퓨터 갯수
		int                               N   = Integer.parseInt(br.readLine());
		// 전선 갯수
		int                               M   = Integer.parseInt(br.readLine());

		HashMap<Integer, ArrayList<Node>> map = new HashMap<Integer, ArrayList<Node>>();

		for (int i = 0; i < M; i++) {
			StringTokenizer st   = new StringTokenizer(br.readLine());

			int             tmp1 = Integer.parseInt(st.nextToken());
			int             tmp2 = Integer.parseInt(st.nextToken());
			int             tmp3 = Integer.parseInt(st.nextToken());

			// 양방향으로 저장
			ArrayList<Node> list = map.getOrDefault(tmp1, new ArrayList<Node>());
			list.add(new Node(tmp2, tmp3));
			map.put(tmp1, list);

			list = map.getOrDefault(tmp2, new ArrayList<Node>());
			list.add(new Node(tmp1, tmp3));
			map.put(tmp2, list);

		}

		// 방문 체크 배열
		boolean[]           v = new boolean[N + 1];

		// 우선순위 큐 생성
		PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> {
									return o1.dis - o2.dis;
								});

		// 첫번쨰 노드 등록
		q.add(new Node(1, 0));
		//v[1] = true;

		int result = 0;
		int cnt    = 0;

		while (!q.isEmpty()) {
			Node now = q.poll();

			// 방문 했으면 무시
			if (v[now.num]) {
				continue;
			}

			cnt++;
			result     += now.dis;
			v[now.num]  = true;

			//전부 방문했으면 그만
			if (cnt == N) {
				break;
			}

			for (Node next : map.getOrDefault(now.num, new ArrayList<Node>())) {

				// 방문안햇으면 큐에 추가
				if (!v[next.num]) {
					q.add(next);
				}
			}

		}

		System.out.println(result);

	}
}

class Node {
	int num;
	int dis;

	public Node(int num, int dis) {
		this.num = num;
		this.dis = dis;
	}
}