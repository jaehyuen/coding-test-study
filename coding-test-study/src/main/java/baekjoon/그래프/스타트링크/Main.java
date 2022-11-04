package baekjoon.그래프.스타트링크;

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

		// 층수
		int             F  = Integer.parseInt(st.nextToken());

		// 현재 위치
		int             S  = Integer.parseInt(st.nextToken());

		// 도착지
		int             G  = Integer.parseInt(st.nextToken());

		// 위로 가는 층수
		int             U  = Integer.parseInt(st.nextToken());

		// 아래로 가는 층수
		int             D  = Integer.parseInt(st.nextToken());

		int[]           v  = new int[F + 1];

		Queue<Integer>  q  = new LinkedList<Integer>();
		q.add(S);
		v[S] = 1;

		while (!q.isEmpty()) {
			int now = q.poll();

			if (now == G) {
				break;
			}

			// 윗층 이동
			int next = now + U;

			if (next > 0 && next <= F) {
				if (v[next] == 0) {
					q.add(next);
					v[next] = v[now] + 1;

				}
			}

			// 아래층 이동
			next = now - D;
			if (next > 0 && next <= F) {
				if (v[next] == 0) {
					q.add(next);
					v[next] = v[now] + 1;

				}
			}

		}

		System.out.println(v[G] == 0 ? "use the stairs" : (v[G] - 1));

	}
}
