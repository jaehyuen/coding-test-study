package baekjoon.그래프.문제집;

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
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 간선수 저장용 배열
		int[] arr = new int[N + 1];

		// 그래프용 리스트
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());

			list.get(tmp1).add(tmp2);
			arr[tmp2]++;
		}

		// 문제 번호가 낮을수록 쉽기에 우선순위큐를 사용한다
		PriorityQueue<Integer> q = new PriorityQueue<>();

		// 간선이 0인 문제만 큐에 추가
		for (int i = 1; i <= N; i++) {
			if (arr[i] == 0) {
				q.add(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {

			// 문제를 풀고 출력한다
			int now = q.poll();
			sb.append(now + " ");
			for (int next : list.get(now)) {
				arr[next]--;

				if (arr[next] == 0) {
					q.add(next);
				}
			}
		}

		System.out.println(sb.toString());
	}

}
