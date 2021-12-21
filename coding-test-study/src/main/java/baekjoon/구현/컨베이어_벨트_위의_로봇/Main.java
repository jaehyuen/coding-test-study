package baekjoon.구현.컨베이어_벨트_위의_로봇;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int         N;
	static int         K;

	static int[][]     arr;
	static boolean[][] v;

	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N   = Integer.parseInt(st.nextToken());
		K   = Integer.parseInt(st.nextToken());

		arr = new int[2][N];
		v   = new boolean[2][N];

		st  = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[0][i] = Integer.parseInt(st.nextToken());

		}

		for (int i = N - 1; i >= 0; i--) {
			arr[1][i] = Integer.parseInt(st.nextToken());

		}

		int cnt = 0;

		while (K > 0) {
			cnt++;

			move();
			robotMove();
			addRobot();

		}

		System.out.println(cnt);

	}

	public static void move() {

		int     tmp1   = arr[1][0];// 이전값
		int     tmp2   = 0;        // 현재값

		boolean robot1 = false;    // 이전값
		boolean robot2 = false;    // 현재값

		for (int i = 0; i < N; i++) {

			// 현재값을 담아준다
			tmp2      = arr[0][i];
			// 이전값을 담아준다
			arr[0][i] = tmp1;
			tmp1      = tmp2;

			robot2    = v[0][i];
			v[0][i]   = robot1;
			robot1    = robot2;

			// 로봇이 도착하면 내린다
			if (v[0][N - 1]) {
				v[0][N - 1] = !v[0][N - 1];
			}

		}

		for (int i = N - 1; i >= 0; i--) {

			// 현재값을 담아준다
			tmp2      = arr[1][i];
			// 이전값을 담아준다
			arr[1][i] = tmp1;
			tmp1      = tmp2;

		}

	}

	public static void robotMove() {

		for (int i = N - 2; i >= 0; i--) {
			// 해당 조건이면 로봇 이동
			if (v[0][i] == true && v[0][i + 1] == false && arr[0][i + 1] > 0) {
				v[0][i]     = false;
				v[0][i + 1] = true;
				arr[0][i + 1]--;
				if (arr[0][i + 1] == 0) {
					K--;
				}
			}
		}
		// 로봇이 도착하면 내린다
		if (v[0][N - 1]) {
			v[0][N - 1] = !v[0][N - 1];
		}

	}

	public static void addRobot() {
		if (arr[0][0] > 0) {
			v[0][0] = true;
			arr[0][0]--;
			if (arr[0][0] == 0) {
				K--;
			}
		}

	}

//	public static void print() {
//		System.out.println(Arrays.toString(arr[0]));
//		System.out.println(Arrays.toString(arr[1]));
//		System.out.println(Arrays.toString(v[0]));
//		System.out.println(Arrays.toString(v[1]));
//		System.out.println();
//	}

}
