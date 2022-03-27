package baekjoon.수학.최소공배수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			//유클리드 호재법으로 최대공약수를 구하고 (a * b) / 최대공약수 공식으로 최소공배수를 구해준다
			System.out.println((A * B) / find(B, A));

		}
	}

	/**
	 * 유클리드 호재법 함수
	 * @param a
	 * @param b
	 * @return 최대공약수
	 */
	public static int find(int a, int b) {
		int tmp = 0;

		while (b > 0) {
			tmp = a % b;
			a = b;
			b = tmp;
		}

		return a;
	}
}
