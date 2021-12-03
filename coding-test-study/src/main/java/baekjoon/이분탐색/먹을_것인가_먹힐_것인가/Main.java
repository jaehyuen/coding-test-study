package baekjoon.이분탐색.먹을_것인가_먹힐_것인가;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int            T  = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int             N  = Integer.parseInt(st.nextToken());
			int             M  = Integer.parseInt(st.nextToken());

			int[]           A  = new int[N];
			int[]           B  = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[j] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				B[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(A);
			Arrays.sort(B);
			int result = 0;

			for (int a = 0; a < N; a++) {
				int start = 0;
				int end   = M - 1;
				while (start <= end) {
					int mid = (start + end) / 2;

					if (A[a] <= B[mid]) {
						end = mid - 1;
					} else {
						start = mid + 1;
					}
				}
				result += start;
			}
			System.out.println(result);

		}

	}

}
