package baekjoon.구현.뱀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] xArr = { 1, 0, -1, 0 };
	static int[] yArr = { 0, 1, 0, -1 };
	static int   dIdx = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int             N  = Integer.parseInt(br.readLine());

		// 사과 위치 저장용 배열
		boolean[][]     v  = new boolean[N][N];

		int             K  = Integer.parseInt(br.readLine());

		StringTokenizer st = null;

		// 사과 위치 저징
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;

			v[y][x] = true;

		}

		// 방향 정보저장을 위한 큐
		Queue<Object[]> directions = new LinkedList<Object[]>();
		int             L          = Integer.parseInt(br.readLine());

		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			directions.add(new Object[] { Integer.parseInt(st.nextToken()), st.nextToken() });

		}

		// 뱀의 길이를 체크하기 위한 큐
		Queue<int[]> snake = new LinkedList<int[]>();
		snake.add(new int[] { 0, 0 });

		// 뱀의 머리 위치
		int headX = 0;
		int headY = 0;

		// 0초부터 시작하기 위함
		int time  = -1;

		while (true) {
			time++;

			Object[] direction = directions.peek();

			// 방향 전환 여부 검색
			if (direction != null && time == (int) direction[0]) {
				spin((String) direction[1]);
				directions.poll();

			}

			int nextX = headX + xArr[dIdx];
			int nextY = headY + yArr[dIdx];

			// 벽과 부딛히면 게임 종료
			if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
				System.out.println(time + 1);
				return;
			}

			for (int[] s : snake) {
				// 몸이 겹치기 떄문에 게임 종료
				if (s[0] == nextY && s[1] == nextX) {
					System.out.println(time + 1);
					return;
				}

			}

			snake.add(new int[] { nextY, nextX });

			// 사과가 없으면 뒤에를 삭제
			if (!v[nextY][nextX]) {
				snake.poll();
			} else {

				// 사과룰 먹는다
				v[nextY][nextX] = false;
			}

			headX = nextX;
			headY = nextY;

		}

	}

	public static void spin(String d) {
		if (d.equals("D")) {
			dIdx++;
		} else {
			dIdx--;
		}

		if (dIdx < 0) {
			dIdx = 3;
		} else {
			dIdx %= 4;
		}

	}
}
