package baekjoon.브루트포스.근손실;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int[] arr1;
	static int[] arr2;
	static boolean[] v;
	static int N;
	static int K;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr1 = new int[N];
		arr2 = new int[N];
		v = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}

		find(0, 500);

		System.out.println(cnt);

	}

	public static void find(int idx, int tmp) {

		// 모든날짜가 지나면 카운트 증가
		if (idx == N) {
			cnt++;
			return;

		}

		for (int i = 0; i < N; i++) {

			if (!v[i]) {
				int next = tmp - K + arr1[i];

				// 중량이 500이 넘는지 체크
				if (next >= 500) {
					v[i] = true;
					find(idx + 1, next);
					v[i] = false;
				}

			}
		}
	}

}