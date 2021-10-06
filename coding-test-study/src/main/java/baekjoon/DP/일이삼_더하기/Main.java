package baekjoon.DP.일이삼_더하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int            T   = Integer.parseInt(br.readLine());
		int[]          arr = new int[15];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			for (int j = 4; j <= n; j++) {
				if (arr[j] == 0) {
					arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];
				}
			}
			System.out.println(arr[n]);

		}

	}
}