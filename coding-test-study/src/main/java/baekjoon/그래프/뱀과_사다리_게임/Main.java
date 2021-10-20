package baekjoon.그래프.뱀과_사다리_게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader            br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer           st  = new StringTokenizer(br.readLine());

		int                       N   = Integer.parseInt(st.nextToken());
		int                       M   = Integer.parseInt(st.nextToken());


		int[]                     arr = new int[110];
		HashMap<Integer, Integer> map = new HashMap<>();
		Queue<Integer>            q   = new LinkedList<>();

		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());

			map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		q.add(1);


		while (!q.isEmpty()) {
			int idx = q.poll();

			for (int i = 1; i <= 6; i++) {
				int nextIdx = idx + i;

				nextIdx = map.getOrDefault(nextIdx, -1) == -1 ? nextIdx : map.get(nextIdx);

				if (arr[nextIdx] == 0 && nextIdx <= 100) {
					q.add(nextIdx);
					arr[nextIdx] = arr[idx] + 1;

				}
			}
		}

//		System.out.println(map);
//		for (int i = 1; i < 101; i++) {
//			System.out.print(i + " : " + arr[i] + ", ");
//			if (i % 10 == 0) {
//				System.out.println();
//			}
//		}
		System.out.println(arr[100]);

	}
}
