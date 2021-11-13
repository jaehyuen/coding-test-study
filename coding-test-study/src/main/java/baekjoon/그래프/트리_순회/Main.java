package baekjoon.그래프.트리_순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static HashMap<String, String[]> map = new HashMap<String, String[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());
			String tmp1 = st.nextToken();
			String[] arr = new String[2];

			for (int j = 0; j < 2; j++) {
				String tmp2 = st.nextToken();
				if (!tmp2.equals(".")) {
					arr[j] = tmp2;
				}

			}
			map.put(tmp1, arr);
		}
		preOrder("A");
		System.out.println();
		inOrder("A");
		System.out.println();
		postOrder("A");
		System.out.println();

	}

	public static void preOrder(String str) {
		System.out.print(str);
		String[] arr = map.get(str);

		if (arr[0] != null) {
			preOrder(arr[0]);
		}
		if (arr[1] != null) {
			preOrder(arr[1]);
		}

	}

	public static void inOrder(String str) {

		String[] arr = map.get(str);

		if (arr[0] != null) {
			inOrder(arr[0]);
		}
		System.out.print(str);
		if (arr[1] != null) {
			inOrder(arr[1]);
		}

	}

	public static void postOrder(String str) {

		String[] arr = map.get(str);

		if (arr[0] != null) {
			postOrder(arr[0]);
		}

		if (arr[1] != null) {
			postOrder(arr[1]);
		}
		System.out.print(str);
	}
}
