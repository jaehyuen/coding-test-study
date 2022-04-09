package baekjoon.수학.에라토스테네스의_체;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int cnt = 0;

		boolean[] v = new boolean[N + 1];

		// 에라토라테네스의체 공식으로 소수 판별
		for (int i = 2; i <= N; i++) {
			for (int j = i; j <= N; j += i) {
				if (!v[j]) {
					cnt++;
					v[j] = true;
				}

				if (cnt == K) {
					System.out.println(j);
					return;
				}
			}
		}

	}
}
