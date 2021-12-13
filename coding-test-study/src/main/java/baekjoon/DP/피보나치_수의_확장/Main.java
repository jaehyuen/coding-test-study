package baekjoon.DP.피보나치_수의_확장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static long[] arr;
	static int    test = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            n  = Integer.parseInt(br.readLine());
		if (n == 0) {
			System.out.println(0);
			System.out.println(0);
			return;
		}

		boolean flag = true;

		if (n < 0) {
			n    *= -1;
			flag  = !flag;
		}

		arr    = new long[n + 3];

		arr[0] = 0;
		arr[1] = 1;

		if (flag) {
			System.out.println(1);
		} else {
			if (n % 2 == 0) {
				System.out.println(-1);
			} else {
				System.out.println(1);
			}
		}
		System.out.println(fibo(n));
		// System.out.println(Arrays.toString(arr));

	}

	public static long fibo(int n) {

		if (n == 0) {
			return 0;
		} else if (arr[n] == 0) {
			arr[n] = (fibo(n - 1) + fibo(n - 2)) % test;
		}

		return arr[n];
	}

}
