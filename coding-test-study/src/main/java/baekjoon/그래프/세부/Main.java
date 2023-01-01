package baekjoon.그래프.세부;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];

		st = new StringTokenizer(br.readLine());

		// 출발, 도착 위치
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		ArrayList<int[]> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			// 유니온 파인드 부모 배열 초기화
			arr[i + 1] = i + 1;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int h1 = Integer.parseInt(st.nextToken());
			int h2 = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			// 다리 정보 저장
			list.add(new int[] { h1, h2, k });
		}

		// 무게 제한 내림차순 정렬
		Collections.sort(list, (o1, o2) -> {
			return o2[2] - o1[2];
		});

		for (int[] now : list) {
			int a = find(now[0]);
			int b = find(now[1]);

			// 둘이 합쳐준다
			if (a != b) {
				union(a, b);
			}

			// 두 지점이 이어지면 현재 무게 제한 출력후 종료
			if (find(e) == find(s)) {
				System.out.println(now[2]);
				return;
			}
		}
		System.out.println(0);

	}

	public static int find(int node) {
		if (node == arr[node]) {
			return node;
		}

		return arr[node] = find(arr[node]);
	}

	public static void union(int a, int b) {
		if (a < b) {
			arr[b] = a;
		} else {
			arr[a] = b;
		}
	}
}
