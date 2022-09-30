package baekjoon.그래프.컴백홈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int      cnt  = 0;
	static int[]    xArr = { 1, -1, 0, 0 };
	static int[]    yArr = { 0, 0, 1, -1 };

	static int[][]  v;
	static char[][] arr;

	static int      R;
	static int      C;
	static int      K;

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R   = Integer.parseInt(st.nextToken());
		C   = Integer.parseInt(st.nextToken());
		K   = Integer.parseInt(st.nextToken());

		// 방문 체크
		v   = new int[R][C];

		// 지도
		arr = new char[R][C];

		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine()
				.toCharArray();
		}

		v[R - 1][0] = 1;
		find(new int[] { R - 1, 0 }, 1);

		System.out.println(cnt);

	}

	public static void find(int[] now, int n) {

		// 집에 도착하고 거리가 k면 카운트 증가
		if (now[0] == 0 && now[1] == C - 1 && n == K) {
			cnt++;
			return;
		} else if (K < n) {
			// 거리가 너무길면 그만
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nextX = now[0] + xArr[i];
			int nextY = now[1] + yArr[i];

			// 지도 범위 체크
			if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C)
				continue;

			// 방문 안햇고 T가 아니면 방문
			if (v[nextX][nextY] == 0 && arr[nextX][nextY] != 'T') {
				v[nextX][nextY] = n + 1;
				find(new int[] { nextX, nextY }, n + 1);
				v[nextX][nextY] = 0;
			}
		}

	}
}
