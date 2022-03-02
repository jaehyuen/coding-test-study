package baekjoon.DP.A에서B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// A, B 입력
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());

		//계산이 안되면 -1이기 떄문에 초기값 설정
		long result = -1;

		// bfs 탐색을 위한 큐 선언
		Queue<long[]> q = new LinkedList<long[]>();

		// 뒷자리 1추가 햇을떄 b보다 작거나 같으면 큐에 추가
		if (A * 10 + 1 <= B) {
			q.add(new long[] { A * 10 + 1, 1 });
		}

		// 두배를 했을떄 b보다 작거나 같으면 큐에 추가
		if (A * 2 <= B) {
			q.add(new long[] { A * 2, 1 });
		}

		while (!q.isEmpty()) {
			long[] now = q.poll();

			// 목표값에 도달시 카운트+1하며 종료
			if (now[0] == B) {
				result = now[1] + 1;
				break;
			}

			// 뒷자리 1추가 햇을떄 b보다 작거나 같으면 큐에 추가 및 카운트 증가
			if (now[0] * 10 + 1 <= B) {
				q.add(new long[] { now[0] * 10 + 1, now[1] + 1 });
			}

			// 두배를 했을떄 b보다 작거나 같으면 큐에 추가 카운트 증가
			if (now[0] * 2 <= B) {
				q.add(new long[] { now[0] * 2, now[1] + 1 });
			}
		}

		System.out.println(result);

	}
}