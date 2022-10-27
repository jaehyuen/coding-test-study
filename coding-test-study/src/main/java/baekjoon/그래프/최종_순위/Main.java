package baekjoon.그래프.최종_순위;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int            T  = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			int             n      = Integer.parseInt(br.readLine());

			// 기존 순위 저장 배열
			int[]           before = new int[n];

			// 진입 차수 저장 배열
			int[]           arr    = new int[n + 1];

			// 방문 체크 배열
			boolean[]       v      = new boolean[n + 1];

			// 연결 관계 그래프 배열
			boolean[][]     g      = new boolean[n + 1][n + 1];

			StringTokenizer st     = new StringTokenizer(br.readLine());

			// 기존 순위 저장
			for (int j = 0; j < n; j++) {
				before[j] = Integer.parseInt(st.nextToken());
			}

			// 위상정렬을 위한 간선 카운팅
			for (int j = 0; j < n; j++) {
				arr[before[j]] = j;

				// 연결
				for (int k = j + 1; k < n; k++) {
					g[before[j]][before[k]] = true;
				}

			}

			int m = Integer.parseInt(br.readLine());

			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				// 두 간선의 방향을 바꿔준다

				if (g[a][b]) {
					arr[a]++;
					arr[b]--;

					g[b][a] = true;
					g[a][b] = false;

				} else {
					arr[a]--;
					arr[b]++;

					g[b][a] = false;
					g[a][b] = true;
				}
			}

			ArrayList<Integer> result = new ArrayList<Integer>();
			Queue<Integer>     q      = new LinkedList<Integer>();

			// 차수가 0인게 1등
			for (int j = 1; j <= n; j++) {
				if (arr[j] == 0) {
					q.add(j);
					v[j] = true;
				}

			}

			// 1등을 모르면 종료
			if (q.size() < 1) {
				System.out.println("IMPOSSIBLE");
				continue;
			}

			// 위상 정렬 시작
			while (!q.isEmpty()) {
				int now = q.poll();
				result.add(now);

				for (int j = 1; j <= n; j++) {
					if (g[now][j]) {
						arr[j]--;

						if (arr[j] == 0 && !v[j]) {
							q.add(j);
							v[j] = true;
						}
					}
				}

			}

			// 순위를 다 못정햇으면 오류
			if (result.size() != n) {
				System.out.println("IMPOSSIBLE");
			} else {
				for (int r : result) {
					System.out.print(r + " ");
				}
				System.out.println();
			}

		}

	}
}
