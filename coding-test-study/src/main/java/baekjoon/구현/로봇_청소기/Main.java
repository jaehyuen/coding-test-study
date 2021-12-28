package baekjoon.구현.로봇_청소기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[]   xArr   = { -1, 0, 1, 0 };
	static int[]   yArr   = { 0, 1, 0, -1 };

	static int[][] room;

	static Robot   robot;
	static int     result = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int             N  = Integer.parseInt(st.nextToken());
		int             M  = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		room = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {

				room[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		robot = new Robot(r, c, d);

		while (true) {

			// 1 청소하기
			if (room[robot.x][robot.y] == 0) {
				room[robot.x][robot.y] = 2;
				result++;
			} else if (room[robot.x][robot.y] == 1) {
				break;
			}

			// 2-a 탐색
			if (room[robot.x + xArr[spin(robot.d)]][robot.y + yArr[spin(robot.d)]] == 0) {
				robot.x = robot.x + xArr[spin(robot.d)];
				robot.y = robot.y + yArr[spin(robot.d)];
				robot.d = spin(robot.d);
				continue;
			}

			if (find()) {
				// 2-b 탐색
				if (room[robot.x + xArr[spin(robot.d)]][robot.y + yArr[spin(robot.d)]] != 0) {

					robot.d = spin(robot.d);
					continue;
				}
			} else {
				moveBack();
			}

		}
		System.out.println(result);

	}

	public static boolean find() {
		for (int i = 0; i < 4; i++) {
			if (room[robot.x + xArr[i]][robot.y + yArr[i]] == 0) {
				return true;
			}

		}

		return false;
	}

	public static int spin(int d) {
		if (d == 0) {
			d = 3;
		} else {
			d--;
		}
		return d;
	}

	public static void moveBack() {
		int tmp = robot.d;

		if (tmp == 0) {
			tmp = 2;
		} else if (tmp == 1) {
			tmp = 3;
		} else if (tmp == 2) {
			tmp = 0;
		} else if (tmp == 3) {
			tmp = 1;
		}

		robot.x = robot.x + xArr[tmp];
		robot.y = robot.y + yArr[tmp];

	}

}

class Robot {
	int x;
	int y;
	int d;

	public Robot(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + x + "," + y + ") " + d;
	}

}
