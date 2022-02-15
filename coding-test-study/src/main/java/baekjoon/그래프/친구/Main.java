package baekjoon.그래프.친구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int            N   = Integer.parseInt(br.readLine());

		int[][]        arr = new int[N][N];
		// 최대값 선언
		int            INF = 987654321;

		// 플로이드 와샬 알고리즘을 사용하기 위한 초기값 세팅
		// 본인은 친구가 아니기떄문에 0
		// 친구사이면 1
		// 친구사이가 아니면 최대
		for (int i = 0; i < N; i++) {
			char[] strs = br.readLine()
				.toCharArray();

			for (int j = 0; j < N; j++) {
				if (i == j) {
					arr[i][j] = 0;
				} else {
					arr[i][j] = INF;
				}
				arr[i][j] = strs[j] == 'Y' ? 1 : arr[i][j];
			}

		}
		
		//플로이드 와샹 알고리즘으로 최단 거리 탐색 시작
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = Math.min(arr[k][j] + arr[i][k], arr[i][j]);

				}
			}
		}

		
		//2 친구사이 최대값 탐색
		int max = 0;
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;

				if (arr[i][j] <= 2)
					cnt++;
			}
			max = Math.max(max, cnt);
		}

		System.out.println(max);

	}
}