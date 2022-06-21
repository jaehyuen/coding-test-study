package baekjoon.그래프.게임_개발;

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
		BufferedReader                br   = new BufferedReader(new InputStreamReader(System.in));
		int                           N    = Integer.parseInt(br.readLine());
		int[]                         v    = new int[N + 1];
		int[]                         tArr = new int[N + 1];

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}

		// 역으로 위상 정렬
		for (int i = 1; i <= N; i++) {
			StringTokenizer st   = new StringTokenizer(br.readLine());

			int             time = Integer.parseInt(st.nextToken());
			tArr[i] = time;

			while (true) {
				int tmp = Integer.parseInt(st.nextToken());

				if (tmp == -1) {
					break;
				}

				list.get(tmp)
					.add(i);
				v[i]++;
			}

		}
//		System.out.println(list);
//		System.out.println(Arrays.toString(v));

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (v[i] == 0) {
				q.add(i);
			}
		}
		int[] result = new int[N + 1];
		while (!q.isEmpty()) {
			int now = q.poll();

			// r결과 저장

			for (int next : list.get(now)) {
				v[next]--;

				result[next] = Math.max(result[next], result[now] + tArr[now]);
				if (v[next] == 0) {
					q.add(next);
				}
			}

		}

		for (int i = 1; i <= N; i++) {
			System.out.println(result[i] + tArr[i]);
		}

	}

}
