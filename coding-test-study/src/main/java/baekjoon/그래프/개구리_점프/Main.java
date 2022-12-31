package baekjoon.그래프.개구리_점프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.naming.CompoundName;

public class Main {

	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		ArrayList<int[]> list = new ArrayList<>();

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());

			int[] tmp = { x1, x2, y1, i };

			list.add(tmp);

			arr[i] = i;

		}

		// 정렬
		Collections.sort(list, (o1, o2) -> {
			return o1[0] - o2[0];
		});

		int idx = 0;
		for (int i = 1; i < N; i++) {
			int[] aArr = list.get(idx);
			int[] bArr = list.get(i);

			// 연결한다
			if (aArr[1] >= bArr[0]) {
				union(find(aArr[3]), find(bArr[3]));
			}

			// 인덱스 갱신
			if (aArr[1] <= bArr[1]) {
				idx = i;
			}
		}

		StringBuilder sb = new StringBuilder();

		// 연결 여부 체크
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			a = find(a - 1);
			b = find(b - 1);

			if (a == b) {
				sb.append(1 + "\n");
			} else {
				sb.append(0 + "\n");
			}
		}

		System.out.println(sb.toString());

	}

	public static int find(int node) {
		if (node == arr[node]) {
			return node;
		}

		return arr[node] = find(arr[node]);
	}

	public static boolean check(int[] a, int[] b) {

		// 점프가 가능한 거리인지 체크
		if (a[1] < b[0] || b[1] < a[0]) {
			return false;
		}
		return true;
	}

	public static void union(int a, int b) {
		if (a > b) {
			arr[a] = b;
		} else {
			arr[b] = a;
		}
	}
}
