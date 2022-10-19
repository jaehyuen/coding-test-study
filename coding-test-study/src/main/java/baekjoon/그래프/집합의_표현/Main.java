package baekjoon.그래프.집합의_표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int             n  = Integer.parseInt(st.nextToken());
		int             m  = Integer.parseInt(st.nextToken());

		arr = new int[n + 1];

		// 최상위 노드 초기화
		for (int i = 1; i < n + 1; i++) {
			arr[i] = i;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int idx = Integer.parseInt(st.nextToken());
			int a   = Integer.parseInt(st.nextToken());
			int b   = Integer.parseInt(st.nextToken());

			// 합친다
			if (idx == 0) {
				// a, b의 부모를 구한다
				a = find(a);
				b = find(b);

				// 둘이 다르면 부모끼리 연결
				if (a != b) {

					// 큰 부모에 작은걸 연결
					if (a < b)
						arr[b] = a;
					else
						arr[a] = b;
				}

			} else {
				if (find(a) == find(b)) {
					sb.append("YES\n");
				} else {

					sb.append("NO\n");
				}
			}
		}
		System.out.println(sb.toString());
	}

	/**
	 * 루트 노드를 찾는 함수
	 * 
	 * @param node 현재 노드
	 * 
	 * @return 루트 노드
	 */
	public static int find(int node) {
		if (node == arr[node]) {
			return node;
		}
		return arr[node] = find(arr[node]);
	}
}
