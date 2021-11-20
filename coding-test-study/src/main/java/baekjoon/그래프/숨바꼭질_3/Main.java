package baekjoon.그래프.숨바꼭질_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[100001];

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		arr[N] = 1;

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i = 2; i >= 0; i--) {

				int next = now;
				int nextSec = arr[now];

				if (i == 0) {
					next += 1;
					nextSec += 1;

				} else if (i == 1) {
					next -= 1;
					nextSec += 1;
				} else {
					next *= 2;

				}

				if (next < 0 || next > 100000)
					continue;

//				if (arr[next] == 0 || arr[next] == nextSec) {
//					q.add(next);
//					arr[next] = nextSec;
//				}
				if (arr[next] == 0) {
					q.add(next);
					arr[next] = nextSec;
				}
			}
		}
		System.out.println(arr[K] - 1);
	}
}
