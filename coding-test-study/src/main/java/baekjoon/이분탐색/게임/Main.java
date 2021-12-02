package baekjoon.이분탐색.게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long            X  = Integer.parseInt(st.nextToken());
		long            Y  = Integer.parseInt(st.nextToken());
		int             Z  = (int) ((long) Y * 100 / X);

		if (Z == 100 || Z == 99) {
			System.out.println(-1);
			return;
		}

		long start  = X + 1;
		long end    = X * 2;
		int  result = 0;

		while (start <= end) {
			long mid     = (start + end) / 2;
			long gameCnt = mid - X;

			int  avg     = (int) ((long) (Y + gameCnt) * 100 / mid);

			if (avg == Z) {

				start = mid + 1;
			} else {
				result = (int) (mid - X);
				end    = mid - 1;
			}
		}

		System.out.println(result);

	}

}
