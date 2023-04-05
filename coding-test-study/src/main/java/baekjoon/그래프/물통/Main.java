package baekjoon.그래프.물통;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		boolean[][][] v = new boolean[A + 1][B + 1][C + 1];

		Queue<int[]> q = new LinkedList<>();
		ArrayList<Integer> result = new ArrayList<>();

		q.add(new int[] { 0, 0, C });

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int a = now[0];
			int b = now[1];
			int c = now[2];

			if (v[a][b][c]) {
				continue;
			}
			v[a][b][c] = true;

			// A물병이 비었을때 C용량을 리스트에 추가
			if (a == 0) {
				result.add(c);
			}

			// C to B 물 이동
			if (b + c <= B) {
				// C의 물을 전부 이동
				q.add(new int[] { a, b + c, 0 });
			} else {
				// B가 꽉찰떄 까지 이동
				q.add(new int[] { a, B, c - (B - b) });
			}

			// C to A 물 이동
			if (a + c <= A) {
				// C의 물을 전부 이동
				q.add(new int[] { a + c, b, 0 });
			} else {
				// A가 꽉찰떄 까지 이동
				q.add(new int[] { A, b, c - (A - a) });
			}

			// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

			// B to C 물 이동
			if (b + c <= C) {
				// B의 물을 전부 이동
				q.add(new int[] { a, 0, b + c });
			} else {
				// C가 꽉찰떄 까지 이동
				q.add(new int[] { a, b - (C - c), C });
			}

			// B to A 물 이동
			if (a + b <= A) {
				// C의 물을 전부 이동
				q.add(new int[] { a + b, 0, c });
			} else {
				// A가 꽉찰떄 까지 이동
				q.add(new int[] { A, b - (A - a), c });
			}

			// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

			// A to C 물 이동
			if (a + c <= C) {
				// A의 물을 전부 이동
				q.add(new int[] { 0, b, a + c });
			} else {
				// C가 꽉찰떄 까지 이동
				q.add(new int[] { A - (C - c), b, C });
			}

			// A to B 물 이동
			if (a + b <= B) {
				// C의 물을 전부 이동
				q.add(new int[] { 0, a + b, c });
			} else {
				// A가 꽉찰떄 까지 이동
				q.add(new int[] { a - (B - b), B, c });
			}
		}

		Collections.sort(result);
		for (int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

}
