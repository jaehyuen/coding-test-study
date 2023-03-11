package baekjoon.그래프.다리_만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class Main {

	public static int N;
	public static int M;

	public static int[][] map;

	public static int islandCnt = 0;

	public static HashMap<Integer, ArrayList<int[]>> bridge = new HashMap<Integer, ArrayList<int[]>>();
	public static PriorityQueue<int[]> bridgeQ = new PriorityQueue<>((o1, o2) -> {
		return o1[2] - o2[2];
	});

	public static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];

		// 지도 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬 카운팅 세팅 함수
		initIslandCnt();

		// 가능한 모든 다리 다리 세팅
		initBridge();

		// 부모 초기화
		parent = new int[islandCnt + 1];
		for (int i = 1; i <= islandCnt; i++) {
			parent[i] = i;
		}

		int sum = 0;
		while (!bridgeQ.isEmpty()) {
			int[] now = bridgeQ.poll();

			int a = find(now[0]);
			int b = find(now[1]);
			int distance = now[2];

			// 거리가 1인 다리는 못만드니 넘어감
			if (distance <= 1) {
				continue;
			}

			// 둘이 연결 시킴
			if (a != b) {
				sum += distance;

				if (a > b) {
					parent[a] = b;
				} else {
					parent[b] = a;
				}
			}

		}
		HashSet<Integer> set = new HashSet<>();

		// 연결 여부 확인
		for (int i = 1; i <= islandCnt; i++) {
			set.add(find(parent[i]));
		}

		// 셋사이즈가 1보다 크면 모든 섬이 연결 안된것
		if (set.size() > 1) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
		}

	}

	public static int find(int node) {
		if (node == parent[node]) {
			return node;
		}
		return parent[node] = find(parent[node]);
	}

	public static void initBridge() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				// 섬 오른쪽으로 다리 생성
				if (map[i][j] != 0 && map[i][j + 1] != map[i][j]) {

					int distance = 0;
					for (int k = j + 1; k < M; k++) {
						distance++;

						if (map[i][k] == map[i][j]) {
							// 마주친 위치가 같은 섬이면 그 경로에는 다리를 못만듬
							break;
						} else if (map[i][k] != 0 && map[i][k] != map[i][j]) {

							// 마주친 위치가 다른 섬이면 다리 생성
							// 양방향 다리 생성
							bridgeQ.add(new int[] { map[i][j], map[i][k], distance - 1 });

							break;

						}
					}

				}
			}
			for (int j = 0; j < M; j++) {
				// 섬 왼쪽으로 다리 생성
				if (map[i][j] != 0 && map[i + 1][j] != map[i][j]) {

					int distance = 0;
					for (int k = i + 1; k < N; k++) {
						distance++;

						if (map[k][j] == map[i][j]) {
							// 마주친 위치가 같은 섬이면 그 경로에는 다리를 못만듬
							break;
						} else if (map[k][j] != 0 && map[k][j] != map[i][j]) {
							// 마주친 위치가 다른 섬이면 다리 생성
							// 양방향 다리 생성
							bridgeQ.add(new int[] { map[i][j], map[k][j], distance - 1 });
							break;

						}
					}
				}
			}
		}
	}

	public static void initIslandCnt() {
		// 섬 번호 카운팅 및 세팅

		boolean[][] v = new boolean[N][M];

		int[] xArr = { 1, -1, 0, 0 };
		int[] yArr = { 0, 0, 1, -1 };

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (!v[i][j] && map[i][j] == 1) {
					islandCnt++;

					v[i][j] = true;
					map[i][j] = islandCnt;

					Queue<int[]> q = new LinkedList<int[]>();

					q.add(new int[] { i, j });

					while (!q.isEmpty()) {
						int[] now = q.poll();

						for (int k = 0; k < 4; k++) {
							int x = now[0] + xArr[k];
							int y = now[1] + yArr[k];

							if (x < 0 || x >= N || y < 0 || y >= M) {
								continue;
							}

							if (!v[x][y] && map[x][y] == 1) {
								v[x][y] = true;
								map[x][y] = islandCnt;
								q.add(new int[] { x, y });
							}
						}

					}
				}
			}
		}

	}

}