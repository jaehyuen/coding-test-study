package baekjoon.DP.가장_긴_증가하는_부분_수열_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
//		BufferedReader     br   = new BufferedReader(new InputStreamReader(System.in));
//		int                N    = Integer.parseInt(br.readLine());
//
//		ArrayList<Integer> list = new ArrayList<Integer>();
//
//		list.add(-1);
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		for (int i = 0; i < N; i++) {
//			int tmp = Integer.parseInt(st.nextToken());
//
//			if (tmp > list.get(list.size() - 1)) {
//				list.add(tmp);
//
//			} else {
//				int start = 0;
//				int end   = list.size() - 1;
//
//				while (start <= end) {
//					int mid = (start + end) / 2;
//
//					if (list.get(mid) >= tmp) {
//						end = mid - 1;
//
//					} else {
//						start = mid + 1;
//					}
//				}
//				// System.out.println("start : " + start + " end : " + end);
//				// System.out.println(list);
//				//list.set(start, tmp);
//			}
//
//		}
//		System.out.println(list.size() - 1);
//
//		for (int i = 1; i < list.size(); i++) {
//			System.out.print(list.get(i) + " ");
//		}
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		int             N   = Integer.parseInt(br.readLine());
		int[]           arr = new int[N];
		int[]           dp  = new int[N];

		StringTokenizer st  = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;

		dp[0] = 1;
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
		Stack<Integer> s = new Stack<>();
		for (int j = N - 1; j >= 0; j--) {
			if (dp[j] == max) {
				s.push(arr[j]);
				max--;

			}

		}

		while (!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}

	}
}