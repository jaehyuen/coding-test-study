package baekjoon.구현.등수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader  br     = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st     = new StringTokenizer(br.readLine());

		int             N      = Integer.parseInt(st.nextToken());
		int             score1 = Integer.parseInt(st.nextToken());
		int             P      = Integer.parseInt(st.nextToken());

		// 0이면 무조건 1등
		if (N != 0) {
			st = new StringTokenizer(br.readLine());

			int idx = -1;
			int cnt = 0;

			for (int i = 0; i < N; i++) {
				int score2 = Integer.parseInt(st.nextToken());
				if (idx == -1 && score2 <= score1) {
					idx = i + 1;
				}

				// 점수가 같으면 카운트 증가
				if (score1 == score2) {
					cnt++;
				}
			}

			// 멘 마지막이면 처리
			if (idx == -1)
				idx = N + 1;

			System.out.println(idx + cnt > P ? -1 : idx);
		} else {
			System.out.println(1);
		}

	}
}
