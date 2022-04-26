package baekjoon.수학.N과M_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	// 변수 배열
	static int[] arr1;

	// 조합된 수 배열
	static int[] arr2;

	// 방문 체크용 배열
	static boolean[] v;

	static int N;
	static int M;

	static StringBuilder sb = new StringBuilder();

	// 중복 체크용 리스트
	static ArrayList<int[]> list = new ArrayList<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr1 = new int[N];
		arr2 = new int[M];
		v = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr1);

		find(0, 0);
		System.out.println(sb.toString());

	}

	public static void find(int idx, int start) {
		if (idx == M) {
			// 조합이 완료되면 중복체크를 한다
			for (int[] arr : list) {
				if (Arrays.equals(arr, arr2)) {
					return;
				}
			}

			// 중복이 아니면 추후 체크를 위해 리스트에 추가한다
			list.add(arr2.clone());
			print();
			return;
		}

		for (int i = start; i < N; i++) {
			if (!v[i]) {
				v[i] = true;
				arr2[idx] = arr1[i];
				find(idx + 1, i + 1);
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
