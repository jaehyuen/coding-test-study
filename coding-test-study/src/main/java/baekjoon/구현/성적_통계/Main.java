package baekjoon.구현.성적_통계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static String[] test;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            K  = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			StringTokenizer st  = new StringTokenizer(br.readLine());
			int             N   = Integer.parseInt(st.nextToken());
			int             max = 0;
			int             gap = 0;
			int             min = Integer.MAX_VALUE;

			int[]           arr = new int[N];

			// 데이터 입력과 동시에 최대 최소를 구한다
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());

				max    = Math.max(max, tmp);
				min    = Math.min(min, tmp);

				arr[j] = tmp;

			}

			// 정렬하여 갭 최대값을 구한다
			Arrays.sort(arr);

			for (int j = 1; j < N; j++) {

				gap = Math.max(gap, arr[j] - arr[j - 1]);

			}

			System.out.println("Class " + (i + 1));
			System.out.println("Max " + max + ", Min " + min + ", Largest gap " + gap);

		}

	}
}
