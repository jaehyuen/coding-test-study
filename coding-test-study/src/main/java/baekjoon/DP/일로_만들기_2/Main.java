package baekjoon.DP.일로_만들기_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];

//		Queue<Integer> q = new LinkedList<>();
//		q.add(N);
		// arr[N] = 1;
//		while (!q.isEmpty()) {
//			if (arr[1] != 0) {
//				break;
//			}
//			int now = q.poll();
//
//			if (now % 3 == 0 && now / 3 > 0) {
//				if (arr[now / 3] == 0) {
//					q.add(now / 3);
//					arr[now / 3] = arr[now] + 1;
//				}
//			}
//
//			if (now % 2 == 0 && now / 2 > 0) {
//				if (arr[now / 2] == 0) {
//					q.add(now / 2);
//					arr[now / 2] = arr[now] + 1;
//				}
//			}
//
//			if (now - 1 > 0) {
//				if (arr[now - 1] == 0) {
//					q.add(now - 1);
//					arr[now - 1] = arr[now] + 1;
//				}
//			}
//		}
		
		//초기값 세팅
		arr[0] = arr[1] = 0;

		//디피로 탐색
		for (int i = 2; i <= N; i++) {
			arr[i] = arr[i - 1] + 1;
			if (i % 3 == 0) {
				arr[i] = Math.min(arr[i], arr[i / 3] + 1);
			}
			if (i % 2 == 0) {
				arr[i] = Math.min(arr[i], arr[i / 2] + 1);
			}

		}

		//System.out.println(Arrays.toString(arr));
		System.out.println(arr[N]);
		
		//역추적
		print(N);

	}

	public static void print(int n) {

		if (n == 0)
			return;

		System.out.print(n + " ");

		if (n % 3 == 0 && arr[n / 3] == arr[n] - 1) {
			print(n / 3);
		} else if (n % 2 == 0 && arr[n / 2] == arr[n] - 1) {
			print(n / 2);
		} else if (n - 1 >= 0 && arr[n - 1] == arr[n] - 1) {
			print(n - 1);
		}

	}
}