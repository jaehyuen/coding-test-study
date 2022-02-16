package baekjoon.그래프.Small_World_Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());

		int             N   = Integer.parseInt(st.nextToken());
		int             K   = Integer.parseInt(st.nextToken());

		int[][]         arr = new int[N + 1][N + 1];

		// max 값
		int             INF = 987654321;

		// 플로이드 와샬 알고리즘을 위한 초기값 세팅
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {

				if (i == j) {
					arr[i][j] = 0;
				} else {
					arr[i][j] = INF;
				}

			}
		}

		// 친구 사이인 값들 추가
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());

			arr[tmp1][tmp2] = 1;
			arr[tmp2][tmp1] = 1;

		}

		// 플로이드 와샬 알고리즘 진행
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
				}
			}
		}

		// 친구사이가 6이상이면 빅월드 출력
		String result = "Small World!";
		for (int[] ar : arr) {

			for (int a : ar) {
				if (a > 6) {
					System.out.println("Big World!");
					return;
				}
			}

		}

		System.out.println(result);

	}
}
