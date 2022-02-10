package baekjoon.그리디.주식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            T  = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int             N   = Integer.parseInt(br.readLine());

			long[]          arr = new long[N];
			StringTokenizer st  = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {

				arr[j] = Integer.parseInt(st.nextToken());
			}
			long tmp    = arr[N - 1];
			long result = 0;

			for (int j = N - 2; j >= 0; j--) {

				if (tmp > arr[j]) {
					result += tmp - arr[j];
				} else {
					tmp = arr[j];
				}
			}
			System.out.println(result);

		}

	}
}
