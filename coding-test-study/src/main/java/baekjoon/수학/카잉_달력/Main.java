package baekjoon.수학.카잉_달력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            T  = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st  = new StringTokenizer(br.readLine());
			int             M   = Integer.parseInt(st.nextToken());
			int             N   = Integer.parseInt(st.nextToken());
			int             x   = Integer.parseInt(st.nextToken());
			int             y   = Integer.parseInt(st.nextToken());

			int             tmp = 0;
			if (M > N) {
				tmp = gcd(M, N);
			} else {
				tmp = gcd(N, M);
			}
			tmp = M * N / tmp;

			int result = -2;

			for (int j = x - 1; j <= tmp; j += M) {
				if (j % N == y - 1) {
					result = j;
					break;
				}
			}
			System.out.println(result + 1);

		}
	}

	public static int gcd(int num1, int num2) {
		if (num2 == 0)
			return num1;
		else
			return gcd(num2, num1 % num2);
	}

}
