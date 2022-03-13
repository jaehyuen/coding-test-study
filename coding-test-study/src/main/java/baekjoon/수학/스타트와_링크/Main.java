package baekjoon.수학.스타트와_링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	// 능력치 배열
	static int[][] arr;

	// 팀을 조합 하기위한 배열
	static boolean[] v;

	// 인원수
	static int N;

	// 최소값
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1][N + 1];
		v = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		find(1, 0);
		System.out.println(min);

	}

	public static void find(int start, int idx) {

		// 팀원 조합이 끝낫을때 true = 스타트팀, false = 링크팀
		if (idx == N / 2) {

			// 능력치 합산 변수
			int sum1 = 0;
			int sum2 = 0;

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {

					if (v[i] && v[j]) {
						// 스타트 팀일때 합산
						sum1 += arr[i][j];
					} else if (!v[i] && !v[j]) {
						// 링크 팀일때 합산
						sum2 += arr[i][j];
					}
				}
			}

			// 최소값 갱신
			min = Math.min(min, Math.abs(sum1 - sum2));
			return;
		}

		// 팀원 조합
		for (int i = start; i <= N; i++) {

			if (!v[i]) {
				v[i] = true;
				find(i + 1, idx + 1);
				v[i] = false;
			}

		}

	}

}
