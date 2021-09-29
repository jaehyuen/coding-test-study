package baekjoon.수학.소수_구하기;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner s   = new Scanner(System.in);
		int     N   = s.nextInt();
		int     M   = s.nextInt();

		int[]   arr = new int[M + 1];

		for (int i = 2; i <= M; i++) {
			arr[i] = i;
		}

		for (int i = 2; i <= M; i++) {
			if (arr[i] == 0)
				continue;

			for (int j = 2 * i; j <= M; j += i) {
				arr[j] = 0;
			}
		}

		for (int i = N; i < arr.length; i++) {
			if (arr[i] != 0) {
				System.out.println(arr[i]);
			}
		}

	}

}
