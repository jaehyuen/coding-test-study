package baekjoon.그래프.작업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 걸리는 시간, 결과, 간선 갯수 배열
		int[] arr = new int[N + 1];
		int[] time = new int[N + 1];
		int[] result = new int[N + 1];

		// 그래프 리스트
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());

			time[i] = tmp1;
			result[i] = tmp1;
			for (int j = 0; j < tmp2; j++) {
				int tmp3 = Integer.parseInt(st.nextToken());

				list.get(tmp3).add(i);
				arr[i]++;

			}
		}

		// 간선이 0개면 큐에 저장
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (arr[i] == 0) {
				q.add(i);
			}
		}

		// 위상 정렬 시작
		while (!q.isEmpty()) {
			int now = q.poll();

			for (int next : list.get(now)) {
				arr[next]--;

				// 결고 배열에 계속 업데이트 해준다
				result[next] = Math.max(result[next], result[now] + time[next]);
				if (arr[next] == 0) {
					q.add(next);
				}
			}
		}
		
		//제일 큰값이 답
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, result[i]);
		}
		System.out.println(max);

	}

}
