package baekjoon.그래프.서강그라운드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader              br   = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer             st   = new StringTokenizer(br.readLine());

		int                         n    = Integer.parseInt(st.nextToken());
		int                         m    = Integer.parseInt(st.nextToken());
		int                         r    = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<int[]>> map  = new ArrayList<ArrayList<int[]>>();

		int[]                       item = new int[n];

		st = new StringTokenizer(br.readLine());

		// 아이템 정보 입력
		for (int i = 0; i < n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
			map.add(new ArrayList<int[]>());
		}

		// 경로 입력
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int l = Integer.parseInt(st.nextToken());

			// 경로 등록
			map.get(a)
				.add(new int[] { b, l });
			map.get(b)
				.add(new int[] { a, l });
		}

		int max = 0;

		// 도착 지점 별로 체크한다
		for (int i = 0; i < n; i++) {

			int[][]              arr = new int[n][2];
			boolean[]            v   = new boolean[n];

			PriorityQueue<int[]> q   = new PriorityQueue<int[]>((o1, o2) -> {
											return o1[1] - o2[1];
										});

			for (int j = 0; j < n; j++) {

				arr[j][0] = j;

				// 출발지 지정
				if (i == j) {
					arr[j][1] = 0;

				} else {
					arr[j][1] = Integer.MAX_VALUE;
				}
				q.add(arr[j]);
			}

			while (!q.isEmpty()) {
				int[] now = q.poll();

				// 방문 체크
				if (v[now[0]]) {
					continue;
				}
				v[i] = true;

				// 경로가 없는게 나오면 넘어감
				if (now[1] == Integer.MAX_VALUE) {
					continue;
				}

				// 다음 경로 체크
				for (int[] next : map.get(now[0])) {

					// 다음 방문할곳이 현재를 거처서 가는게 더 빠르면 큐에 추가
					if (arr[next[0]][1] > arr[now[0]][1] + next[1]) {
						arr[next[0]][1] = arr[now[0]][1] + next[1];

						q.add(next);

					}

				}
			}

			int sum = 0;
			for (int[] distance : arr) {

				// 이동 가능간 지역의 아이탬만 획득
				if (distance[1] <= m) {
					sum += item[distance[0]];
				}
			}

			// 최대값 갱신
			max = Math.max(sum, max);
		}
		System.out.println(max);
	}

}
