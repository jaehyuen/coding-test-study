package baekjoon.그리디.마인크래프트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
//		Scanner s     = new Scanner(System.in);
//
//		int     N     = s.nextInt();
//		int     M     = s.nextInt();
//		int     B     = s.nextInt();
		BufferedReader  br    = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st    = new StringTokenizer(br.readLine());
		int             N     = Integer.parseInt(st.nextToken());
		int             M     = Integer.parseInt(st.nextToken());
		int             B     = Integer.parseInt(st.nextToken());

		int[][]         house = new int[N][M];
		int             max   = -1, min = 258;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
//				house[i][j] = s.nextInt();
				house[i][j] = Integer.parseInt(st.nextToken());
				if (house[i][j] > max)
					max = house[i][j];
				if (house[i][j] < min)
					min = house[i][j];

			}
		}

		int minTime = Integer.MAX_VALUE;
		int height  = 0;

		for (int k = min; k <= max; k++) {
			int time  = 0;
			int block = B;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (house[i][j] > k) {
						time   = time + (house[i][j] - k) * 2;
						block += Math.abs(house[i][j] - k);
					} else if (house[i][j] < k) {
						time   = time + k - house[i][j];
						block -= Math.abs(k - house[i][j]);

					}
				}
			}
			if (block < 0)
				continue;
			if (minTime >= time) {
				minTime = time;
				height  = k;
			}
		}
		System.out.println(minTime + " " + height);

	}

}
