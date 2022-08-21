package baekjoon.그래프.ACM_Craft;

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
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			// 연결 갯수 배열
			int[] arr = new int[N + 1];
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			list.add(new ArrayList<>());

			// 건설비용
			int[] money = new int[N + 1];
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++) {
				money[j] = Integer.parseInt(st.nextToken());
				list.add(new ArrayList<>());
			}

			// 연결 순서 리스트 생성, 연결 카운트 증가
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());

				int tmp1 = Integer.parseInt(st.nextToken());
				int tmp2 = Integer.parseInt(st.nextToken());

				list.get(tmp1).add(tmp2);
				arr[tmp2]++;
			}

			Queue<Integer> q = new LinkedList<Integer>();
			int[] result = new int[N + 1];

			for (int j = 1; j <= N; j++) {

				// 제일 우선순위가 낮은걸 큐에 넣어준다
				if (arr[j] == 0) {
					q.add(j);
					result[j] = money[j];
				}
			}

			while (!q.isEmpty()) {
				int now = q.poll();

				for (int next : list.get(now)) {

					arr[next]--;

					// 소요시간 계산
					result[next] = Math.max(result[next], money[next] + result[now]);

					if (arr[next] == 0) {
						q.add(next);
					}
				}
			}

			// 해당 건물의 소요시간 출력
			System.out.println(result[Integer.parseInt(br.readLine())]);

		}
	}

}
