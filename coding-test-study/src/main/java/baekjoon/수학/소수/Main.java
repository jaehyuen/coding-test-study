package baekjoon.수학.소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		boolean[] v = new boolean[M + 1];

		v[1] = true;

		// 에라토스테네스의체 공식으로 소수 판별
		for (int i = 2; i * i <= M; i++) {
			if (v[i] == false) {
				for (int j = i * i; j <= M; j += i) {
					v[j] = true;
				}
			}

		}

		int sum = 0;
		int min = -1;

		// 소수 카운팅 및 최소값 세팅
		for (int i = N; i <= M; i++) {
			if (!v[i]) {
				sum += i;
				if (min == -1) {
					min = i;
				}
			}

		}

		// 최소값이 -1 이면 소수 없음
		if (min == -1) {
			System.out.println(min);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}

	}

}
