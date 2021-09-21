package baekjoon.DP.파도반_수열;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int T = s.nextInt();

		for (int i = 0; i < T; i++) {
			int test = s.nextInt();
			long[] P = new long[test + 12];

			P[1] = 1;
			P[2] = 1;
			P[3] = 1;
			P[4] = 2;
			P[5] = 2;
			P[6] = 3;
			P[7] = 4;
			P[8] = 5;
			P[9] = 7;
			P[10] = 9;

			for (int j = 11; j <= test; j++) {
				P[j] = P[j] == 0 ? P[j - 1] + P[j - 5] : P[j];
			}
			System.out.println(P[test]);

		}

	}

}
