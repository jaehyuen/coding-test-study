package baekjoon.그래프.파이프_옮기기_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][][] xArr = { { { 0 }, {}, { 1, 0, 1 } }, { {}, { 1 }, { 1, 0, 1 } }, { { 0 }, { 1 }, { 1, 0, 1 } } };
	static int[][][] yArr = { { { 1 }, {}, { 0, 1, 1 } }, { {}, { 0 }, { 0, 1, 1 } }, { { 1 }, { 0 }, { 0, 1, 1 } } };

	static int[][]   arr;
	static int       N;

	static int       cnt  = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N   = Integer.parseInt(br.readLine());
		arr = new int[N][N];

//		int[][][]      xArr = { { { 0 }, {}, { 1, 0, 1 } }, { {}, { 1 }, { 1, 0, 1 } }, { { 0 }, { 1 }, { 1, 0, 1 } } };
//		int[][][]      yArr = { { { 1 }, {}, { 0, 1, 1 } }, { {}, { 0 }, { 0, 1, 1 } }, { { 1 }, { 0 }, { 0, 1, 1 } } };

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {

				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 1) {
					arr[i][j] = -1;
				} else {
					arr[i][j] = tmp;
				}
			}
		}
		
		dfs(new Pipe(0, 1, 0));
		System.out.println(cnt);

//		Queue<Pipe> q = new LinkedList<Pipe>();
//		q.add(new Pipe(0, 1, 0));
//		arr[0][1] = 1;
//
//		while (!q.isEmpty()) {
//			Pipe p = q.poll();
//
////			arr[p.x][p.y]++;
//
//			for (int i = 0; i < xArr[p.type].length; i++) {
//
//				int     nextX, nextY;
//				boolean flag = true;
//
//				for (int j = 0; j < xArr[p.type][i].length; j++) {
//					nextX = p.x + xArr[p.type][i][j];
//					nextY = p.y + yArr[p.type][i][j];
//
//					if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
//						flag = false;
//						break;
//					}
//
//					if (arr[nextX][nextY] == -1) {
//						flag = false;
//						break;
//					}
//
//				}
//
//				if (flag && xArr[p.type][i].length > 0) {
//					nextX = p.x + xArr[p.type][i][xArr[p.type][i].length - 1];
//					nextY = p.y + yArr[p.type][i][yArr[p.type][i].length - 1];
//
//					if (arr[nextX][nextY] != 0) {
//						arr[nextX][nextY] += arr[p.x][p.y];
//					} else {
//						q.add(new Pipe(nextX, nextY, i));
////						arr[p.x][p.y]++;
//						arr[nextX][nextY] = arr[p.x][p.y];
//					}
//
//				}
//
//			}
//		}
//
//		for (int[] ar : arr) {
//			System.out.println(Arrays.toString(ar));
//		}
//
//		System.out.println(arr[N - 1][N - 1] == -1 ? 0 : arr[N - 1][N - 1]);
	}

	public static void dfs(Pipe now) {

		if (now.x == N - 1 && now.y == N - 1) {
			cnt++;
			return;
		}

		for (int i = 0; i < xArr[now.type].length; i++) {

			int     nextX, nextY;
			boolean flag = true;

			for (int j = 0; j < xArr[now.type][i].length; j++) {
				nextX = now.x + xArr[now.type][i][j];
				nextY = now.y + yArr[now.type][i][j];

				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
					flag = false;
					break;
				}

				if (arr[nextX][nextY] == -1) {
					flag = false;
					break;
				}

			}

			if (flag && xArr[now.type][i].length > 0) {
				nextX = now.x + xArr[now.type][i][xArr[now.type][i].length - 1];
				nextY = now.y + yArr[now.type][i][yArr[now.type][i].length - 1];

//				if (arr[nextX][nextY] != 0) {
//					arr[nextX][nextY] += arr[now.x][now.y];
//				} else {
//					q.add(new Pipe(nextX, nextY, i));
				dfs(new Pipe(nextX, nextY, i));
//					arr[p.x][p.y]++;
//					arr[nextX][nextY] = arr[now.x][now.y];
//				}

			}

		}
	}
}

class Pipe {
	int x;
	int y;
	int type;

	public Pipe(int x, int y, int type) {
		this.x    = x;
		this.y    = y;
		this.type = type;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ x: " + x + ", y:" + y + ", type:" + type + "]";
	}
}
