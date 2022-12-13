package baekjoon.그래프.데스_나이트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br   = new BufferedReader(new InputStreamReader(System.in));
		int             N    = Integer.parseInt(br.readLine());

		StringTokenizer st   = new StringTokenizer(br.readLine());

		// 위치 정보
		int             r1   = Integer.parseInt(st.nextToken());
		int             c1   = Integer.parseInt(st.nextToken());
		int             r2   = Integer.parseInt(st.nextToken());
		int             c2   = Integer.parseInt(st.nextToken());

		int[][]         arr  = new int[N][N];
		int[]           xArr = { -2, -2, 0, 0, 2, 2 };
		int[]           yArr = { -1, 1, -2, 2, -1, 1 };

		Queue<int[]>    q    = new LinkedList<int[]>();

		q.add(new int[] { r1, c1 });
		arr[r1][c1] = 1;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			if (now[0] == r2 && now[1] == c2) {
				break;
			}

			for (int i = 0; i < 6; i++) {

				int nextX = now[0] + xArr[i];
				int nextY = now[1] + yArr[i];

				// 범위 체크
				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
					continue;
				}

				// 방문 안햇으면 추가
				if (arr[nextX][nextY] == 0) {
					q.add(new int[] { nextX, nextY });
					arr[nextX][nextY] = arr[now[0]][now[1]] + 1;
				}

			}
		}

		System.out.println(arr[r2][c2] - 1);

	}
}
