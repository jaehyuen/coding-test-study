package baekjoon.그래프.전국시대;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static int[] parent;
	public static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int             N  = Integer.parseInt(st.nextToken());
		int             M  = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		arr    = new int[N + 1];

		// 군사력 및 부모 배열 초기화
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
			arr[i]    = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int O = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());

			int a = find(P);
			int b = find(Q);

			// 이미 연결됫으면 무시
			if (a == b)
				continue;

			if (O == 1) {
				// 동맹
				union(a, b, arr[a] + arr[b]);
			} else {
				// 전쟁
				union(a, b, Math.abs(arr[a] - arr[b]));
			}

		}

		// 국가 카운팅용 셋
		HashSet<Integer>   set  = new HashSet<Integer>();

		// 오름차순 정렬용 리스트
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 1; i <= N; i++) {
			int now = find(parent[i]);

			// 망한 나라 아니면 셋에 추가
			if (now != 0) {
				set.add(now);
			}

		}

		// 남은 군사력 정렬을 위헤 배열에 추가
		for (int i : set) {
			list.add(arr[i]);
		}
		Collections.sort(list);

		System.out.println(list.size());
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

	public static int find(int node) {
		if (node == parent[node]) {
			return node;
		}

		return parent[node] = find(parent[node]);
	}

	public static void union(int a, int b, int cnt) {

		if (cnt == 0) {

			parent[a] = 0;
			parent[b] = 0;
			arr[a]    = 0;
			arr[b]    = 0;

			return;
		}
		if (a < b) {
			parent[b] = a;
			arr[a]    = cnt;
			arr[b]    = 0;
		} else {
			parent[a] = b;
			arr[b]    = cnt;
			arr[a]    = 0;
		}
	}
}
