package baekjoon.브루트포스.리모컨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		arr = new int[10];

		if (M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				arr[Integer.parseInt(st.nextToken())] = 1;
			}
		}

		int min = Math.abs(N - 100);
		for (int i = 0; i <= 1000000; i++) {
			int cnt = check(i);
			if (cnt > 0) {
				min = Math.min(min, cnt + Math.abs(N - i));
			}
		}
		System.out.println(min);

	}

	static int check(int n) {
		if (n == 0) {
			if (arr[0] == 1) {
				return 0;
			} else {
				return 1;
			}
		}
		int len = 0;
		while (n > 0) {
			if (arr[n % 10] == 1) {
				return 0;
			}
			n /= 10;
			len += 1;
		}
		return len;
	}

}
