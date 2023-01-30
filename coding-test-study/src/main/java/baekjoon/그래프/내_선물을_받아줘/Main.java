package baekjoon.그래프.내_선물을_받아줘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static char[][]                  map;
	static boolean[][]               v;
	static int[]                     parent;

	static int                       N;
	static int                       M;

	static HashMap<Character, int[]> m = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m.put('N', new int[] { -1, 0 });
		m.put('S', new int[] { 1, 0 });
		m.put('W', new int[] { 0, -1 });
		m.put('E', new int[] { 0, 1 });

		N      = Integer.parseInt(st.nextToken());
		M      = Integer.parseInt(st.nextToken());

		map    = new char[N][M];
		parent = new int[N * M];

		// 부모 초기화
		for (int i = 0; i < N * M; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine()
				.toCharArray();
		}

		// 모든 노드를 순회하며 연결
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				int[] tmp = m.get(map[i][j]);

				// 현재 위치와 다음 위치를 연결
				int   a   = (i * M) + j;
				int   b   = ((i + tmp[0]) * M) + (j + tmp[1]);

				a = find(a);
				b = find(b);

				if (a != b) {
					if (a > b) {
						parent[b] = a;
					} else {
						parent[a] = b;
					}
				}

			}
		}

		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < N * M; i++) {
			set.add(find(i));
		}

		System.out.println(set.size());

	}

	public static int find(int node) {
		if (node == parent[node]) {

			return node;
		}
		return parent[node] = find(parent[node]);
	}

}
