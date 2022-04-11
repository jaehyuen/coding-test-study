package baekjoon.수학.모든_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	static int[] arr1;
	static int[] arr2;
	static boolean[] v;

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr1 = new int[N];
		arr2 = new int[N];
		v = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr1[i] = i + 1;
		}
		find(0);
	}

	public static void find(int idx) {
		
		//순열을 완성 시키면 출력
		if (idx == N) {
			for (int i : arr2) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		//방문 체크를 하며 순열을 만든다
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
