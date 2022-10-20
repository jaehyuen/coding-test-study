package baekjoon.그래프.사이클_게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int             n  = Integer.parseInt(st.nextToken());
		int             m  = Integer.parseInt(st.nextToken());

		arr = new int[n];

		// 유니온 파인드 기본 세팅
		for (int i = 0; i < n; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 양쪽 점의 부모 찾기
			a = find(a);
			b = find(b);

			// 부모가 다르면 이어줌
			if (a != b) {
				if (a > b) {
					arr[b] = a;
				} else {
					arr[a] = b;
				}

			} else {
				// 부모가 같으면 사이클이 완성됨
				System.out.println(i + 1);
				return;
			}

		}

		System.out.println(0);

	}

	public static void union(int a, int b) {

	}

	public static int find(int node) {
		if (node == arr[node]) {
			return node;
		}
		return arr[node] = find(arr[node]);
	}
}
