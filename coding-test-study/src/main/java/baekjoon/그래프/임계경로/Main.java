package baekjoon.그래프.임계경로;

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

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		// 연결 정보
		ArrayList<ArrayList<int[]>> list = new ArrayList<>();

		// 역방향 연결 정보
		ArrayList<ArrayList<int[]>> reverseList = new ArrayList<>();

		// 입력 정보
		ArrayList<int[]> roadList = new ArrayList<>();

		// 순방향 정보
		int[] arr = new int[n + 1];
		int[] cost = new int[n + 1];

		// 역방향 정보
		int[] reverseArr = new int[n + 1];
		int[] reverseCost = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
			reverseList.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			// 순방향 정보 입력
			list.get(a).add(new int[] { b, c });
			arr[b]++;

			// 역방향 정보 입력
			reverseList.get(b).add(new int[] { a, c });
			reverseArr[a]++;

			// 입력 정보 저장
			roadList.add(new int[] { a, b, c });

		}

		StringTokenizer st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		// 순방향 위상 정렬 시작
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int[] next : list.get(now)) {
				arr[next[0]]--;

				// 최대 비용 계산
				cost[next[0]] = Math.max(next[1] + cost[now], cost[next[0]]);

				if (arr[next[0]] == 0) {
					q.add(next[0]);

				}
			}

		}

		// 역방향 위상 정렬 시작
		q = new LinkedList<Integer>();
		q.add(end);

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int[] next : reverseList.get(now)) {
				reverseArr[next[0]]--;

				// 최대 비용 계산
				reverseCost[next[0]] = Math.max(next[1] + reverseCost[now], reverseCost[next[0]]);

				if (reverseArr[next[0]] == 0) {
					q.add(next[0]);

				}
			}

		}

		int cnt = 0;
		for (int[] road : roadList) {

			// 최대 비용으로 가는 경로면 카운트 증가
			if (cost[road[0]] + reverseCost[road[1]] + road[2] == cost[end]) {
				cnt++;
			}
		}

		System.out.println(cost[end]);
		System.out.println(cnt);

	}
}
