package baekjoon.자료구조.카드_합체_놀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader      br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer     st = new StringTokenizer(br.readLine());

		int                 n  = Integer.parseInt(st.nextToken());
		int                 m  = Integer.parseInt(st.nextToken());

		PriorityQueue<Long> q  = new PriorityQueue<Long>();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			q.add(Long.parseLong(st.nextToken()));
		}

		for (int i = 0; i < m; i++) {
			long tmp = q.poll() + q.poll();

			q.add(tmp);
			q.add(tmp);
		}

		System.out.println(q.stream()
			.mapToLong(i -> i)
			.sum());
	}

}
