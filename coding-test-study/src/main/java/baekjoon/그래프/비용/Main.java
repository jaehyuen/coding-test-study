package baekjoon.그래프.비용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static int[] arr1;
	public static int[] arr2;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long total = 0;

		ArrayList<int[]> list = new ArrayList<int[]>();

		// 연결 정보 저장
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			total += w;

			list.add(new int[] { Math.min(x, y), Math.max(x, y), w });

		}

		arr1 = new int[N + 1];
		arr2 = new int[N + 1];

		// 유니온 파인드 및 배열 초기화
		for (int i = 0; i < N + 1; i++) {
			arr1[i] = i;
			arr2[i] = 1;

		}

		// 비용을 내림차순으로 정렬
		Collections.sort(list, (o1, o2) -> {
			return o2[2] - o1[2];
		});

		long cnt = 0;

		for (int[] now : list) {
			int a = find(now[0]);
			int b = find(now[1]);

			// 연결 시킨다
			if (a != b) {

				// a 연결갯수 * b 연결갯수 * total 이 비용이다
				cnt += ((((long) arr2[a] * arr2[b]) % 1000000000) * total) % 1000000000;
				cnt %= 1000000000;

				arr1[b] = a;
				arr2[a] += arr2[b];
				arr2[b] = 0;

			}

			total -= now[2];
		}

		System.out.println(cnt);

	}

	public static int find(int node) {
		if (node == arr1[node]) {
			return node;
		}

		return arr1[node] = find(arr1[node]);
	}
}