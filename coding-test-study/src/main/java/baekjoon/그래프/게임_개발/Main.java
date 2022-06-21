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

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (v[i] == 0) {
				q.add(i);
			}
		}

		// 결과를 저장할 배열
		int[] result = new int[N + 1];

		// 위상 정렬 시작
		while (!q.isEmpty()) {
			int now = q.poll();

			for (int next : list.get(now)) {
				v[next]--;

				// 본인 건물 시작전에 최소한 기다려야하는 시간 계산
				result[next] = Math.max(result[next], result[now] + tArr[now]);
				if (v[next] == 0) {
					q.add(next);
				}
			}

		}

		for (int i = 1; i <= N; i++) {
			// 계산된 시간과 본인 시간을 더함
			System.out.println(result[i] + tArr[i]);
		}

	}

}
