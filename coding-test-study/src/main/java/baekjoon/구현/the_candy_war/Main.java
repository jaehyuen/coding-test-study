package baekjoon.구현.the_candy_war;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            T  = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int             N   = Integer.parseInt(br.readLine());

			int[]           arr = new int[N];
			StringTokenizer st  = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());

				// 홀수면 증가
				if (arr[j] % 2 == 1)
					arr[j]++;
			}

			int cnt = 0;
			while (!check(arr)) {
				cnt++;

				// 사탕을 옮긴다
				for (int j = 0; j < N; j++) {

					// 홀수면 증가
					if (arr[j] % 2 == 1)
						arr[j]++;
				}

				// 사탕을 나눈다
				for (int j = 0; j < N; j++) {
					arr[j] /= 2;
				}

				// 사탕을 더해준다
				int tmp1, tmp2;
				tmp1 = arr[0];

				for (int j = 0; j < N; j++) {
					if (j == 0) {
						arr[0] += arr[N - 1];
					} else {
						tmp2    = arr[j];
						arr[j] += tmp1;
						tmp1    = tmp2;
					}
				}

			}

			System.out.println(cnt);

		}
	}

	public static boolean check(int[] arr) {

		// 같은 수인지 체크
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] != arr[i]) {
				return false;
			}
		}
		return true;
	}
}
