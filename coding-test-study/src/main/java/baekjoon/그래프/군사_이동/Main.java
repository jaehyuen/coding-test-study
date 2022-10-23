package baekjoon.그래프.군사_이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int p;
	static int w;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 지점의 갯수
		p = Integer.parseInt(st.nextToken());

		// 길의 갯수
		w = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		arr = new int[p];

		// 유니온 파인드 배열 초기화
		for (int i = 0; i < p; i++) {
			arr[i] = i;
		}

		ArrayList<int[]> list = new ArrayList<>();

		// 길과 넓이를 저장
		for (int i = 0; i < w; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());

			list.add(new int[] { a, b, width });

		}

		// 넓이가 넓은순으로 정렬
		Collections.sort(list, (o1, o2) -> {
			return o2[2] - o1[2];
		});

		for (int[] arr : list) {
			// 길을 이어준다
			union(arr[0], arr[1]);

			// 양 국가간 길이 이어지면 종료
			if (find(c) == find(v)) {
				System.out.println(arr[2]);
				return;
			}

		}

	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			if (a > b) {
				arr[b] = a;
			} else {
				arr[a] = b;
			}
		}
	}

	public static int find(int node) {
		if (node == arr[node]) {
			return node;
		}
		return arr[node] = find(arr[node]);
	}
}
