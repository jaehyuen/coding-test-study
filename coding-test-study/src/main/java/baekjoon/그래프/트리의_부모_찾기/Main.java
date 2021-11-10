package baekjoon.그래프.트리의_부모_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int                           N;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static StringBuilder                 sb   = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st   = new StringTokenizer(br.readLine());
			int             tmp1 = Integer.parseInt(st.nextToken());
			int             tmp2 = Integer.parseInt(st.nextToken());

			list.get(tmp1)
				.add(tmp2);
			list.get(tmp2)
				.add(tmp1);

		}

		find();

	}

	public static void find() {
		Queue<Integer> q = new LinkedList<Integer>();
		int[]          v = new int[N + 1];
		q.add(1);
		v[1] = -1;
		while (!q.isEmpty()) {
			int                tmp   = q.poll();
			ArrayList<Integer> list2 = list.get(tmp);

			for (int a : list2) {
				if (v[a] == 0) {
					q.add(a);
					v[a] = tmp;

				}
			}

		}
		for (int i = 2; i <= N; i++) {
			sb.append(v[i] + "\n");
		}
		System.out.println(sb.toString());

	}
}
