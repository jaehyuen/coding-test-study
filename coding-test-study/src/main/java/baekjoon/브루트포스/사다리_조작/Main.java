package baekjoon.브루트포스.사다리_조작;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int         N;
	public static int         M;
	public static int         H;

	public static boolean[][] arr;

	public static int         min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N   = Integer.parseInt(st.nextToken());
		M   = Integer.parseInt(st.nextToken());
		H   = Integer.parseInt(st.nextToken());

		arr = new boolean[H + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = true;

		}

		// 선을 추가 안해도 되면 바로 리턴
		if (check()) {
			System.out.println(0);
			return;
		}

		// 모든 경우의수를 돌린다
		find(0, 0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);

	}

	public static void find(int cnt, int idx) {

		// 3개 이상 연결하면 그만
		if (cnt > 3) {
			return;
		}

		// 사다리 체크를 하고 최소값 갱신
		if (check()) {
			min = Math.min(cnt, min);
		}

		// 좌표 값을 인덱스로 변경하여 최적화
		for (int i = idx; i < N * H; i++) {

			int x = (i / N) + 1;
			int y = (i % N) + 1;

			if (y == N) {
				continue;
			}

			// 양쪽과 안이어지면 실행
			if (!arr[x][y - 1] && !arr[x][y + 1] && !arr[x][y]) {
				arr[x][y] = true;

				find(cnt + 1, (N * (x - 1)) + y - 1);

				arr[x][y] = false;
			}
		}

	}

	public static boolean check() {

		// 사다리 타기 시작
		for (int i = 1; i <= N; i++) {

			// 현재 세로 위치
			int now = i;
			for (int j = 1; j <= H; j++) {

				// 사다리가 존재하면 위치 변경
				if (arr[j][now - 1]) {
					now--;
				} else if (arr[j][now]) {
					now++;
				}
			}

			// 시작 위치와 종료위치가 다르면 실패
			if (now != i) {
				return false;
			}

		}

		return true;

	}
}