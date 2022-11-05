package baekjoon.그래프.Strahler_순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int K = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());

			int[] arr = new int[M + 1];
			int[][] cnt = new int[M + 1][2];

			ArrayList<ArrayList<Integer>> list = new ArrayList<>();

			for (int j = 0; j <= M; j++) {
				list.add(new ArrayList<>());
			}

			for (int j = 0; j < P; j++) {

				st = new StringTokenizer(br.readLine());

				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());

				list.get(A).add(B);
				arr[B]++;
			}

			Queue<Integer> q = new LinkedList<Integer>();

			// 시작점을 큐에 등록과 동시에 Strahler값 초기화
			for (int j = 1; j < M; j++) {
				if (arr[j] == 0) {
					q.add(j);
					cnt[j][0] = 1;
				}
			}

			int max = 0;
			while (!q.isEmpty()) {
				int now = q.poll();

				for (int next : list.get(now)) {

					arr[next]--;

					// Strahler의 맥스값이 바뀌거나 기존의 갯수가 높아 자동증가 됫을때 Strahler 값을 초기화 한다
					if (cnt[next][0] < cnt[now][0] || (cnt[next][0] == cnt[now][0] && cnt[next][1] == 1)) {

						// cnt[a][1] 1이면 자동증가 된거기 때문에 최대값을 카운틸 하기 위해 0으로 초기화
						cnt[next][0] = cnt[now][0];
						cnt[next][1] = 0;

					} else if (cnt[next][0] == cnt[now][0]) {

						// cnt[a][0] 값이 같으면 자동으로 Strahler값을 증가하고 cnt[a][1] 값 변경
						cnt[next][0]++;
						cnt[next][1] = 1;

					}
					if (arr[next] == 0) {
						q.add(next);
					}
				}
			}

			sb.append(K + " " + cnt[M][0] + "\n");

		}
		System.out.println(sb.toString());

	}
}
