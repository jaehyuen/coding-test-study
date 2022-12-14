package baekjoon.구현.나무_제테크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int                                          N;
	public static int                                          M;
	public static int                                          K;

	// 기계가 넣어주는 양분 정보
	public static int[][]                                      A;

	// 현재 땅의 양분 정보
	public static int[][]                                      arr;

	public static int[]                                        xArr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	public static int[]                                        yArr = { -1, 0, 1, -1, 1, -1, 0, 1 };

	// 나무 정보
	public static ArrayList<ArrayList<PriorityQueue<Integer>>> list = new ArrayList<ArrayList<PriorityQueue<Integer>>>();

	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N   = Integer.parseInt(st.nextToken());
		M   = Integer.parseInt(st.nextToken());
		K   = Integer.parseInt(st.nextToken());

		A   = new int[N][N];
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ArrayList<PriorityQueue<Integer>> tmp = new ArrayList<PriorityQueue<Integer>>();

			for (int j = 0; j < N; j++) {
				A[i][j]   = Integer.parseInt(st.nextToken());
				arr[i][j] = 5;
				tmp.add(new PriorityQueue<Integer>());
			}
			list.add(tmp);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int r   = Integer.parseInt(st.nextToken());
			int c   = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());

			// 나무 증가
			list.get(r - 1)
				.get(c - 1)
				.add(age);

		}

		for (int i = 0; i < K; i++) {
			spring();
			summer();
			fall();
			winter();
		}

		int cnt = 0;

		// 살아남은 나무 갯수 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				cnt += list.get(i)
					.get(j)
					.size();
			}
		}

		System.out.println(cnt);

	}

	public static void spring() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				PriorityQueue<Integer> before = list.get(i)
					.get(j);
				PriorityQueue<Integer> after  = new PriorityQueue<Integer>();

				while (!before.isEmpty()) {
					int now = before.poll();

					// 양분을 먹을수 있는지 체크
					if (now <= arr[i][j]) {
						arr[i][j] -= now;
						now++;
					} else {

						// 음수로 만들어 죽음을 표현
						now *= -1;
					}
					after.add(now);

				}

				list.get(i)
					.set(j, after);
			}
		}

	}

	public static void summer() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				PriorityQueue<Integer> q = list.get(i)
					.get(j);

				// 음수면 죽은것
				while (!q.isEmpty()) {

					if (q.peek() >= 0) {
						break;
					}

					int now = q.poll();

					// 양분 추가
					arr[i][j] += (now * -1) / 2;

				}

			}
		}

	}

	public static void fall() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				PriorityQueue<Integer> q = list.get(i)
					.get(j);

				for (int k : q) {
					// 5 배수면 번식
					if (k % 5 == 0) {

						for (int a = 0; a < 8; a++) {
							int x = i + xArr[a];
							int y = j + yArr[a];

							if (x < 0 || x >= N || y < 0 || y >= N)
								continue;

							// 나이 1인 나무 추가
							list.get(x)
								.get(y)
								.add(1);
						}

					}
				}

			}
		}
	}

	public static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] += A[i][j];
			}
		}
	}
}
