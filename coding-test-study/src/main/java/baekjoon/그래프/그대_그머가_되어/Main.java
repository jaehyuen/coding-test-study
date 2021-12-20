package baekjoon.그래프.그대_그머가_되어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static String[] test;

	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int             a  = Integer.parseInt(st.nextToken());
		int             b  = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int                           N    = Integer.parseInt(st.nextToken());
		int                           M    = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());

		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());

			list.get(tmp1)
				.add(tmp2);

			list.get(tmp2)
				.add(tmp1);

		}

		Word[]    arr = new Word[N + 1];
		boolean[] v   = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {

			if (i == a) {
				arr[i] = new Word(i, 0);
			} else {
				arr[i] = new Word(i, 100002);
			}

		}

		PriorityQueue<Word> q = new PriorityQueue<Word>((o1, o2) -> {
			return o1.to - o2.to;
		});

		q.add(arr[a]);
		v[a] = true;

		while (!q.isEmpty()) {
			Word now = q.poll();

			if (now.to == 100002)
				continue;

			for (int next : list.get(now.now)) {
				if (!v[next]) {
					v[next]      = true;
					arr[next].to = arr[now.now].to + 1;
					q.add(arr[next]);
				}
			}
		}

		System.out.println(arr[b].to == 100002 ? -1 : arr[b].to);
//		
//		while()
	}

}

class Word {
	int now;
	int to;

	public Word(int now, int to) {
		this.now = now;
		this.to  = to;
	}
}
