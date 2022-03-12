package baekjoon.브루트포스.연산자_끼워넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 숫자 배열
	static int[] arr;

	// 연산자 배열
	static String[] opr;

	// 연산자 방문 배열
	static boolean[] v;

	// max, min, N 값
	static int max = Integer.MAX_VALUE * -1;
	static int min = Integer.MAX_VALUE;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N 입력
		N = Integer.parseInt(br.readLine());

		// 배열 크기선언
		arr = new int[N];
		opr = new String[N - 1];
		v = new boolean[N - 1];

		// 숫자 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 연산자 입력
		st = new StringTokenizer(br.readLine());
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			int tmp = Integer.parseInt(st.nextToken());

			for (int j = 0; j < tmp; j++) {
				switch (i) {
				case 0:
					opr[idx] = "+";
					break;
				case 1:
					opr[idx] = "-";
					break;
				case 2:
					opr[idx] = "*";
					break;
				case 3:
					opr[idx] = "/";
					break;

				}
				idx++;

			}
		}

		// 브루트 포스로 모든 경우의수 탐색
		find(0, arr[0], 1);
		System.out.println(max);
		System.out.println(min);
	}

	public static void find(int start, int result, int idx) {

		// 초기값
		int next = result;

		// 연산울 끝내면 최대, 최소 값 갱신
		if (idx == N) {
			min = Math.min(result, min);
			max = Math.max(result, max);
		}

		for (int i = 0; i < N - 1; i++) {

			// 사용안한 연산자로 연산
			if (!v[i]) {
				switch (opr[i]) {
				case "+":
					next += arr[idx];
					break;
				case "-":
					next -= arr[idx];
					break;
				case "*":
					next *= arr[idx];
					break;
				case "/":
					next /= arr[idx];
					break;

				}

				v[i] = true;
				find(0, next, idx + 1);
				v[i] = false;

				next = result;
			}

		}

	}

}