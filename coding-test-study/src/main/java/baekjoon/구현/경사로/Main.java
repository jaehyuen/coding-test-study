package baekjoon.구현.경사로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int     N;
	static int     L;

	static int[][] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N   = Integer.parseInt(st.nextToken());
		L   = Integer.parseInt(st.nextToken());

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}

		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {

			if (find1(i))
				cnt++;

			if (find2(i))
				cnt++;

		}
		System.out.println(cnt);

	}

	public static boolean find1(int i) {
		boolean[] v = new boolean[N];

		for (int j = 0; j < N - 1; j++) {

			// 경사로가 필요하다
			if (arr[i][j] != arr[i][j + 1]) {

				// 2칸 이상 차이나면 실패
				if (Math.abs(arr[i][j] - arr[i][j + 1]) > 1) {
					return false;
				} else if (arr[i][j] > arr[i][j + 1] && j + L < N) {

					int tmp = arr[i][j + 1];

					// 내려가는 경사로 생성
					for (int k = j + 1; k <= j + L; k++) {

						// 경사로 생성 실패
						if (arr[i][k] != tmp) {
							return false;
						}

						// 경사로 생성 실패(중복)
						if (v[k]) {
							return false;
						}

						// 경사로 생성
						v[k] = true;

					}
					// 경사로 가능하면
					j += L - 1;
				} else if (arr[i][j] < arr[i][j + 1] && j - L + 1 >= 0) {

					for (int k = j - L + 1; k <= j; k++) {

						int tmp = arr[i][j - L + 1];

						if (arr[i][k] != tmp) {
							return false;
						}

						// 경사로 생성 실패(중복)
						if (v[k]) {
							return false;
						}
						// 경사로 생성
						v[k] = true;

					}
				} else {
					return false;
				}
			}

		}
		// System.out.println(Arrays.toString(v));
		// System.out.println(Arrays.toString(arr[i]));
		return true;
	}

	public static boolean find2(int i) {
		boolean[] v = new boolean[N];

		for (int j = 0; j < N - 1; j++) {

			// 경사로가 필요하다
			if (arr[j][i] != arr[j + 1][i]) {

				// 2칸 이상 차이나면 실패
				if (Math.abs(arr[j][i] - arr[j + 1][i]) > 1) {
					return false;
				} else if (arr[j][i] > arr[j + 1][i] && j + L < N) {

					int tmp = arr[j + 1][i];

					// 내려가는 경사로 생성
					for (int k = j + 1; k <= j + L; k++) {

						// 경사로 생성 실패
						if (arr[k][i] != tmp) {
							return false;
						}

						// 경사로 생성 실패(중복)
						if (v[k]) {
							return false;
						}

						// 경사로 생성
						v[k] = true;

					}
					// 경사로 가능하면
					j += L - 1;
				} else if (arr[j][i] < arr[j + 1][i] && j - L + 1 >= 0) {

					for (int k = j - L + 1; k <= j; k++) {

						int tmp = arr[j - L + 1][i];

						if (arr[k][i] != tmp) {
							return false;
						}

						// 경사로 생성 실패(중복)
						if (v[k]) {
							return false;
						}
						// 경사로 생성
						v[k] = true;

					}
				} else {
					return false;
				}
			}

		}
		return true;
	}

}
