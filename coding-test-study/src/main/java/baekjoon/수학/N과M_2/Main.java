package baekjoon.수학.N과M_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[]         arr1;
	static int[]         arr2;
	static boolean[]     v;

	static int           N;
	static int           M;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N    = Integer.parseInt(st.nextToken());
		M    = Integer.parseInt(st.nextToken());

		arr1 = new int[N];
		arr2 = new int[M];
		v    = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr1[i] = i + 1;
		}
		test(0, 0);
		System.out.println(sb.toString());

	}

	public static void test(int len, int start) {
		if (len == M) {
			print();
			return;
		}

		for (int i = start; i < N; i++) {
			if (!v[i]) {
				v[i]      = true;
				arr2[len] = arr1[i];
				test(len + 1, i + 1);
				v[i] = false;
			}
		}

	}

	public static void print() {
		for (int arr : arr2) {
			sb.append(arr + " ");
		}
		sb.append("\n");
	}

}
