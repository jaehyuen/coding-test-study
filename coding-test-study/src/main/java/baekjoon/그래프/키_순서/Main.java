package baekjoon.그래프.키_순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][N + 1];

		// 플로이드 와샬을 위한 초기화
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					arr[i][j] = 0;
				} else {
					arr[i][j] = 987654321;
				}
			}
		}

		// 정보 등록
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());

			arr[tmp1][tmp2] = 1;

		}

		// 플로이드와샬 진행
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {

					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}

		// 양방향으로 길이 없으면 알수없음
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			boolean flag = true;
			for (int j = 1; j <= N; j++) {
				if (arr[i][j] >= 987654321 && arr[j][i] >= 987654321) {
					flag = false;
					break;
				}
			}

			if (flag)
				cnt++;
		}

		System.out.println(cnt);

	}
}
