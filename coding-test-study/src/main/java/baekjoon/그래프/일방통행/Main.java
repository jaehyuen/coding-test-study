package baekjoon.그래프.일방통행;

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
		BufferedReader                br   = new BufferedReader(new InputStreamReader(System.in));
		int                           N    = Integer.parseInt(br.readLine());

		int[]                         arr  = new int[N];
		char[][]                      tmp  = new char[N][N];
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < N; i++) {
			tmp[i] = br.readLine()
				.toCharArray();
			list.add(new ArrayList<Integer>());

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;

				// 단방향 그래프 일때 사이클 체크
				if (tmp[i][j] != tmp[j][i] && tmp[i][j] == 'Y') {

					list.get(i)
						.add(j);
					arr[j]++;
				}
			}
		}

		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {

			// 연결된 간선이 없으면 큐에 넣어줌
			if (arr[i] == 0) {
				q.add(i);
			}
		}

		// 위상 정렬
		while (!q.isEmpty()) {
			int now = q.poll();

			for (int next : list.get(now)) {
				arr[next]--;

				// 간선이 모두 지워지면 큐에 넣는다
				if (arr[next] == 0) {
					q.add(next);
				}
			}
		}

		for (int i = 0; i < N; i++) {

			// 간선이 남아있으면 사이클이 있는것으로 종료
			if (arr[i] != 0) {
				System.out.println("NO");
				return;
			}
		}

		System.out.println("YES");

	}

}
