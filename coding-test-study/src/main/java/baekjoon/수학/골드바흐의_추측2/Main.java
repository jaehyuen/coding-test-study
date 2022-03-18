package baekjoon.수학.골드바흐의_추측2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1000000중 소수 판별을 위한 배열
		boolean[] v = new boolean[1000001];
		v[1] = true;

		// 에라토스테네의 체 공식
		for (int i = 2; i * i <= 1000000; i++) {
			for (int j = i * i; j <= 1000000; j += i) {
				if (!v[j]) {
					v[j] = true;
				}
			}
		}

		// 0이 나올때까지 반복
		while (true) {
			int N = Integer.parseInt(br.readLine());

			if (N == 0) {
				break;
			}

			// 값이 있는지 체크값
			boolean flag = true;

			// 큰숩부터 값이있는지 체크한다
			for (int i = N - 1; i > 0; i--) {
				if (!v[i] && !v[N - i]) {
					System.out.println(N + " = " + (N - i) + " + " + i);
					flag = false;
					break;
				}
			}

			// 값이 없으면 아래 문자 출력
			if (flag) {
				System.out.println("Goldbach's conjecture is wrong.");
			}

		}

	}
}
