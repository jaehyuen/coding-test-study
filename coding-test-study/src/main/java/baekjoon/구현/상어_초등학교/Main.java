package baekjoon.구현.상어_초등학교;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br       = new BufferedReader(new InputStreamReader(System.in));
		int            N        = Integer.parseInt(br.readLine());

		int[]          xArr     = { 0, 0, 1, -1 };
		int[]          yArr     = { 1, -1, 0, 0 };

		int[]          scoreArr = { 0, 1, 10, 100, 1000 };

		int[][]        arr      = new int[N * N + 1][4];
		int[][]        room     = new int[N][N];

		for (int i = 0; i < N * N; i++) {
			StringTokenizer st      = new StringTokenizer(br.readLine());
			int             student = Integer.parseInt(st.nextToken());

			// 선호하는 사람 저장
			arr[student][0] = Integer.parseInt(st.nextToken());
			arr[student][1] = Integer.parseInt(st.nextToken());
			arr[student][2] = Integer.parseInt(st.nextToken());
			arr[student][3] = Integer.parseInt(st.nextToken());

			int[][] cnt = new int[N][N];

			// 처음은 1,1 고정석
			if (i == 0) {
				room[1][1] = student;

			} else {
				int     max  = 0;
				boolean flag = false;

				// 자리 위치
				int[]   tmp  = { 0, 0 };

				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {

						// 빈곳이면 넘어감
						if (room[j][k] != 0) {
							continue;
						}

						// 인접한곳 체크
						for (int a = 0; a < 4; a++) {
							int x = j + xArr[a];
							int y = k + yArr[a];

							// 범위체크
							if (x < 0 || x >= N || y < 0 || y >= N) {
								continue;
							}

							// 좋아하는칸이 몇개인지 체크
							if (room[x][y] == arr[student][0] || room[x][y] == arr[student][1]
									|| room[x][y] == arr[student][2] || room[x][y] == arr[student][3]) {
								cnt[j][k]++;

								// 최대값이 나타나면 플래그 초기화 및 위치 저장
								if (max < cnt[j][k]) {
									flag   = true;
									max    = cnt[j][k];

									tmp[0] = j;
									tmp[1] = k;

								} else if (max == cnt[j][k]) {
									// 최대값이 중복되면 블래그 변경
									flag = false;
								}
								max = Math.max(max, cnt[j][k]);
							}
						}
					}
				}

				if (flag) {
					// 자리 지정
					room[tmp[0]][tmp[1]] = student;
				} else {
					int max2 = 0;

					for (int j = 0; j < N; j++) {
						for (int k = 0; k < N; k++) {

							// 빈곳이면 넘어감
							if (room[j][k] != 0) {
								continue;
							}

							if (cnt[j][k] != max) {
								continue;
							}

							int empty = 1;

							// 인접한곳 체크
							for (int a = 0; a < 4; a++) {
								int x = j + xArr[a];
								int y = k + yArr[a];

								// 범위체크
								if (x < 0 || x >= N || y < 0 || y >= N) {
									continue;
								}

								// 빈칸 갯수 더하기
								if (room[x][y] == 0) {
									empty++;

								}
							}

							if (max2 < empty) {
								tmp[0] = j;
								tmp[1] = k;
								max2   = empty;
							}
						}
					}

					// 자리 지정
					room[tmp[0]][tmp[1]] = student;
				}

			}
		}
		int score = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 완전 탐색
				int now = room[i][j];
				int cnt = 0;
				// 4방향
				for (int k = 0; k < 4; k++) {

					int x = xArr[k] + i;
					int y = yArr[k] + j;

					if (x < 0 || x >= N || y < 0 || y >= N) {
						continue;
					}
					if (room[x][y] == arr[now][0] || room[x][y] == arr[now][1] || room[x][y] == arr[now][2]
							|| room[x][y] == arr[now][3]) {
						cnt++;
					}

				}
				score += scoreArr[cnt];
			}

		}
		System.out.println(score);

	}

}
