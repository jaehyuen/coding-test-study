package baekjoon.그래프.DSLR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		String[]       opt = { "D", "S", "L", "R" };

//		

		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

		int            T   = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st    = new StringTokenizer(br.readLine());
			int             start = Integer.parseInt(st.nextToken());
			int             end   = Integer.parseInt(st.nextToken());

			String[]        arr   = new String[10001];

			Queue<Integer>  q     = new LinkedList<Integer>();
			q.add(start);
			arr[start] = "";

			while (arr[end] == null) {
				int now = q.poll();

				for (int j = 0; j < 4; j++) {
					int nextNum = 0;

					if (j == 0) {
						nextNum = (now * 2) % 10000;
					} else if (j == 1) {
						nextNum = now == 0 ? 9999 : now - 1;
					} else if (j == 2) {
						nextNum = Integer.parseInt("" + now % 1000 + (now / 1000));
					} else {
						nextNum = ((now % 10 * 1000) + (now / 10));
					}

					if (arr[nextNum] == null) {
						q.add(nextNum);
						arr[nextNum] = arr[now] + opt[j];
					}
				}
			}
			System.out.println(arr[end]);
		}

	}
}
