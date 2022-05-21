package baekjoon.브루트포스.부등호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N;

	// 조합 가능한 수 배열
	static int[] arr1 = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	// 방문 체크 베열
	static boolean[] v = new boolean[10];

	// 부등호 배열
	static boolean[] arr2;

	// 조합된 문자열 배열
	static ArrayList<String> list = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr2 = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			String str = st.nextToken();

			if (str.equals(">")) {
				arr2[i] = true;
			} else {
				arr2[i] = false;
			}
		}

		for (int i = 0; i < 10; i++) {
			v[i] = true;
			find(1, "" + i, i);
			v[i] = false;
		}

		// 정렬해서 최대, 최소값을 출력
		Collections.sort(list);
		System.out.println(list.get(list.size() - 1));
		System.out.println(list.get(0));

	}

	public static void find(int idx, String str, int prev) {
		// System.out.println(str);
		if (idx == N + 1) {
			list.add(str);
			return;
		}

		for (int i = 0; i < 10; i++) {

			// 방문을 안햇다면?
			if (!v[i]) {

				// 부등호에 맞게 재귀
				if (arr2[idx - 1] && prev > i) {
					v[i] = true;
					find(idx + 1, str + i, i);
					v[i] = false;
				} else if (!arr2[idx - 1] && prev < i) {
					v[i] = true;
					find(idx + 1, str + i, i);
					v[i] = false;
				}

			}

		}
	}
}