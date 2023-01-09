package baekjoon.그래프.최소비용_구하기2;

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
		int                         n    = Integer.parseInt(br.readLine());
		int                         m    = Integer.parseInt(br.readLine());

		ArrayList<ArrayList<int[]>> map  = new ArrayList<ArrayList<int[]>>();
		int[]                       root = new int[n + 1];

		// 연결 정보 초기화
		for (int i = 0; i <= n; i++) {
			map.add(new ArrayList<int[]>());

		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int             a  = Integer.parseInt(st.nextToken());
			int             b  = Integer.parseInt(st.nextToken());
			int             c  = Integer.parseInt(st.nextToken());

			// 연결
			map.get(a)
				.add(new int[] { b, c });

		}
		StringTokenizer      st    = new StringTokenizer(br.readLine());

		int                  start = Integer.parseInt(st.nextToken());
		int                  end   = Integer.parseInt(st.nextToken());

		// 거리가 짧은순 우선순위큐 생성
		PriorityQueue<int[]> q     = new PriorityQueue<int[]>((o1, o2) -> {
										return o1[1] - o2[1];
									});

		boolean[]            v     = new boolean[n + 1];
		int[][]              arr   = new int[n + 1][2];

		for (int i = 1; i <= n; i++) {
			// 시작점 설정
			if (i == start) {
				arr[i][0] = i;
				arr[i][1] = 0;
			} else {
				arr[i][0] = i;
				arr[i][1] = Integer.MAX_VALUE;
			}
			q.add(arr[i]);
		}

		while (!q.isEmpty()) {
			int[] now = q.poll();

			// 방문햇으면 넘어감
			if (v[now[0]])
				continue;

			// 방문 처리
			v[now[0]] = true;

			if (now[1] == Integer.MAX_VALUE) {
				break;
			}

			for (int[] next : map.get(now[0])) {

				// 더 짧으면 큐를 수정
				if (arr[next[0]][1] > arr[now[0]][1] + next[1]) {

					arr[next[0]][1] = arr[now[0]][1] + next[1];

					// 경로 저장
					root[next[0]]   = now[0];

					q.remove(arr[next[0]]);
					q.add(arr[next[0]]);
				}

			}
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		int                now  = end;

		// 경로 구하기
		while (true) {
			list.add(now);

			now = root[now];
			if (now == 0) {
				break;
			}

		}

		System.out.println(arr[end][1]);
		System.out.println(list.size());

		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();

	}

}