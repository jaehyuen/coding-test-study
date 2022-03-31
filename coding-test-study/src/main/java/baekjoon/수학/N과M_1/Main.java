package baekjoon.수학.N과M_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;

	static int[] arr1;
	static int[] arr2;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 수열에 사용되는 숫자 배열
		arr1 = new int[N];

		// 완성된 수열을 저장하는 배열
		arr2 = new int[M];

		// 숫자 사용여부 체크 배열
		v = new boolean[N];

		// 필요한 숫자 저장
		for (int i = 0; i < N; i++) {
			arr1[i] = i + 1;

		}

		find(0);

	}

	public static void find(int idx) {

		// 갯수가 채워지면 출력
		if (M == idx) {
			for (int i : arr2) {
				System.out.print(i + " ");
			}
			System.out.println();

			return;
		}

		// 사용안한 숫자를 배열에 저장하고 다음 자리를 채운다
		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				v[i] = true;
				arr2[idx] = arr1[i];
				find(idx + 1);
				v[i] = false;
			}

		}
	}
}
