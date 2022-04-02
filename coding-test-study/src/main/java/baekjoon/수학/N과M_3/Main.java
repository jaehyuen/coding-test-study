package baekjoon.수학.N과M_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;

	static int[] arr1;
	static int[] arr2;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 숫자 저장, 수열 저장용 배열 선언
		arr1 = new int[N];
		arr2 = new int[M];

		//숫자배열 초기화
		for (int i = 0; i < N; i++) {
			arr1[i] = i + 1;
		}

		find(0);
		System.out.println(sb.toString());

	}

	public static void find(int idx) {

		//수열이 완성되면 stringbuilder에 추가
		if (idx == M) {
			for (int i : arr2) {

				sb.append(i + " ");

			}
			sb.append("\n");

			return;
		}

		for (int i = 0; i < N; i++) {

			arr2[idx] = arr1[i];
			find(idx + 1);

		}
	}

}
