package baekjoon.수학.소인수분해;

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

		// 에라토스태네스의 체 공식을 사용하기 위한 배열
		boolean[] v = new boolean[N + 1];

		v[0] = true;
		v[1] = true;

		// 에라토스태네스의 체 공식으로 소수 판별
		for (int i = 2; i * i <= N; i++) {
			for (int j = i * i; j <= N; j += i) {

				if (!v[j]) {
					v[j] = true;
				}
			}

		}

		// N=1 이면 출력하지 않고 종료
		if (N == 1) {
			return;
		}

		// 작은 숫자부터 소인수 분해 시작
		while (v[N]) {
			for (int i = 0; i <= N; i++) {
				// 소수면서 나눠지면 나눈다
				if (!v[i] && N % i == 0) {
					N /= i;
					System.out.println(i);
					break;
				}

			}
		}
		// 마지막 값도 출력
		System.out.println(N);

	}
}
