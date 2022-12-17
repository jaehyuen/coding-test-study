package baekjoon.구현.EASY_2048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int max = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];

		// 게임 값 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 첫번째 칸을 최대값으로 초기화
		max = Math.max(max, map[0][0]);

		// 4방향을 돌려본다
		for (int i = 0; i < 4; i++) {
			find(i, 0, map);
		}

		System.out.println(max);
	}

	public static void find(int dir, int idx, int[][] map) {

		// 5번 진행했으면 그만
		if (idx > 5) {
			return;
		}

		// 게임판을 복사한다
		int[][] newMap = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				newMap[i][j] = map[i][j];
			}

		}

		// 이동 함수
		move(dir, newMap);

		// 다음 방향 조정
		for (int i = 0; i < 4; i++) {
			find(i, idx + 1, newMap);
		}

	}

	public static void move(int dir, int[][] map) {
		int idx;
		// 방향별 움직임 지정
		if (dir == 0) {
			for (int i = 0; i < N; i++) {
				idx = 0;
				for (int j = 1; j < N; j++) {

					// 빈칸이 아니면 움직인다
					if (map[i][j] != 0) {
						if (map[i][j] == map[i][idx]) {

							// 같으면 합친다
							map[i][idx++] *= 2;
							map[i][j] = 0;
						} else if (map[i][idx] == 0) {

							// 빈칸이면 그냥 옮긴다
							map[i][idx] = map[i][j];
//							if (idx != j)
							map[i][j] = 0;
						} else {

							// 빈칸이 아니면 기준칸 옆에 넣어줌
							map[i][++idx] = map[i][j];
							if (idx != j)
								map[i][j] = 0;
						}
					}
					max = Math.max(max, map[i][idx]);
				}
			}
		} else if (dir == 1) {
			for (int i = 0; i < N; i++) {
				idx = 0;
				for (int j = 1; j < N; j++) {

					// 빈칸이 아니면 움직인다
					if (map[j][i] != 0) {
						if (map[j][i] == map[idx][i]) {

							// 같으면 합친다
							map[idx++][i] *= 2;
							map[j][i] = 0;
						} else if (map[idx][i] == 0) {

							// 빈칸이면 그냥 옮긴다
							map[idx][i] = map[j][i];
							map[j][i] = 0;
						} else {

							// 빈칸이 아니면 기준칸 옆에 넣어줌
							map[++idx][i] = map[j][i];

							if (idx != j)
								map[j][i] = 0;

						}
					}

					max = Math.max(max, map[idx][i]);
				}
			}
		} else if (dir == 2) {
			for (int i = 0; i < N; i++) {
				idx = N - 1;
				for (int j = N - 2; j >= 0; j--) {

					// 빈칸이 아니면 움직인다
					if (map[i][j] != 0) {
						if (map[i][j] == map[i][idx]) {

							// 같으면 합친다
							map[i][idx--] *= 2;
							map[i][j] = 0;
						} else if (map[i][idx] == 0) {

							// 빈칸이면 그냥 옮긴다
							map[i][idx] = map[i][j];
//							if (idx != j)
							map[i][j] = 0;
						} else {

							// 빈칸이 아니면 기준칸 옆에 넣어줌
							map[i][--idx] = map[i][j];
							if (idx != j)
								map[i][j] = 0;
						}
					}

					max = Math.max(max, map[i][idx]);
				}
			}
		} else {

			for (int i = 0; i < N; i++) {
				idx = N - 1;
				for (int j = N - 2; j >= 0; j--) {

					// 빈칸이 아니면 움직인다
					if (map[j][i] != 0) {
						if (map[j][i] == map[idx][i]) {

							// 같으면 합친다
							map[idx--][i] *= 2;
							map[j][i] = 0;
						} else if (map[idx][i] == 0) {

							// 빈칸이면 그냥 옮긴다
							map[idx][i] = map[j][i];
							map[j][i] = 0;
						} else {

							// 빈칸이 아니면 기준칸 옆에 넣어줌
							map[--idx][i] = map[j][i];

							if (idx != j)
								map[j][i] = 0;

						}
					}

					max = Math.max(max, map[idx][i]);
				}
			}

		}

	}
}
