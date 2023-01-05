package baekjoon.그래프.민서의_응급_수술;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 부모 배열 초기화
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}

		int cnt = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			a = find(a);
			b = find(b);

			// 이미 연결되있으면 카운트 증가 아니면 연결
			if (a != b) {
				union(a, b);
			} else {
				cnt++;
			}
		}

		HashSet<Integer> set = new HashSet<>();

		// 그룹 갯수를 카운팅하기 위해 셋에 넣어줌
		for (int i = 1; i <= N; i++) {
			set.add(find(i));
		}
		System.out.println(set.size() - 1 + cnt);

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
