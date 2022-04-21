package baekjoon.수학.N과M_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	// 조합을 하기위한 배열
	static int[] arr1;
	static int[] arr2;
	static boolean[] v;

	// 숫자 갯수
	static int N;
	static int M;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr1 = new int[N];
		arr2 = new int[M];

		st = new StringTokenizer(br.readLine());

		// 숫자 입력
		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}

		// 사전순 출력을 위해 정렬
		Arrays.sort(arr1);

		find(0);
		
		System.out.println(sb.toString());
	}

	public static void find(int idx) {

		// 조합을 다하면 출력
		if (idx == M) {
			for (int i : arr2) {
				sb.append(i + " ");

			}
			sb.append("\n");
			return;
		}

		// 조합
		for (int i = 0; i < N; i++) {

			arr2[idx] = arr1[i];
			find(idx + 1);
		}
	}
}