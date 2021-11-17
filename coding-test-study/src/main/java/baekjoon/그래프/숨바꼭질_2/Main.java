package baekjoon.그래프.숨바꼭질_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int             N  = Integer.parseInt(st.nextToken());
		int             K  = Integer.parseInt(st.nextToken());

		int[]           v  = new int[100001];

		Queue<Integer>  q  = new LinkedList<Integer>();

		q.add(N);
		v[N] = 1;

		int cnt = 0;

		while (!q.isEmpty()) {
			int now = q.poll();

			if (now == K)
				cnt++;

			for (int i = 0; i < 3; i++) {
				int next = 0;
				if (i == 0) {
					next = now + 1;
				} else if (i == 1) {
					next = now - 1;
				} else {
					next = now * 2;
				}

				if (next < 0 || next > 100000)
					continue;

				if ((v[next] == 0 || v[now] + 1 == v[next])) {
					q.add(next);
					v[next] = v[now] + 1;

				}

			}
		}

		System.out.println(v[K] - 1);
		System.out.println(cnt);

	}

}
