package baekjoon.구현.청소년_상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int[] xArr = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	public static int[] yArr = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };

	public static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Fish[][] map = new Fish[4][4];
		int[] location = new int[17];

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());

				map[i][j] = new Fish(num, dir, false);

				location[num] = (i * 4) + j;
			}

		}

		// 0,0 에 상어를 둔다
		Shark shark = new Shark(-1, map[0][0].dir, 0, 0);
		map[0][0].flag = true;

		find(map, location, map[0][0].num, shark);
		System.out.println(max);

	}

	public static void find(Fish[][] now, int[] nowLocation, int sum, Shark shark) {

		// System.out.println(shark);
		// 최대값 갱신
		max = Math.max(sum, max);

		// 물고기 카피
		Fish[][] nextFish = copyArr(now);
		int[] nextLocation = new int[17];

		System.arraycopy(nowLocation, 0, nextLocation, 0, nowLocation.length);

		// 물고기 이동
		moveFish(nextFish, nextLocation, shark);

		// 상어이동
		Shark before = new Shark(-1, shark.dir, shark.x, shark.y);
		int dir = shark.dir;

		while (true) {
			Shark next = new Shark(-1, before.dir, before.x + xArr[dir], before.y + yArr[dir]);

			// 범위 벗어나면 그만
			if (next.x < 0 || next.x >= 4 || next.y < 0 || next.y >= 4) {
				break;
			}

			// 물고기가 없으면 무시
			if (nextFish[next.x][next.y].flag) {
				before = next;
				continue;
			}

			// 다음위치 물고기를 먹는다
			nextFish[next.x][next.y].flag = true;

			// 상어 방향 전환
			next.dir = nextFish[next.x][next.y].dir;
			find(nextFish, nextLocation, sum + nextFish[next.x][next.y].num, next);

			// 물고기 위치 복구
			nextFish[next.x][next.y].flag = false;

			// 방향도 복구
			next.dir = dir;
			before = next;

		}

	}

	public static void moveFish(Fish[][] nowFish, int[] nowLocation, Shark shark) {

		// 물고기 번호가 작은 순으로 이동 시작
		for (int i = 1; i <= 16; i++) {
			// 좌표 파싱
			int x = nowLocation[i] / 4;
			int y = nowLocation[i] % 4;

			// 물고기가 먹힌게 아니면 이동
			if (!nowFish[x][y].flag) {

				// 상어 위치면 그만
				if (shark.x == x && shark.y == y) {
					continue;
				}

				int dir = nowFish[x][y].dir;

				// 한바퀴 플레그
				boolean flag = false;

				while (true) {

					// 방향 범위 체크
					if (dir >= 9) {
						dir = 1;
					}

					// 한바퀴 돌앗는데 이동 못하면 그만
					if (flag && dir == nowFish[x][y].dir) {
						break;
					}

					int nextX = x + xArr[dir];
					int nextY = y + yArr[dir];

					// 맵 범위 체크
					if (nextX < 0 || nextX >= 4 || nextY < 0 || nextY >= 4) {
						dir++;
						flag = true;
						continue;
					}
					if (shark.x == nextX && shark.y == nextY) {
						dir++;
						flag = true;
						continue;
					}

					// 위치 변경
					nowFish[x][y].dir = dir;
					Fish tmp = nowFish[x][y];
					nowFish[x][y] = nowFish[nextX][nextY];
					nowFish[nextX][nextY] = tmp;

					int nowNum = nowFish[nextX][nextY].num;
					int nextNum = nowFish[x][y].num;

					// 위치 정보 배열 변경
					int locationTmp = nowLocation[nowNum];
					nowLocation[nowNum] = nowLocation[nextNum];
					nowLocation[nextNum] = locationTmp;

					break;

				}

			}

		}

	}

	public static Fish[][] copyArr(Fish[][] now) {

		Fish[][] result = new Fish[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				result[i][j] = new Fish(now[i][j].num, now[i][j].dir, now[i][j].flag);
			}
		}
		return result;
	}
}

class Shark extends Fish {
	int x;
	int y;

	public Shark(int num, int dir, int x, int y) {
		super(num, dir, false);
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + num + ", " + dir + ", " + x + ", " + y + ")";
	}

}

class Fish {
	int num;
	int dir;
	boolean flag;

	public Fish(int num, int dir, boolean flag) {
		this.num = num;
		this.dir = dir;
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "(" + num + ", " + dir + ", " + flag + ")";
	}
}
