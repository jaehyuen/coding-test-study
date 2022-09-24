package baekjoon.그래프.소수_경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		boolean[] p = new boolean[10000];

		p[1] = true;

		// 소수 저장
		for (int i = 2; i * i < 10000; i++) {
			if (!p[i]) {
				for (int j = i * i; j < 10000; j += i) {
					p[j] = true;
				}
			}
		}

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 시작, 끝점
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			// 시작점을 배열로 변경, 마지막 요소는 카운팅용
			int[] startArr = new int[5];
			int idx = 3;
			while (start > 0) {
				startArr[idx] = start % 10;
				start /= 10;
				idx--;

			}

			// 방문 체크 배열
			boolean[] v = new boolean[10000];

			// bfs용 큐
			Queue<int[]> q = new LinkedList<int[]>();
			q.add(startArr);

			// 시작점 방문체크
			v[start] = true;

			while (!q.isEmpty()) {

				int[] nowArr = q.poll();

				// 배열은 인트형으로 변경
				int now = getInt(nowArr);

				// 도작했으면 탐색 종료
				if (now == end) {
					System.out.println(nowArr[4]);
					break;
				}

				// 4자릴 변경하기위해 반복
				for (int j = 0; j < 4; j++) {

					// 자릴수를 변경하기 위한 배령생성 및 복사
					int[] nextArr = new int[5];
					System.arraycopy(nowArr, 0, nextArr, 0, 5);

					// 0~9까지 변경을 해본다
					for (int k = 0; k < 10; k++) {
						nextArr[j] = k;

						int next = getInt(nextArr);

						// 현재 위치면 넘어감
						if (next == now)
							continue;

						// 방문 했으면 넘어감
						if (v[next])
							continue;

						// 소수 체크 및 1000이상인지 확인
						if (!p[next] && next >= 1000) {

							// 큐 저장용 배열 카피
							int[] arr = new int[5];
							System.arraycopy(nextArr, 0, arr, 0, 5);

							arr[4]++;
							q.add(arr);
							v[next] = true;

						}
					}
				}
			}

		}

	}

	public static int getInt(int[] arr) {
		int result = 0;

		int tmp = 1000;

		for (int i = 0; i < 4; i++) {
			result += arr[i] * tmp;
			tmp /= 10;
		}

		return result;
	}

}
