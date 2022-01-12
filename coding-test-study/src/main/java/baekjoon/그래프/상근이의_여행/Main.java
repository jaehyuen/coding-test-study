package baekjoon.그래프.상근이의_여행;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int            T  = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer               st   = new StringTokenizer(br.readLine());
			int                           N    = Integer.parseInt(st.nextToken());
			int                           M    = Integer.parseInt(st.nextToken());
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			for (int j = 0; j <= N; j++) {
				list.add(new ArrayList<Integer>());
			}

			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());

				int tmp1 = Integer.parseInt(st.nextToken());
				int tmp2 = Integer.parseInt(st.nextToken());
				list.get(tmp1)
					.add(tmp2);
				list.get(tmp2)
					.add(tmp1);
			}

			Queue<Integer> q      = new LinkedList<Integer>();
			boolean[]      v      = new boolean[N + 1];
			int            result = 0;
			q.add(1);
			v[1] = true;
			while (!q.isEmpty()) {
				int now = q.poll();
				result++;
				for (int next : list.get(now)) {
					if (!v[next]) {
						q.add(next);
						v[next] = true;
					}
				}
			}
			System.out.println(result - 1);

		}

	}
}
