package baekjoon.그래프.음악프로그램;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 간선 체크용 배열
		int[] arr = new int[N + 1];

		// 그래프용 리스트
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			//순서대로 간선 갯수를 카운팅 및 그래프를 그려준다
			int cnt = Integer.parseInt(st.nextToken());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = 0;

			for (int j = 1; j < cnt; j++) {
				tmp2 = Integer.parseInt(st.nextToken());
				list.get(tmp1).add(tmp2);
				arr[tmp2]++;
				tmp1 = tmp2;

			}

		}
		
		
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		
		//간선 갯수가 0 인거부터 큐에 넣어줌
		for (int i = 1; i <= N; i++) {
			if (arr[i] == 0) {
				q.add(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		
		//간선 갯수를 줄여주며 bfs 탐색
		while (!q.isEmpty()) {
			int now = q.poll();
			cnt++;

			sb.append(now + "\n");
			for (int next : list.get(now)) {
				arr[next]--;
				if (arr[next] == 0) {
					q.add(next);
				}
			}
		}
		
		//탐색을 다하면 출력 아니면 0 출력
		if (cnt == N) {
			System.out.println(sb.toString());
		} else {
			System.out.println(0);
		}
	}

}
