package baekjoon.수학.N과M_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int              N;
	static int              M;

	static int[]            N1;
	static int[]            M1;

	static ArrayList<int[]> list = new ArrayList<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N  = Integer.parseInt(st.nextToken());
		M  = Integer.parseInt(st.nextToken());

		N1 = new int[N];
		M1 = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			N1[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(N1);

		find(0);

		for (int[] arr : list) {
			for (int i : arr) {
				System.out.print(i + " ");

			}
			System.out.println();
		}

	}

	public static void find(int depth) {
		if (depth == M) {

			for (int[] arr : list) {
				if (Arrays.equals(arr, M1)) {
					return;
				}
			}

			list.add(M1.clone());
			return;
		}
		for (int i = 0; i < N; i++) {

			if (depth > 0 && M1[depth - 1] > N1[i]) {
				continue;
			}

			M1[depth] = N1[i];
			find(depth + 1);

		}

	}
}
