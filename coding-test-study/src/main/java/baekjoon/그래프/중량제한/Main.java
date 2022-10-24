package baekjoon.그래프.중량제한;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int             N  = Integer.parseInt(st.nextToken());
		int             M  = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];

		// 유니온 파인드용 배열 초기화
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}

		// 다리 정보 입력
		ArrayList<int[]> list = new ArrayList<int[]>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			list.add(new int[] { A, B, C });
		}

		// 중량이 큰순으로 정렬
		Collections.sort(list, (o1, o2) -> {
			return o2[2] - o1[2];
		});
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end   = Integer.parseInt(st.nextToken());

		// 중량이 큰거부터 연결
		for (int[] bridge : list) {
			union(bridge[0], bridge[1]);

			// 시작과 끝이 연결됫으면 해당 다리가 최대값이다
			if (find(start) == find(end)) {
				System.out.println(bridge[2]);
				return;
			}
		}

	}

	public static int find(int node) {
		if (node == arr[node]) {
			return node;
		}
		return arr[node] = find(arr[node]);
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			if (a < b) {
				arr[b] = a;
			} else {
				arr[a] = b;
			}
		}

	}

}
