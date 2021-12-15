package baekjoon.그래프.숫자판_점프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static String[][]      arr  = new String[5][5];

	static int[]           xArr = { 0, 0, 1, -1 };
	static int[]           yArr = { 1, -1, 0, 0 };
	static HashSet<String> set  = new HashSet<String>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = st.nextToken();

			}
		}

		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < 5; j++) {
				dfs(i, j, 0, "");

			}

		}

//		for (String str : set) {
//			System.out.println(str);
//		}
		System.out.println(set.size());

	}

	public static void dfs(int x, int y, int depth, String str) {

		str = str + arr[x][y];

		if (depth >= 5) {
			set.add(str);

		} else {
			for (int k = 0; k < 4; k++) {
				int nextX = x + xArr[k];
				int nextY = y + yArr[k];

				if (nextX < 0 || nextX >= 5 || nextY < 0 || nextY >= 5)
					continue;

				dfs(nextX, nextY, depth + 1, str);

			}
		}

	}
}
