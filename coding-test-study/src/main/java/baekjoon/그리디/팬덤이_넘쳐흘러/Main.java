package baekjoon.그리디.팬덤이_넘쳐흘러;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int            N   = Integer.parseInt(br.readLine());

		// 팬이 학교에 온시간 중 가장 늦은시간
		int            max = Integer.MIN_VALUE;

		// 팬이 학교를 떠난시간 중 가장 빠른시간
		int            min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int             s  = Integer.parseInt(st.nextToken());
			int             e  = Integer.parseInt(st.nextToken());

			// 최대 최소 갱신
			max = Math.max(max, s);
			min = Math.min(min, e);
		}

		
		if (max <= min) {
			System.out.println(0);

		} else {
			System.out.println(max - min);
		}

	}

}
