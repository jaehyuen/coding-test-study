package baekjoon.구현.캐슬_디펜스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int     N;
	public static int     M;
	public static int     D;
	public static int     total;

	public static int     max       = 0;

	public static int[][] map;

	public static int[]   attackers = new int[3];

	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N   = Integer.parseInt(st.nextToken());
		M   = Integer.parseInt(st.nextToken());
		D   = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				// 적 카운트
				if (map[i][j] == 1) {
					total++;
				}
			}

		}

		find(0, 0);
		System.out.println(max);

	}

	public static void find(int idx, int start) {

		// 궁수 위치가 다 정해지면 시뮬레이션 시작
		if (idx == 3) {

			check();
			return;
		}

		for (int i = start; i < M; i++) {
			attackers[idx] = i;
			find(idx + 1, i + 1);
			attackers[idx] = 0;
		}

	}

	public static void check() {
		int[][] castle = new int[N][M];

		// 기존값 복사
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				castle[i][j] = map[i][j];
			}
		}

		int idx = 0;
		int cnt = 0;
		while (idx < N) {
			HashSet<Integer> set = new HashSet<Integer>();

			// 사격 시작
			for (int attacker : attackers) {

				// 가까운곳부터 탐색
				Loop1: for (int i = 1; i <= D; i++) {

					// 거리별 제일 왼쪽 위치 지정
					int x = N - idx;
					int y = attacker - i;

					// 왼쪽
					for (int j = 0; j < i - 1; j++) {
						x--;
						y++;

						// 범위 체크
						if (x < 0 || x >= N || y < 0 || y >= M)

							continue;

						if (castle[x][y] == 1) {

							// 공격 위치 저장
							set.add((x * M) + y);
							break Loop1;
						}

					}

					x--;
					y++;

					if (x >= 0 && x < N && y >= 0 && y < M) {

						// 가운데
						if (castle[x][y] == 1) {

							// 공격 위치 저장
							set.add((x * M) + y);
							break Loop1;
						}
					}

					// 오른쪽
					for (int j = i - 2; j >= 0; j--) {

						x++;
						y++;

						// 범위 체크
						if (x < 0 || x >= N || y < 0 || y >= M)
							continue;

						if (castle[x][y] == 1) {

							// 공격 위치 저장
							set.add((x * M) + y);
							break Loop1;
						}
					}

				}

			}

			cnt += set.size();
			for (int now : set) {

				int x = now / M;
				int y = now % M;

				// 적 삭제
				castle[x][y] = 0;

			}
			idx++;

		}

		// 최대값 초기
		max = Math.max(cnt, max);

	}
}
