package baekjoon.그래프.친구비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int[] money;

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int             N  = Integer.parseInt(st.nextToken());
		int             M  = Integer.parseInt(st.nextToken());
		int             k  = Integer.parseInt(st.nextToken());

		arr   = new int[N + 1];
		money = new int[N + 1];
		int[] result = new int[N + 1];

		st = new StringTokenizer(br.readLine());

		// 유니온 파인드를 위한 배열 초기화 및 친구비 저장
		for (int i = 1; i < N + 1; i++) {
			arr[i]   = i;
			money[i] = Integer.parseInt(st.nextToken());
		}

		// 유니온 파인드 실행
		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			a = find(a);
			b = find(b);

			if (a > b) {
				arr[b] = a;
			} else {
				arr[a] = b;
			}
		}

		// 현재 사람의 부모를 찾고 해당 부모의 대한 친구비 최소값을 구한다
		for (int i = 1; i < N + 1; i++) {
			int root = find(i);

			if (result[root] == 0) {
				result[root] = money[i];
			} else {
				result[root] = result[root] > money[i] ? money[i] : result[root];
			}
		}

		// 친구비 최소갑을 전부 더함
		int total = 0;
		for (int i = 1; i < N + 1; i++) {
			total += result[i];
		}

		if (total > k) {
			System.out.println("Oh no");
		} else {
			System.out.println(total);
		}

	}

	public static int find(int node) {
		if (arr[node] == node) {
			return node;
		}

		return arr[node] = find(arr[node]);
	}
}
