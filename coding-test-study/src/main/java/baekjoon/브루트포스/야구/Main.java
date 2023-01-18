package baekjoon.브루트포스.야구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int       N;
	public static int[][]   inningArr;
	public static int[]     order = new int[9];
	public static boolean[] v     = new boolean[9];
	public static int       max   = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N         = Integer.parseInt(br.readLine());
		inningArr = new int[N][9];
//		v[3]=;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 9; j++) {
				inningArr[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		find(0);
//		order = new int[] { 4, 5, 6, 0, 1, 2, 3, 7, 8 };
//		startGame();
		System.out.println(max);
	}

	public static void find(int idx) {
		if (idx == 9) {
//			System.out.println(Arrays.toString(order));
			startGame();
			return;
		} else if (idx == 3) {
			// 4번타자는 1번 선수로 고정
			find(idx + 1);
		} else {
			for (int i = 1; i < 9; i++) {
				if (!v[i]) {
					v[i]       = true;
					order[idx] = i;
					find(idx + 1);
					v[i] = false;
				}
			}
		}
	}

	public static void startGame() {
		int inning    = 0;
		int hitterIdx = 0;
		int score     = 0;

		while (inning < N) {
			int                out  = 0;

			ArrayList<Integer> list = new ArrayList<Integer>();

			// 3아웃이 되기전까지 반복
			while (out < 3) {

				// 인덱스 체크
				if (hitterIdx >= 9) {
					hitterIdx = 0;
				}

				int hitter = order[hitterIdx];
				int hit    = inningArr[inning][hitter];

				if (hit == 0) {
					// 아웃 증가
					out++;
				} else {
					// 안타 리스트
					list.add(hit);
				}

				// 타자 변경
				hitterIdx++;

			}
			int sum = 0;

			// 뒤에서 부터 홈에 들어온 타자 앞사람은 모두 득점 한거기에 합계가 4이상 되면 종료
			for (int i = list.size() - 1; i >= 0; i--) {

				sum += list.get(i);

				if (sum >= 4) {
					score += i + 1;
					break;
				}
			}

			// 다음 이닝 진행
			inning++;

		}

		max = Math.max(score, max);

	}
}