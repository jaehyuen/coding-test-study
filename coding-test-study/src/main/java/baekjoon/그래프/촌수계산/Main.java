package baekjoon.그래프.촌수계산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		ArrayList<HashSet<Integer>> list = new ArrayList<>();
		int[] arr = new int[n + 1];

		int tmp = Integer.parseInt(br.readLine());

		for (int i = 0; i <= n; i++) {
			list.add(new HashSet<>());
			arr[i] = -1;
		}

		for (int i = 0; i < tmp; i++) {
			st = new StringTokenizer(br.readLine());

			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());

			list.get(tmp1).add(tmp2);
			list.get(tmp2).add(tmp1);

		}

		Queue<Integer> q = new LinkedList<>();
		q.add(a);
		arr[a] = 1;

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int next : list.get(now)) {

				if (arr[next] == -1) {
					q.add(next);
					arr[next] = arr[now] + 1;
				}

			}
		}

		//System.out.println(Arrays.toString(arr));
		System.out.println(arr[b] > 0 ? arr[b] - 1 : arr[b]);

	}
}
