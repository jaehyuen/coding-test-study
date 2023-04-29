package baekjoon.문자열.애너그램;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	// 문자열 배열
	public static char[] str;

	// 완성 배열
	public static char[] arr;

	// 중복 문자열 체크 배열
	public static char[] check;

	// 방문 체크 배열
	public static boolean[] v;

	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			str = br.readLine().toCharArray();

			// 배열 초기화
			arr = new char[str.length];
			check = new char[str.length];
			v = new boolean[str.length];

			// 정렬
			Arrays.sort(str);
			find(0);

		}
		System.out.println(sb.toString());

	}

	public static void find(int idx) {
		if (idx == str.length) {
			// 문자열 출력
			sb.append(new String(arr) + "\n");
			return;
		}

		// 문자열 중복 체크 값 넣기
		check[idx] = 0;
		for (int i = 0; i < str.length; i++) {

			// 방문 체크
			if (v[i]) {
				continue;
			}

			// 중복된 문자열 체크
			if (check[idx] >= str[i]) {
				continue;
			}

			v[i] = true;
			arr[idx] = str[i];
			check[idx] = str[i];

			find(idx + 1);

			v[i] = false;

		}
	}

}
