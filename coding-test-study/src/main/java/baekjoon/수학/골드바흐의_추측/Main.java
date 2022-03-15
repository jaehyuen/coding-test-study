package baekjoon.수학.골드바흐의_추측;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//에라토스테네스의 체 공식을 위한 배열
		boolean[] v = new boolean[10001];

		//에라토스테네스의 체 공식으로 소수 판별
		for (int i = 2; i <= 10000; i++) {
			if (!v[i]) {
				for (int j = i * i; j <= 10000; j += i) {
					v[j] = true;
				}
			}

		}

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			// N/2부터 N-1 까지 소수로 조합이 가능한 경우가 나오면 출력 후 종료
			for (int j = N / 2; j < N; j++) {
				if (!v[j] && !v[N - j]) {
					System.out.println((N - j) + " " + j);
					break;
				}

			}
		}

	}

}
