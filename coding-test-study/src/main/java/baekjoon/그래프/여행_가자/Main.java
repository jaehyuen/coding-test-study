package baekjoon.그래프.여행_가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][N];

		// 연결 여부 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());

				if (i == j) {
					arr[i][j] = 0;
				} else if (tmp == 0) {
					arr[i][j] = 987654321;
				} else {
					arr[i][j] = tmp;
				}
			}
		}

		// 플로이드와샬로 가능여부 체크
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					arr[i][j] = Math.min(arr[k][j] + arr[i][k], arr[i][j]);
				}
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int prev = Integer.parseInt(st.nextToken()) - 1;

		// 현재 지역에서 다음 지역으로 갈수 있는지 체크
		for (int i = 1; i < M; i++) {
			int now = Integer.parseInt(st.nextToken()) - 1;

			if (arr[prev][now] >= 987654321) {
				System.out.println("NO");
				return;
			}

			prev = now;
		}

		System.out.println("YES");

	}

}
