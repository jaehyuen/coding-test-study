package baekjoon.자료구조.회전하는_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[M];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 큐 채우기
		LinkedList<Integer> d = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			d.add(i + 1);

		}

		int cnt = 0;

		for (int i = 0; i < M; i++) {

			// 큐에서 뽑을수 없으면 큐를 돌린다
			while (d.peekFirst() != arr[i]) {

				// 더 빠른 방향으로 돌린다
				if (d.indexOf(arr[i]) <= d.size() / 2) {
					d.add(d.poll());
				} else {
					d.addFirst(d.pollLast());
				}
				cnt++;

			}
			d.poll();

		}
		System.out.println(cnt);

	}

}
