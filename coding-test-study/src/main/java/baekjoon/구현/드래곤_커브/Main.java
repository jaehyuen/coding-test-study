package baekjoon.구현.드래곤_커브;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static int[] yArr = { 0, -1, 0, 1 };
	public static int[] xArr = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

		int            N   = Integer.parseInt(br.readLine());

		// 격자
		boolean[][]    map = new boolean[102][102];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int             x  = Integer.parseInt(st.nextToken());
			int             y  = Integer.parseInt(st.nextToken());
			int             d  = Integer.parseInt(st.nextToken());
			int             g  = Integer.parseInt(st.nextToken());

			// 시작점 체크
			map[y][x] = true;

			// 드래곤 커브를 구하고 해당 점을 전부 체크해줌
			for (int dir : find(g, d)) {

				x         += xArr[dir];
				y         += yArr[dir];
				map[y][x]  = true;
			}

		}
		int cnt = 0;

		// 사각형이면 카운트 증가
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {

				if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
					cnt++;
				}

			}

		}

		System.out.println(cnt);

	}

	public static ArrayList<Integer> find(int n, int dir) {

		// 세대가 1보다 적으면 바로 점을 찍어준다
		if (n <= 1) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			result.add(dir);

			if (n == 1) {
				result.add((dir + 1) % 4);
			}

			return result;
		} else {

			// 세대가 2이상이면 전세대를 먼저 구하고 90도 이동
			ArrayList<Integer> result = find(n - 1, dir);
			int                size   = result.size();

			for (int i = 0; i < size; i++) {

				// 이전세대의 절반은 반대방향, 나머지 절반은 그대로 추가해준다
				if (size / 2 > i) {
					result.add((result.get(i) + 2) % 4);
				} else {
					result.add(result.get(i));
				}
			}

			return result;
		}

	}
}