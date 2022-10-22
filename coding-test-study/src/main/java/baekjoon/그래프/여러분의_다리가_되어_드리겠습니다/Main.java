package baekjoon.그래프.여러분의_다리가_되어_드리겠습니다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];

		// 유니온 파인드 초기화
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}

		// 다리 입
		for (int i = 0; i < N - 2; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}

		// 1번의 부모를 구한다
		int a = find(1);

		for (int i = 2; i <= N; i++) {

			// 1번을 제외한 노드의 부모를 구해 다르면 1번이랑 이어준다
			int b = find(i);

			if (a != b) {
				System.out.println("1 " + i);
				return;
			}
		}

	}

	public static int find(int node) {
		if (arr[node] == node) {
			return node;
		}
		return arr[node] = find(arr[node]);
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			if (a > b) {
				arr[b] = a;
			} else {
				arr[b] = a;
			}
		}
	}
}
