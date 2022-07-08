package baekjoon.그래프.구슬_탈출_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

//	static int[][] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());

		int             N   = Integer.parseInt(st.nextToken());
		int             M   = Integer.parseInt(st.nextToken());

		int[][]         arr = new int[N][M];
		boolean[][][][] v   = new boolean[N][M][N][M];

		int[]           b   = null;
		int[]           r   = null;

		// 구슬 탈출 저장
		// 1 : 벽
		// 2 : 파란구슬
		// 3 : 빨간구슬
		// 0 : 빈칸
		// -1 : 구멍

		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine()
				.toCharArray();
			for (int j = 0; j < M; j++) {

				if (tmp[j] == '#') {
					arr[i][j] = 1;
				} else if (tmp[j] == 'B') {
					arr[i][j] = 2;
					b         = new int[] { i, j };

				} else if (tmp[j] == 'R') {
					arr[i][j] = 3;
					r         = new int[] { i, j };

				} else if (tmp[j] == 'O') {
					arr[i][j] = -1;
				} else {
					arr[i][j] = 0;
				}

			}
		}

		// 첫 4방향을 넣어준다
		Queue<Marble> q = new LinkedList<Marble>();
		q.add(new Marble(arr, b, r, 1, 0));
		q.add(new Marble(arr, b, r, 1, 1));
		q.add(new Marble(arr, b, r, 1, 2));
		q.add(new Marble(arr, b, r, 1, 3));

		// 현재 파란, 빨간 위치에 대해 방문체크
		v[b[0]][b[1]][r[0]][r[1]] = true;

		while (!q.isEmpty()) {
			Marble now = q.poll();

			int    idx = now.moveBall();

			// 빨간볼면 빠지면 성공
			if (idx == 0) {
				System.out.println(now.cnt);
				return;
			} else if (idx == 1 && now.cnt < 10) { // 둘다 실패하고 카운트가 적으면 큐 증가

				// 방문 확인
				if (!v[now.b[0]][now.b[1]][now.r[0]][now.r[1]]) {
					
					v[now.b[0]][now.b[1]][now.r[0]][now.r[1]] = true;
					
					for (int i = 0; i < 4; i++) {
						q.add(new Marble(now.arr, now.b, now.r, now.cnt + 1, i));
					}
				}
			}

			// now.print();
		}
		System.out.println(-1);

	}
}

class Marble {

	int[][] arr;
	int[]   b;
	int[]   r;
	int     cnt;
	int     dir;

	int[]   xDir = { 1, -1, 0, 0 };
	int[]   yDir = { 0, 0, 1, -1 };

	public Marble(int[][] arr, int[] b, int[] r, int cnt, int dir) {

		// 현재 지도 카피
		this.arr = new int[arr.length][arr[0].length];

		for (int i = 0; i < arr.length; i++) {
			System.arraycopy(arr[i], 0, this.arr[i], 0, this.arr[i].length);
		}

		// deep copy
		this.b   = b.clone();
		this.r   = r.clone();

		this.cnt = cnt;
		this.dir = dir;

	}

	public int moveBall() {

		boolean bFlag = false;
		boolean rFlag = false;

		// 방향마다 먼저 움직일 순서 지정
		if (dir == 0 && b[1] == r[1]) {
			// 아래쪽에 있는거 부터 움직인다
			if (b[0] > r[0]) {
				bFlag = moveBlue();
				rFlag = moveRed();
			} else {
				rFlag = moveRed();
				bFlag = moveBlue();

			}

		} else if (dir == 1 && b[1] == r[1]) {
			// 위쪽에 있는거 부터 움직인다
			if (b[0] > r[0]) {
				rFlag = moveRed();
				bFlag = moveBlue();

			} else {
				bFlag = moveBlue();
				rFlag = moveRed();

			}
		} else if (dir == 2 && b[0] == r[0]) {
			// 오른쪽 있는거 부터 움직인다
			if (b[1] > r[1]) {
				bFlag = moveBlue();
				rFlag = moveRed();
			} else {
				rFlag = moveRed();
				bFlag = moveBlue();

			}
		} else if (dir == 3 && b[0] == r[0]) {
			if (b[1] > r[1]) {
				rFlag = moveRed();
				bFlag = moveBlue();

			} else {
				bFlag = moveBlue();
				rFlag = moveRed();

			}
		} else {
			// 나머지는 순서 상관 없음
			bFlag = moveBlue();
			rFlag = moveRed();
		}

		// 두 구술이 못빠져 나가면 다음 방향으로 돌린다
		if (!bFlag && !rFlag) {
			return 1;
		} else if (rFlag && !bFlag) {// 빨간 구슬만 빠져나가면 성공
			return 0;
		} else {// 나머지 케이스는 실패
			return 2;
		}

	}

	public boolean moveBlue() {

		int nextX = b[0] + xDir[dir];
		int nextY = b[1] + yDir[dir];

		// 벽일떄까지 이동
		while (arr[nextX][nextY] == 0) {

			arr[b[0]][b[1]]   = 0;
			arr[nextX][nextY] = 2;

			b[0]              = nextX;
			b[1]              = nextY;

			// 자리 이동
			nextX             = b[0] + xDir[dir];
			nextY             = b[1] + yDir[dir];
		}

		// 구멍 체크
		if (arr[nextX][nextY] == -1) {
			arr[b[0]][b[1]] = 0;
			return true;
		} else {
			return false;
		}
	}

	public boolean moveRed() {
		int nextX = r[0] + xDir[dir];
		int nextY = r[1] + yDir[dir];

		// 벽일떄까지 이동
		while (arr[nextX][nextY] == 0) {

			arr[r[0]][r[1]]   = 0;
			arr[nextX][nextY] = 3;

			r[0]              = nextX;
			r[1]              = nextY;

			// 자리 이동
			nextX             = r[0] + xDir[dir];
			nextY             = r[1] + yDir[dir];
		}

		// 구멍 체크
		if (arr[nextX][nextY] == -1) {
			arr[r[0]][r[1]] = 0;
			return true;
		} else {
			return false;
		}
	}

	public void print() {
		System.out.println("###############################");
		for (int[] ar : arr) {
			System.out.println(Arrays.toString(ar));
		}
		System.out.println("###############################");

	}

}
