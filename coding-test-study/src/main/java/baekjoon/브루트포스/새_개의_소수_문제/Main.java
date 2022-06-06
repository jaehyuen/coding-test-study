package baekjoon.브루트포스.새_개의_소수_문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean[]      v  = new boolean[1001];

		v[1] = true;

		for (int i = 1; i * i <= 1000; i++) {
			if (!v[i]) {
				for (int j = i * i; j <= 1000; j += i) {
					v[j] = true;
				}
			}
		}
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int K = Integer.parseInt(br.readLine());
			
			//값을 찾으면 루프를 종료시킨다
			loop: for (int j = 2; j < K; j++) {
				for (int a = 2; a < K; a++) {
					for (int b = 2; b < K; b++) {
						if ((!v[j] && !v[a] && !v[b]) && (j + a + b == K)) {
							System.out.println(j + " " + a + " " + b);
							break loop;
						}

					}
				}
			}
		}

	}
}