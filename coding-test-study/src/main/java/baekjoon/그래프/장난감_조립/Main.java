package baekjoon.그래프.장난감_조립;

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
		BufferedReader              br     = new BufferedReader(new InputStreamReader(System.in));

		int                         N      = Integer.parseInt(br.readLine());
		int                         M      = Integer.parseInt(br.readLine());

		// 연결 차수 카운팅 배열
		int[]                       arr    = new int[N + 1];

		// 기본 부품 확인용 배열
		int[]                       basic  = new int[N + 1];

		// 부품 갯수 저장 배열
		int[]                       result = new int[N + 1];
		ArrayList<ArrayList<int[]>> list   = new ArrayList<ArrayList<int[]>>();

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<int[]>());
		}

		for (int i = 0; i < M; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int             X  = Integer.parseInt(st.nextToken());
			int             Y  = Integer.parseInt(st.nextToken());
			int             K  = Integer.parseInt(st.nextToken());

			// 재료가 필요하면 카운트 증가
			basic[X]++;

			// 위상별로 연결
			arr[Y]++;
			list.get(X)
				.add(new int[] { Y, K });

		}

		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++) {
			if (arr[i] == 0) {
				q.add(i);
				result[i] = 1;
			}

		}

		while (!q.isEmpty()) {

			int now = q.poll();

			for (int[] next : list.get(now)) {

				// 차수 감소
				arr[next[0]]--;

				// 부품 사용량 증가
				result[next[0]] += result[now] * next[1];

				if (arr[next[0]] == 0) {
					q.add(next[0]);
				}
			}

		}

		// 기본 부품만 출력
		for (int i = 1; i <= N; i++) {
			if (basic[i] == 0) {
				System.out.println(i + " " + result[i]);
			}
		}
	}
}
