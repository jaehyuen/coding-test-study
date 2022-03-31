package baekjoon.브루트포스.N_Queen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] arr;
	static int   N;
	static int   result = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N   = Integer.parseInt(br.readLine());
		arr = new int[N];

		// 브루트 포스로 탐색
		find(0);

		System.out.println(result);

	}

	public static void find(int idx) {

		// N개의 퀸을 놓으면 결과값 증가
		if (N == idx) {
			result++;
			return;
		}

		for (int i = 0; i < N; i++) {
			// idx = 열, arr[idx] = 행
			arr[idx] = i;
			if (check(idx)) {
				find(idx + 1);
			}

		}
	}

	public static boolean check(int idx) {
		
		for (int i = 0; i < idx; i++) {
			// 같은 행에 놓이면 false
			if (arr[i] == arr[idx]) {
				return false;
			} else if (Math.abs(idx - i) == Math.abs(arr[idx] - arr[i])) {
				// 대각선에 놓이면 false (두위치의 차이가 같으면 대각선에 위치)
				return false;
			}

		}
		// 조건을 통과하면 true
		return true;
	}

}
