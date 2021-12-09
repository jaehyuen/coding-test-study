package baekjoon.DP.점프_점프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		int             N   = Integer.parseInt(br.readLine());
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int[]           arr = new int[N];
		int[]           dp  = new int[N];

		for (int i = 0; i < N; i++) {

			arr[i] = Integer.parseInt(st.nextToken());
			dp[i]  = -1;

		}

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		dp[0] = 0;

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i = 1; i <= arr[now]; i++) {
				int next = now + i;

				if (next >= N)
					continue;

				if (dp[next] == -1) {
					q.add(next);
					dp[next] = dp[now] + 1;
				}

			}
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N - 1]);
	}

}
