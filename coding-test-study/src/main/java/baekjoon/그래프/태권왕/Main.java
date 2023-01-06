package baekjoon.그래프.태권왕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());

		for (int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());

			int[] v = new int[101];

			Queue<int[]> q = new LinkedList<int[]>();
			q.add(new int[] { S, T, 0 });

			// 상대방의 점수까지 도달할때까지 반복
			while (v[T] == 0) {
				int[] now = q.poll();

				// 점수가 같으면 종료
				if (now[0] == now[1]) {
					System.out.println(now[2]);
					break;
				}

				// 이미 넘어서면 중단
				if (now[0] > now[1]) {
					continue;
				}

				// A발차기
				q.add(new int[] { now[0] * 2, now[1] + 3, now[2] + 1 });

				// B발차기
				q.add(new int[] { now[0] + 1, now[1], now[2] + 1 });

			}

		}

	}
}
