package baekjoon.브루트포스.감시_피하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int              N;
	static int[][]          arr1;

	static ArrayList<int[]> tList = new ArrayList<int[]>();
	static ArrayList<int[]> eList = new ArrayList<int[]>();

	static int[]            xArr  = { 1, -1, 0, 0 };
	static int[]            yArr  = { 0, 0, 1, -1 };
	static boolean          flag  = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N    = Integer.parseInt(br.readLine());
		arr1 = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				String str = st.nextToken();
				int    tmp = 2;
				if (str.equals("X")) {
					tmp = 0;
					eList.add(new int[] { i, j });
				} else if (str.equals("S")) {
					tmp = 1;
				} else {
					tList.add(new int[] { i, j });
				}

				arr1[i][j] = tmp;
			}

		}

		find(0, 0);
		System.out.println(flag ? "YES" : "NO");
	}

	public static void find(int idx, int start) {

		// 벽이 3개면 감시를 확인한다
		if (idx == 3) {
			for (int[] t : tList) {
				if (check(t[0], t[1], 0) || check(t[0], t[1], 1) || check(t[0], t[1], 2) || check(t[0], t[1], 3)) {
					return;
				}
			}

			flag = true;
			return;
		} else {
			for (int i = start; i < eList.size(); i++) {
				int[] now = eList.get(i);

				// 벽을 세운다
				arr1[now[0]][now[1]] = 3;
				find(idx + 1, i + 1);
				arr1[now[0]][now[1]] = 0;
			}
		}
	}

	public static boolean check(int x, int y, int tmp) {
		int nextX = x + xArr[tmp];
		int nextY = y + yArr[tmp];

		// 다음위치가 못가는곳이면?
		if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
			return false;
		// 벽이면?
		if (arr1[nextX][nextY] == 3) {
			return false;
		} else if (arr1[nextX][nextY] == 1) {
			return true;
		} else {
			return check(nextX, nextY, tmp);
		}
	}
}