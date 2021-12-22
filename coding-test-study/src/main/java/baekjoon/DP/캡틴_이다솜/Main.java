package baekjoon.DP.캡틴_이다솜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int            N   = Integer.parseInt(br.readLine());

		int[]          dp1 = new int[122];
		int[]          dp2 = new int[122];
		int[]          dp3 = new int[N + 1];

		dp1[1] = 1;
		dp2[1] = 1;
		dp3[1] = 1;
		for (int i = 2; i < 122; i++) {
			dp1[i] = dp1[i - 1] + i;
			dp2[i] = dp2[i - 1] + dp1[i];

		}

		for (int i = 2; i <= N; i++) {
			dp3[i] = i;
			for (int j = 1; j < 122; j++) {
				if (dp2[j] > i)
					break;

				dp3[i] = Math.min(dp3[i], dp3[i - dp2[j]] + 1);
			}
		}

//		System.out.println(Arrays.toString(dp1));
//		System.out.println(Arrays.toString(dp2));
		System.out.println(dp3[N]);

	}
}