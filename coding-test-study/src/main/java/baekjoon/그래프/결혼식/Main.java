package baekjoon.그래프.결혼식;

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

	public static void main(String[] args) throws IOException {

//		

		BufferedReader              br   = new BufferedReader(new InputStreamReader(System.in));

		int                         n    = Integer.parseInt(br.readLine());
		int                         m    = Integer.parseInt(br.readLine());

		ArrayList<HashSet<Integer>> list = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			list.add(new HashSet<Integer>());
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st   = new StringTokenizer(br.readLine());

			int             tmp1 = Integer.parseInt(st.nextToken());
			int             tmp2 = Integer.parseInt(st.nextToken());

			list.get(tmp1)
				.add(tmp2);
			list.get(tmp2)
				.add(tmp1);

		}

		Queue<Integer> q = new LinkedList<Integer>();
		int[]          v = new int[n + 1];
		q.add(1);
		v[1] = 1;

		int result = -1;

		while (!q.isEmpty()) {
			int now = q.poll();
			result++;
			for (int next : list.get(now)) {
				if (v[next] == 0 && v[now] + 1 < 4) {
					q.add(next);
					v[next] = v[now] + 1;
				}
			}
		}
		// Arrays.stream(v);

		System.out.println(result);

	}
}
