package baekjoon.수학.N과M_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int       N;
	static int       M;

	static int[]     arr1;
	static int[]     arr2;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N    = Integer.parseInt(st.nextToken());
		M    = Integer.parseInt(st.nextToken());

		arr1 = new int[N];
		arr2 = new int[M];
		v    = new boolean[N];

		st   = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr1);
		test(0);

	}

	public static void test(int depth) {
		if (depth == M) {
			for (int a : arr2) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				v[i]        = true;
				arr2[depth] = arr1[i];
				test(depth + 1);

				v[i] = false;
			}
		}
	}

}
