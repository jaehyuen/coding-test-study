package baekjoon.그래프.해킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();

			for (int j = 0; j <= n; j++) {
				list.add(new ArrayList<Node>());
			}

			// 감염 경로 저장
			for (int j = 0; j < d; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());

				list.get(b).add(new Node(a, s));
			}

			// 우선 순위 큐 생성
			PriorityQueue<Integer> q = new PriorityQueue<Integer>();

			// 경로 시간 저장 배열
			int[] arr = new int[n + 1];

			// 최대로 채움
			Arrays.fill(arr, 999999999);

			// 시작 지점 설정
			q.add(c);
			arr[c] = 0;

			while (!q.isEmpty()) {
				int now = q.poll();

				for (Node next : list.get(now)) {

					// 최단 거리 갱신 시 큐에 추가
					if (arr[next.node] > arr[now] + next.distance) {
						arr[next.node] = arr[now] + next.distance;
						q.add(next.node);
					}
				}
			}

			int cnt = 0;
			int max = 0;

			// 최대값 및 감염 카운트
			for (int j = 1; j <= n; j++) {
				if (arr[j] != 999999999) {
					cnt++;
					max = Math.max(max, arr[j]);
				}
			}
			System.out.println(cnt + " " + max);
		}
	}
}

class Node {
	int node;
	int distance;

	Node(int node, int distance) {
		this.node = node;
		this.distance = distance;
	}
}
