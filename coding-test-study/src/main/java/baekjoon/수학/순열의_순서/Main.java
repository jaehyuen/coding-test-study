package baekjoon.수학.순열의_순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr1 = new int[N];
		long[] fact = new long[21];
		boolean[] v = new boolean[21];

		fact[0] = 1;
		for (int i = 1; i < 21; i++) {

			fact[i] = fact[i - 1] * i;

		}

		StringTokenizer st = new StringTokenizer(br.readLine());

		int qNum = Integer.parseInt(st.nextToken());

		if (qNum == 1) {
			long K = Long.parseLong(st.nextToken());

			// 첫째 자리부터 찾는다
			for (int i = 0; i < N; i++) {
				for (int j = 1; j <= N; j++) {

					// 사용했으면 넘어감
					if (v[j])
						continue;
					// 카운트를 감소해준다
					if (fact[N - i - 1] < K) {
						K -= fact[N - i - 1];
					} else {
						// 자리에 들어갈 숫자를 찾앗기에 포문 종료
						arr1[i] = j;
						v[j] = true;
						break;
					}
				}
			}

			for (int i : arr1) {
				System.out.print(i + " ");
			}

		} else {
			for (int i = 0; i < N; i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}
			long cnt = 1;

			// 첫째 자리부터 찾는다
			for (int i = 0; i < N; i++) {
				for (int j = 1; j < arr1[i]; j++) {
					// 사용안한 숫자가 있으며 피보나치 값을 카운트에 증가시킨다
					if (!v[j]) {
						cnt += fact[N - i - 1];
					}
				}

				// 사용 체크
				v[arr1[i]] = true;
			}
			System.out.println(cnt);

		}

	}

}
