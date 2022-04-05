package baekjoon.그래프.알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int       max;
	static boolean[] v    = new boolean[26];
	static char[][]  arr;

	static int[]     xArr = { 1, -1, 0, 0 };
	static int[]     yArr = { 0, 0, -1, 1 };

	static int       R;
	static int       C;

	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 키보드 가로 세로 값
		R   = Integer.parseInt(st.nextToken());
		C   = Integer.parseInt(st.nextToken());

		// 키보드 정보 저장용 배열
		arr = new char[R][C];

		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine()
				.toCharArray();

		}

		// 최대값 찾기 함수 (dfs)
		find(1, 0, 0);

		// 최대값 출력
		System.out.println(max);

	}

	public static void find(int cnt, int y, int x) {

		// 첫 위치에 알바펫은 방문처리 해준다
		v[arr[y][x] - 65] = true;
		max               = Math.max(cnt, max);

		for (int i = 0; i < 4; i++) {

			// 상하좌우 탐색
			int nextY = y + yArr[i];
			int nextX = x + xArr[i];

			if (nextY < 0 || nextY >= R || nextX < 0 || nextX >= C)
				continue;

			// 사용안한 알파벳이면 한칸 이동
			if (!v[arr[nextY][nextX] - 65]) {
				
				v[arr[nextY][nextX] - 65] = true;
				find(cnt + 1, nextY, nextX);
				v[arr[nextY][nextX] - 65] = false;
			}

		}

	}

}
