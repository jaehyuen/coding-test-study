package baekjoon.이분탐색.서버실;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static long[][] room;
	static int      N;

	public static void main(String[] args) throws IOException {
		BufferedReader br          = new BufferedReader(new InputStreamReader(System.in));
		long           computerCnt = 0;
		long           max         = 0;

		N    = Integer.parseInt(br.readLine());
		room = new long[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				room[i][j]   = Integer.parseInt(st.nextToken());
				computerCnt += room[i][j];
				max          = Math.max(max, room[i][j]);
			}
		}

		long start  = 1;
		long end    = max;
		long result = 0;

		while (start <= end) {
			long   mid  = (start + end) / 2;
			long   sum  = countComputers(mid);

			double test = (sum / (double) computerCnt);
			if (test >= 0.5) {
				result = mid;
				end    = mid - 1;

			} else {
				start = mid + 1;
			}

		}

		System.out.println(result);

	}

	public static long countComputers(long min) {
		long sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += (min > room[i][j] ? room[i][j] : min);
			}
		}
		return sum;
	}
}
