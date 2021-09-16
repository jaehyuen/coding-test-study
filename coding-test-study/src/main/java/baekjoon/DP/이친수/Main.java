package baekjoon.DP.이친수;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner s   = new Scanner(System.in);
		int     T   = s.nextInt();
		long[]  arr = new long[T + 2];
		arr[1] = 1;
		arr[2] = 1;
		for (int i = 3; i <= T; i++) {
			arr[i] = arr[i - 2] + arr[i - 1];
		}

		System.out.println(arr[T]);

	}

}
