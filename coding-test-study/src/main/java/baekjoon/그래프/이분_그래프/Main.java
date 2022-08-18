package baekjoon.그래프.이분_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int            K  = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			StringTokenizer               st   = new StringTokenizer(br.readLine());

			// 노드 갯수
			int                           V    = Integer.parseInt(st.nextToken());
			// 간선 갯수
			int                           E    = Integer.parseInt(st.nextToken());

			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

			for (int j = 0; j <= V; j++) {
				list.add(new ArrayList<Integer>());

			}

			// 그래프 생성
			for (int j = 0; j < E; j++) {
				st = new StringTokenizer(br.readLine());

				int node1 = Integer.parseInt(st.nextToken());
				int node2 = Integer.parseInt(st.nextToken());

				list.get(node1)
					.add(node2);
				list.get(node2)
					.add(node1);

			}

			if (find(V, list)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}

	}

	public static boolean find(int v, ArrayList<ArrayList<Integer>> list) {

		// 방문 체크 배열
		int[] visit = new int[v + 1];

		// 완전한 그래프가 아닐떄도 찾는다
		for (int i = 1; i <= v; i++) {

			if (visit[i] == 0) {
				Queue<Integer> q = new LinkedList<Integer>();

				q.add(i);
				visit[i] = 1;

				while (!q.isEmpty()) {
					int now = q.poll();

					for (int next : list.get(now)) {

						// 방문 안했을떄
						if (visit[next] == 0) {
							visit[next] = visit[now] * -1;
							q.add(next);
						} else if (visit[next] == visit[now]) {
							// 방문햇는데 같은 집합이면 이분그래프 아님
							return false;
						}
					}

				}
			}

		}

		return true;

	}

}
