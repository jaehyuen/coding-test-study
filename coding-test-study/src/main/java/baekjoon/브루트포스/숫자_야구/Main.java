package baekjoon.브루트포스.숫자_야구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Q[] arr = new Q[N];
		for (int i = 0; i < N; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Q(st.nextToken(), st.nextToken(), st.nextToken());
		}
		int cnt = 0;

		// 모든 경우의수를 파악한다
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (i == j)
					continue;
				for (int k = 1; k < 10; k++) {
					if (j == k || i == k)
						continue;

					// 가능성이 있는지 체크
					if (check(new int[] { i, j, k }, arr))
						cnt++;
				}
			}
		}

		System.out.println(cnt);

	}

	public static boolean check(int[] arr, Q[] qArr) {

		for (Q q : qArr) {
			int sCnt = 0;
			int bCnt = 0;
			for (int i = 0; i < 3; i++) {

				// 스트라이크 체크
				if (q.str.charAt(i) - '0' == arr[i]) {
					sCnt++;
					bCnt--; // 본인자리 볼체크는 하면 안되서 마이너스
				}
				// 볼 체크
				if (q.str.contains(String.valueOf(arr[i]))) {
					bCnt++;
				}
			}
			if (sCnt != q.strike || bCnt != q.ball) {
				return false;
			}

		}
		return true;

	}
}

class Q {
	String str;
	int strike;
	int ball;

	public Q(String str, String strike, String ball) {
		this.str = str;
		this.strike = Integer.parseInt(strike);
		this.ball = Integer.parseInt(ball);
	}
}