package baekjoon.그리디.동전_0;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner s     = new Scanner(System.in);
		int     T     = s.nextInt();
		int     total = s.nextInt();
		int[]   arr   = new int[T];

		for (int i = 0; i < T; i++) {
			arr[i] = s.nextInt();
		}

		int cnt = 0;
		for (int i = T - 1; i >= 0; i--) {
			while (total >= arr[i]) {
				total -= arr[i];
				cnt++;
			}
		}

		System.out.println(cnt);

	}

}
