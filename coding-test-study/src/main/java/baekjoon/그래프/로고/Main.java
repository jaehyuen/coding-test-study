package baekjoon.그래프.로고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));

		int            n    = Integer.parseInt(br.readLine());

		int[][]        info = new int[n + 1][4];

		info[0][0] = 0;
		info[0][1] = 0;
		info[0][2] = 0;
		info[0][3] = 0;

		// 저장
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int             x1 = Integer.parseInt(st.nextToken());
			int             y1 = Integer.parseInt(st.nextToken());
			int             x2 = Integer.parseInt(st.nextToken());
			int             y2 = Integer.parseInt(st.nextToken());

			info[i][0] = x1;
			info[i][1] = y1;
			info[i][2] = x2;
			info[i][3] = y2;
		}

		// 유니온 파인드 부모 배열
		arr = new int[n + 1];

		// 부모 초기화
		for (int i = 0; i <= n; i++) {
			arr[i] = i;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= n; j++) {

				// 같으면 넘어감
				if (i == j) {
					continue;
				}

				int a = find(i);
				int b = find(j);

				// 부모가 같으면 이미 한붓 그리기 가능함으로 넘어감
				if (a == b) {
					continue;
				}

				// x 체크
				if (check(info[i], info[j])) {
					union(a, b);
				}
			}
		}

		// 한붓으로 가능한 갯수 체크
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : arr) {
			set.add(find(i));
		}
		System.out.println(set.size() - 1);

	}

	public static int find(int node) {
		if (arr[node] == node) {
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

	public static boolean check(int[] a, int[] b) {

		// 겹치는 여부 체크
		if (a[2] < b[0] || a[0] > b[2] || a[3] < b[1] || a[1] > b[3]) {
			return false;
		}

		// 내부에 있는지 체크 (a>b)
		if (a[0] < b[0] && a[2] > b[2] && a[1] < b[1] && a[3] > b[3]) {
			return false;
		}

		// 내부에 있는지 체크 (b>a)
		if (a[0] > b[0] && a[2] < b[2] && a[1] > b[1] && a[3] < b[3]) {
			return false;
		}

		return true;
	}

}
